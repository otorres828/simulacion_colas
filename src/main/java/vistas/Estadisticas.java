package vistas;

import clases.Cliente;
import clases.DatosSalida;
import clases.Estaticas;
import clases.GestorArchivos;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import principal.principal;

public class Estadisticas extends javax.swing.JPanel {

  DefaultTableModel tabla_eventos = new DefaultTableModel();
  DefaultTableModel estadisticas = new DefaultTableModel();

  public int at = 0;

  public ArrayList<Integer> wl = new ArrayList<>();
  public ArrayList<Integer> id_cliente = new ArrayList<>(); //CUENTA LA CANTIDAD DE CLIENTES QUE VAN LLEGANDO

  //TIEMPO ENTRE LLEGADAS
  public int n_tell = 0;
  public int tell = 0;

  //TIEMPO DE SERVICIO
  public int n_ts = 0;
  public int ts = 0;

  public int tm = 0;
  public int simulacion = 0;
  public String tipo_evento = "";
  public int cant_cliente = 0;
  public int clientes_sistema = 0;

  public int[] servidores;

  public Cliente dt[];
  public float utilizacion[];
  public float acumulador_utilizacion[];
  public float costo_servidores[];
  public float acosto_servidores[];
  
  /*VARIABLES PARA EL CALCULO DE LA UTILIZACION Y LOS COSTOS*/
  public int bandera[];
  public int TM_ANTERIOR[];
  public int TM_AUXILIAR[];
  
  public int n_evento_totales = 0, n_eventos_diarios = 0;

  /*VARIABLES QUE CONTROLAN LA CANTIDAD DE SERVIDORES Y EL TIEMPO DE SIMULACION*/
  public int cantidad_servidores = 0;
  public int cliente_salida_cola = 0; //SE UTILIZA PARA OBTENER EL ID DEL CLIENTE QUE ENTRA A LA COLA
  public int cliente_salida_no_cola = 0; //SE UTILIZA PARA OBTENER EL ID DEL CLIENTE QUE SALDRA DE LA COLA

  /*VARIABLES PARA EL CALCULO DE ESTADISTICAS DIARIAS*/
  public float l = 0, lq = 0, w = 0, wq = 0;
  /*VARIABLES PARA EL CALCULO DE ESTADISTICAS TOTALES PROMEDIALES*/
  public float acumulador_l = 0, acumulador_lq = 0, acumulador_w =
    0, acumulador_wq = 0;

  public ArrayList<Cliente> w_auxiliar = new ArrayList<>();
  public ArrayList<Cliente> wq_auxiliar = new ArrayList<>();

  /*VARIABLE PARA EL CALCULO DEL TIEMPO ADICIONAL O EXTRA DIARIO*/
  public int ta = 0;
  /*VARIABLE PARA EL CALCULO DEL TIEMPO ADICIONAL O EXTRA TOTAL PROMEDIAL*/
  public int acumulador_ta = 0;
  public int tiempo_extra=0;
  
  /*VARIABLES PARA EL CALCULO DE COSTOS*/
  public float costo_espera_cliente = 0;
  public float acosto_espera_cliente = 0;
  public float costo_clientes_servicio = 0;
  public float acosto_clientes_servicio = 0;
  public float costo_cliente = 0;
  public float costo_general = 0;
  public float costo_general_servidores=0;
  /*VARIABLES NUEVAS PARA EL CASO DE USO*/
  public int dia = 0;

  public Estadisticas() {
    initComponents();
  }

  public void inicializar_datos() {
    this.label_servidores.setText(
        Integer.toString(Estaticas.cantidad_servidores)
      );
    this.unidad_tiempow.setText(Estaticas.unidad_tiempo);
    this.unidad_tiempowq.setText(Estaticas.unidad_tiempo);
    this.unidad_tiempota.setText(Estaticas.unidad_tiempo);
    this.time.setText(Estaticas.unidad_tiempo);
    this.time1.setText(Estaticas.unidad_tiempo);
    this.time2.setText(Estaticas.unidad_tiempo);
    this.time3.setText(Estaticas.unidad_tiempo);
    this.time4.setText(Estaticas.unidad_tiempo);
    this.cantidad_servidores = Estaticas.cantidad_servidores;
    this.simulacion = Estaticas.TM_simulacion;
    cargar_cabecera_tabla(); //CARGAR CABECERA DE LA TABLA DE EVENTOS
    
    //MOSTRAR EL PANEL DE EVENTOS
    if ("No".equals(Estaticas.presentar_tabla_eventos)) {
      this.panel_tabla_eventos.setVisible(false);
    } else {
      this.panel_tabla_eventos.setVisible(true);
    }
    
    llamada_simulacion(cantidad_servidores); //INICIAR LA SIMULACION
  }

  private void cargar_cabecera_tabla() {
    String[] titulos = new String[12 + (2 * cantidad_servidores)];
    titulos[0] = "Nº Evento";
    titulos[1] = "Tipo Evento";
    titulos[2] = "Id Cliente";
    titulos[3] = "TM";
    int index = 3;
    for (int i = 0; i < cantidad_servidores; i++) {
      titulos[index = index + 1] = "S" + (i + 1);
    }
    titulos[index = index + 1] = "WL";
    titulos[index = index + 1] = "Clientes Sistema";
    titulos[index = index + 1] = "AT";
    for (int i = 0; i < cantidad_servidores; i++) {
      titulos[index = index + 1] = "DT" + (i + 1);
    }
    titulos[index = index + 1] = "Np/TELL";
    titulos[index = index + 1] = "TELL";
    titulos[index = index + 1] = "Np/TS";
    titulos[index = index + 1] = "TS";
    titulos[index = index + 1] = "Dia";

    tabla_eventos = new DefaultTableModel(null, titulos);
    table_modelo.setModel(tabla_eventos);

    //CABECERA DE ESTADISTICAS
    String[] titulos_estadisticas = new String[this.cantidad_servidores];
    for (int i = 0; i < this.cantidad_servidores; i++) {
      titulos_estadisticas[i] = "Utilizacion S" + (i + 1);
    }

    estadisticas = new DefaultTableModel(null, titulos_estadisticas);
    table_modelo_estadisticas.setModel(estadisticas);
  }

  //INICIALIZAR SIMULACION
  public final void llamada_simulacion(int servidores) {
    this.servidores = new int[servidores];
    this.dt = new Cliente[servidores];
    this.utilizacion = new float[servidores]; //PARA CALCULAR EL PORCENTAJE DE UTILIZACION DIARIO
    this.acumulador_utilizacion = new float[servidores]; //PARA CALCULAR EL PORCENTAJE DE UTILIZACION TOTAL PROMEDIAL
    this.TM_ANTERIOR = new int[servidores];
    this.TM_AUXILIAR = new int[servidores];
    this.bandera = new int[servidores];
    this.costo_servidores = new float[servidores];
    this.acosto_servidores = new float[servidores];
    
    /*INICIALIZAR LA UTILIZACION EN 0*/
    for (int i = 0; i < this.utilizacion.length; i++) {
      this.utilizacion[i] = 0;
      this.acumulador_utilizacion[i] = 0;
      this.TM_ANTERIOR[i] = 0;
      this.TM_AUXILIAR[i] = 0;
      this.bandera[i] = 0;
      /*COSTO*/
      this.costo_servidores[i]=0;
      this.acosto_servidores[i]=0;
    }

    //INICIALIZAMOS LOS SERVIDORES EN 0
    for (int i = 0; i < this.servidores.length; i++) {
      this.servidores[i] = 0;
      Cliente c = new Cliente(0, 999999);
      this.dt[i] = c;
    }
    this.n_evento_totales = 0; //INICIALIZAMOS EL EVENTO EN 0
    correr_simulacion(); //CORREMOS LA SIMULACION

    //CALCULAR COSTOS
    calcular_costos();

    //CARGAR ESTADISTICAS DEL PORCENTAJE DE UTILIZACION DE CADA SERVIDOR
    cargar_estadisticas();
  }

  //ESTE METODO ES EL ENCARGADO DE SACAR TODOS LOS CALCULOS DE LA TABLA DE EVENTOS Y ESTADITICAS
  private void correr_simulacion() {
    limpiar(); //LIMPIAR VARIABLES
    this.dia = 1; 
    this.tiempo_extra=Estaticas.TM_interno;
    tabla_eventos.addRow(obtener_objeto_llegada());
    //MIENTRAS DIA MENOR TIEMPO_SIMULACION

    while (this.dia <= Estaticas.TM_simulacion) {
      while (this.tm < Estaticas.TM_interno) {
        n_evento_totales++;
        n_eventos_diarios++;
        if (this.at < valor_menor_dt()) { //compara AT con el valor menor de DT
          //LLEGADA
          llegada();
        } else {
          //SALIDA
          salida();
        }
        //CALCULAR L
        this.l = l + calcular_l();
        this.lq = lq + calcular_lq();

        //AUMENTAR LA UTILIZACION DEL SERVIDOR
        aumentar_utilizacion();
      } //TERMINO EL DIA

      //SACAR A LOS QUE ESTAN EN COLA
      while(verificar_servidor_vacio()!=0 && this.tm>Estaticas.TM_interno){  //SE EJECUTA MIENTRAS TODOS LOS SERVIDORES NO ESTEN VACIOS
        n_evento_totales++;
        n_eventos_diarios++;

        salida();
         //CALCULAR L
        this.l = l + ((valor_menor_dt() - tm) * clientes_sistema); 
        this.lq = lq + ((valor_menor_dt() - tm) *  wl.size());
        //AUMENTAR LA UTILIZACION DEL SERVIDOR
        aumentar_utilizacion();
      }
      //CALCULAR TIEMPO EXTRA O ADICIONAL 
      this.ta=this.tm-this.tiempo_extra;   
      //CALCULAR W Y WQ
      this.w = w / cant_cliente; 
      this.wq = wq / cant_cliente;
      
      //CALCULAR L Y LQ
      this.l = (this.l / this.tm); 
      this.lq = (this.lq / this.tm);
      
      //CALCULAR COSTO CLIENTE
      this.costo_clientes_servicio=(this.l-this.lq)*Estaticas.costo_servicio;
      this.costo_espera_cliente=this.lq*Estaticas.costo_tiempo_cliente;;
      reiniciar_dia();
    } //aqui termino toda la simulacion

    calculo_estadisticas_finales();
  }

  private void reiniciar_dia() {
    acumuladores();
    limpiar();
    this.dia = this.dia + 1;
    //REINICIAMOS LOS SERVIDORES EN 0
    for (int i = 0; i < this.servidores.length; i++) {
      this.servidores[i] = 0;
      Cliente c = new Cliente(0, 999999);
      this.dt[i] = c;
    }
  }

  private void acumuladores() {
    //ASIGNAMOS EL PORCENTAJE DE UTILIZACION AL ACUMULADOR
    for (int i = 0; i < this.utilizacion.length; i++) {
      this.costo_servidores[i]=this.utilizacion[i]*Estaticas.costo_servidor;
      this.utilizacion[i] =(this.utilizacion[i]/this.tm)*100;
      
    }
    //ASIGNAMOS EL PORCENTAJE AL ACUMULADOR
    for (int i = 0; i < this.utilizacion.length; i++) {
      this.acumulador_utilizacion[i] =this.acumulador_utilizacion[i] + this.utilizacion[i];
      this.acosto_servidores[i] =this.acosto_servidores[i] + this.costo_servidores[i];
      
    }
    this.acumulador_l = this.acumulador_l + this.l;
    this.acumulador_lq = this.acumulador_lq + this.lq;
    this.acumulador_w = this.acumulador_w + this.w; 
    this.acumulador_wq = this.acumulador_wq + this.wq;
    this.acumulador_ta = this.acumulador_ta + this.ta;
    
    /*COSTO CLIENTE EN SERVICIO*/
    this.acosto_clientes_servicio=this.acosto_clientes_servicio+this.costo_clientes_servicio;
    this.acosto_espera_cliente=this.acosto_espera_cliente+this.costo_espera_cliente;  
  }
    
  private void calculo_estadisticas_finales() {
    // PORCENTAJE DE UTILIZACION
    this.dia=this.dia-1;
    for (int i = 0; i < this.acumulador_utilizacion.length; i++) {
      this.acumulador_utilizacion[i] =(this.acumulador_utilizacion[i] / this.dia);
      this.acosto_servidores[i] =(this.acosto_servidores[i] / this.dia);
    }
    this.acumulador_l = this.acumulador_l / this.dia;
    this.acumulador_lq = this.acumulador_lq / this.dia; 
    this.acumulador_w = this.acumulador_w / this.dia; 
    this.acumulador_wq = this.acumulador_wq / this.dia;
    this.acumulador_ta = this.acumulador_ta / this.dia;
    this.label_simulacion.setText(Integer.toString(Estaticas.TM_simulacion));
    
  }
  
  private void calcular_costos() {
    /*COSTO GENERAL*/ 
    for (int i = 0; i < cantidad_servidores; i++) {
      this.costo_general_servidores= this.acosto_servidores[i]+this.costo_general_servidores;
    }
    this.costo_general_servidores=this.costo_general_servidores/cantidad_servidores;
    this.costo_ser.setText(String.valueOf(this.costo_general_servidores));
    
    /*COSTO CLIENTES EN SERVICIO*/
    this.costo_clientes_servicio=this.acosto_clientes_servicio/this.dia;
    this.costo_servicio.setText(String.valueOf(costo_clientes_servicio));
    
    /*COSTO CLIENTES EN COLA*/
    this.costo_espera_cliente =  this.acosto_espera_cliente/this.dia;
    this.costo_co.setText(String.valueOf(this.costo_espera_cliente));
    
    /*COSTO CLIENTE*/
    this.costo_cliente =   this.costo_espera_cliente + this.costo_clientes_servicio;
    this.costo_cli.setText(String.valueOf(this.costo_cliente));
    
    /*COSTO GENERAL*/
    this.costo_general = this.costo_general_servidores+this.costo_cliente ;
    this.costo_ge.setText(String.valueOf(this.costo_general));
  }

  private Object[] obtener_objeto_llegada() {
    añadir_tm_w(cant_cliente, tm);
    String[] objeto = new String[12 + (2 * cantidad_servidores)];
    objeto[0] = String.valueOf(n_evento_totales);
    objeto[1] = tipo_evento;
    objeto[2] = String.valueOf(cant_cliente);
    objeto[3] = String.valueOf(tm);
    int index = 3;
    for (int i = 0; i < cantidad_servidores; i++) {
      objeto[index = index + 1] = String.valueOf(servidores[i]);
    }
    if (!wl.isEmpty()) objeto[index = index + 1] =
      wl.size() + "" + wl; else objeto[index = index + 1] = ""; //wl.size();
    objeto[index = index + 1] = String.valueOf(clientes_sistema);
    objeto[index = index + 1] = String.valueOf(at);
    for (int i = 0; i < cantidad_servidores; i++) {
      if (dt[i].valor != 999999) objeto[index = index + 1] =
        dt[i].valor + "(" + dt[i].id + ")"; else objeto[index = index + 1] =
        "XXX";
    }
    objeto[index = index + 1] = String.valueOf(n_tell);
    objeto[index = index + 1] = String.valueOf(tell);
    objeto[index = index + 1] = String.valueOf(n_ts);
    objeto[index = index + 1] = String.valueOf(ts);
    objeto[index = index + 1] = String.valueOf(dia);

    return objeto;
  }

  private Object obtener_objeto_salida() {
    Object[] objeto = new Object[12 + (2 * cantidad_servidores)];
    objeto[0] = n_evento_totales;
    objeto[1] = tipo_evento;

    if (cliente_salida_cola != 0) {
      objeto[2] = this.cliente_salida_cola; //CUANDO HAY COLA SE LE ASIGNA EL CLIENTE QUE ESTA SALIENDO DE LA COLA
      añadir_w_dt(this.cliente_salida_cola, tm); //ASIGNAR DT AL CLIENTE QUE ESTA SALIENDO PARA CALCULAR EL W
    } else {
      int id_de_cliente =
        this.id_cliente.get(id_cliente.indexOf(cliente_salida_no_cola));
      objeto[2] = id_de_cliente; //CUANDO NO HAY COLA SE LE ASIGNA EL CLIENTE 0 EN EL ARRAY LIST
      añadir_w_dt(id_de_cliente, tm); //ASIGNAR DT AL CLIENTE QUE ESTA SALIENDO PARA CALCULAR EL W
    }

    objeto[3] = tm;
    int index = 3;
    for (int i = 0; i < cantidad_servidores; i++) {
      objeto[index = index + 1] = servidores[i];
    }
    /*IMPRIMIR CLIENTES EN COLA*/
    if (!wl.isEmpty()) objeto[index = index + 1] =
      wl.size() + "" + wl; else objeto[index = index + 1] = ""; //wl.size()
    objeto[index = index + 1] = clientes_sistema;
    objeto[index = index + 1] = at;
    for (int i = 0; i < cantidad_servidores; i++) {
      if (dt[i].valor != 999999) objeto[index = index + 1] =
        dt[i].valor + "(" + dt[i].id + ")"; //OBTIENE EL VALOR DE DT CON EL CLIENTE (AQUI ALGUIEN DEL A COLA ENTRO A UN SERVIDOR)
      else objeto[index = index + 1] = "XXX"; //OBTIENE 999 PORQUE HUBO UNA SALIDA Y EL SERVIDOR QUEDO VACIO
    }
    objeto[index = index + 1] = n_tell;
    objeto[index = index + 1] = tell;
    objeto[index = index + 1] = n_ts;
    objeto[index = index + 1] = ts;
    objeto[index = index + 1] = dia;

    return objeto;
  }

  private int hallar_servidor_vacio() {
    for (int i = 0; i < this.servidores.length; i++) {
      if (this.servidores[i] == 0) {
        return i; //RETORNA LA POSICION SI ENCUENTRA UN SERVIDOR VACIO
      }
    }
    return 999999; //RETORNA SI NO HAY SERVIDOR VACIO
  }

  private int verificar_servidor_vacio() {
    int acumulador=0;
    for (int i = 0; i < this.servidores.length; i++) {
      acumulador=this.servidores[i]+acumulador;
    }
    return acumulador; //RETORNA LA CANTIDAD DE SERVIDORES LLENOS
  }
  
  private int valor_menor_dt() {
    int menor;
    menor = this.dt[0].valor;
    for (int i = 0; i < this.dt.length; i++) {
      if (this.dt[i].valor < menor) {
        menor = this.dt[i].valor;
      }
    }
    return menor;
  }

  private int hallar_menor_dt() {
    int menor, posicion = 0;
    menor = this.dt[0].valor;
    for (int i = 0; i < this.dt.length; i++) {
      if (this.dt[i].valor < menor) {
        menor = this.dt[i].valor;
        posicion = i;
      }
    }
    return posicion;
  }

  private int calcular_tell() {
    for (int i = 0; i < Estaticas.probabilidades_tell.size(); i++) if (
      n_tell >= Estaticas.probabilidades_tell.get(i).rango_desde &&
      n_tell <= Estaticas.probabilidades_tell.get(i).rango_hasta
    ) return Estaticas.probabilidades_tell.get(i).tiempo;

    return (99999); //GENERA EN CASO DE ERROR
  }

  private int calcular_ts() {
    for (int i = 0; i < Estaticas.probabilidades_ts.size(); i++) if (
      n_ts >= Estaticas.probabilidades_ts.get(i).rango_desde &&
      n_ts <= Estaticas.probabilidades_ts.get(i).rango_hasta
    ) return Estaticas.probabilidades_ts.get(i).tiempo;
    return (99999); //GENERA EN CASO DE ERROR
  }

  @SuppressWarnings("empty-statement")
  private void generar_ts() {
    int numero;
    while ((numero = (int) (Math.random() * 100)) == n_ts);
    this.n_ts = numero; //SE GENERA UN NUMERO ALEATORIO DE TS
    this.ts = calcular_ts();
  }

  private void limpiar() {
    id_cliente.clear(); //LIMPIAMOS EL ARRAY QUE GUARDA EL ID DEL CLIENTE
    wl.clear(); //LIMPIAMOS EL ARRAY QUE GUARDA LA COLA
    this.tm = 0;
    this.at = 0;
    this.tipo_evento = "";
    this.cant_cliente = 0;
    this.n_eventos_diarios = 0;
    this.n_tell = 0;
    this.n_ts = 0;
    this.tell = 0;
    this.ts = 0;
    this.clientes_sistema = 0;
    //estadisticas
    this.w = 0;
    this.wq = 0;
    this.l = 0;
    this.lq = 0;
    this.ta = 0;
    this.w_auxiliar.clear();
    this.wq_auxiliar.clear();
    //PORCENTAJE DE UTILIZACION DE LOS SERVIDORES
    for (int i = 0; i < this.utilizacion.length; i++) {
      this.utilizacion[i] = 0;
      this.TM_ANTERIOR[i] = 0;
      this.TM_AUXILIAR[i] = 0;
      this.bandera[i] = 0;
      /*costo*/
      this.costo_servidores[i] = 0;

    }
    //COSTOS
    this.costo_clientes_servicio = 0;
    this.costo_cliente = 0;
    this.costo_espera_cliente = 0;
    this.costo_general = 0;
    
  }

  private int calcular_l() {
    int calculo;
    if (at < valor_menor_dt()) {
      calculo = (at - tm) * clientes_sistema;
    } else {
      calculo = (valor_menor_dt() - tm) * clientes_sistema;
    }
    return calculo;
  }

  private int calcular_lq() {
    int calculo;
    if (at < valor_menor_dt()) {
      calculo = (at - tm) * wl.size();
    } else {
      calculo = (valor_menor_dt() - tm) * wl.size();
    }
    return calculo;
  }

  //PARA CALCULAR W
  private void añadir_tm_w(int ncliente, int valortm) {
    Cliente objeto = new Cliente(ncliente, valortm, 0);
    this.w_auxiliar.add(objeto);
  }

  private void añadir_w_dt(int ncliente, int valortm) {
    //Cliente obj2;
    for (Cliente obj : w_auxiliar) {
      if (obj.id == ncliente) {
        w = (valortm - obj.tm) + w;
        //obj2= new Cliente(obj.id,obj.valor,obj.tm);
        break;
      }
    }
    //w_auxiliar.remove(obj2);
  }

  //PARA CALCULAR WQ
  private void añadir_wq_tm(int ncliente, int valortm) {
    Cliente objeto = new Cliente(ncliente, valortm, 0);
    this.wq_auxiliar.add(objeto);
  }

  private void añadir_wq_dt(int ncliente, int valortm) {
    for (Cliente obj : wq_auxiliar) {
      if (obj.id == ncliente) {
        wq = (valortm - obj.tm) + wq;
        break;
      }
    }
  }

  private int calcular_tiempo_adicional() {
    int mayor = 0, posicion = 0;
    for (int i = 0; i < this.dt.length; i++) {
      if (this.dt[i].valor != 999999) {
        if (this.dt[i].valor > mayor) {
          mayor = this.dt[i].valor;
          posicion = i;
        }
      }
    }
    if (mayor != 0) {
      return this.dt[posicion].valor - this.tm;
    }
    return 0;
  }

  private void cargar_estadisticas() {
    Object[] fila = new Object[this.cantidad_servidores];
    for (int i = 0; i < cantidad_servidores; i++) {
      fila[i] = this.acumulador_utilizacion[i];
    }

    this.estadisticas.addRow(fila);

    this.valor_l.setText(String.valueOf(this.acumulador_l));
    this.valor_lq.setText(String.valueOf(this.acumulador_lq));
    this.valor_w.setText(String.valueOf(this.acumulador_w));
    this.valor_wq.setText(String.valueOf(this.acumulador_wq));
    this.valor_ta.setText(String.valueOf(this.acumulador_ta));
  }

 

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_tabla_eventos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_modelo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_modelo_estadisticas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        valor_l = new javax.swing.JLabel();
        valor_lq = new javax.swing.JLabel();
        valor_w = new javax.swing.JLabel();
        valor_wq = new javax.swing.JLabel();
        unidad_tiempowq = new javax.swing.JLabel();
        unidad_tiempow = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        valor_ta = new javax.swing.JLabel();
        unidad_tiempota = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        costo_ser = new javax.swing.JLabel();
        costo_ge = new javax.swing.JLabel();
        costo_servicio = new javax.swing.JLabel();
        costo_co = new javax.swing.JLabel();
        costo_cli = new javax.swing.JLabel();
        dolar = new javax.swing.JLabel();
        dolar1 = new javax.swing.JLabel();
        dolar2 = new javax.swing.JLabel();
        dolar3 = new javax.swing.JLabel();
        dolar4 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        time1 = new javax.swing.JLabel();
        time2 = new javax.swing.JLabel();
        time3 = new javax.swing.JLabel();
        time4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        label_simulacion = new javax.swing.JLabel();
        label_servidores = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();
        regresar = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 204, 255));

        panel_tabla_eventos.setBackground(new java.awt.Color(102, 204, 255));

        table_modelo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(table_modelo);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setText("TABLA DE EVENTOS");

        javax.swing.GroupLayout panel_tabla_eventosLayout = new javax.swing.GroupLayout(panel_tabla_eventos);
        panel_tabla_eventos.setLayout(panel_tabla_eventosLayout);
        panel_tabla_eventosLayout.setHorizontalGroup(
            panel_tabla_eventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tabla_eventosLayout.createSequentialGroup()
                .addGroup(panel_tabla_eventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_tabla_eventosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1007, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_tabla_eventosLayout.createSequentialGroup()
                        .addGap(421, 421, 421)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_tabla_eventosLayout.setVerticalGroup(
            panel_tabla_eventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_tabla_eventosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        table_modelo_estadisticas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(table_modelo_estadisticas);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("Tiempo promedio que pasa el cliente en el sistema (W):");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel3.setText("Tiempo promedio que pasa el cliente en cola (WQ):");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel4.setText("Cantidad promedio de clientes en el sistema (L):");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel6.setText("Cantidad promedio de clientes en cola (LQ):");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("ESTADISTICAS");

        valor_l.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        valor_l.setText("valor de l");

        valor_lq.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        valor_lq.setText("valor de lq");

        valor_w.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        valor_w.setText("valor de w");

        valor_wq.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        valor_wq.setText("valor de wq");

        unidad_tiempowq.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        unidad_tiempowq.setText("unidad_tiempo");

        unidad_tiempow.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        unidad_tiempow.setText("unidad_tiempo");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel9.setText("Tiempo promedio adicional trabajado por los servidores:");

        valor_ta.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        valor_ta.setText("valor de ta");

        unidad_tiempota.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        unidad_tiempota.setText("unidad_tiempo");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel10.setText("Costo promedio de servidores");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("COSTOS");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel13.setText("Costo promedio clientes en servicio:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel14.setText("Costo promedio de clientes en cola:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel15.setText("Costo promedio de clientes (TOTAL):");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel16.setText("Costo promedio general (clientes + servidores):");

        costo_ser.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        costo_ser.setText("c_s");

        costo_ge.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        costo_ge.setText("c_g");

        costo_servicio.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        costo_servicio.setText("c_c_s");

        costo_co.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        costo_co.setText("c_c");

        costo_cli.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        costo_cli.setText("c_cl");

        dolar.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        dolar.setText("$/");

        dolar1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        dolar1.setText("$/");

        dolar2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        dolar2.setText("$/");

        dolar3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        dolar3.setText("$/");

        dolar4.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        dolar4.setText("$/");

        time.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        time.setText("time");

        time1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        time1.setText("time");

        time2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        time2.setText("time");

        time3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        time3.setText("time");

        time4.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        time4.setText("time");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(costo_ge)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dolar4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(time4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(valor_lq)
                                            .addComponent(valor_ta))
                                        .addGap(27, 27, 27)
                                        .addComponent(unidad_tiempota))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(costo_servicio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dolar1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(time1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(costo_co)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dolar2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(time2))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(costo_cli)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dolar3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(time3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(costo_ser)
                                        .addGap(18, 18, 18)
                                        .addComponent(dolar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(time))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(valor_w)
                                .addGap(18, 18, 18)
                                .addComponent(unidad_tiempow))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(valor_wq)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(unidad_tiempowq))
                            .addComponent(valor_l)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(valor_w)
                    .addComponent(unidad_tiempow))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(valor_wq)
                    .addComponent(unidad_tiempowq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(valor_l))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(valor_lq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(valor_ta)
                    .addComponent(unidad_tiempota))
                .addGap(12, 12, 12)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(costo_ser)
                    .addComponent(dolar)
                    .addComponent(time))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(costo_servicio)
                    .addComponent(dolar1)
                    .addComponent(time1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(costo_co)
                    .addComponent(dolar2)
                    .addComponent(time2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(costo_cli)
                    .addComponent(dolar3)
                    .addComponent(time3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(costo_ge)
                    .addComponent(dolar4)
                    .addComponent(time4))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel7.setText("CANT SIMULACION: ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel8.setText("SERVIDORES:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("VARIABLES");

        label_simulacion.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        label_simulacion.setText("SI");

        label_servidores.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        label_servidores.setText("SER");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_servidores, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(label_simulacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(label_simulacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(label_servidores))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        guardar.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        guardar.setText("Guardar Simulacion");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        regresar.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        regresar.setText("REGRESAR");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(panel_tabla_eventos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_tabla_eventos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(guardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(regresar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

  private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
      this.limpiar();
      this.dia=1;
      this.costo_cliente=0;
      this.costo_clientes_servicio=0;
      this.acosto_clientes_servicio=0;
      this.costo_espera_cliente=0;
      this.costo_general=0;
      this.costo_general_servidores=0;
      this.at=0;
      this.acosto_clientes_servicio=0;
      this.acosto_espera_cliente=0;
      //ACUMULADORES DE W/WQ/L/LQ/UTILIZACION
      this.acumulador_wq=0;
      this.acumulador_w=0;
      this.acumulador_l=0;
      this.acumulador_lq=0;
      this.acumulador_l=0;
      
      for (int i = 0; i < this.utilizacion.length; i++) {
          this.utilizacion[i]=0;
      }


      
      principal.principal.cargar();
  }//GEN-LAST:event_regresarActionPerformed

  private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
    String nombre_archivo_salida = JOptionPane.showInputDialog(
      "¿Con que nombre quiere guardar el archivo?"
    );
    if (nombre_archivo_salida != null) {
      nombre_archivo_salida = nombre_archivo_salida.replace(" ", "_");
      nombre_archivo_salida = nombre_archivo_salida.concat(".csv");

      JFileChooser jf = new JFileChooser();
      GestorArchivos gestorarchivos = new GestorArchivos();
      DatosSalida data;

      //GUARDAMOS LOS DATOS EN UN OBJETO DE SALIDA
      data =
        new DatosSalida(
          this.acumulador_w,
          this.acumulador_wq,
          this.acumulador_l,
          this.acumulador_lq,
          this.acumulador_ta,
          this.acumulador_utilizacion,
          this.costo_general_servidores,
          this.costo_espera_cliente,
          this.costo_clientes_servicio,
          this.costo_cliente,
          this.costo_general,
          principal.principal.obtener_tabla_configurar_tell(),
          principal.principal.obtener_tabla_configurar_ts()
        );
      gestorarchivos.guardar_salida(
        data,
        jf,
        nombre_archivo_salida,
        cantidad_servidores
      );
    }
  }//GEN-LAST:event_guardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel costo_cli;
    private javax.swing.JLabel costo_co;
    private javax.swing.JLabel costo_ge;
    private javax.swing.JLabel costo_ser;
    private javax.swing.JLabel costo_servicio;
    private javax.swing.JLabel dolar;
    private javax.swing.JLabel dolar1;
    private javax.swing.JLabel dolar2;
    private javax.swing.JLabel dolar3;
    private javax.swing.JLabel dolar4;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label_servidores;
    private javax.swing.JLabel label_simulacion;
    private javax.swing.JPanel panel_tabla_eventos;
    private javax.swing.JButton regresar;
    public javax.swing.JTable table_modelo;
    public javax.swing.JTable table_modelo_estadisticas;
    private javax.swing.JLabel time;
    private javax.swing.JLabel time1;
    private javax.swing.JLabel time2;
    private javax.swing.JLabel time3;
    private javax.swing.JLabel time4;
    private javax.swing.JLabel unidad_tiempota;
    private javax.swing.JLabel unidad_tiempow;
    private javax.swing.JLabel unidad_tiempowq;
    private javax.swing.JLabel valor_l;
    private javax.swing.JLabel valor_lq;
    private javax.swing.JLabel valor_ta;
    private javax.swing.JLabel valor_w;
    private javax.swing.JLabel valor_wq;
    // End of variables declaration//GEN-END:variables

  private void llegada() {
    this.tm = this.at;
    this.tipo_evento = "llegada";
    this.cant_cliente = this.cant_cliente + 1;
    this.clientes_sistema = this.clientes_sistema + 1;
    this.id_cliente.add(cant_cliente);

    int n_servidor_vacio = hallar_servidor_vacio();
    if (n_servidor_vacio != 999999) { //CUANDO HAY COLA
      //EXISTEN SERVIDORES VACIOS
      this.servidores[n_servidor_vacio] = 1; //SE OCUPA EL SERVIDOR
      generar_ts(); //SE CALCULA EL TS
      int valor = this.tm + this.ts;
      this.dt[n_servidor_vacio].valor = valor; //ASIGNAMOS EL TS AL CLIENTE QUE ENTRO EN EL SERVIDOR VACIO
      this.dt[n_servidor_vacio].id = cant_cliente;

      añadir_w_dt(cant_cliente, valor);
    } else {
      //NO EXISTEN SERVIDORES VACIOS
      this.wl.add(this.cant_cliente);
      añadir_wq_tm(this.cant_cliente, tm); //AÑADIMOS EL CLIENTE CON SU TM AL  ARRAY CUANDO INGRESA A LA COLA
    }
    this.n_tell = (int) (Math.random() * 100); //SE GENERA UN NUMERO ALEATORIO DE TS
    this.tell = calcular_tell(); //SE CALCULA EL TS
    this.at = this.tm + this.tell;

    tabla_eventos.addRow(obtener_objeto_llegada());
  }

  private void salida() {
    this.clientes_sistema = this.clientes_sistema - 1;
    this.tipo_evento = "salida";
    this.tm = this.dt[hallar_menor_dt()].valor; //TM=DT
    if (!this.wl.isEmpty()) {
      //CUANDO HAY COLA
      int id_cliente_servidor = this.wl.get(0);
      añadir_wq_dt(id_cliente_servidor, tm); //AÑADIR DT AL CLIENTE QUE SALE DE LA COLA PARA CALCULAR WQ
      this.wl.remove(0); //SE REMUEVE EL PRIMERO EN COLA
      generar_ts(); //SE GENERA EL TS
      int valor = this.tm + this.ts; //SE OBTIENE TM+TS
      this.cliente_salida_cola = this.dt[hallar_menor_dt()].id; //SE OBTIENE EL ID DEL CLIENTE QUE VA A SALIR

      this.dt[hallar_menor_dt()].id = id_cliente_servidor; //ASIGNAMOS EL ID DEL CLIENTE QUE SE LE ASIGNARA EL DT QUE VIENE DE LA COLA
      this.dt[hallar_menor_dt()].valor = valor; //ASIGNAMOS EL VALOR A LA SALIDA DEL QUE VIENE DE LA COLA
    } else {
      //CUANDO NO HAY COLA
      int menor = hallar_menor_dt();
      this.dt[menor].valor = 999999;
      this.cliente_salida_no_cola = this.dt[menor].id; //OBTENEMOS LA POSICION DEL CLIENTE QUE SALDRA
      this.dt[menor].id = 0;
      this.servidores[menor] = 0;

      this.cliente_salida_cola = 0; //BANDERA, CUANDO NO HAY HAY COLA
    }
    tabla_eventos.addRow((Object[]) obtener_objeto_salida());
    if (this.cliente_salida_cola == 0) this.id_cliente.remove(
        id_cliente.indexOf(cliente_salida_no_cola)
      ); //REMOVER EL CLIENTE SI NO HAY COLA
    else this.id_cliente.remove(id_cliente.indexOf(this.cliente_salida_cola));
  }

    private void aumentar_utilizacion() {
        for (int i = 0; i < this.utilizacion.length; i++) {
             if(this.servidores[i]==0 && this.bandera[i]==1){
              this.utilizacion[i]=this.tm - this.TM_ANTERIOR[i] +this.utilizacion[i];
             }

             if(this.servidores[i]==1 && this.bandera[i]==0)
                this.TM_ANTERIOR[i] = this.tm;

             if(this.servidores[i]==1)                      
                this.bandera[i]=  1;
             else
                this.bandera[i]=  0;
        }    
    }
}
