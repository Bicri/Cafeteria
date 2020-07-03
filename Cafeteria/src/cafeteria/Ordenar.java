/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteria;

import BaseDatos.Mysql;
import Emergentes.GenerarId;
import Emergentes.UnBoton;
import com.sun.glass.events.KeyEvent;
import java.awt.Frame;
import java.awt.Window;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import objetos.Orden;
import objetos.Platillo;
import tipografia.Fuentes;

/**
 *
 * @author isaac
 */
public class Ordenar extends javax.swing.JPanel {

    /**
     * Creates new form Ordenar
     */
    private Fuentes tipografia = new Fuentes();
    private Platillo plato;
    private Mysql mysql = new Mysql();
    private Orden orden, ordenQuitar, ordenGuardar;
    private String TotalPlatos = "0", v = "0";
    private List <Platillo> listaplatillos = new ArrayList<>();
    private List <Orden> listaorden = new ArrayList<>();
    private int i =-1;
    private UnBoton unboton;
    private GenerarId genera = new GenerarId();
    private Calendar calendar = new GregorianCalendar();
    
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
    
    DefaultTableModel modelo2 = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int filas, int columnas) {
            if(columnas == 4)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    };
    
    public void IdOrden()
    {
        lblId.setText(genera.generaIdOrden());
        
    }
    public Ordenar() {
        initComponents();
        lblId.requestFocus();
        this.setSize(1256, 352);
        estilos();
        tablaLlena();
        listaorden.clear();
        tablaLlenaOrden();
        IdOrden();
    }
    
    public void importe()
    {
        float total = 0;
        if(listaorden.size()>0)
        {
            for(Orden aux : listaorden)
            {
                total += aux.getPrecio();
            }
        }
        txtTotal.setText(String.valueOf(total));
    }
    
    public void estilos()
    {
        
        lblCambio.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 0, 18));
        lblRecibe.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 0, 18));
        lblTota.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 0, 18));
        lblId.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 0, 30));
        
        txtsearch.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 0, 20));
        txtAdd.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 0, 20));
        txtQuit.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 0, 22));
        txtCliente.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 0, 20));
        txtTotal.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 0, 20));
        txtRecibido.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 0, 20));
        txtCambio.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 0, 20));
        
        btnAdd.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 1, 16));
        btnQuit.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 1, 16));
        btnAcepta.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 1, 16));
        btnLimpiar.setFont(tipografia.fuente(tipografia.pragatiNarrowRegular, 1, 16));
    }
//------------------------- TABLA MENU ----------------------------------------------------------------------------------
    public void tablaLlena ()
    {
        listaplatillos.clear();
        modelo.setRowCount(0);
        modelo.setColumnIdentifiers(new Object[]{"Id Platillo","Nombre", "Precio"});
        mysql.conectar();
        listaplatillos = mysql.muestraPlatillos();
        mysql.desconectar();
        for(Platillo aux : listaplatillos)
        {
            modelo.addRow(new Object[]{aux.getIdPlatillo(), aux.getNombrePlatillo(), aux.getPrecio()});
        }
        tblMenu.setModel(modelo);
    }
    
    public void tablaLlenaDinamic ()
    {
        listaplatillos.clear();
        modelo.setRowCount(0);
        modelo.setColumnIdentifiers(new Object[]{"Id Platillo","Nombre", "Precio"});
        mysql.conectar();
        listaplatillos = mysql.muestraPlatillosDinamic(txtsearch.getText());
        mysql.desconectar();
        for(Platillo aux : listaplatillos)
        {
            modelo.addRow(new Object[]{aux.getIdPlatillo(), aux.getNombrePlatillo(), aux.getPrecio()});
        }
        tblMenu.setModel(modelo);
    }
//---------------------------------------------------------------------------------------------------------------------------


    public void tablaLlenaOrden ()
    {
        modelo2.setRowCount(0);
        modelo2.setColumnIdentifiers(new Object[]{"Cantidad", "Id Platillo","Nombre", "Precio"});

        for(Orden aux : listaorden)
        {
            modelo2.addRow(new Object[]{String.valueOf(aux.getCantidad()), aux.getIdPlatillo(), aux.getNombrePlatillo(), String.valueOf(aux.getPrecio())});
        }
        importe();
        tblOrden.setModel(modelo2);
        getCambio();
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
        tblMenu = new rojerusan.RSTableMetro();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrden = new rojerusan.RSTableMetro();
        txtTotal = new rscomponentshade.RSTextFieldShade();
        txtRecibido = new rscomponentshade.RSTextFieldShade();
        txtCambio = new rscomponentshade.RSTextFieldShade();
        jPanel1 = new javax.swing.JPanel();
        lblTota = new javax.swing.JLabel();
        lblRecibe = new javax.swing.JLabel();
        lblCambio = new javax.swing.JLabel();
        txtCliente = new rscomponentshade.RSTextFieldShade();
        txtAdd = new rscomponentshade.RSTextFieldShade();
        txtQuit = new rscomponentshade.RSTextFieldShade();
        btnLimpiar = new javax.swing.JButton();
        btnAcepta = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtsearch = new rscomponentshade.RSTextFieldShade();
        jPanel2 = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        tblMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id Platillo", "Nombre", "Precio"
            }
        ));
        tblMenu.setColorBackgoundHead(new java.awt.Color(181, 8, 37));
        tblMenu.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tblMenu.setColorBordeHead(new java.awt.Color(181, 8, 37));
        tblMenu.setColorFilasBackgound2(new java.awt.Color(255, 102, 102));
        tblMenu.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tblMenu.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tblMenu.setGridColor(new java.awt.Color(255, 255, 255));
        tblMenu.setGrosorBordeFilas(0);
        tblMenu.setGrosorBordeHead(0);
        tblMenu.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblMenu.setMultipleSeleccion(false);
        tblMenu.setShowHorizontalLines(false);
        tblMenu.setShowVerticalLines(false);
        tblMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblMenuMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblMenu);

        tblOrden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cantidad", "Id platillo", "Nombre", "Precio"
            }
        ));
        tblOrden.setColorBackgoundHead(new java.awt.Color(51, 51, 51));
        tblOrden.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tblOrden.setColorBordeHead(new java.awt.Color(51, 51, 51));
        tblOrden.setColorFilasBackgound2(new java.awt.Color(137, 137, 137));
        tblOrden.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tblOrden.setColorFilasForeground2(new java.awt.Color(255, 255, 255));
        tblOrden.setGridColor(new java.awt.Color(255, 255, 255));
        tblOrden.setGrosorBordeFilas(0);
        tblOrden.setGrosorBordeHead(0);
        tblOrden.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblOrden.setMultipleSeleccion(false);
        tblOrden.setShowHorizontalLines(false);
        tblOrden.setShowVerticalLines(false);
        tblOrden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblOrdenMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblOrden);

        txtTotal.setPlaceholder("");

        txtRecibido.setPlaceholder("");
        txtRecibido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRecibidoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRecibidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRecibidoKeyTyped(evt);
            }
        });

        txtCambio.setPlaceholder("");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTota.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTota.setText("Total");

        lblRecibe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblRecibe.setText("Recibido");

        lblCambio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCambio.setText("Cambio");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRecibe)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(lblCambio))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(lblTota))))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTota)
                .addGap(30, 30, 30)
                .addComponent(lblRecibe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCambio)
                .addContainerGap())
        );

        txtCliente.setPlaceholder("Nombre del cliente");
        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        txtAdd.setPlaceholder("Cantidad");

        txtQuit.setPlaceholder("Cantidad");

        btnLimpiar.setBackground(new java.awt.Color(181, 8, 37));
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnAcepta.setBackground(new java.awt.Color(181, 8, 37));
        btnAcepta.setForeground(new java.awt.Color(255, 255, 255));
        btnAcepta.setText("Aceptar");
        btnAcepta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptaActionPerformed(evt);
            }
        });

        btnQuit.setBackground(new java.awt.Color(51, 51, 51));
        btnQuit.setForeground(new java.awt.Color(255, 255, 255));
        btnQuit.setText("Quitar");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(181, 8, 37));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtsearch.setPlaceholder("Buscar Platillo");
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblId.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        lblId.setText("ID Orden: O125");
        jPanel2.add(lblId);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAcepta, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAcepta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtQuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed

    }//GEN-LAST:event_txtClienteActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        // TODO add your handling code here:
        tablaLlenaDinamic();
    }//GEN-LAST:event_txtsearchKeyReleased

    private void tblMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMenuMousePressed

        v = "1";
        plato = new Platillo(tblMenu.getValueAt(tblMenu.getSelectedRow(), 0).toString(), tblMenu.getValueAt(tblMenu.getSelectedRow(), 1).toString(), Float.parseFloat(tblMenu.getValueAt(tblMenu.getSelectedRow(), 2).toString()));
        if(evt.getClickCount()==2)
        {
            if(listaorden.size()==0)
            {
                listaorden.add(new Orden(1,plato.getIdPlatillo(),plato.getNombrePlatillo(),plato.getPrecio()));
                tablaLlenaOrden();
            }else
            {
                if(validarEnOrden(plato)==false)
                {
                    listaorden.add(new Orden(1,plato.getIdPlatillo(),plato.getNombrePlatillo(),plato.getPrecio()));
                    txtTotal.setText(String.valueOf(plato.getPrecio()));
                    tablaLlenaOrden();
                    
                }
                else
                {
                    orden = listaorden.get(i);
                    orden.setCantidad(orden.getCantidad()+1);
                    orden.setPrecio(Float.parseFloat(tblMenu.getValueAt(tblMenu.getSelectedRow(), 2).toString())*orden.getCantidad());
                    listaorden.set(i, orden);
                    tablaLlenaOrden();
                }               
            }
        }
    }//GEN-LAST:event_tblMenuMousePressed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
         Window parentWindow = SwingUtilities.windowForComponent(this);
         Frame parentframe = null;
         if(parentWindow instanceof Frame)
         {
            parentframe = (Frame)parentWindow;
         }
         if(!(v.equals("1")))
         {
             unboton = new UnBoton(parentframe, true, 5);
             unboton.setVisible(true);
         }
         else
         {
             if(txtAdd.getText().isEmpty() || txtAdd.getText().equals("0"))
             {
                if(txtAdd.getText().isEmpty())
                {
                    unboton = new UnBoton(parentframe, true, 6);
                    unboton.setVisible(true);
                }
                if(txtAdd.getText().equals("0"))
                {
                    unboton = new UnBoton(parentframe, true, 7);
                    unboton.setVisible(true);
                }
             }
             else
             {
                 if(listaorden.size()==0)
                {
                    listaorden.add(new Orden(Integer.parseInt(txtAdd.getText()),plato.getIdPlatillo(),plato.getNombrePlatillo(),plato.getPrecio()*Float.parseFloat(txtAdd.getText())));
                    tablaLlenaOrden();
                }else
                {
                    if(validarEnOrden(plato)==false)
                    {
                        listaorden.add(new Orden(Integer.parseInt(txtAdd.getText()),plato.getIdPlatillo(),plato.getNombrePlatillo(),plato.getPrecio()));
                        tablaLlenaOrden();
                    }
                    else
                    {
                        orden = listaorden.get(i);
                        orden.setCantidad(orden.getCantidad()+Integer.parseInt(txtAdd.getText()));
                        orden.setPrecio(Float.parseFloat(tblMenu.getValueAt(tblMenu.getSelectedRow(), 2).toString())*orden.getCantidad());
                        listaorden.set(i, orden);
                        tablaLlenaOrden();
                    }
                    txtAdd.setText("");
                }
             }
         }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        Window parentWindow = SwingUtilities.windowForComponent(this);
        Frame parentframe = null;
        if(parentWindow instanceof Frame)
        {
            parentframe = (Frame)parentWindow;
        }
        if(!(v.equals("2")))
        {
            unboton = new UnBoton(parentframe, true, 8);
            unboton.setVisible(true);
        }
        else
        {
            if(txtQuit.getText().equals("0"))
            {
                unboton = new UnBoton(parentframe, true, 7);
                unboton.setVisible(true);
            }
            else
            {
                if(Integer.parseInt(txtQuit.getText())> ordenQuitar.getCantidad())
                {
                    unboton = new UnBoton(parentframe, true, 9);
                    unboton.setVisible(true);
                }
                else
                {
                    if(ordenQuitar.getCantidad() == Integer.parseInt(txtQuit.getText()))
                    {
                        listaorden.remove(tblOrden.getSelectedRow());
                        tablaLlenaOrden();
                    }
                    else
                    {
                        ordenQuitar.setCantidad(ordenQuitar.getCantidad()-Integer.parseInt(txtQuit.getText()));
                        ordenQuitar.setPrecio(ordenQuitar.getCantidad()*buscarPrecio());
                        listaorden.set(tblOrden.getSelectedRow(), ordenQuitar);
                        tablaLlenaOrden();
                        
                    }
                    txtQuit.setText("");
                }
            }
        }
    }//GEN-LAST:event_btnQuitActionPerformed

    private void tblOrdenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrdenMousePressed
        v = "2";
        ordenQuitar = new Orden(Integer.parseInt(tblOrden.getValueAt(tblOrden.getSelectedRow(), 0).toString()), tblOrden.getValueAt(tblOrden.getSelectedRow(), 1).toString(), tblOrden.getValueAt(tblOrden.getSelectedRow(), 2).toString(), Float.parseFloat(tblOrden.getValueAt(tblOrden.getSelectedRow(), 3).toString()));
        if(evt.getClickCount()==2)
        {
            if(ordenQuitar.getCantidad() == 1)
            {
                listaorden.remove(tblOrden.getSelectedRow());
                tablaLlenaOrden();
            }
            else
            {
                ordenQuitar.setCantidad(ordenQuitar.getCantidad()-1);
                ordenQuitar.setPrecio(ordenQuitar.getCantidad()*buscarPrecio());
                listaorden.set(tblOrden.getSelectedRow(), ordenQuitar);
                tablaLlenaOrden();
            }
        }
    }//GEN-LAST:event_tblOrdenMousePressed

    private void txtRecibidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecibidoKeyTyped
        char caracter = evt.getKeyChar();
        
       if(Character.isLetter(caracter) || caracter == KeyEvent.VK_SPACE || txtRecibido.getText().length() == 8 || caracter==',' || (caracter == '.' && txtRecibido.getText().length()==0))
        {
            getToolkit().beep();
            evt.consume();
        }
        else 
       {
            if(txtRecibido.getText().contains(".") && caracter == '.')
            {
                evt.consume();
            }
       }
    }//GEN-LAST:event_txtRecibidoKeyTyped

    
    private void txtRecibidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecibidoKeyReleased

        getCambio();
    }//GEN-LAST:event_txtRecibidoKeyReleased

    public void getCambio()
    {
        if(txtRecibido.getText().isEmpty())
        {
            txtCambio.setPlaceholder("Sin pago recibido");
        }
        else
        {
            txtCambio.setPlaceholder("");
            if(Float.parseFloat(txtRecibido.getText())<Float.parseFloat(txtTotal.getText()))
            {
                txtCambio.setPlaceholder("No cubre pago");
            }
            else
            {
                txtCambio.setText(String.valueOf(Float.parseFloat(txtRecibido.getText())-Float.parseFloat(txtTotal.getText())));
            }
        }
    }
    
    private void txtRecibidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecibidoKeyPressed
        
    }//GEN-LAST:event_txtRecibidoKeyPressed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpia();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAceptaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptaActionPerformed
        
        Window parentWindow = SwingUtilities.windowForComponent(this);
        Frame parentframe = null;
        if(parentWindow instanceof Frame)
        {
            parentframe = (Frame)parentWindow;
        }
        
        if(txtCliente.getText().isEmpty())
        {
            unboton = new UnBoton(parentframe, true, 10);
            unboton.setVisible(true);
        }
        else if(listaorden.size()==0)
        {
            unboton = new UnBoton(parentframe, true,11);
            unboton.setVisible(true);
        }
        else if(txtRecibido.getText().isEmpty())
        {
            unboton = new UnBoton(parentframe, true,12);
            unboton.setVisible(true);
        }
        else if(Float.parseFloat(txtTotal.getText())>Float.parseFloat(txtRecibido.getText()))
        {
            unboton = new UnBoton(parentframe, true,13);
            unboton.setVisible(true);
        }
        else
        {
            String fecha = String.valueOf(calendar.get(Calendar.YEAR))+"/"+String.valueOf(calendar.get(Calendar.MONTH)+1)+"/"+String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
            ordenGuardar = new Orden(lblId.getText(),txtCliente.getText(),fecha,"En cola",pasaString(),Float.parseFloat(txtTotal.getText()));
            mysql.conectar();
            mysql.insertaOrden(ordenGuardar);
            mysql.desconectar();
            limpia();
            IdOrden();
        }
        
    }//GEN-LAST:event_btnAceptaActionPerformed

    private String pasaString ()
    {
        String productos = "";
        for(Orden aux : listaorden)
        {
            productos += aux.getCantidad()+" "+aux.getIdPlatillo()+" "+aux.getNombrePlatillo()+",";
        }
        return productos;
    }
    
    public void limpia()
    {
        listaorden.clear();
        tablaLlenaOrden();
        tablaLlena();
        txtRecibido.setText("");
        txtCambio.setText("");
        txtsearch.setText("");
        txtCliente.setText("");
        v="0";
    }
    
    private float buscarPrecio()
    {
        for(Platillo aux : listaplatillos)
        {
            if(aux.getIdPlatillo().equals(ordenQuitar.getIdPlatillo()))
            {
                return aux.getPrecio();
            }
        }
        
        return (float) 0;
    }
    private boolean validarEnOrden(Platillo p)
    {
        i = -1;
        for(Orden aux : listaorden)
        {  
            i++;
            if(aux.getIdPlatillo().equals(p.getIdPlatillo()))
            {
                return true;
            }
        }
        
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcepta;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnQuit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCambio;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblRecibe;
    private javax.swing.JLabel lblTota;
    private rojerusan.RSTableMetro tblMenu;
    private rojerusan.RSTableMetro tblOrden;
    private rscomponentshade.RSTextFieldShade txtAdd;
    private rscomponentshade.RSTextFieldShade txtCambio;
    private rscomponentshade.RSTextFieldShade txtCliente;
    private rscomponentshade.RSTextFieldShade txtQuit;
    private rscomponentshade.RSTextFieldShade txtRecibido;
    private rscomponentshade.RSTextFieldShade txtTotal;
    private rscomponentshade.RSTextFieldShade txtsearch;
    // End of variables declaration//GEN-END:variables
}
