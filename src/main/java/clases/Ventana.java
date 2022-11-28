package clases;
import javax.swing.*;

public class Ventana extends JFrame {
    public Ventana() {
        this.setTitle("Simulacion de Colas");       //titulo de la ventana
        this.setSize(730,730);            //tamaño de la ventana de juego
       // this.setLocationRelativeTo(null); // posicionamos la ventana en el centro de la pantalla
       // this.setResizable(false);         //evita que el usuario le cambie el tamaño a la ventana       
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  //finaliza la ejecucion al darle en la X de la ventana           
    }
}
