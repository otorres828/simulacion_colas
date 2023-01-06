
package vistas;

import clases.DatosEntrada;
import clases.Estaticas;
import clases.GestorArchivos;
import clases.TELL;
import clases.TS;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import principal.principal;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CargarVariablesEntrada extends javax.swing.JPanel {
    
    //CONFIGURACION DE VARIABLES ALEATORIAS
    //public Configurar_tell configurar_tell = null;
    
    public CargarVariablesEntrada() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        Opciones = new javax.swing.JPanel();
        Calcular = new javax.swing.JButton();
        limpiar_todo = new javax.swing.JButton();
        limpiar_todo1 = new javax.swing.JButton();
        cargar_archivo = new javax.swing.JButton();
        guardar_archivo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        valores_ts = new javax.swing.JButton();
        cantidad_simulacion = new javax.swing.JTextField();
        cantidad_tell = new javax.swing.JTextField();
        cantidad_servidores = new javax.swing.JTextField();
        cantidad_ts = new javax.swing.JTextField();
        valores_tell = new javax.swing.JButton();
        unidad_tiempo = new javax.swing.JComboBox<>();
        presentar_tabla_eventos = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        costo_servicio = new javax.swing.JTextField();
        costo_servidor = new javax.swing.JTextField();
        costo_tiempo_cliente = new javax.swing.JTextField();

        setBackground(new java.awt.Color(102, 204, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        jLabel8.setText("Cargar Datos de Entrada");

        Opciones.setBackground(new java.awt.Color(255, 255, 255));
        Opciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones de Entrada"));

        Calcular.setText("Calcular");
        Calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcularActionPerformed(evt);
            }
        });

        limpiar_todo.setText("Limpiar todo");
        limpiar_todo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar_todoActionPerformed(evt);
            }
        });

        limpiar_todo1.setText("Regresar");
        limpiar_todo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar_todo1ActionPerformed(evt);
            }
        });

        cargar_archivo.setText("Cargar Archivo");
        cargar_archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargar_archivoActionPerformed(evt);
            }
        });

        guardar_archivo.setText("Guardar Archivo");
        guardar_archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_archivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout OpcionesLayout = new javax.swing.GroupLayout(Opciones);
        Opciones.setLayout(OpcionesLayout);
        OpcionesLayout.setHorizontalGroup(
            OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OpcionesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(limpiar_todo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(cargar_archivo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(guardar_archivo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(limpiar_todo1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        OpcionesLayout.setVerticalGroup(
            OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Calcular)
                    .addComponent(limpiar_todo)
                    .addComponent(limpiar_todo1)
                    .addComponent(cargar_archivo)
                    .addComponent(guardar_archivo))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("1. Unidad de tiempo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("2. ¿Desea presentar la tabla de eventos?");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("3. Cantidad de tiempo de simulación: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("4. cantidad de valores del TELL");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("6. Cantidad de Servidores");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("5. Valores del TELL y probabilidades ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("7. cantidad de valores del TS");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("8. Valores del TS y probabilidades ");

        valores_ts.setText("CONFIGURAR VALORES TS Y PROBABILIDADES");
        valores_ts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valores_tsActionPerformed(evt);
            }
        });

        cantidad_simulacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidad_simulacionKeyTyped(evt);
            }
        });

        cantidad_tell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidad_tellActionPerformed(evt);
            }
        });
        cantidad_tell.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidad_tellKeyTyped(evt);
            }
        });

        cantidad_servidores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidad_servidoresKeyTyped(evt);
            }
        });

        cantidad_ts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidad_tsKeyTyped(evt);
            }
        });

        valores_tell.setText("CONFIGURAR VALORES TELL Y PROBABILIDADES");
        valores_tell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valores_tellActionPerformed(evt);
            }
        });

        unidad_tiempo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Segundos", "Minutos", "Horas", "Dias", "Semanas", "Meses", "Años" }));

        presentar_tabla_eventos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel2))
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valores_ts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cantidad_simulacion)
                    .addComponent(cantidad_tell)
                    .addComponent(cantidad_servidores)
                    .addComponent(cantidad_ts)
                    .addComponent(valores_tell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(unidad_tiempo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(presentar_tabla_eventos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(unidad_tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(presentar_tabla_eventos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(cantidad_simulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cantidad_tell, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(valores_tell))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cantidad_servidores, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cantidad_ts, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(valores_ts))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("9. Costo del tiempo en servicio del cliente");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("10. Costo del tiempo de espera del cliente");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("11. Costo de cada servidor");

        costo_servidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costo_servidorActionPerformed(evt);
            }
        });

        costo_tiempo_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costo_tiempo_clienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(costo_tiempo_cliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(costo_servicio, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(costo_servidor))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(costo_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(costo_tiempo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(costo_servidor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(447, 447, 447)
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(Opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Opciones.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void CalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcularActionPerformed
        //funcion_para_probar();
        
        if(this.cantidad_simulacion.getText().isEmpty()   
                || this.cantidad_tell.getText().isEmpty()
                || this.cantidad_servidores.getText().isEmpty() 
                || this.cantidad_ts.getText().isEmpty() 
                || Estaticas.probabilidades_tell.isEmpty()
                || Estaticas.probabilidades_ts.isEmpty()
           ){
            message("Debes de llenar todos los campos para continuar. Esto incluye la configuracion de las probabilidades", 3);
        }else{
            Estaticas.TM_simulacion = Integer.parseInt(this.cantidad_simulacion.getText());
            Estaticas.cantidad_servidores = Integer.parseInt(this.cantidad_servidores.getText());
            Estaticas.unidad_tiempo = this.unidad_tiempo.getSelectedItem().toString();
            Estaticas.presentar_tabla_eventos = this.presentar_tabla_eventos.getSelectedItem().toString();
            principal.principal.estadisticas();
        }
    }//GEN-LAST:event_CalcularActionPerformed

    private void limpiar_todoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar_todoActionPerformed
     int decision = JOptionPane.showConfirmDialog(null, "¿Estas seguro que deseas limpiar todos los campos?");
        if(decision == 0){
        this.unidad_tiempo.setSelectedIndex(0);
        this.presentar_tabla_eventos.setSelectedIndex(0);
        this.costo_servicio.setText("");
        this.costo_servidor.setText("");
        this.costo_tiempo_cliente.setText("");
        this.cantidad_tell.setText("");
        this.cantidad_servidores.setText("");
        this.cantidad_simulacion.setText("");
        this.cantidad_ts.setText("");
        
        //COLOCAR EN CERO LAS VARIABLES ESTATICAS
        Estaticas.TM_simulacion=0;
        Estaticas.cantidad_servidores=0;
        }      

    }//GEN-LAST:event_limpiar_todoActionPerformed

    private void valores_tsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valores_tsActionPerformed
       if(this.cantidad_ts.getText().isEmpty()  || Integer.parseInt(this.cantidad_ts.getText())<4)
            message("Debes de ingresar una cantidad de tiempo de servicio superior a 4", 3);
       else{
            Estaticas.cantidad_ts=Integer.parseInt(this.cantidad_ts.getText());
            principal.principal.configurar_ts();
       }
    }//GEN-LAST:event_valores_tsActionPerformed

    private void cantidad_tellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidad_tellActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidad_tellActionPerformed

    private void costo_servidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costo_servidorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costo_servidorActionPerformed

    private void costo_tiempo_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costo_tiempo_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costo_tiempo_clienteActionPerformed

    private void limpiar_todo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar_todo1ActionPerformed
        this.unidad_tiempo.setSelectedIndex(0);
        this.presentar_tabla_eventos.setSelectedIndex(0);
        this.costo_servicio.setText("");
        this.costo_servidor.setText("");
        this.costo_tiempo_cliente.setText("");
        this.cantidad_tell.setText("");
        this.cantidad_servidores.setText("");
        this.cantidad_simulacion.setText("");
        this.cantidad_ts.setText("");
        
        //COLOCAR EN CERO LAS VARIABLES ESTATICAS
        Estaticas.TM_simulacion=0;
        Estaticas.cantidad_servidores=0;
        
        principal.principal.menu_p();
    }//GEN-LAST:event_limpiar_todo1ActionPerformed

    private void valores_tellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valores_tellActionPerformed
        if (this.cantidad_tell.getText().isEmpty() || Integer.parseInt(this.cantidad_tell.getText()) < 4)
            message("Debes de ingresar una cantidad de tiempos entre llegadas superior a 4", 3);
        else {
            Estaticas.cantidad_tell=Integer.parseInt(this.cantidad_tell.getText());
            principal.principal.configurar_tell();
        }
        
    }//GEN-LAST:event_valores_tellActionPerformed

    private void cantidad_tellKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidad_tellKeyTyped
        int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        if (!numeros) {
            evt.consume();
        }
        if (this.cantidad_tell.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_cantidad_tellKeyTyped

    private void cantidad_simulacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidad_simulacionKeyTyped
      int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        if (!numeros) {
            evt.consume();
        }
        if (this.cantidad_simulacion.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_cantidad_simulacionKeyTyped

    private void cantidad_servidoresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidad_servidoresKeyTyped
      int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        if (!numeros) {
            evt.consume();
        }
        if (this.cantidad_servidores.getText().trim().length() == 10) {
            evt.consume();
        }
        
    }//GEN-LAST:event_cantidad_servidoresKeyTyped

    private void cantidad_tsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidad_tsKeyTyped
      int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        if (!numeros) {
            evt.consume();
        }
        if (this.cantidad_servidores.getText().trim().length() == 10) {
            evt.consume();
        }

    }//GEN-LAST:event_cantidad_tsKeyTyped

    private void cargar_archivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargar_archivoActionPerformed
        JFileChooser archivo = new JFileChooser();
        GestorArchivos gestorarchivos = new GestorArchivos();
        int open = archivo.showOpenDialog(this);
        String ruta="";
        if (open == JFileChooser.APPROVE_OPTION) {
            ruta=archivo.getSelectedFile().getAbsolutePath();
            DatosEntrada data = gestorarchivos.leer_archivo(archivo.getSelectedFile().getAbsolutePath());
            this.escribir_data_variables(data);
        }
    }//GEN-LAST:event_cargar_archivoActionPerformed

    private void guardar_archivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_archivoActionPerformed
              if(this.cantidad_simulacion.getText().isEmpty()   
                || this.cantidad_tell.getText().isEmpty()
                || this.cantidad_servidores.getText().isEmpty() 
                || this.cantidad_ts.getText().isEmpty() 
                || Estaticas.probabilidades_tell.isEmpty()
                || Estaticas.probabilidades_ts.isEmpty()
                || this.costo_servicio.getText().isEmpty()
                || this.costo_tiempo_cliente.getText().isEmpty()
                || this.costo_servidor.getText().isEmpty()
           ){
            message("Debes de llenar todos los campos para continuar. Esto incluye la configuracion de las probabilidades", 3);
        }else{
            JFileChooser jf = new JFileChooser();     
            GestorArchivos gestorarchivos = new GestorArchivos();  
            DatosEntrada data = null;
            data = this.LeerCampos();
            gestorarchivos.guardar_archivo(data, jf);
        }
    }//GEN-LAST:event_guardar_archivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Calcular;
    private javax.swing.JPanel Opciones;
    private javax.swing.JTextField cantidad_servidores;
    private javax.swing.JTextField cantidad_simulacion;
    private javax.swing.JTextField cantidad_tell;
    private javax.swing.JTextField cantidad_ts;
    private javax.swing.JButton cargar_archivo;
    private javax.swing.JTextField costo_servicio;
    private javax.swing.JTextField costo_servidor;
    private javax.swing.JTextField costo_tiempo_cliente;
    private javax.swing.JButton guardar_archivo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton limpiar_todo;
    private javax.swing.JButton limpiar_todo1;
    private javax.swing.JComboBox<String> presentar_tabla_eventos;
    private javax.swing.JComboBox<String> unidad_tiempo;
    private javax.swing.JButton valores_tell;
    private javax.swing.JButton valores_ts;
    // End of variables declaration//GEN-END:variables

    private void message(String text, int operation) {
        if (operation == 1) {
            JOptionPane.showMessageDialog(null, text, " Operacion exitosa ", JOptionPane.INFORMATION_MESSAGE);
        } else if (operation == 2) {
            JOptionPane.showMessageDialog(null, text, " Operacion denegada ", JOptionPane.WARNING_MESSAGE);
        } else if (operation == 3) {
            JOptionPane.showMessageDialog(null, text, " Operacion Erronea ", JOptionPane.ERROR_MESSAGE);
        }

    }

    private DefaultComboBoxModel loadComboTime(String[] unit) {
        DefaultComboBoxModel modelCb = new DefaultComboBoxModel();
        for (String unit1 : unit) {
            modelCb.addElement(unit1);
        }
        return modelCb;
    }

    private void funcion_para_probar() {
        Estaticas.TM_simulacion = Integer.parseInt(this.cantidad_simulacion.getText());
        Estaticas.cantidad_servidores = Integer.parseInt(this.cantidad_servidores.getText());
        Estaticas.unidad_tiempo = this.unidad_tiempo.getSelectedItem().toString();
        Estaticas.presentar_tabla_eventos = this.presentar_tabla_eventos.getSelectedItem().toString();
        principal.principal.estadisticas();
    }
    
    public DatosEntrada LeerCampos() {
        DatosEntrada data;
        //CAPTURAMOS LOS INPUTOS 
        /*1*/ String aunidad_tiempo = this.unidad_tiempo.getSelectedItem().toString();
        /*2*/ String apresentar_tabla_eventos = this.presentar_tabla_eventos.getSelectedItem().toString();
        /*3*/ int acantidad_simulacion = Integer.parseInt(this.cantidad_simulacion.getText());
        /*4*/ int acantidad_tell = Integer.parseInt(this.cantidad_tell.getText());
        /*6*/ int acantidad_servidores = Integer.parseInt(this.cantidad_servidores.getText());
        /*7*/ int acantidad_ts = Integer.parseInt(this.cantidad_ts.getText());

        /*
         COSTOS
         */
        /*9*/ int acosto_servicio = Integer.parseInt(this.costo_servicio.getText());
        /*10*/ int acosto_tiempo_cliente = Integer.parseInt(this.costo_tiempo_cliente.getText());
        /*11*/ int acosto_servidor = Integer.parseInt(this.costo_servidor.getText());
       
        data = new DatosEntrada(aunidad_tiempo, 
                                apresentar_tabla_eventos, 
                                acantidad_simulacion, 
                                acantidad_tell, 
                                principal.principal.obtener_tabla_configurar_tell(),
                                acantidad_servidores, 
                                acantidad_ts,
                                principal.principal.obtener_tabla_configurar_ts(),
                                acosto_servicio,
                                acosto_tiempo_cliente,
                                acosto_servidor);
        return data;
    }

    private void escribir_data_variables(DatosEntrada data) {
        /*1*/ this.unidad_tiempo.setSelectedItem(data.getUnidad_tiempo());
        /*2*/ this.presentar_tabla_eventos.setSelectedItem(data.getPresentar_tabla_eventos());
        /*3*/ this.cantidad_simulacion.setText(String.valueOf(data.getCantidad_simulacion()));
        /*4*/ this.cantidad_tell.setText(String.valueOf(data.getCantidad_tell()));
        /*6*/ this.cantidad_servidores.setText(String.valueOf(data.getCantidad_servidores()));
        /*7*/ this.cantidad_ts.setText(String.valueOf(data.getCantidad_ts()));

        /* costs variables*/
        /*9*/  this.costo_servicio.setText(String.valueOf(data.getCosto_servicio()));
        /*10*/ this.costo_tiempo_cliente.setText(String.valueOf(data.getCosto_tiempo_cliente()));
        /*11*/ this.costo_servidor.setText(String.valueOf(data.getCosto_servidor()));

        
        /*5*/ principal.principal.configurar_tell.deleteAll();
         for (int i = 0; i < data.getTabla_tell().getRowCount(); i++) {
             //System.out.print("tiempo: "+data.getTabla_tell().getValueAt(i, 0));
             //System.out.println("probabilidad: "+data.getTabla_tell().getValueAt(i, 1));
             int tiempo = Integer.parseInt((String) data.getTabla_tell().getValueAt(i, 0));
             int probabilidad =Integer.parseInt((String)data.getTabla_tell().getValueAt(i, 1));
             
             TELL objeto=Estaticas.asignar_tell(tiempo,probabilidad);
                principal.principal.configurar_tell.tabla_nueva.addRow(new Object[]{
                    objeto.tiempo,
                    objeto.probabilidad,
                    objeto.probabilidad_acumulada,
                    objeto.rango_desde,
                    objeto.rango_hasta
                });
         }

        /*8*/ principal.principal.configurar_ts.deleteAll();
        for (int i = 0; i < data.getTabla_ts().getRowCount(); i++) {
             //System.out.print("tiempo: "+data.getTabla_ts().getValueAt(i, 0));
             //System.out.println("probabilidad: "+data.getTabla_ts().getValueAt(i, 1));
             int tiempo = Integer.parseInt((String) data.getTabla_ts().getValueAt(i, 0));
             int probabilidad =Integer.parseInt((String)data.getTabla_ts().getValueAt(i, 1));
             
             TS objeto=Estaticas.asignar_ts(tiempo,probabilidad);
                principal.principal.configurar_ts.tabla_nueva.addRow(new Object[]{
                    objeto.tiempo,
                    objeto.probabilidad,
                    objeto.probabilidad_acumulada,
                    objeto.rango_desde,
                    objeto.rango_hasta
                });
         }
        
    }
}
