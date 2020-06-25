/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteria;

import tipografia.Fuentes;

/**
 *
 * @author isaac
 */
public class Base extends javax.swing.JFrame {

    /**
     * Creates new form InicioAdmin
     */
    private Fuentes fuente;
    
    public Base() {
        initComponents();
        setSize(1100,600);
        setLocationRelativeTo(null);
        estilos();
    }
    
    public void estilos()
    {
        
        lblInicio.setLocation(100, 200);
        fuente = new Fuentes();
        lblTitulo.setFont(fuente.fuente(fuente.monserratSemiBold, 0, 65));
        lblUsuario.setFont(fuente.fuente(fuente.pragatiNarrowRegular, 0, 18));
        lblInicio.setFont(fuente.fuente(fuente.monserratRegular, 0, 24));
        lblPersonal.setFont(fuente.fuente(fuente.monserratRegular, 0, 24));
        lblCerrar.setFont(fuente.fuente(fuente.monserratRegular, 0, 24));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        norte = new javax.swing.JPanel();
        sur = new javax.swing.JPanel();
        derecha = new javax.swing.JPanel();
        izquierda = new javax.swing.JPanel();
        centro = new javax.swing.JPanel();
        cabecera = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblInicio = new javax.swing.JLabel();
        lblPersonal = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        norte.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout norteLayout = new javax.swing.GroupLayout(norte);
        norte.setLayout(norteLayout);
        norteLayout.setHorizontalGroup(
            norteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1273, Short.MAX_VALUE)
        );
        norteLayout.setVerticalGroup(
            norteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(norte, java.awt.BorderLayout.PAGE_START);

        sur.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout surLayout = new javax.swing.GroupLayout(sur);
        sur.setLayout(surLayout);
        surLayout.setHorizontalGroup(
            surLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1273, Short.MAX_VALUE)
        );
        surLayout.setVerticalGroup(
            surLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(sur, java.awt.BorderLayout.PAGE_END);

        derecha.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout derechaLayout = new javax.swing.GroupLayout(derecha);
        derecha.setLayout(derechaLayout);
        derechaLayout.setHorizontalGroup(
            derechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        derechaLayout.setVerticalGroup(
            derechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        getContentPane().add(derecha, java.awt.BorderLayout.LINE_END);

        izquierda.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout izquierdaLayout = new javax.swing.GroupLayout(izquierda);
        izquierda.setLayout(izquierdaLayout);
        izquierdaLayout.setHorizontalGroup(
            izquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        izquierdaLayout.setVerticalGroup(
            izquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        getContentPane().add(izquierda, java.awt.BorderLayout.LINE_START);

        centro.setBackground(new java.awt.Color(204, 204, 204));
        centro.setLayout(new java.awt.BorderLayout());

        cabecera.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 65)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(181, 8, 37));
        lblTitulo.setText("INICIO");

        lblUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUsuario.setText("Nombre de usuario mas su id");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LogoSolo1.png"))); // NOI18N

        lblInicio.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblInicio.setForeground(new java.awt.Color(153, 153, 153));
        lblInicio.setText("Inicio");
        lblInicio.setToolTipText("");
        lblInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblPersonal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblPersonal.setForeground(new java.awt.Color(153, 153, 153));
        lblPersonal.setText("Datos personales");

        lblCerrar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblCerrar.setForeground(new java.awt.Color(153, 153, 153));
        lblCerrar.setText("Cerrar Sesion");

        javax.swing.GroupLayout cabeceraLayout = new javax.swing.GroupLayout(cabecera);
        cabecera.setLayout(cabeceraLayout);
        cabeceraLayout.setHorizontalGroup(
            cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario)
                    .addComponent(lblTitulo))
                .addGap(70, 70, 70)
                .addComponent(lblInicio)
                .addGap(40, 40, 40)
                .addComponent(lblPersonal)
                .addGap(41, 41, 41)
                .addComponent(lblCerrar)
                .addGap(93, 93, 93)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(288, Short.MAX_VALUE))
        );
        cabeceraLayout.setVerticalGroup(
            cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
            .addGroup(cabeceraLayout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cabeceraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicio)
                    .addComponent(lblPersonal)
                    .addComponent(lblCerrar))
                .addGap(25, 25, 25))
        );

        centro.add(cabecera, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(centro, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Base().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel centro;
    private javax.swing.JPanel derecha;
    private javax.swing.JPanel izquierda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblPersonal;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel norte;
    private javax.swing.JPanel sur;
    // End of variables declaration//GEN-END:variables
}