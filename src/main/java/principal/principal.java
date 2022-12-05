package principal;

import vistas.Menu;
import clases.Ventana;
import vistas.Estadisticas;
import clases.Estaticas;
import vistas.CargarVariablesEntrada;
import vistas.Configurar_tell;

public class principal {

    static Ventana ventana = new Ventana();
    Menu menu = new Menu();
    Estadisticas estadisticas = new Estadisticas();
    CargarVariablesEntrada cargarvariablesentrada = new CargarVariablesEntrada();
    Configurar_tell configurar_tell = new Configurar_tell();
    static public principal principal;

    public static void main(String[] args) {       
        principal = new principal(); //INSTANCIAMOS LA CLASE MAIN PARA PODER HACER USO DEL MOVIMIENTO ENTRE PANELES
        principal.menu_p();                    //LLAMAMOS AL MENU PRINCIPAL
    }
    
    public void menu_p (){
        estadisticas.setVisible(false); estadisticas.setEnabled(false);
        cargarvariablesentrada.setVisible(false); cargarvariablesentrada.setEnabled(false);
        configurar_tell.setVisible(false); configurar_tell.setEnabled(false);
        ventana.setVisible(true);
        ventana.add(menu);    
        menu.setVisible(true); 
        ventana.validate();
    }
    
    public void salir(){
        ventana.dispose();
    }
    
    public void cargar(){
         menu.setVisible(false); menu.setEnabled(false);
         estadisticas.setVisible(false); estadisticas.setEnabled(false);
         configurar_tell.setVisible(false); configurar_tell.setEnabled(false);
         ventana.add(cargarvariablesentrada);
         cargarvariablesentrada.setVisible(true);
         ventana.validate();
    }
    
    public void estadisticas(){
        menu.setVisible(false);
        menu.setEnabled(false);
        ventana.add(estadisticas);
        estadisticas.setVisible(true); 
        ventana.validate();
    }
    
    public void configurar_tell(){
         cargarvariablesentrada.setVisible(false); cargarvariablesentrada.setEnabled(false);
         menu.setVisible(false); menu.setEnabled(false);
         estadisticas.setVisible(false); estadisticas.setEnabled(false);
         configurar_tell.setVisible(true); 
         ventana.add(configurar_tell);
         ventana.validate();
    }
    
}
