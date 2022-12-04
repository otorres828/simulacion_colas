
package clases;

public class TELL {
    public int tiempo;
    public int probabilidad;
    public int probabilidad_acumulada;
    public int rango_desde;
    public int rango_hasta;

    public TELL(int tiempo, int probabilidad) {
        this.tiempo = tiempo;
        this.probabilidad = probabilidad;
        this.probabilidad_acumulada=Estaticas.probabilidad_acumulada_tell+probabilidad;
        Estaticas.probabilidad_acumulada_tell=this.probabilidad_acumulada;
        this.rango_desde=Estaticas.probabilidad_acumulada_tell-probabilidad;
        this.rango_hasta=Estaticas.probabilidad_acumulada_tell-1;
    }
}
