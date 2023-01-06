
package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestorArchivos {
    private final String file;
    private final String salida;

    public GestorArchivos() {
        this.file = "Datos_Entrada_Simulacion.csv";
        this.salida="Datos_Salida_Simulacion.csv";
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
                "Cantidad de valores tell",
                "Cantidad de valores ts",
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
                    + data.getPresentar_tabla_eventos()+ " ;" 
                    + data.getCantidad_simulacion()+ " ;" 
                    + data.getCantidad_servidores() + " ;" 
                    + data.getCantidad_tell()+ " ;" 
                    + data.getCantidad_ts()+ " ;" 
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
    
    public DatosEntrada leer_archivo(String file) {
        DatosEntrada data = new DatosEntrada();
        String[] titulos_tabla_tell = {"Tiempo de llegada", "Probabilidad"};
        String[] titulos_tabla_ts = {"Tiempo de servicio", "Probabilidad"};
        DefaultTableModel tabla_tell = new DefaultTableModel(null, titulos_tabla_tell);
        DefaultTableModel tabla_ts = new DefaultTableModel(null, titulos_tabla_ts);
        File ruta = new File(file);
        try {

            FileReader fi = new FileReader(ruta);
            BufferedReader bu = new BufferedReader(fi);

            String linea = bu.readLine();
            StringTokenizer st;
            while (!(linea = bu.readLine()).contains("Tiempo de llegada")) {
                st = new StringTokenizer(linea, ";");
                data.setUnidad_tiempo(st.nextToken().trim());
                data.setPresentar_tabla_eventos(st.nextToken().trim());
                data.setCantidad_simulacion(Integer.parseInt(st.nextToken().trim()));
                data.setCantidad_servidores(Integer.parseInt(st.nextToken().trim()));
                data.setCantidad_tell(Integer.parseInt(st.nextToken().trim()));
                data.setCantidad_ts(Integer.parseInt(st.nextToken().trim()));
                /*COSTOS*/
                data.setCosto_servicio(Integer.parseInt(st.nextToken().trim()));
                data.setCosto_tiempo_cliente(Integer.parseInt(st.nextToken().trim()));
                data.setCosto_servidor(Integer.parseInt(st.nextToken().trim()));
            }
            
            /*PROBABILIDADES TIEMPO DE LLEGADA*/
            while (!(linea = bu.readLine()).contains("Tiempo de servicio")) {
                st = new StringTokenizer(linea, ";");
                String tiempo = st.nextToken().trim();
                String probabilidad = st.nextToken().trim();
                tabla_ts.addRow(new Object[]{
                    tiempo,
                    probabilidad
                });
                 //System.out.print("tiempo: "+tiempo);
                 //System.out.println("tiempo: "+probabilidad);

            }
            data.setTabla_ts(tabla_ts);
            
            /*PROBABILIDADES TIEMPO DE SERVICIO*/
            while ((linea = bu.readLine()) != null) {
                st = new StringTokenizer(linea, ";");
                String tiempo = st.nextToken().trim();
                String probabilidad = st.nextToken().trim();
                tabla_tell.addRow(new Object[]{
                    tiempo,
                    probabilidad
                });
                //System.out.print("tiempo: "+tiempo);
                //System.out.println("tiempo: "+probabilidad);
            }
            data.setTabla_tell(tabla_tell);
            
            bu.close();
            
            JOptionPane.showMessageDialog(null, "Archivo cargado exitosamente","Operacion exitosa",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
        }
        return data;
    }

    public void guardar_salida(DatosSalida data, JFileChooser jf) {
        FileWriter fw;
        PrintWriter pw;
        try {
            String[] dataTitles = {
                "cantidad promedio de clientes en cola (lq)", 
                "cantidad promedio de clientes en el sistema (l)", 
                "tiempo promedio de un cliente en cola (wq)",
                "tiempo promedio de un cliente en el sistema (w)",
            };
            String[] titlesArrivedTable = {"Tiempo de llegada", "Probabilidad"};
            String[] titlesServiceTable = {"Tiempo de servicio", "Probabilidad"};
            fw = new FileWriter(jf.getCurrentDirectory() + "/" + salida);
            pw = new PrintWriter(fw);

            for (int i = 0; i < dataTitles.length; i++) {
                pw.print(dataTitles[i] + ";");
            }
            pw.println();
            pw.println(
                    data.getLq()+ " ;" 
                    + data.getL()+ " ;" 
                    + data.getWq()+ " ;" 
                    + data.getW() + " ;" 
                    
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
            JOptionPane.showMessageDialog(null, "Se ha creado el archivo Datos_Salida_Simulacion.csv exitosamente en el directorio Documentos", " Operacion exitosa ", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al grabar archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
        }        
    }
    
}
