/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemalicencias.views;

import java.awt.Image;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import sistemalicencias.accesoDatos.EmpleadoData;
import sistemalicencias.entidades.Empleado;

/**
 *
 * @author calo_
 */
public class LicenciaEmpleados extends javax.swing.JInternalFrame {

    /**
     * Creates new form LicenciaEmpleados
     */
    public LicenciaEmpleados() {
        initComponents();
        setearIcono(jLabel1, "src/Imagenes/uader.png");
        modelo();
        listarEmpleados();
    }

    private DefaultTableModel tabla = new DefaultTableModel() {

        public boolean isCellEditable(int row, int column) {

            return false;
        }
    };
    
    private void modelo() {
        tabla.addColumn("Apellido");
        tabla.addColumn("Nombre");
        tabla.addColumn("Dni");
        tabla.addColumn("Teléfono");
        tabla.addColumn("Dias");

        jtTable.setModel(tabla);

        TableColumnModel columnModel = jtTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(80);
        columnModel.getColumn(1).setPreferredWidth(80);
        columnModel.getColumn(2).setPreferredWidth(80);
        columnModel.getColumn(3).setPreferredWidth(80);
        columnModel.getColumn(4).setPreferredWidth(50);
    }
    
    public void listarEmpleados() {
    EmpleadoData ed = new EmpleadoData();
    if (!jtDocumento.getText().isEmpty()) {
        
        tabla.setRowCount(0);
        for (Empleado empleado : ed.listarClientePorApellidoYdni(jtDocumento.getText(), "")) {
            tabla.addRow(new Object[]{empleado.getApellido(), empleado.getNombre(),
                    empleado.getDni(), empleado.getTelefono(), empleado.getDiasMax()});

        }
    } else {
        tabla.setRowCount(0);
        
        for (Empleado empleado : ed.listarEmpleado()) {
            tabla.addRow(new Object[]{empleado.getApellido(), empleado.getNombre(), empleado.getDni(), empleado.getTelefono(), empleado.getDiasMax()});
        }
    }
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTable = new javax.swing.JTable();
        jtFechaInicio = new com.toedter.calendar.JDateChooser();
        jtFechaFinal = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtDocumento = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setPreferredSize(new java.awt.Dimension(300, 100));

        jtTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtTable);

        jLabel2.setText("Desde:");

        jLabel3.setText("Hasta:");

        jLabel4.setText("Documento:");

        jtDocumento.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jtDocumentoComponentAdded(evt);
            }
        });
        jtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDocumentoActionPerformed(evt);
            }
        });
        jtDocumento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtDocumentoPropertyChange(evt);
            }
        });
        jtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtDocumentoKeyReleased(evt);
            }
        });

        jButton1.setText("Pedir licencia");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Volver al menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addComponent(jtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(197, 197, 197))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1)
                                    .addComponent(jtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2)
                                    .addComponent(jtFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(114, 114, 114))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtFechaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(79, 79, 79))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        Date fecha1 = new Date();
        Date fecha2 = new Date();
        
        fecha1 = jtFechaInicio.getDate();
        fecha2 = jtFechaFinal.getDate();
        
        int diasHabiles = calcularDiasHabiles(fecha1, fecha2);

        
        if(jtTable.getSelectedRow() != -1){
            int filaSeleccionada = jtTable.getSelectedRow();
            String dni = (String) tabla.getValueAt(filaSeleccionada, 2);
            int dias = (int) tabla.getValueAt(filaSeleccionada, 4);
            
            EmpleadoData ed = new EmpleadoData();
            
            int x = JOptionPane.showConfirmDialog(this, "¿Realmente quiere pedir esta licencia?",
            "", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (x == 0){
                ed.actualizarDiasMax(dni, dias-diasHabiles);
                listarEmpleados();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un empleado", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtDocumentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDocumentoKeyReleased
        // TODO add your handling code here:
        if (!jtDocumento.getText().isEmpty()) {
            //jtTable.clearSelection();
            listarEmpleados();
        } else {
            listarEmpleados();
        }
    }//GEN-LAST:event_jtDocumentoKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDocumentoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jtDocumentoActionPerformed

    private void jtTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTableMouseClicked
        // TODO add your handling code here:
        if(jtTable.getSelectedRow() != -1){
            int filaSeleccionada = jtTable.getSelectedRow();
            String dni = (String) tabla.getValueAt(filaSeleccionada, 2);
            jtDocumento.setText(dni);
        }
        listarEmpleados();
        jtTable.selectAll();
    }//GEN-LAST:event_jtTableMouseClicked

    private void jtDocumentoComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jtDocumentoComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDocumentoComponentAdded

    private void jtDocumentoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtDocumentoPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDocumentoPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtDocumento;
    private com.toedter.calendar.JDateChooser jtFechaFinal;
    private com.toedter.calendar.JDateChooser jtFechaInicio;
    private javax.swing.JTable jtTable;
    // End of variables declaration//GEN-END:variables

   
    
    private void setearIcono(JLabel jLabelName, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(300, 100, Image.SCALE_DEFAULT));
        jLabelName.setIcon(icon);
        this.repaint();
    }

    public void borrado() {
        jtDocumento.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                listarEmpleados();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

        });

    }
    
   private static int calcularDiasHabiles(Date fechaInicio, Date fechaFin) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaInicio);

        int diasHabiles = 0;
        while (cal.getTime().before(fechaFin) || cal.getTime().equals(fechaFin)) {
            // Excluir sábados (Calendar.SATURDAY) y domingos (Calendar.SUNDAY)
            if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                diasHabiles++;
            }
            cal.add(Calendar.DAY_OF_MONTH, 1); // Avanzar al siguiente día
        }

        return diasHabiles;
    }
    
    public static Date convertirLocalDateTimeADate(LocalDateTime localDateTime) {
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return date;
    }
}
