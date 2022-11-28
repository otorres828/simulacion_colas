package principal;

import vistas.Menu;
import clases.Ventana;

public class principal {

    Ventana ventana = new Ventana();
    Menu menu = new Menu();
    static public principal principal;

    public static void main(String[] args) {       
        principal = new principal(); //INSTANCIAMOS LA CLASE MAIN PARA PODER HACER USO DEL MOVIMIENTO ENTRE PANELES
        principal.menu_p();                    //LLAMAMOS AL MENU PRINCIPAL
    }
    
    public void menu_p (){        
        ventana.setVisible(true);
        ventana.add(menu);    
        menu.setVisible(true); 
        ventana.validate();
    }
    
    public void salir(){
        ventana.dispose();
    }


    
}
