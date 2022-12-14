package principal;

import vistas.Menu;
import clases.Ventana;
import vistas.Estadisticas;
import clases.Estaticas;
import javax.swing.table.DefaultTableModel;
import vistas.CargarVariablesEntrada;
import vistas.Configurar_tell;
import vistas.Configurar_ts;

public class principal {

    static Ventana ventana = new Ventana();
    Menu menu = new Menu();
    Estadisticas estadisticas = new Estadisticas();
    CargarVariablesEntrada cargarvariablesentrada = new CargarVariablesEntrada();
    public Configurar_tell configurar_tell = new Configurar_tell();
    public Configurar_ts configurar_ts = new Configurar_ts();
    static public principal principal;

    public static void main(String[] args) {       
        principal = new principal(); //INSTANCIAMOS LA CLASE MAIN PARA PODER HACER USO DEL MOVIMIENTO ENTRE PANELES
        principal.menu_p();                    //LLAMAMOS AL MENU PRINCIPAL
    }
    
    public void menu_p (){
        estadisticas.setVisible(false); estadisticas.setEnabled(false);
        cargarvariablesentrada.setVisible(false); cargarvariablesentrada.setEnabled(false);
        configurar_tell.setVisible(false); configurar_tell.setEnabled(false);
        configurar_ts.setVisible(false); configurar_ts.setEnabled(false);
        ventana.setVisible(true);
        ventana.add(menu);    
        menu.setVisible(true); 
        ventana.validate();
    }
    
    public void salir(){
        ventana.dispose();
    }
    
    public void cargar(){
         configurar_ts.setVisible(false); configurar_ts.setEnabled(false);
         menu.setVisible(false); menu.setEnabled(false);
         estadisticas.setVisible(false); estadisticas.setEnabled(false);
         configurar_tell.setVisible(false); configurar_tell.setEnabled(false);
         ventana.add(cargarvariablesentrada);
         cargarvariablesentrada.setVisible(true);
         ventana.validate();
    }
    
    public void cargar_resetear(){
         configurar_tell.resetear();                                              //RESETEAR VALORES DE TELL
         configurar_ts.resetear();                                                //RESETEAR VAKIRES DE TS
         Estaticas.probabilidades_tell.clear();                                   //LIMPIAMOS EL ARRAY DE TELL
         Estaticas.probabilidades_ts.clear();                                      //LIMPIAMOS EL ARRAY DE TS
         
         configurar_ts.setVisible(false); configurar_ts.setEnabled(false);
         menu.setVisible(false); menu.setEnabled(false);
         estadisticas.setVisible(false); estadisticas.setEnabled(false);
         configurar_tell.setVisible(false); configurar_tell.setEnabled(false);
         ventana.add(cargarvariablesentrada);
         cargarvariablesentrada.setVisible(true);
         ventana.validate();
    }
    
    public void estadisticas(){
        configurar_ts.setVisible(false); configurar_ts.setEnabled(false);
        menu.setVisible(false); menu.setEnabled(false);
        cargarvariablesentrada.setVisible(false); cargarvariablesentrada.setEnabled(false);
        configurar_tell.setVisible(false); configurar_tell.setEnabled(false);        
        ventana.add(estadisticas);
        estadisticas.setVisible(true); 
        ventana.validate();
        estadisticas.inicializar_datos();                                        //CARGAR LOS DATOS
    }
    
    public void configurar_tell(){
         configurar_ts.setVisible(false); configurar_ts.setEnabled(false);
         cargarvariablesentrada.setVisible(false); cargarvariablesentrada.setEnabled(false);
         menu.setVisible(false); menu.setEnabled(false);
         estadisticas.setVisible(false); estadisticas.setEnabled(false);
         configurar_tell.setVisible(true); 
         ventana.add(configurar_tell);
         ventana.validate();
    }
    
    public void configurar_ts(){
         configurar_tell.setVisible(false); configurar_tell.setEnabled(false);
         cargarvariablesentrada.setVisible(false); cargarvariablesentrada.setEnabled(false);
         menu.setVisible(false); menu.setEnabled(false);
         estadisticas.setVisible(false); estadisticas.setEnabled(false);
         configurar_ts.setVisible(true); 
         ventana.add(configurar_ts);
         ventana.validate();
    }
    
    public DefaultTableModel obtener_tabla_configurar_tell(){
        return configurar_tell.tabla_nueva;
    }
    
    public DefaultTableModel obtener_tabla_configurar_ts(){
        return configurar_ts.tabla_nueva;
    }
}
