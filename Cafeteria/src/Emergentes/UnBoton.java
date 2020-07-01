/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emergentes;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import tipografia.Fuentes;

/**
 *
 * @author isaac
 */
public class UnBoton extends javax.swing.JDialog {

    /*
        0 = Datos editados correctamente
        1 = datos vacios
        2 = error de contraseña
        3 = Error al tratar de eliminar
        4 = error al tratar de eliminar plato
    */
    
    Fuentes tipograf = new Fuentes();
    public UnBoton(java.awt.Frame parent, boolean modal, int flag) {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("../imagenes/LogoSolo.png")).getImage());
        setLocationRelativeTo(null);
        estilos();
        validacion(flag);
    }
    
    public void validacion(int flag)
    {
        if(flag==0)
        {
            lbltitulo.setText("Edición de datos");
            lblMensaje.setText("Los datos han sido editados exitosamente");
        }
        else if(flag==1)
        {
            lbltitulo.setText("Campos vacíos");
            lblMensaje.setText("Todos los campos de texto deben llenarse");
        }
        else if(flag==2)
        {
            lbltitulo.setText("Error de Contraseña");
            lblMensaje.setText("Formato incorrecto de cambio de contraseña");
        }
        else if(flag == 3)
        {
            lbltitulo.setText("Error al eliminar");
            lblMensaje.setText("Selecciona un empleado para eliminarlo");
        }
        else if(flag == 4)
        {
            lbltitulo.setText("Error al eliminar");
            lblMensaje.setText("Selecciona un platillo para eliminarlo");
        }
    }

    private UnBoton(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void estilos()
    {
        lbltitulo.setFont(tipograf.fuente(tipograf.monserratSemiBold, 1, 38));
        lblMensaje.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 0, 22));
        btnAceptar.setFont(tipograf.fuente(tipograf.pragatiNarrowRegular, 1, 22));
        
        lbltitulo.requestFocus();
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
        cabecera = new javax.swing.JPanel();
        lbltitulo = new javax.swing.JLabel();
        pie = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        centro = new javax.swing.JPanel();
        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        cabecera.setBackground(new java.awt.Color(255, 255, 255));
        cabecera.setPreferredSize(new java.awt.Dimension(450, 70));

        lbltitulo.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        lbltitulo.setForeground(new java.awt.Color(131, 8, 37));
        lbltitulo.setText("Titulo");
        cabecera.add(lbltitulo);

        jPanel1.add(cabecera, java.awt.BorderLayout.PAGE_START);

        pie.setBackground(new java.awt.Color(255, 255, 255));
        pie.setPreferredSize(new java.awt.Dimension(450, 70));

        btnAceptar.setBackground(new java.awt.Color(181, 8, 37));
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.setPreferredSize(new java.awt.Dimension(115, 40));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        pie.add(btnAceptar);

        jPanel1.add(pie, java.awt.BorderLayout.PAGE_END);

        centro.setBackground(new java.awt.Color(255, 255, 255));
        centro.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 30, 50));

        lblMensaje.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMensaje.setText("Este es un mensaje de error a de aceptar");
        centro.add(lblMensaje);

        jPanel1.add(centro, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
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
            java.util.logging.Logger.getLogger(UnBoton.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UnBoton.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UnBoton.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UnBoton.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UnBoton dialog = new UnBoton(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAceptar;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel centro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JPanel pie;
    // End of variables declaration//GEN-END:variables
}
