
package cafeteria;

import java.awt.Color;
import java.awt.Window;
import javax.swing.SwingUtilities;
import objetos.Empleado;
import tipografia.Fuentes;
/**
 *
 * @author isaac
 */
public class Inicio extends javax.swing.JPanel {

    /**
     * Creates new form Inicio
     */
    private Fuentes fonts = new Fuentes();
    private DatosPersonales objeto;
    private AdminEmpleados adminE;
    private Ventas ventas;
    private AdminMenu menu;
    private String empleado;
    
    public Inicio(String emp) {
        initComponents();
        tipografias();
        empleado = emp;
    }
    
    public void tipografias()
    {
      
        lblEmpleados.setFont(fonts.fuente(fonts.pragatiNarrowRegular, 1, 32));
        lblEmpleados.setForeground(Color.WHITE);
        lblMenu.setFont(fonts.fuente(fonts.pragatiNarrowRegular, 1, 32));
        lblMenu.setForeground(Color.WHITE);
        lblVentas.setFont(fonts.fuente(fonts.pragatiNarrowRegular, 1, 32));
        lblVentas.setForeground(Color.WHITE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUser = new cafeteria.Gradiente();
        lblEmpleados = new javax.swing.JLabel();
        panelMenu = new cafeteria.Gradiente();
        lblMenu = new javax.swing.JLabel();
        panelVentas = new cafeteria.Gradiente();
        lblVentas = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        panelUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelUser.setMaximumSize(new java.awt.Dimension(1256, 61));
        panelUser.setMinimumSize(new java.awt.Dimension(1256, 61));
        panelUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelUserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelUserMouseExited(evt);
            }
        });

        lblEmpleados.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        lblEmpleados.setText("Administrar empleados");

        javax.swing.GroupLayout panelUserLayout = new javax.swing.GroupLayout(panelUser);
        panelUser.setLayout(panelUserLayout);
        panelUserLayout.setHorizontalGroup(
            panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUserLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblEmpleados)
                .addContainerGap(882, Short.MAX_VALUE))
        );
        panelUserLayout.setVerticalGroup(
            panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUserLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblEmpleados)
                .addContainerGap())
        );

        panelMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelMenuMouseExited(evt);
            }
        });

        lblMenu.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        lblMenu.setText("Administrar Menú");

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lblMenu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMenu)
                .addContainerGap())
        );

        panelVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelVentasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelVentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelVentasMouseExited(evt);
            }
        });

        lblVentas.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        lblVentas.setText("Ventas del día");

        javax.swing.GroupLayout panelVentasLayout = new javax.swing.GroupLayout(panelVentas);
        panelVentas.setLayout(panelVentasLayout);
        panelVentasLayout.setHorizontalGroup(
            panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVentasLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(lblVentas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelVentasLayout.setVerticalGroup(
            panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVentasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblVentas)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addComponent(panelUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(panelVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void panelUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUserMouseEntered
        // TODO add your handling code here:
        lblEmpleados.setForeground(new Color(51,51,51));
    }//GEN-LAST:event_panelUserMouseEntered

    private void panelUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUserMouseExited
        // TODO add your handling code here:
        lblEmpleados.setForeground(Color.WHITE);
    }//GEN-LAST:event_panelUserMouseExited

    private void panelUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUserMouseClicked
        Window parentWindow = SwingUtilities.windowForComponent(this);
        adminE = new AdminEmpleados(empleado);
        adminE.setVisible(true);
        parentWindow.dispose();

    }//GEN-LAST:event_panelUserMouseClicked

        
    private void panelMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMenuMouseEntered
        // TODO add your handling code here:
        lblMenu.setForeground(new Color(51,51,51));
    }//GEN-LAST:event_panelMenuMouseEntered

    private void panelMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMenuMouseExited
        // TODO add your handling code here:
        lblMenu.setForeground(Color.WHITE);
    }//GEN-LAST:event_panelMenuMouseExited

    private void panelVentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVentasMouseEntered
        // TODO add your handling code here:
        lblVentas.setForeground(new Color(51,51,51));
    }//GEN-LAST:event_panelVentasMouseEntered

    private void panelVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVentasMouseExited
        // TODO add your handling code here:
        lblVentas.setForeground(Color.WHITE);
    }//GEN-LAST:event_panelVentasMouseExited

    private void panelMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMenuMouseClicked
        // TODO add your handling code here:
        Window parentWindow = SwingUtilities.windowForComponent(this);
        menu = new AdminMenu(empleado);
        menu.setVisible(true);
        parentWindow.dispose();
    }//GEN-LAST:event_panelMenuMouseClicked

    private void panelVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVentasMouseClicked
        Window parentWindow = SwingUtilities.windowForComponent(this);
        ventas = new Ventas(empleado);
        ventas.setVisible(true);
        parentWindow.dispose();
    }//GEN-LAST:event_panelVentasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblEmpleados;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblVentas;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelUser;
    private javax.swing.JPanel panelVentas;
    // End of variables declaration//GEN-END:variables
}
