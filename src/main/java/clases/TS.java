
package clases;

public class TS {
    public int tiempo;
    public int probabilidad;
    public int probabilidad_acumulada;
    public int rango_desde;
    public int rango_hasta;

    public TS(int tiempo, int probabilidad) {
        this.tiempo = tiempo;
        this.probabilidad = probabilidad;
        this.probabilidad_acumulada=Estaticas.probabilidad_acumulada_ts+probabilidad;
        Estaticas.probabilidad_acumulada_ts=this.probabilidad_acumulada;
        this.rango_desde=Estaticas.probabilidad_acumulada_ts-probabilidad;
        this.rango_hasta=Estaticas.probabilidad_acumulada_ts-1;
    }
}
