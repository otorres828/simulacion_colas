
package clases;

import java.util.ArrayList;


public class Estaticas {
    static public ArrayList<TELL> probabilidades_tell = new ArrayList<TELL>(); 
    static public ArrayList<TS> probabilidades_ts = new ArrayList<TS>(); 
    static public int cantidad_servidores=0; 
    static public int TM_simulacion=0; 
    static public int probabilidad_acumulada_tell=0; 
    static public int probabilidad_acumulada_ts=0; 
    
    static public void asignar_tell(int tiempo,int probabilidad){
        TELL objeto = new TELL(tiempo,probabilidad);
        probabilidades_tell.add(objeto);
    }
    
    static public void asignar_ts(int tiempo,int probabilidad){
        TS objeto = new TS(tiempo,probabilidad);
        probabilidades_ts.add(objeto);
    }
    
    
}
