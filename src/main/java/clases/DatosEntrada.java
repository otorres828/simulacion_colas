
package clases;

import javax.swing.table.DefaultTableModel;

public class DatosEntrada {
    /*1*/ public String unidad_tiempo;
    /*2*/ public String presentar_tabla_eventos;
    /*3*/ public int cantidad_simulacion;
    /*4*/ public int cantidad_tell;
    /*5*/ public DefaultTableModel tabla_tell;
    /*6*/ public int cantidad_servidores;
    /*7*/ public int cantidad_ts;
    /*8*/ public DefaultTableModel tabla_ts;
    /*9*/ public int costo_servicio;
    /*10*/ public int costo_tiempo_cliente;
    /*11*/ public int costo_servidor;

    public DatosEntrada() {
        this.unidad_tiempo = "horas";
        this.presentar_tabla_eventos = "si";
        this.cantidad_simulacion = 0;
        this.cantidad_tell = 0;
        this.tabla_tell = new DefaultTableModel();
        this.cantidad_servidores = 0;
        this.cantidad_ts = 0;
        this.tabla_ts = new DefaultTableModel();
        this.costo_servicio = 0;
        this.costo_tiempo_cliente = 0;
        this.costo_servidor = 0;
    }

    public DatosEntrada(String unidad_tiempo, String presentar_tabla_eventos, int cantidad_simulacion, int cantidad_tell, DefaultTableModel tabla_tell, int cantidad_servidores, int cantidad_ts, DefaultTableModel tabla_ts, int costo_servicio, int costo_tiempo_cliente, int costo_servidor) {
        this.unidad_tiempo = unidad_tiempo;
        this.presentar_tabla_eventos = presentar_tabla_eventos;
        this.cantidad_simulacion = cantidad_simulacion;
        this.cantidad_tell = cantidad_tell;
        this.tabla_tell = tabla_tell;
        this.cantidad_servidores = cantidad_servidores;
        this.cantidad_ts = cantidad_ts;
        this.tabla_ts = tabla_ts;
        this.costo_servicio = costo_servicio;
        this.costo_tiempo_cliente = costo_tiempo_cliente;
        this.costo_servidor = costo_servidor;
    }

    public String getUnidad_tiempo() {
        return unidad_tiempo;
    }

    public void setUnidad_tiempo(String unidad_tiempo) {
        this.unidad_tiempo = unidad_tiempo;
    }

    public String getPresentar_tabla_eventos() {
        return presentar_tabla_eventos;
    }

    public void setPresentar_tabla_eventos(String presentar_tabla_eventos) {
        this.presentar_tabla_eventos = presentar_tabla_eventos;
    }


    public int getCantidad_simulacion() {
        return cantidad_simulacion;
    }

    public void setCantidad_simulacion(int cantidad_simulacion) {
        this.cantidad_simulacion = cantidad_simulacion;
    }

    public int getCantidad_tell() {
        return cantidad_tell;
    }

    public void setCantidad_tell(int cantidad_tell) {
        this.cantidad_tell = cantidad_tell;
    }

    public DefaultTableModel getTabla_tell() {
        return tabla_tell;
    }

    public void setTabla_tell(DefaultTableModel tabla_tell) {
        this.tabla_tell = tabla_tell;
    }

    public int getCantidad_servidores() {
        return cantidad_servidores;
    }

    public void setCantidad_servidores(int cantidad_servidores) {
        this.cantidad_servidores = cantidad_servidores;
    }

    public int getCantidad_ts() {
        return cantidad_ts;
    }

    public void setCantidad_ts(int cantidad_ts) {
        this.cantidad_ts = cantidad_ts;
    }

    public DefaultTableModel getTabla_ts() {
        return tabla_ts;
    }

    public void setTabla_ts(DefaultTableModel tabla_ts) {
        this.tabla_ts = tabla_ts;
    }

    public int getCosto_servicio() {
        return costo_servicio;
    }

    public void setCosto_servicio(int costo_servicio) {
        this.costo_servicio = costo_servicio;
    }

    public int getCosto_tiempo_cliente() {
        return costo_tiempo_cliente;
    }

    public void setCosto_tiempo_cliente(int costo_tiempo_cliente) {
        this.costo_tiempo_cliente = costo_tiempo_cliente;
    }

    public int getCosto_servidor() {
        return costo_servidor;
    }

    public void setCosto_servidor(int costo_servidor) {
        this.costo_servidor = costo_servidor;
    }

    
}
