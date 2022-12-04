
package vistas;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

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
    public int dt[];
    public int n_evento=0;
    
    public Estadisticas() {
        initComponents();
        //LLAMAR CLASE ESTATICA Y RECUPERAR CANTIDAD DE SERVIDORES,TM DE SIMULACION Y CARGAR ARRAYLIST DE LAS PROBABILIDADES
        int cantidad_servidores=2;
        String[] titulos = new String[10+(2*cantidad_servidores)];
        titulos[0]="Nº Evento";
        titulos[1]="Tipo Evento";
        titulos[2]="Id Cliente";
        titulos[3]="TM";
        int index=3;
        for (int i = 0; i < cantidad_servidores; i++) {
            titulos[index=index+1]="S"+(i+1);
        }
        titulos[index=index+1]="WL";
        titulos[index=index+1]="AT";
        for (int i = 0; i < cantidad_servidores; i++) {
            titulos[index=index+1]="DT"+(i+1);
        }
        titulos[index=index+1]="Np/TELL";
        titulos[index=index+1]="TELL";
        titulos[index=index+1]="Np/TS";
        titulos[index=index+1]="TS";
        
        //String[] titulo = new String[]{"NºEvento","Tipo Evento","IdCliente","TM","S1", "WL","AT","DT1", "NºAleatorio p/TELL","TELL","NºAleatorio p/TS","TS"};
        tabla_eventos.setColumnIdentifiers(titulos);
        table_model.setBounds(0, 0, 1020, 5);

        table_model.setModel(tabla_eventos);
        llamada_simulacion(100,2); //INICIAR LA SIMULACION
    }  
    
    //INICIALIZAR SIMULACION
    public final void llamada_simulacion(int simulacion,int servidores) {
        this.simulacion=simulacion;
        this.servidores = new int[servidores];
        this.dt = new int[servidores];
        
        //INICIALIZAMOS LOS SERVIDORES EN 0
        for (int i = 0; i < this.servidores.length; i++) {
            this.servidores[i]=0;
            this.dt[i]=9999;
        }
        
        correr_simulacion(); //CORREMOS LA SIMULACION
    }
    
    private void correr_simulacion(){
        tabla_eventos.addRow(new Object[]{
                0,"-",0,0,0,0,0,dt[0],"","","",""
         }); 
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
                if(n_servidor_vacio!=9999){
                    //EXISTEN SERVIDORES VACIOS
                    this.servidores[n_servidor_vacio]=1;                     //SE OCUPA EL SERVIDOR
                    generar_ts();                 //SE CALCULA EL TS
                    int valor = this.tm+this.ts;
                    this.dt[n_servidor_vacio]=valor;                        //ASIGNAMOS EL TS AL CLIENTE QUE ENTRO EN EL SERVIDOR VACIO
                }else{
                    //NO EXISTEN SERVIDORES VACIOS
                    this.wl.add(this.cant_cliente);
                }
                this.n_tell= (int)(Math. random()*100+1);   //SE GENERA UN NUMERO ALEATORIO DE TS
                this.tell=calcular_tell();                   //SE CALCULA EL TS
                this.at=this.tm+this.tell;   
                
                tabla_eventos.addRow(new Object[]{
                    n_evento,tipo_evento,cant_cliente,tm,
                    servidores[0],servidores[1],
                    wl.size(),at,
                    dt[0],dt[1],
                    n_tell,tell,n_ts,ts
               });
            }else{
                //SALIDA
                this.tipo_evento="salida";
                this.tm=this.dt[hallar_menor_dt()]; //TM=DT
                if(!this.wl.isEmpty()){
                    //CUANDO HAY COLA
                    this.wl.remove(0); //SE REMUEVE EL PRIMERO EN COLA
                    generar_ts();
                    int valor = this.tm+this.ts;
                    this.dt[hallar_menor_dt()]=valor;  
                }else{
                    //CUANDO NO HAY COLA
                    int menor =hallar_menor_dt();
                    this.dt[menor]=9999;
                    this.servidores[menor]=0;
                }
                tabla_eventos.addRow(new Object[]{
                    n_evento,tipo_evento,id_cliente.get(0),tm,
                    servidores[0],servidores[1],wl.size(),at,
                    dt[0],dt[1]
                    ,n_tell,tell,n_ts,ts
               });
                id_cliente.remove(0);
            }
           
        }
    }
   
    private int hallar_servidor_vacio(){
        for (int i = 0; i < this.servidores.length; i++) {
            if(this.servidores[i]==0){
                return i; //RETORNA LA POSICION SI ENCUENTRA UN SERVIDOR VACIO
            }
        }
        return 9999;
    }
    
    private int valor_menor_dt(){
        int  menor;
        menor=this.dt[0];
        for (int i = 0; i < this.dt.length; i++) {         
            if(this.dt[i]<menor) {
                menor = this.dt[i];
            }
        }
        return menor;
    }

    private int hallar_menor_dt(){
        int menor,posicion=0;
        menor=this.dt[0];
        for (int i = 0; i < this.dt.length; i++) {
            if(this.dt[i]<menor) {
                menor = this.dt[i];
                posicion=i;
            }
        }
        return posicion;
    }
    
    private int calcular_tell(){
         return ((int)(Math. random()*10+1));
    }
    
    private void generar_ts(){
        this.n_ts= (int)(Math. random()*100+1);   //SE GENERA UN NUMERO ALEATORIO DE TS
        this.ts=calcular_ts();  
    }
    
    private int calcular_ts(){
        return ((int)(Math. random()*10+1));
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(guardar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(guardar)
                .addGap(27, 27, 27))
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
