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
import java.awt.event.ItemEvent;
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
public class Estados extends javax.swing.JPanel {

    /**
     * Creates new form Estados
     */
    
    private Fuentes tipografia = new Fuentes();
    private List <Orden> listaorden = new ArrayList<>();
    private Mysql mysql = new Mysql();
    private UnBoton unboton;
    String estado = "";
    
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
    
    public Estados() {
        initComponents();
        estilos();
        tablaLlena("En cola");
    }
    
    public void estilos()
    {
        lblId2.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 0, 18));
        lblId.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 0, 18));
        lbltit.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 1, 24));
        
        lblId2.setText("Selecciona");
        
        cmbFiltro.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 0, 18));
        cmbStatus.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 0, 18));
        
        btnestado.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 1, 16));
        
        cmbFiltro.addItem("En cola");
        cmbFiltro.addItem("En proceso");
        cmbFiltro.addItem("Terminada");
        cmbFiltro.addItem("Entregada");
        cmbFiltro.addItem("Cancelada");
        
        cmbStatus.addItem("Entregada");
        cmbStatus.addItem("Cancelada");
        
    }
    
    public void tablaLlena (String filtro)
    {
        listaorden.clear();
        modelo.setRowCount(0);
        modelo.setColumnIdentifiers(new Object[]{"Id orden","Nombre cliente", "Estado"});
        mysql.conectar();
        listaorden = mysql.listStatusOrdenes(filtro);
        mysql.desconectar();
        for(Orden aux : listaorden)
        {
            modelo.addRow(new Object[]{aux.getIdOrden(), aux.getCliente(), aux.getEstado()});
        }
        tblEstatus.setModel(modelo);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstatus = new rojerusan.RSTableMetro();
        cmbFiltro = new javax.swing.JComboBox<>();
        Edita = new javax.swing.JPanel();
        btnestado = new javax.swing.JButton();
        cmbStatus = new javax.swing.JComboBox<>();
        lbltit = new javax.swing.JLabel();
        contineDatos = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        lblId2 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        Contenedor.setBackground(new java.awt.Color(255, 255, 255));

        tblEstatus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id orden", "Nombre cliente", "Estado"
            }
        ));
        tblEstatus.setColorBackgoundHead(new java.awt.Color(51, 51, 51));
        tblEstatus.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tblEstatus.setColorBordeHead(new java.awt.Color(51, 51, 51));
        tblEstatus.setColorFilasBackgound2(new java.awt.Color(137, 137, 137));
        tblEstatus.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tblEstatus.setColorFilasForeground2(new java.awt.Color(255, 255, 255));
        tblEstatus.setGridColor(new java.awt.Color(255, 255, 255));
        tblEstatus.setGrosorBordeFilas(0);
        tblEstatus.setGrosorBordeHead(0);
        tblEstatus.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblEstatus.setMultipleSeleccion(false);
        tblEstatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblEstatusMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblEstatus);

        cmbFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbFiltroItemStateChanged(evt);
            }
        });

        Edita.setBackground(new java.awt.Color(255, 255, 255));

        btnestado.setBackground(new java.awt.Color(181, 8, 37));
        btnestado.setForeground(new java.awt.Color(255, 255, 255));
        btnestado.setText("Editar");
        btnestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnestadoActionPerformed(evt);
            }
        });

        lbltit.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbltit.setText("Cambiar Estado");

        contineDatos.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        lblId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblId.setText("Id orden:");
        contineDatos.add(lblId);

        lblId2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblId2.setText("OR1234");
        contineDatos.add(lblId2);

        javax.swing.GroupLayout EditaLayout = new javax.swing.GroupLayout(Edita);
        Edita.setLayout(EditaLayout);
        EditaLayout.setHorizontalGroup(
            EditaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EditaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditaLayout.createSequentialGroup()
                        .addComponent(contineDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(263, 263, 263))
                    .addGroup(EditaLayout.createSequentialGroup()
                        .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnestado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(EditaLayout.createSequentialGroup()
                        .addComponent(lbltit)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        EditaLayout.setVerticalGroup(
            EditaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditaLayout.createSequentialGroup()
                .addComponent(lbltit)
                .addGap(29, 29, 29)
                .addComponent(contineDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(EditaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnestado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ContenedorLayout = new javax.swing.GroupLayout(Contenedor);
        Contenedor.setLayout(ContenedorLayout);
        ContenedorLayout.setHorizontalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ContenedorLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Edita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        ContenedorLayout.setVerticalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenedorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 25, Short.MAX_VALUE)
                .addGroup(ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContenedorLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(ContenedorLayout.createSequentialGroup()
                        .addComponent(Edita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        add(Contenedor, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbFiltroItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            tablaLlena(cmbFiltro.getSelectedItem().toString());
            if(cmbFiltro.getSelectedItem().equals("En proceso") || cmbFiltro.getSelectedItem().equals("Entregada") || cmbFiltro.getSelectedItem().equals("Cancelada"))
            {
                btnestado.setEnabled(false);
                btnestado.setBackground(new Color(51,51,51));
            }
            else
            {
                btnestado.setEnabled(true);
                btnestado.setBackground(new Color(181,8,37));
            }
        }
    }//GEN-LAST:event_cmbFiltroItemStateChanged

    private void tblEstatusMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEstatusMousePressed
        lblId2.setText(tblEstatus.getValueAt(tblEstatus.getSelectedRow(), 0).toString());
        estado = tblEstatus.getValueAt(tblEstatus.getSelectedRow(), 2).toString();
        if(estado.equals("En proceso") || estado.equals("Entregada") || estado.equals("Cancelada"))
        {
            btnestado.setEnabled(false);
            btnestado.setBackground(new Color(51,51,51));
        }
        else
        {
            btnestado.setEnabled(true);
            btnestado.setBackground(new Color(181,8,37));
        }
    }//GEN-LAST:event_tblEstatusMousePressed

    private void btnestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnestadoActionPerformed
       
        if(estado.equals(""))
        {
            Window parentWindow = SwingUtilities.windowForComponent(this);
            Frame parentframe = null;
            if(parentWindow instanceof Frame)
            {
                parentframe = (Frame)parentWindow;
            }
            unboton = new UnBoton(parentframe, true, 14);
            unboton.setVisible(true);
        }
        else
        {
            
            if(estado.equals("En cola") && cmbStatus.getSelectedItem().toString().equals("Entregada"))
            {
                Window parentWindow = SwingUtilities.windowForComponent(this);
                Frame parentframe = null;
                if(parentWindow instanceof Frame)
                {
                    parentframe = (Frame)parentWindow;
                }
                unboton = new UnBoton(parentframe, true, 15);
                unboton.setVisible(true);
            }
            else
            {
                actualizaO();
            }
        }
    }//GEN-LAST:event_btnestadoActionPerformed

    public void actualizaO()
    {
        mysql.conectar();
        mysql.ActualizaOrden(lblId2.getText(), cmbStatus.getSelectedItem().toString());
        mysql.desconectar();
            
        cmbFiltro.setSelectedIndex(0);
        tablaLlena("En cola");
            
        lblId2.setText("Selecciona");
        estado = "";
        cmbStatus.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Contenedor;
    private javax.swing.JPanel Edita;
    private javax.swing.JButton btnestado;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JPanel contineDatos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblId2;
    private javax.swing.JLabel lbltit;
    private rojerusan.RSTableMetro tblEstatus;
    // End of variables declaration//GEN-END:variables
}
