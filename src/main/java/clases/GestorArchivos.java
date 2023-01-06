
package clases;

import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class GestorArchivos {
    private final String file;

    public GestorArchivos() {
        this.file = "Datos_Entrada_Simulacion.csv";
    }

    public void guardar_archivo(DatosEntrada data, JFileChooser jf) {
        FileWriter fw;
        PrintWriter pw;
        try {
            String[] dataTitles = {
                "Unidad de tiempo", 
                "Tabla de eventos", 
                "tiempo de simulacion",
                "Cantidad de servidores", 
                "Costo de tiempo de servidor de cliente",
                "Costo del tiempo de esèra de cliente", 
                "Costo de cada servidor"};
            String[] titlesArrivedTable = {"Tiempo de llegada", "Probabilidad"};
            String[] titlesServiceTable = {"Tiempo de servicio", "Probabilidad"};
            fw = new FileWriter(jf.getCurrentDirectory() + "/" + file);
            pw = new PrintWriter(fw);

            for (int i = 0; i < dataTitles.length; i++) {
                pw.print(dataTitles[i] + ";");
            }
            pw.println();
            pw.println(
                    data.getUnidad_tiempo() + " ;" 
                    + data.isPresentar_tabla_eventos() + " ;" 
                    + data.getCantidad_simulacion()+ " ;" 
                    + data.cantidad_servidores + " ;" 
                    + data.getCosto_servicio() + " ;" 
                    + data.getCosto_tiempo_cliente() + " ;"
                    + data.getCosto_servidor() + " ;" 
            );

            //Here you can write the customers arrived table
            for (int i = 0; i < titlesArrivedTable.length; i++) {
                pw.print(titlesArrivedTable[i] + ";"); //Titles
            }
            pw.println();
            for (int i = 0; i < data.getTabla_tell().getRowCount(); i++) {
                //Values
                pw.println(data.getTabla_tell().getValueAt(i, 0) + ";" + data.getTabla_tell().getValueAt(i, 1) + ";");
            }

            //Here you can read the service time table
            for (int i = 0; i < titlesServiceTable.length; i++) {
                pw.print(titlesServiceTable[i] + ";");//Titles
            }
            pw.println();
            for (int i = 0; i < data.getTabla_ts().getRowCount(); i++) {
                //Values
                pw.println(data.getTabla_ts().getValueAt(i, 0) + ";" + data.getTabla_ts().getValueAt(i, 1) + ";");
            }

            pw.close();
            JOptionPane.showMessageDialog(null, "Se ha creado el archivo Datos_Entrada_Simulacion.csv exitosamente en el directorio Documentos", " Operacion exitosa ", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al grabar archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
        }
    }
}
