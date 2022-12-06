
package clases;

public class Cliente {
    public int id;
    public int valor;
    public int tm=0;
    public int dt=0;
    
    public Cliente(int id, int valor) {
        this.id = id;
        this.valor = valor;
    }
    
    public Cliente(int id,int tm,int dt){
        this.id=id;
        this.tm=tm;
        this.dt=dt;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTm() {
        return tm;
    }

    public void setTm(int tm) {
        this.tm = tm;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }
    
    
}
