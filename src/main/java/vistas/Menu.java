
package vistas;

import principal.principal;

public class Menu extends javax.swing.JPanel {

    public Menu() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        salir = new javax.swing.JButton();
        nuevo1 = new javax.swing.JButton();
        cargar1 = new javax.swing.JButton();
        modificar1 = new javax.swing.JButton();
        ayuda = new javax.swing.JButton();

        salir.setText("SALIR");
        salir.setToolTipText("");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        nuevo1.setText("NUEVO");
        nuevo1.setToolTipText("");
        nuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo1ActionPerformed(evt);
            }
        });

        cargar1.setText("CARGAR");
        cargar1.setToolTipText("");
        cargar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargar1ActionPerformed(evt);
            }
        });

        modificar1.setText("MODIFICAR");
        modificar1.setToolTipText("");
        modificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar1ActionPerformed(evt);
            }
        });

        ayuda.setText("AYUDA");
        ayuda.setToolTipText("");
        ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(nuevo1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(cargar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(modificar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(nuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cargar1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modificar1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        principal.principal.salir();
    }//GEN-LAST:event_salirActionPerformed

    private void nuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevo1ActionPerformed

    private void cargar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cargar1ActionPerformed

    private void modificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificar1ActionPerformed

    private void ayudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ayudaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ayuda;
    private javax.swing.JButton cargar1;
    private javax.swing.JButton modificar1;
    private javax.swing.JButton nuevo1;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
