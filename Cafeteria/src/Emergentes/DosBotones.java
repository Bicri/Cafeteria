/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emergentes;

import BaseDatos.Mysql;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import objetos.Empleado;
import objetos.Orden;
import objetos.Platillo;
import tipografia.Fuentes;

/**
 *
 * @author isaac
 */
public class DosBotones extends javax.swing.JDialog {

    /*
        0 = Eliminar empleado
        1 = elimina plato
        2 = finalizar dia
        3 = Cancelar orden;
    */
    
    private Fuentes tipograf = new Fuentes();
    private Empleado emp = new Empleado();
    private Orden orden = new Orden();
    private Platillo plato = new Platillo();
    private Mysql mysql = new Mysql();
    private int flag2;
    boolean flag;
    
    
    public DosBotones(java.awt.Frame parent, boolean modal, int flag, Object o) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("../imagenes/LogoSolo.png")).getImage());
        estilos();
        flag2 = flag;
        validacion(o);
    }
    
    public boolean respuesta()
    {
        return flag;
    }
    
    public void validacion(Object o)
    {
        if(flag2 == 0)
        {
            emp = (Empleado) o;
            lbltitulo.setText("Eliminar empleado");
            lblMensaje.setText("<html> <body>¿Deseas eliminar al empleado "+emp.getNumeroEmpleado()+" <br> "+emp.getNombre()+" "+emp.getPrimerApellido()+" "+emp.getSegundoApellido()+" ?</body> </html>");
        }
        else if(flag2 == 1)
        {
            plato = (Platillo) o;
            lbltitulo.setText("Eliminar platillo");
            lblMensaje.setText("<html> <body>¿Deseas eliminar el platillo "+plato.getIdPlatillo()+" <br> "+plato.getNombrePlatillo()+"?</body> </html>");
        }
        else if(flag2 == 2)
        {
            lbltitulo.setText("Finalizar dia");
            lblMensaje.setText("¿Deseas terminar las operaciones del dia?");
        }
        else if(flag2 == 3)
        {
            orden = (Orden) o;
            lbltitulo.setText("Cancelar orden");
            lblMensaje.setText("¿Deseas cancelar la orden: "+orden.getIdOrden()+"?");
            flag=true;
        }
    }

    private DosBotones(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void estilos()
    {
        lbltitulo.setFont(tipograf.fuente(tipograf.monserratSemiBold, 1, 38));
        lblMensaje.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 22));
        btnCancelar.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 1, 22));
        btnAceptar.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 1, 22));
        lbltitulo.requestFocus();
    }
    
    public boolean exito()
    {
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Contenedor = new javax.swing.JPanel();
        cabecera = new javax.swing.JPanel();
        lbltitulo = new javax.swing.JLabel();
        footer = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        body = new javax.swing.JPanel();
        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        Contenedor.setBackground(new java.awt.Color(255, 255, 255));

        cabecera.setBackground(new java.awt.Color(255, 255, 255));

        lbltitulo.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        lbltitulo.setForeground(new java.awt.Color(181, 8, 37));
        lbltitulo.setText("Titulo");
        cabecera.add(lbltitulo);

        footer.setBackground(new java.awt.Color(255, 255, 255));
        footer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 30, 5));

        btnCancelar.setBackground(new java.awt.Color(181, 8, 37));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(115, 40));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        footer.add(btnCancelar);

        btnAceptar.setBackground(new java.awt.Color(181, 8, 37));
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.setPreferredSize(new java.awt.Dimension(115, 40));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        footer.add(btnAceptar);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setPreferredSize(new java.awt.Dimension(221, 100));
        body.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 20));

        lblMensaje.setText("Mensaje");
        body.add(lblMensaje);

        javax.swing.GroupLayout ContenedorLayout = new javax.swing.GroupLayout(Contenedor);
        Contenedor.setLayout(ContenedorLayout);
        ContenedorLayout.setHorizontalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(footer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ContenedorLayout.setVerticalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        getContentPane().add(Contenedor, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        flag=false;
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        mysql.conectar();
        if(flag2 == 0)
        {
            mysql.eliminaEmpleados(emp.getNumeroEmpleado());
        }
        else if(flag2 == 1)
        {
            mysql.eliminaPlato(plato.getIdPlatillo());
        }
        else if(flag2 == 2)
        {
            mysql.copyVentas();
            mysql.FinalizaDia();
        }
        else if(flag2==3)
        {
            mysql.ActualizaOrden(orden.getIdOrden(), "Cancelada");
        }
        mysql.desconectar();
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(DosBotones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DosBotones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DosBotones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DosBotones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DosBotones dialog = new DosBotones(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel Contenedor;
    private javax.swing.JPanel body;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel footer;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lbltitulo;
    // End of variables declaration//GEN-END:variables
}
