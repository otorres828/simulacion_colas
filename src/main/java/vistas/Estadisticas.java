
package vistas;

import clases.Cliente;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import clases.Estaticas;

public class Estadisticas extends javax.swing.JPanel {
    DefaultTableModel tabla_eventos = new DefaultTableModel();
        
    public  int at=0;
    
    public ArrayList<Integer> wl = new ArrayList<>(); 
    public ArrayList<Integer> id_cliente = new ArrayList<>(); 
    //TIEMPO ENTRE LLEGADAS
    
    public  int n_tell=0;
    public  int tell=0;
    
    //TIEMPO DE SERVICIO
    public  int n_ts=0;
    public  int ts=0;
    
    public int tm=0;
    public int simulacion=0;
    public String tipo_evento="";
    public int cant_cliente=0;
    
    public  int[] servidores;

    public Cliente dt[];
    public int n_evento=0;
    
    /*VARIABLES QUE CONTROLAN LA CANTIDAD DE SERVIDORES Y EL TIEMPO DE SIMULACION*/
    public int cantidad_servidores=2;
    public int cantidad_simulacion =30;
    
    public Estadisticas() {
        initComponents();
        //LLAMAR CLASE ESTATICA Y RECUPERAR CANTIDAD DE SERVIDORES,TM DE SIMULACION Y CARGAR ARRAYLIST DE LAS PROBABILIDADES
        cargar_probabilidades();
        
        cargar_cabecera_tabla();
        llamada_simulacion(cantidad_simulacion,cantidad_servidores); //INICIAR LA SIMULACION
    }  
    
    private void cargar_cabecera_tabla() {
        String[] titulos = new String[10 + (2 * cantidad_servidores)];
        titulos[0] = "Nº Evento";
        titulos[1] = "Tipo Evento";
        titulos[2] = "Id Cliente";
        titulos[3] = "TM";
        int index = 3;
        for (int i = 0; i < cantidad_servidores; i++) {
            titulos[index = index + 1] = "S" + (i + 1);
        }
        titulos[index = index + 1] = "WL";
        titulos[index = index + 1] = "AT";
        for (int i = 0; i < cantidad_servidores; i++) {
            titulos[index = index + 1] = "DT" + (i + 1);
        }
        titulos[index = index + 1] = "Np/TELL";
        titulos[index = index + 1] = "TELL";
        titulos[index = index + 1] = "Np/TS";
        titulos[index = index + 1] = "TS";

        //String[] titulo = new String[]{"NºEvento","Tipo Evento","IdCliente","TM","S1", "WL","AT","DT1", "NºAleatorio p/TELL","TELL","NºAleatorio p/TS","TS"};
        tabla_eventos.setColumnIdentifiers(titulos);

        table_model.setModel(tabla_eventos);
    }

    private void cargar_probabilidades(){
        Estaticas.asignar_tell(1, 30);
        Estaticas.asignar_tell(2, 20);
        Estaticas.asignar_tell(3, 15);
        Estaticas.asignar_tell(5, 15);
        Estaticas.asignar_tell(6, 10);
        Estaticas.asignar_tell(8, 10);
        Estaticas.asignar_ts(1, 15);
        Estaticas.asignar_ts(2, 5);
        Estaticas.asignar_ts(3, 10);
        Estaticas.asignar_ts(4, 20);
        Estaticas.asignar_ts(5, 15);
        Estaticas.asignar_ts(6, 15);
        Estaticas.asignar_ts(7, 10);
        Estaticas.asignar_ts(9, 10);
    }
    
    //INICIALIZAR SIMULACION
    public final void llamada_simulacion(int simulacion,int servidores) {
        this.simulacion=simulacion;
        this.servidores = new int[servidores];
        this.dt = new Cliente[servidores];
        
        //INICIALIZAMOS LOS SERVIDORES EN 0
        for (int i = 0; i < this.servidores.length; i++) {
            this.servidores[i]=0;
            Cliente c = new Cliente(0, 999);
            this.dt[i]=c;
        }
        
        correr_simulacion(); //CORREMOS LA SIMULACION
    }
    
    private void correr_simulacion(){
        tabla_eventos.addRow((Object[]) obtener_objeto_llegada()); 
        //MIENTRAS TM SEA MENOR AL TIEMPO DE SIMULACION
        while(this.tm<this.simulacion){
            n_evento++;
            if(this.at<valor_menor_dt()){  //compara AT con el valor menor de DT
                //LLEGADA
                this.tm=this.at;
                this.tipo_evento="llegada";
                this.cant_cliente=this.cant_cliente+1;
                this.id_cliente.add(cant_cliente);
                
                int n_servidor_vacio=hallar_servidor_vacio();
                if(n_servidor_vacio!=9999){                                        //CUANDO HAY COLA
                    //EXISTEN SERVIDORES VACIOS
                    this.servidores[n_servidor_vacio]=1;                          //SE OCUPA EL SERVIDOR
                    generar_ts();                                                 //SE CALCULA EL TS
                    int valor = this.tm+this.ts;
                    this.dt[n_servidor_vacio].valor=valor;                        //ASIGNAMOS EL TS AL CLIENTE QUE ENTRO EN EL SERVIDOR VACIO
                    this.dt[n_servidor_vacio].id=cant_cliente;
                }else{
                    //NO EXISTEN SERVIDORES VACIOS
                    this.wl.add(this.cant_cliente);
                }
                this.n_tell= (int)(Math. random()*100);                           //SE GENERA UN NUMERO ALEATORIO DE TS
                this.tell=calcular_tell();                                        //SE CALCULA EL TS
                this.at=this.tm+this.tell;   
                
                tabla_eventos.addRow((Object[]) obtener_objeto_llegada());
                //tabla_eventos.addRow(new Object[]{n_evento,tipo_evento,cant_cliente,tm,servidores[0],servidores[1],wl.size(),at,dt[0],dt[1],n_tell,tell,n_ts,ts});
            }else{
                //SALIDA
                this.tipo_evento="salida";
                this.tm=this.dt[hallar_menor_dt()].valor; //TM=DT
                if(!this.wl.isEmpty()){
                    //CUANDO HAY COLA
                    int id_cliente_servidor=this.wl.get(0);
                    this.wl.remove(0);                                            //SE REMUEVE EL PRIMERO EN COLA
                    generar_ts();                                                 //SE GENERA EL TS
                    int valor = this.tm+this.ts;                                  //SE OBTIENE TM+TS
                    this.dt[hallar_menor_dt()].valor=valor;                       //ASIGNAMOS EL VALOR A LA SALIDA DEL QUE SALE DE LA COLA
                    this.dt[hallar_menor_dt()].id=id_cliente_servidor;
                }else{
                    //CUANDO NO HAY COLA
                    int menor =hallar_menor_dt();
                    this.dt[menor].valor=999;
                    this.servidores[menor]=0;
                }
                tabla_eventos.addRow((Object[]) obtener_objeto_salida());
                id_cliente.remove(0);
                //tabla_eventos.addRow(new Object[]{n_evento,tipo_evento,id_cliente.get(0),tm, servidores[0],servidores[1],wl.size(),at, dt[0],dt[1],n_tell,tell,n_ts,ts});
            }
           
        }
    }
    
    private Object obtener_objeto_llegada(){
        Object[] objeto = new Object[10+(2*cantidad_servidores)];
        objeto[0]=n_evento;
        objeto[1]=tipo_evento;
        objeto[2]=cant_cliente;
        objeto[3]=tm;
        int index=3;
        for (int i = 0; i < cantidad_servidores; i++) {
            objeto[index=index+1]=servidores[i];
        }
        if(!wl.isEmpty())
            objeto[index=index+1]=wl.size()+""+wl;
        else
            objeto[index=index+1]="";//wl.size();
        objeto[index=index+1]=at;
        for (int i = 0; i < cantidad_servidores; i++) {
            objeto[index=index+1]=dt[i].valor+"("+dt[i].id+")";
        }
        objeto[index=index+1]=n_tell;
        objeto[index=index+1]=tell;
        objeto[index=index+1]=n_ts;
        objeto[index=index+1]=ts;
        
        return objeto;
    }
        
    private Object obtener_objeto_salida(){
        Object[] objeto = new Object[10+(2*cantidad_servidores)];
        objeto[0]=n_evento;
        objeto[1]=tipo_evento;
        objeto[2]=id_cliente.get(0);
        objeto[3]=tm;
        int index=3;
        for (int i = 0; i < cantidad_servidores; i++) {
            objeto[index=index+1]=servidores[i];
        }
        /*IMPRIMIR CLIENTES EN COLA*/
        if(!wl.isEmpty())
            objeto[index=index+1]=wl.size()+""+wl;
        else
            objeto[index=index+1]=""; //wl.size()
        
        objeto[index=index+1]=at;
        for (int i = 0; i < cantidad_servidores; i++) {
            if(dt[i].valor!=999)
                objeto[index=index+1]=dt[i].valor+"("+dt[i].id+")";                //OBTIENE EL VALOR DE DT CON EL CLIENTE (AQUI ALGUIEN DEL A COLA ENTRO A UN SERVIDOR)
            else
                objeto[index=index+1]=dt[i].valor;                                 //OBTIENE 999 PORQUE HUBO UNA SALIDA Y EL SERVIDOR QUEDO VACIO 
        }
        objeto[index=index+1]=n_tell;
        objeto[index=index+1]=tell;
        objeto[index=index+1]=n_ts;
        objeto[index=index+1]=ts;
        
        return objeto;
    }
    
    private int hallar_servidor_vacio(){
        for (int i = 0; i < this.servidores.length; i++) {
            if(this.servidores[i]==0){
                return i; //RETORNA LA POSICION SI ENCUENTRA UN SERVIDOR VACIO
            }
        }
        return 9999; //RETORNA SI NO HAY SERVIDOR VACIO
    }
    
    private int valor_menor_dt(){
        int  menor;
        menor=this.dt[0].valor;
        for (int i = 0; i < this.dt.length; i++) {         
            if(this.dt[i].valor<menor) {
                menor = this.dt[i].valor;
            }
        }
        return menor;
    }

    private int hallar_menor_dt(){
        int menor,posicion=0;
        menor=this.dt[0].valor;
        for (int i = 0; i < this.dt.length; i++) {
            if(this.dt[i].valor<menor) {
                menor = this.dt[i].valor;
                posicion=i;
            }
        }
        return posicion;
    }
    
    private int calcular_tell(){
        for (int i = 0; i < Estaticas.probabilidades_tell.size(); i++) 
           if(n_tell>=Estaticas.probabilidades_tell.get(i).rango_desde && n_tell<=Estaticas.probabilidades_tell.get(i).rango_hasta )
               return Estaticas.probabilidades_tell.get(i).tiempo;
           
         return ((int)(Math. random()*10+1)); //GENERA CUALQUIER NUMERO ALEATORIO EN CASO DE FALLA
    }
    
    private int calcular_ts(){
        for (int i = 0; i < Estaticas.probabilidades_ts.size(); i++) 
          if(n_ts>=Estaticas.probabilidades_ts.get(i).rango_desde && n_ts<=Estaticas.probabilidades_ts.get(i).rango_hasta )
               return Estaticas.probabilidades_ts.get(i).tiempo;
         return ((int)(Math. random()*10+1)); //GENERA CUALQUIER NUMERO ALEATORIO EN CASO DE FALLA
    }
    
    private void generar_ts(){
        this.n_ts= (int)(Math. random()*100);   //SE GENERA UN NUMERO ALEATORIO DE TS
        this.ts=calcular_ts();  
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_model = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();

        table_model.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(table_model);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("ESTADISTICAS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("W:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel3.setText("WQ:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel4.setText("L:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel6.setText("LQ:");

        guardar.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        guardar.setText("Guardar Simulacion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(guardar)
                .addContainerGap(231, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(guardar)
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable table_model;
    // End of variables declaration//GEN-END:variables

}
