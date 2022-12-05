
package vistas;

import clases.Estaticas;
import clases.TS;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import  principal.principal;

public class Configurar_ts extends javax.swing.JPanel {
    DefaultTableModel tabla_nueva = new DefaultTableModel();
    DefaultTableModel tabla_auxiliar = new DefaultTableModel();

    public Configurar_ts() {
        initComponents();
        deleteAll();
        this.tabla_ts.setModel(tabla_nueva);
    }
    
    public void resetear(){
        deleteAll();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_ts = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        probabilidad = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        tiempo = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        ingresar_probabilidad = new javax.swing.JButton();
        limpiar_celdas = new javax.swing.JButton();
        eliminar_fila = new javax.swing.JButton();
        eliminar_todo = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 204, 255));

        tabla_ts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_ts);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Ingrese las Tasas de Servicio"));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Probabilidad: ");

        probabilidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Tiempo de Servicio: ");

        tiempo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(probabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addComponent(tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(probabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Opciones de la tabla"));

        ingresar_probabilidad.setText("Ingresar Probabilidad");
        ingresar_probabilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresar_probabilidadActionPerformed(evt);
            }
        });

        limpiar_celdas.setText("Limpiar Celdas");
        limpiar_celdas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar_celdasActionPerformed(evt);
            }
        });

        eliminar_fila.setText("Eliminar Fila");
        eliminar_fila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_filaActionPerformed(evt);
            }
        });

        eliminar_todo.setText("Eliminar Todo");
        eliminar_todo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_todoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ingresar_probabilidad)
                .addGap(18, 18, 18)
                .addComponent(limpiar_celdas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminar_fila)
                .addGap(18, 18, 18)
                .addComponent(eliminar_todo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ingresar_probabilidad)
                    .addComponent(limpiar_celdas)
                    .addComponent(eliminar_fila)
                    .addComponent(eliminar_todo))
                .addGap(0, 51, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Configuracion de tasa de servicio de los clientes");

        jButton8.setBackground(new java.awt.Color(153, 153, 255));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("REGRESAR");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(438, 438, 438)
                .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(394, 394, 394))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void eliminar_todoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_todoActionPerformed
        int decision = JOptionPane.showConfirmDialog(null, "¿Estas seguro que desea eliminar todas las filas?");
        if (decision == 0) {
            this.deleteAll();
        }
    }//GEN-LAST:event_eliminar_todoActionPerformed

    private void eliminar_filaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_filaActionPerformed
        String[] titles = {"Tiempo de llegada", "Probabilidad","Probabilidad Acumulada","Rango Desde","Rango Hasta"};
        String[] titles_auxiliar = {"Tiempo de llegada", "Probabilidad"};
        int seleccionar_fila = this.tabla_ts.getSelectedRow();
        if (seleccionar_fila != -1) {

            int decision = JOptionPane.showConfirmDialog(null, "¿Estas seguro que desea eliminar esta fila?");
            if (decision == 0) {
                tabla_nueva.removeRow(seleccionar_fila);                          //REMOVEMOS EL ELEMENTO DE LA TABLA 
                Estaticas.probabilidades_ts.clear();                            //LIMPIAMOS EL ARRAY LIST
                Estaticas.probabilidad_acumulada_ts=0;                          //RESETEAMOS LA PROBABILIDAD ACUMULADA
                
                tabla_auxiliar = new DefaultTableModel(null, titles_auxiliar);    //INICIALIZAMOS UNA TABLA AUXILIAR
                for (int i = 0; i < this.tabla_nueva.getRowCount(); i++) {        //DUPLICAMOS LA TABLA ACTUAL SOLO EN LOS CAMPOS TIEMPO Y PROBABILIDAD
                    tabla_auxiliar.addRow(new Object[]{
                        this.tabla_nueva.getValueAt(i, 0).toString(),
                        this.tabla_nueva.getValueAt(i, 1).toString()
                    });
                 }
                tabla_nueva = new DefaultTableModel(null, titles);                    //RESETEAMOS LA TABLA ORIGINAL
                
                for (int i = 0; i < this.tabla_auxiliar.getRowCount(); i++) {        //DUPLICAMOS LA TABLA ACTUAL SOLO EN LOS CAMPOS TIEMPO Y PROBABILIDAD
                    int t=Integer.parseInt(tabla_auxiliar.getValueAt(i, 0).toString());
                    int p=Integer.parseInt(tabla_auxiliar.getValueAt(i, 1).toString());
                    TS objeto=Estaticas.asignar_ts(t,p);
                    this.tabla_nueva.addRow(new Object[]{ objeto.tiempo,  objeto.probabilidad,objeto.probabilidad_acumulada,  objeto.rango_desde,objeto.rango_hasta});
                }
                this.tabla_ts.setModel(tabla_nueva);
                JOptionPane.showMessageDialog(null, "Tabla actualizada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila");
        }
    }//GEN-LAST:event_eliminar_filaActionPerformed

    private void limpiar_celdasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar_celdasActionPerformed
        this.tiempo.setText("");
        this.probabilidad.setText("");
    }//GEN-LAST:event_limpiar_celdasActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        principal.principal.cargar();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void ingresar_probabilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresar_probabilidadActionPerformed
        String time = this.tiempo.getText();
        String probabilidadt = this.probabilidad.getText();
        if (!time.isEmpty() && !probabilidadt.isEmpty()) {
            if (this.validateData(Integer.parseInt(time.trim()), Integer.parseInt(probabilidadt)) && this.tabla_ts.getRowCount()<Estaticas.cantidad_ts) {
                TS objeto=Estaticas.asignar_ts(Integer.parseInt(time), Integer.parseInt(probabilidadt));
                this.tabla_nueva.addRow(new Object[]{
                    objeto.tiempo,
                    objeto.probabilidad,
                    objeto.probabilidad_acumulada,
                    objeto.rango_desde,
                    objeto.rango_hasta
                });
            } else {
                JOptionPane.showMessageDialog(null, "Revise los datos o verifique que la probabilidad no sea mayor a 100, los registros pueden ser superiores a la cantidad ingresada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ingreso algun dato para la fila nueva");
        }
    }//GEN-LAST:event_ingresar_probabilidadActionPerformed

    private String convert() {
        String text = "";
        for (int i = 0; i < this.tabla_ts.getRowCount(); i++) {
            text += tabla_nueva.getValueAt(i, 0).toString() + " ; "
                    + tabla_nueva.getValueAt(i, 1).toString() + " ; \n";
        }

        return text;
    }

    private void deleteAll() {
        String[] titles = {"Tiempo de llegada", "Probabilidad","Probabilidad Acumulada","Rango Desde","Rango Hasta"};
        tabla_nueva = new DefaultTableModel(null, titles);
        this.tabla_ts.setModel(tabla_nueva);
        Estaticas.probabilidades_ts.clear();
        Estaticas.probabilidad_acumulada_ts=0;
        this.tiempo.setText("");
        this.probabilidad.setText("");
    }

    private boolean validateData(int timeArrived, int probability) {

        if (timeArrived < 0
                || probability > 100) {
            return false;
        }

        for (int i = 0; i < tabla_nueva.getRowCount(); i++) {
            if (addProbability(probability) > 100
                    || timeArrived == Integer.parseInt(this.tabla_nueva.getValueAt(i, 0).toString())) {
                return false;
            }
        }
        return true;
    }

    private int addProbability(int probability) {
        int add = 0;

        for (int i = 0; i < tabla_nueva.getRowCount(); i++) {
            add += Integer.parseInt(tabla_nueva.getValueAt(i, 1).toString());
        }
        return add + probability;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eliminar_fila;
    private javax.swing.JButton eliminar_todo;
    private javax.swing.JButton ingresar_probabilidad;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar_celdas;
    private javax.swing.JFormattedTextField probabilidad;
    private javax.swing.JTable tabla_ts;
    private javax.swing.JFormattedTextField tiempo;
    // End of variables declaration//GEN-END:variables
}
