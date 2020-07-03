/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteria;

import BaseDatos.Mysql;
import Emergentes.UnBoton;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.SwingUtilities;
import objetos.Empleado;
import tipografia.Fuentes;

/**
 *
 * @author isaac
 */
public class DatosPersonales extends javax.swing.JPanel {

    /**
     * Creates new form DatosPersonales
     */
    public Empleado empleado = new Empleado();
    private Empleado empleado2 = new Empleado();
    private Fuentes tipograf = new Fuentes();
    private Mysql mysql = new Mysql();
    
    private String genPass;
    
    public DatosPersonales(String emp) {
        initComponents();
        mysql.conectar();
        empleado = mysql.get1empelado(emp);
        mysql.desconectar();
        estilos(empleado);
        datos(empleado);
        validacion(empleado.getCargo());
    }
    
    public void validacion(String nivel)
    {
        if(nivel.equals("Administrador"))
        {
            txtName.setEnabled(true);
            txtFirst.setEnabled(true);
            txtSecond.setEnabled(true);
            txtPass.setEnabled(true);
            cmbSexo.setEnabled(true);
            
            txtCorreo.setEnabled(true);
            txtFon.setEnabled(true);
        }
        else
        {
            txtName.setEnabled(false);
            txtFirst.setEnabled(false);
            txtSecond.setEnabled(false);
            txtPass.setEnabled(false);
            cmbSexo.setEnabled(false);
            
            txtCorreo.setEnabled(true);
            txtFon.setEnabled(true);
        }
    }
    
    public void estilos(Empleado emp)
    {
        lblId.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 28));
        lblID2.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 28));
        lblNombre.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 28));
        lblPrimer.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 28));
        lblSegundo.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 28));
        lblpass.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 28));
        txtName.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 24));
        txtFirst.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 24));
        txtSecond.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 24));
        txtPass.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 24));
        lblCargo.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 28));
        lblCargo2.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 28));
        lblSexo.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 28));
        lblCorreo.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 28));
        lblTel.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 28));
        cmbSexo.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 25));
        txtCorreo.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 24));
        txtFon.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 24));
        btnVer.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 1, 18));
        btnGuardar.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 1, 18));
    }
    
    
    
    public void datos(Empleado emp)
    {
        genPass = "";
        lblID2.setText(emp.getNumeroEmpleado());
        txtName.setText(emp.getNombre());
        txtFirst.setText(emp.getPrimerApellido());
        lblCargo2.setText(emp.getCargo());
        txtCorreo.setText(emp.getCorreo());
        txtFon.setText(String.valueOf(emp.getTelefono()));
        txtSecond.setText(emp.getSegundoApellido());
        if(emp.getSexo().equals("Masculino"))
        {
            cmbSexo.addItem("Masculino");
            cmbSexo.addItem("Femenino");
        }
        else
        {
            cmbSexo.addItem("Femenino");
            cmbSexo.addItem("Masculino");
        }
        for(int i=0; i<emp.getContraseña().length(); i++)
        {
            genPass += "•";
        }
        txtPass.setText(genPass);
    }
    

    
    public void edicion()
    {
        empleado2.setNumeroEmpleado(lblID2.getText());
        empleado2.setNombre(txtName.getText());
        empleado2.setPrimerApellido(txtFirst.getText());
        empleado2.setSegundoApellido(txtSecond.getText());
        empleado2.setCargo(lblCargo2.getText());
        empleado2.setCorreo(txtCorreo.getText());
        empleado2.setTelefono(Integer.parseInt(txtFon.getText()));
        empleado2.setSexo((String)cmbSexo.getSelectedItem());
        
        if(txtPass.getText().equals(genPass))
        {
            empleado2.setContraseña(empleado.getContraseña());
        }
        else if( (!(txtPass.getText().indexOf("•")>-1))  )
        {
            empleado2.setContraseña(txtPass.getText());
        }
        empleado = empleado2;
        mysql.conectar();
        mysql.actualizaEmpleado(empleado);
        mysql.desconectar();
        datos(empleado);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblId = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblSegundo = new javax.swing.JLabel();
        lblPrimer = new javax.swing.JLabel();
        lblpass = new javax.swing.JLabel();
        lblID2 = new javax.swing.JLabel();
        txtName = new rscomponentshade.RSTextFieldShade();
        txtFirst = new rscomponentshade.RSTextFieldShade();
        txtSecond = new rscomponentshade.RSTextFieldShade();
        txtPass = new rscomponentshade.RSTextFieldShade();
        lblTel = new javax.swing.JLabel();
        lblCargo2 = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        cmbSexo = new javax.swing.JComboBox<>();
        lblSexo = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new rscomponentshade.RSTextFieldShade();
        txtFon = new rscomponentshade.RSTextFieldShade();
        btnVer = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblId.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblId.setText("Numero de empleado: ");

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblNombre.setText("Nombre:");

        lblSegundo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblSegundo.setText("Segundo Apellido:");

        lblPrimer.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblPrimer.setText("Primer Apellido:");

        lblpass.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblpass.setText("Contraseña:");

        lblID2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblID2.setText("IDxxxx");

        txtName.setBgShadeHover(new java.awt.Color(191, 141, 0));
        txtName.setPlaceholder("");
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtFirst.setBgShadeHover(new java.awt.Color(191, 141, 0));
        txtFirst.setPlaceholder("");

        txtSecond.setBgShadeHover(new java.awt.Color(191, 141, 0));
        txtSecond.setPlaceholder("");

        txtPass.setBgShadeHover(new java.awt.Color(191, 141, 0));
        txtPass.setPlaceholder("");

        lblTel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTel.setText("Telefono:");

        lblCargo2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblCargo2.setText("Administrador");

        lblCargo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblCargo.setText("Cargo:");

        lblSexo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblSexo.setText("Sexo:");

        lblCorreo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblCorreo.setText("Correo:");

        txtCorreo.setBgShadeHover(new java.awt.Color(191, 141, 0));
        txtCorreo.setPlaceholder("");

        txtFon.setBgShadeHover(new java.awt.Color(191, 141, 0));
        txtFon.setPlaceholder("");

        btnVer.setBackground(new java.awt.Color(0, 255, 0));
        btnVer.setText("Ver");
        btnVer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnVerMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnVerMouseReleased(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(181, 8, 37));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar Cambios");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblId)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(lblNombre))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lblPrimer))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSegundo)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(lblpass)))))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblID2)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFirst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSecond, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSexo)
                            .addComponent(lblCargo)
                            .addComponent(lblCorreo)
                            .addComponent(lblTel))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFon, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCargo2)
                                    .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblId)
                            .addComponent(lblID2))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSexo)
                            .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrimer)
                            .addComponent(txtFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCorreo))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSegundo)
                            .addComponent(txtSecond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTel)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCargo)
                        .addComponent(lblCargo2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(lblpass)
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnVer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnVerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerMousePressed
        // TODO add your handling code here:
        btnVer.setBackground(new Color(181,8,37));
        btnVer.setForeground(Color.WHITE);
        txtPass.setText(empleado.getContraseña());
    }//GEN-LAST:event_btnVerMousePressed

    private void btnVerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerMouseReleased
        // TODO add your handling code here:
        btnVer.setForeground(Color.BLACK);
        btnVer.setBackground(new Color(0,255,0));
        txtPass.setText(genPass);
    }//GEN-LAST:event_btnVerMouseReleased

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        // TODO add your handling code here:
        btnGuardar.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        // TODO add your handling code here:
        btnGuardar.setBackground(new Color(181,8,37));
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Window parentWindow = SwingUtilities.windowForComponent(this);
        Frame parentframe = null;
        if(parentWindow instanceof Frame)
        {
            parentframe = (Frame)parentWindow;
        }
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        if(txtName.getText().isEmpty() || txtFirst.getText().isEmpty() || txtSecond.getText().isEmpty() || txtPass.getText().isEmpty() || txtCorreo.getText().isEmpty() || txtFon.getText().isEmpty())
        {
            UnBoton emergente = new UnBoton(parentframe, true, 1);
            emergente.setVisible(true);
        }
        else
        {
            if( !(txtPass.getText().equals(genPass)) && txtPass.getText().indexOf("•")>-1)
            {
                UnBoton emergente = new UnBoton(parentframe, true, 2);
                emergente.setVisible(true);
            }
            else
            {
                edicion();
                UnBoton emergente = new UnBoton(parentframe, true, 0);
                emergente.setVisible(true);
            }
        }
        
        
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVer;
    private javax.swing.JComboBox<String> cmbSexo;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCargo2;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblID2;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrimer;
    private javax.swing.JLabel lblSegundo;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTel;
    private javax.swing.JLabel lblpass;
    private rscomponentshade.RSTextFieldShade txtCorreo;
    private rscomponentshade.RSTextFieldShade txtFirst;
    private rscomponentshade.RSTextFieldShade txtFon;
    private rscomponentshade.RSTextFieldShade txtName;
    private rscomponentshade.RSTextFieldShade txtPass;
    private rscomponentshade.RSTextFieldShade txtSecond;
    // End of variables declaration//GEN-END:variables
}
