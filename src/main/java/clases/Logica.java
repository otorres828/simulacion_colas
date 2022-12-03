
package clases;

import java.util.ArrayList;

public class Logica {
    
    public  int at=0;
    
    public ArrayList<Integer> wl = new ArrayList<>(); 
    //TIEMPO ENTRE LLEGADAS
    
    public  int n_tell=0;
    public  int tell=0;
    
    //TIEMPO DE SERVICIO
    public  int n_ts=0;
    public  int ts=0;
    
    public int tm=0;
    public int simulacion=0;
    public String tipo_evento="";
    public int cliente=0;
    
    public  int[] servidores;
    public int dt[];
    
    public Logica(int simulacion,int servidores) {
        this.simulacion=simulacion;
        this.servidores = new int[servidores];
        this.dt = new int[servidores];
        
        //INICIALIZAMOS LOS SERVIDORES EN 0
        for (int i = 0; i < this.servidores.length; i++) {
            this.servidores[i]=0;
            this.dt[i]=9999;
        }
    }
        
    public void correr_simulacion(){
        while(this.tm<this.simulacion){
            if(this.at<valor_menor_dt()){  //compara AT con el valor menor de DT
                //LLEGADA
                this.tm=this.at;
                this.tipo_evento="llegada";
                this.cliente=this.cliente+1;
                
                int n_servidor_vacio=hallar_servidor_vacio();
                if(n_servidor_vacio!=9999){
                    //EXISTEN SERVIDORES VACIOS
                    this.servidores[n_servidor_vacio]=1;                     //SE OCUPA EL SERVIDOR
                    generar_ts();                 //SE CALCULA EL TS
                    int valor = this.tm+this.ts;
                    this.dt[n_servidor_vacio]=valor;                        //ASIGNAMOS EL TS AL CLIENTE QUE ENTRO EN EL SERVIDOR VACIO
                }else{
                    //NO EXISTEN SERVIDORES VACIOS
                    this.wl.add(this.cliente);
                }
                this.n_tell= (int)(Math. random()*100+1);   //SE GENERA UN NUMERO ALEATORIO DE TS
                this.tell=calcular_tell();                   //SE CALCULA EL TS
                this.at=this.tm+this.tell;   
            }else{
                //SALIDA
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
        return 0;
    }
    
    private void generar_ts(){
        this.n_ts= (int)(Math. random()*100+1);   //SE GENERA UN NUMERO ALEATORIO DE TS
        this.ts=calcular_ts();  
    }
    
    private int calcular_ts(){
        return 0;
    }
}
