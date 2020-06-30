/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emergentes;

import BaseDatos.Mysql;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;
import objetos.Empleado;
import tipografia.Fuentes;

/**
 *
 * @author isaac
 */
public class Inserta extends javax.swing.JDialog {

    /**
     * Creates new form Inserta
     */
    private Fuentes tipograf = new Fuentes();
    private GenerarId generaid = new GenerarId();
    private Empleado emp;
    private Mysql mysql = new Mysql();

            
    public Inserta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("../imagenes/LogoSolo.png")).getImage());
        estilos();
    }
    
    public boolean respuesta2()
    {
        return true;
    }
    
    public void estilos()
    {
        lbltitle.setFont(tipograf.fuente(tipograf.monserratSemiBold, 1, 32));
        lblCargo.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 18));
        lblNombre.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 18));
        lblFirts.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 18));
        lblSecond.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 18));
        lblCorreo.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 18));
        lblSexo.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 18));
        lblContraseña.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 18));
        lblId2.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 18));
        lblId.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 18));
        lblTel.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 18));
        
        cmbCargo.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 16));
        cmbSexo.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 16));
        
        btnAgregar.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 1, 18));
        btnCancelar.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 1, 18));
        
        txtCorreo.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 16));
        txtFirst.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 16));
        txtNombre.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 16));
        txtPass.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 16));
        txtSecond.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 16));
        txtTelefono.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 16));
        
        lblError.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 1, 20));
        lblError.setVisible(false);
        
        cmbCargo.addItem("Seleccionar");
        cmbCargo.addItem("Administrador");
        cmbCargo.addItem("Cajero");
        cmbCargo.addItem("Chef");
        
        cmbSexo.addItem("Masculino");
        cmbSexo.addItem("Femenino");
        lblId2.setVisible(false);
        lblCargo.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cabecera = new javax.swing.JPanel();
        lbltitle = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        lblId2 = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        cmbCargo = new javax.swing.JComboBox<>();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new rscomponentshade.RSTextFieldShade();
        lblFirts = new javax.swing.JLabel();
        lblSecond = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        txtFirst = new rscomponentshade.RSTextFieldShade();
        txtSecond = new rscomponentshade.RSTextFieldShade();
        txtPass = new rscomponentshade.RSTextFieldShade();
        jPanel1 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new rscomponentshade.RSTextFieldShade();
        lblSexo = new javax.swing.JLabel();
        cmbSexo = new javax.swing.JComboBox<>();
        txtTelefono = new rscomponentshade.RSTextFieldShade();
        lblTel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        cabecera.setBackground(new java.awt.Color(255, 255, 255));
        cabecera.setPreferredSize(new java.awt.Dimension(750, 90));

        lbltitle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbltitle.setForeground(new java.awt.Color(181, 8, 37));
        lbltitle.setText("Agregar Empleado");
        cabecera.add(lbltitle);

        getContentPane().add(cabecera, java.awt.BorderLayout.PAGE_START);

        body.setBackground(new java.awt.Color(255, 255, 255));

        lblId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblId.setText("Numero de empleado: ");

        lblId2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblId2.setText("IDxxxxxxxx");

        lblCargo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCargo.setText("Cargo:");

        cmbCargo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCargoItemStateChanged(evt);
            }
        });
        cmbCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbCargoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmbCargoMouseEntered(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombre.setText("Nombre:");

        txtNombre.setBgShadeHover(new java.awt.Color(191, 141, 0));
        txtNombre.setPlaceholder("");

        lblFirts.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblFirts.setText("Primer Apellido:");

        lblSecond.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSecond.setText("Segundo Apellido:");

        lblContraseña.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblContraseña.setText("Contraseña:");

        txtFirst.setBgShadeHover(new java.awt.Color(191, 141, 0));
        txtFirst.setPlaceholder("");

        txtSecond.setBgShadeHover(new java.awt.Color(191, 141, 0));
        txtSecond.setPlaceholder("");

        txtPass.setBgShadeHover(new java.awt.Color(191, 141, 0));
        txtPass.setPlaceholder("");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 5));

        btnAgregar.setBackground(new java.awt.Color(181, 8, 37));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setPreferredSize(new java.awt.Dimension(150, 40));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar);

        btnCancelar.setBackground(new java.awt.Color(181, 8, 37));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(150, 40));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);

        lblCorreo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCorreo.setText("Correo:");

        txtCorreo.setBgShadeHover(new java.awt.Color(191, 141, 0));
        txtCorreo.setPlaceholder("");
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        lblSexo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSexo.setText("Sexo:");

        cmbSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSexoActionPerformed(evt);
            }
        });

        txtTelefono.setBgShadeHover(new java.awt.Color(191, 141, 0));
        txtTelefono.setPlaceholder("");
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        lblTel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTel.setText("Telefono:");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblError.setForeground(new java.awt.Color(181, 8, 37));
        lblError.setText("Mensajes de error");
        jPanel2.add(lblError);

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bodyLayout.createSequentialGroup()
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCargo)
                            .addComponent(lblNombre)))
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblSecond))
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblFirts))
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(lblContraseña)))
                .addGap(22, 22, 22)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFirst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSecond, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCorreo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSexo, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(16, 16, 16)
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbSexo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblId2)
                        .addContainerGap(45, Short.MAX_VALUE))))
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId2)
                    .addComponent(lblId)
                    .addComponent(cmbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCargo))
                .addGap(19, 19, 19)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCorreo)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirts)
                    .addComponent(txtFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSexo)
                    .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSecond)
                    .addComponent(txtSecond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContraseña)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       
        if(txtNombre.getText().isEmpty() || txtFirst.getText().isEmpty() || txtSecond.getText().isEmpty() || txtCorreo.getText().isEmpty() || txtPass.getText().isEmpty())
        {
            lblError.setVisible(true);
            lblError.setText("Error de campos vacíos");
        }
        else
        {
            if((String)(cmbCargo.getSelectedItem()) == "Seleccionar")
            {
                lblError.setVisible(true);
                lblError.setText("Selecciona un cargo");
            }
            else
            {   
                lblError.setVisible(false);
                //Validacion de correo
                emp = new Empleado(lblId2.getText(),Integer.parseInt(txtTelefono.getText()),txtCorreo.getText(),String.valueOf(cmbCargo.getSelectedItem()),txtPass.getText(), txtNombre.getText(),txtFirst.getText(),txtSecond.getText(),String.valueOf(cmbSexo.getSelectedItem()));
                mysql.conectar();
                mysql.insertaEmpleado(emp);
                mysql.desconectar();
                dispose();
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cmbCargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbCargoMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbCargoMouseClicked

    private void cmbCargoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbCargoMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbCargoMouseEntered

    private void cmbCargoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCargoItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            if(cmbCargo.getSelectedItem().equals("Seleccionar"))
            {
                lblId2.setVisible(false);
                lblId2.setText("");
            }
            else
            {
                lblId2.setVisible(true);
                lblId2.setText(generaid.generarEmpleado((String)cmbCargo.getSelectedItem()));
            }
        }
    }//GEN-LAST:event_cmbCargoItemStateChanged

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void cmbSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSexoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inserta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inserta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inserta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inserta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Inserta dialog = new Inserta(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel cabecera;
    private javax.swing.JComboBox<String> cmbCargo;
    private javax.swing.JComboBox<String> cmbSexo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblFirts;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblId2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSecond;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTel;
    private javax.swing.JLabel lbltitle;
    private rscomponentshade.RSTextFieldShade txtCorreo;
    private rscomponentshade.RSTextFieldShade txtFirst;
    private rscomponentshade.RSTextFieldShade txtNombre;
    private rscomponentshade.RSTextFieldShade txtPass;
    private rscomponentshade.RSTextFieldShade txtSecond;
    private rscomponentshade.RSTextFieldShade txtTelefono;
    // End of variables declaration//GEN-END:variables
}
