/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteria;

import BaseDatos.Mysql;
import Emergentes.DosBotones;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import objetos.Orden;
import tipografia.Fuentes;

/**
 *
 * @author isaac
 */
public class PrepararOrden extends javax.swing.JPanel {

    /**
     * Creates new form PrepararOrden
     */
    private Fuentes tipografia = new Fuentes();
    private Mysql mysql = new Mysql();
    private Orden ordenget, ordentabla;
    private List <Orden> listaorden = new ArrayList<>();
    private Transformada transforma = new Transformada();
    private DosBotones dosbotones;
    
    DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int filas, int columnas) {
            if(columnas == 3)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    };
    
    public PrepararOrden() {
        initComponents();
        estilos();
        ValidaOrden();
    }

    public void estilos()
    {
        lbltitulo.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 1, 28));
        btnGet.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 1, 20));
        btnEnd.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 0, 18));
        btnTerminar.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 0, 18));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlatillos = new rojerusan.RSTableMetro();
        btnTerminar = new javax.swing.JButton();
        btnEnd = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbltitulo = new javax.swing.JLabel();
        btnGet = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tblPlatillos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cantidad", "Id platillo", "Nombre Platillo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPlatillos.setColorBackgoundHead(new java.awt.Color(181, 8, 37));
        tblPlatillos.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tblPlatillos.setColorBordeHead(new java.awt.Color(181, 8, 37));
        tblPlatillos.setColorFilasBackgound2(new java.awt.Color(255, 102, 102));
        tblPlatillos.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tblPlatillos.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tblPlatillos.setGridColor(new java.awt.Color(255, 255, 255));
        tblPlatillos.setGrosorBordeFilas(0);
        tblPlatillos.setGrosorBordeHead(0);
        tblPlatillos.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblPlatillos.setMultipleSeleccion(false);
        jScrollPane1.setViewportView(tblPlatillos);

        btnTerminar.setBackground(new java.awt.Color(181, 8, 37));
        btnTerminar.setForeground(new java.awt.Color(255, 255, 255));
        btnTerminar.setText("Terminar");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        btnEnd.setBackground(new java.awt.Color(181, 8, 37));
        btnEnd.setForeground(new java.awt.Color(255, 255, 255));
        btnEnd.setText("Cancelar");
        btnEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEndActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbltitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbltitulo.setText("SIN ORDEN PENDIENTE");

        btnGet.setBackground(new java.awt.Color(51, 255, 51));
        btnGet.setText("Obtener Orden");
        btnGet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(lbltitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGet, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltitulo)
                    .addComponent(btnGet, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTerminar, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(btnEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 157, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndActionPerformed
        Window parentWindow = SwingUtilities.windowForComponent(this);
        Frame parentframe = null;
        if(parentWindow instanceof Frame)
        {
            parentframe = (Frame)parentWindow;
        }
        dosbotones = new DosBotones(parentframe, true, 3, ordenget);
        dosbotones.setVisible(true);
        if(dosbotones.respuesta()==true)
        {
            ValidaOrden();
        }
        else{}
    }//GEN-LAST:event_btnEndActionPerformed

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        mysql.conectar();
        mysql.ActualizaOrden(ordenget.getIdOrden(), "Terminada");
        mysql.desconectar();
        ValidaOrden();
    }//GEN-LAST:event_btnTerminarActionPerformed

    private void btnGetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetActionPerformed
        // TODO add your handling code here:
        ValidaOrden();
    }//GEN-LAST:event_btnGetActionPerformed

    private void ValidaOrden()
    {
        mysql.conectar();
        if(mysql.countFirstOrden("En cola")>0)
        {
            btnGet.setEnabled(false);
            btnGet.setBackground(new Color(51,51,51));
            mysql.desconectar();
            btnEnd.setEnabled(true);
            btnTerminar.setEnabled(true);
            btnEnd.setBackground(new Color(181,8,37));
            btnTerminar.setBackground(new Color(181,8,37));
            obtenerOrden();
        }
        else
        {
            mysql.desconectar();
            listaorden.clear();
            tablaLlena();
            lbltitulo.setText("SIN ORDEN PENDIENTE, CONTROLES DESHABILITADOS");
            btnEnd.setEnabled(false);
            btnTerminar.setEnabled(false);
            btnEnd.setBackground(new Color(51,51,51));
            btnTerminar.setBackground(new Color(51,51,51));
            btnGet.setEnabled(true);
            btnGet.setBackground(new Color(51,255,51));
        }
    }
    
    private void obtenerOrden()
    {
        mysql.conectar();
        ordenget = mysql.getFirstOrden("En cola");
        mysql.ActualizaOrden(ordenget.getIdOrden(), "En proceso");
        mysql.desconectar();
        listaorden = transforma.separaProd(ordenget.getPlatillos(), 0);
        tablaLlena();
        lbltitulo.setText("Orden: "+ordenget.getIdOrden());
 
    }
    
    public void tablaLlena ()
    {
        modelo.setRowCount(0);
        modelo.setColumnIdentifiers(new Object[]{"Cantidad","Id platillo", "Nombre platillo"});
        for(Orden aux : listaorden)
        {
            modelo.addRow(new Object[]{aux.getCantidad(),aux.getIdPlatillo(), aux.getNombrePlatillo()});
        }
        tblPlatillos.setModel(modelo);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnd;
    private javax.swing.JButton btnGet;
    private javax.swing.JButton btnTerminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltitulo;
    private rojerusan.RSTableMetro tblPlatillos;
    // End of variables declaration//GEN-END:variables
}
