
package clases;

import java.util.ArrayList;


public class Estaticas {
    static public ArrayList<TELL> probabilidades_tell = new ArrayList<>(); 
    static public ArrayList<TS> probabilidades_ts = new ArrayList<>(); 
    static public int cantidad_servidores=0; 
    static public int TM_simulacion=0; 
    static public int probabilidad_acumulada_tell=0; 
    static public int probabilidad_acumulada_ts=0; 
    
    static public int cantidad_tell=0;
    static public int cantidad_ts=0;
    
    static public String unidad_tiempo="";
    static public String presentar_tabla_eventos="";
    
    static public TELL asignar_tell(int tiempo,int probabilidad){
        TELL objeto = new TELL(tiempo,probabilidad);
        probabilidades_tell.add(objeto);
        return objeto;
    }
    
    static public TS asignar_ts(int tiempo,int probabilidad){
        TS objeto = new TS(tiempo,probabilidad);
        probabilidades_ts.add(objeto);
        return objeto;
    }

    public static void setCantidad_servidores(int cantidad_servidores) {
        Estaticas.cantidad_servidores = cantidad_servidores;
    }

    public static void setTM_simulacion(int TM_simulacion) {
        Estaticas.TM_simulacion = TM_simulacion;
    }
    
    public static void reiniciar() {
        probabilidades_tell = new ArrayList<>();
        probabilidades_ts = new ArrayList<>();
        probabilidad_acumulada_tell = 0;
        probabilidad_acumulada_ts = 0;
        cantidad_tell = 0;
        cantidad_ts=0;
    }
    
    
    
}
