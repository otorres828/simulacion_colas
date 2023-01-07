
package clases;

import javax.swing.table.DefaultTableModel;


public class DatosSalida {
    public float w;
    public float wq;
    public float l;
    public float lq;
    public int ta;
    public float utilizacion[];
    public float costo_servidores;
    public float costo_espera_cliente;  
    public float costo_atencion_cliente;
    public float costo_cliente;
    public float costo_general;
    
    public DefaultTableModel tabla_tell;
    public DefaultTableModel tabla_ts;

    public DatosSalida() {
        this.w = 0;
        this.wq = 0;
        this.l = 0;
        this.lq = 0;
        this.ta = 0;
        this.costo_general=0;
        this.costo_espera_cliente=0;
        this.costo_atencion_cliente=0;
        this.costo_cliente=0;
        this.costo_general=0;
        this.tabla_tell = new DefaultTableModel();
        this.tabla_ts = new DefaultTableModel();
    }

    public DatosSalida(float w, float wq, float l, float lq, int ta, float[] utilizacion, float costo_servidores, float costo_espera_cliente, float costo_atencion_cliente, float costo_cliente, float costo_general, DefaultTableModel tabla_tell, DefaultTableModel tabla_ts) {
        this.w = w;
        this.wq = wq;
        this.l = l;
        this.lq = lq;
        this.ta = ta;
        this.utilizacion = utilizacion;
        this.costo_servidores = costo_servidores;
        this.costo_espera_cliente = costo_espera_cliente;
        this.costo_atencion_cliente = costo_atencion_cliente;
        this.costo_cliente = costo_cliente;
        this.costo_general = costo_general;
        this.tabla_tell = tabla_tell;
        this.tabla_ts = tabla_ts;
    }

    public float getCosto_servidores() {
        return costo_servidores;
    }

    public float getCosto_espera_cliente() {
        return costo_espera_cliente;
    }

    public float getCosto_atencion_cliente() {
        return costo_atencion_cliente;
    }

    public float getCosto_cliente() {
        return costo_cliente;
    }

    public float getCosto_general() {
        return costo_general;
    }

    public float[] getUtilizacion() {
        return utilizacion;
    }

    public int getTa() {
        return ta;
    }

    public void setTa(int ta) {
        this.ta = ta;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }

    public float getWq() {
        return wq;
    }

    public void setWq(float wq) {
        this.wq = wq;
    }

    public float getL() {
        return l;
    }

    public void setL(float l) {
        this.l = l;
    }

    public float getLq() {
        return lq;
    }

    public void setLq(float lq) {
        this.lq = lq;
    }

    public DefaultTableModel getTabla_tell() {
        return tabla_tell;
    }

    public void setTabla_tell(DefaultTableModel tabla_tell) {
        this.tabla_tell = tabla_tell;
    }

    public DefaultTableModel getTabla_ts() {
        return tabla_ts;
    }

    public void setTabla_ts(DefaultTableModel tabla_ts) {
        this.tabla_ts = tabla_ts;
    }

  
    
    
}
