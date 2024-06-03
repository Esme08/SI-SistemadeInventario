package sistema_los_amigos.Formularios.formAdmin;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema_los_amigos.Sistema_Los_Amigos;
import sistema_los_amigos.detalles_ventas;
import sistema_los_amigos.ventas;

/*
 * @author esmer
 */

public class AdminVentas extends javax.swing.JFrame {
    Sistema_Los_Amigos Control = new Sistema_Los_Amigos();
    DefaultTableModel modeloVenta;
    DefaultTableModel modeloDetalle;
    int Totalazo = 0;
    
    public void cargarVentas (String Intervalo)
    {
        try 
        {
            if(Intervalo.equals("Hoy"))
            {
                Totalazo = 0;
                ventas ventas = new ventas();
                ventas.setConn(Control.getConn());
                this.modeloVenta.setRowCount(0);
                ResultSet st = ventas.getVentasHoy();
                if(st != null)
                {
                    while(st.next()) 
                    {
                        String datos[] = 
                        {
                            st.getObject(1).toString(),
                            st.getObject(2).toString(),
                            st.getObject(3).toString(),
                            st.getObject(4).toString(),
                            st.getObject(5).toString()
                        };
                        this.modeloVenta.addRow(datos);
                        
                        Totalazo += Double.valueOf(st.getObject(5).toString());
                        txt_totalvendido.setText("$" + String.valueOf(Totalazo));
                    }
                }
            }
                
            if(Intervalo.equals("Esta semana"))
            {
                Totalazo = 0;
                ventas ventas = new ventas();
                ventas.setConn(Control.getConn());
                this.modeloVenta.setRowCount(0);
                ResultSet st = ventas.getVentasUnaSemana();
                if(st != null)
                {
                    while(st.next()) 
                    {
                        String datos[] = 
                        {
                            st.getObject(1).toString(),
                            st.getObject(2).toString(),
                            st.getObject(3).toString(),
                            st.getObject(4).toString(),
                            st.getObject(5).toString()
                        };
                        this.modeloVenta.addRow(datos);
                        
                        Totalazo += Double.valueOf(st.getObject(5).toString());
                        txt_totalvendido.setText("$"+String.valueOf(Totalazo));
                    }
                }
            }
            
            if(Intervalo.equals("Este mes"))
            {
                Totalazo = 0;
                ventas ventas = new ventas();
                ventas.setConn(Control.getConn());
                this.modeloVenta.setRowCount(0);
                ResultSet st = ventas.getVentasUnMes();
                if(st != null)
                {
                    while(st.next()) 
                    {
                        String datos[] = 
                        {
                            st.getObject(1).toString(),
                            st.getObject(2).toString(),
                            st.getObject(3).toString(),
                            st.getObject(4).toString(),
                            st.getObject(5).toString()
                        };
                        this.modeloVenta.addRow(datos);
                        
                        Totalazo += Double.valueOf(st.getObject(5).toString());
                        txt_totalvendido.setText("$"+String.valueOf(Totalazo));
                    }
                }
            }
        }
        catch (SQLException ex) 
        { 
            JOptionPane.showMessageDialog(null, "Ups! Algo salió mal" + ex);
        }
    }
    
    public void cargarDetalles (int ID)
    {
        detalles_ventas detalles_ventas = new detalles_ventas();
        detalles_ventas.setConn(Control.getConn());
        this.modeloDetalle.setRowCount(0);
        try 
        {
            ResultSet st = detalles_ventas.getDetalleVentas(ID);
            if(st != null)
            {
                while(st.next()) 
                {
                    String datos[] = 
                    {
                        st.getObject(1).toString(),
                        st.getObject(2).toString(),
                        st.getObject(3).toString(),
                    };
                    this.modeloDetalle.addRow(datos);
                }
            }
        }
        catch (SQLException ex) 
        { 
            JOptionPane.showMessageDialog(null, "Ups! Algo salió mal" + ex);
        }
    }

    /**
     * Creates new form AdminVentas
     */
    public AdminVentas() {
        initComponents();
        modeloVenta = (DefaultTableModel) this.TablaVentas.getModel();
        modeloDetalle = (DefaultTableModel) this.TablaDetalle.getModel();
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaVentas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaDetalle = new javax.swing.JTable();
        lbl_total = new javax.swing.JLabel();
        cbx_periodo = new javax.swing.JComboBox<>();
        txt_totalvendido = new javax.swing.JTextField();
        lbl_Detalle = new javax.swing.JLabel();
        btn_limpiar = new javax.swing.JButton();
        bttn_volver = new javax.swing.JButton();
        cbx_buscar = new javax.swing.JComboBox<>();
        lbl_buscar = new javax.swing.JLabel();
        lbl_tipobusqueda = new javax.swing.JLabel();
        txt_parametrobusqueda = new javax.swing.JTextField();
        btn_buscr = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(41, 38, 67));

        jTabbedPane1.setBackground(new java.awt.Color(68, 66, 110));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(41, 38, 67));

        TablaVentas.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        TablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Cliente", "Empleado", "Fecha", "Total"
            }
        ));
        TablaVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaVentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaVentas);

        TablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad", "Precio"
            }
        ));
        jScrollPane2.setViewportView(TablaDetalle);

        lbl_total.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_total.setForeground(new java.awt.Color(255, 255, 255));
        lbl_total.setText("Total vendido:");

        cbx_periodo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        cbx_periodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoy", "Esta semana", "Este mes" }));
        cbx_periodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_periodoActionPerformed(evt);
            }
        });

        txt_totalvendido.setEditable(false);
        txt_totalvendido.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        lbl_Detalle.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_Detalle.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Detalle.setText("Detalle de la venta:");

        btn_limpiar.setBackground(new java.awt.Color(201, 101, 0));
        btn_limpiar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btn_limpiar.setForeground(new java.awt.Color(255, 255, 255));
        btn_limpiar.setText("Limpiar");
        btn_limpiar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        bttn_volver.setBackground(new java.awt.Color(68, 66, 110));
        bttn_volver.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        bttn_volver.setForeground(new java.awt.Color(255, 255, 255));
        bttn_volver.setText("Volver");
        bttn_volver.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bttn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttn_volverActionPerformed(evt);
            }
        });

        cbx_buscar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        cbx_buscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Empleado" }));

        lbl_buscar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_buscar.setForeground(new java.awt.Color(255, 255, 255));
        lbl_buscar.setText("Buscar por:");

        lbl_tipobusqueda.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_tipobusqueda.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tipobusqueda.setText("Parámetro:");
        lbl_tipobusqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txt_parametrobusqueda.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        btn_buscr.setBackground(new java.awt.Color(201, 101, 0));
        btn_buscr.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btn_buscr.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscr.setText("Buscar");
        btn_buscr.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_buscr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bttn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_buscar)
                                    .addComponent(lbl_tipobusqueda))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbx_buscar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbx_periodo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_totalvendido, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txt_parametrobusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_buscr, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbl_Detalle, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_total)
                    .addComponent(cbx_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_totalvendido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_buscar)
                        .addComponent(cbx_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_Detalle)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_tipobusqueda)
                            .addComponent(txt_parametrobusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_buscr, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        jTabbedPane1.addTab("Ventas", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttn_volverActionPerformed
        menuPrincipalAdmin form = new menuPrincipalAdmin();
        form.Control = this.Control;
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bttn_volverActionPerformed

    private void btn_buscrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscrActionPerformed
        String Parametro = txt_parametrobusqueda.getText();
        String TipoBusqueda = cbx_buscar.getSelectedItem().toString();
        
        if(Parametro.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingresa un parámetro por favor");
        }
        else
        {
            if(TipoBusqueda.equals("Cliente") )
            {
                try
                {
                    ventas ventas = new ventas();
                    ventas.setConn(Control.getConn());
                    this.modeloVenta.setRowCount(0);
                    ResultSet st = ventas.getVentasPorCliente(Parametro);
                    if(st != null)
                    {
                        while(st.next()) 
                        {
                            String datos[] = 
                            {
                                st.getObject(1).toString(),
                                st.getObject(2).toString(),
                                st.getObject(3).toString(),
                                st.getObject(4).toString(),
                                st.getObject(5).toString()
                            };
                            this.modeloVenta.addRow(datos);
                        }  
                    }
                }
                catch(Exception ee)
                {
                    JOptionPane.showMessageDialog(null, "Ups! Algo salió mal" + ee);
                }
            }
            if(TipoBusqueda.equals("Empleado"))
            {
                try
                {
                    ventas ventas = new ventas();
                    ventas.setConn(Control.getConn());
                    this.modeloVenta.setRowCount(0);
                    ResultSet st = ventas.getVentasPorEmpleado(Parametro);
                    if(st != null)
                    {
                        while(st.next()) 
                        {
                            String datos[] = 
                            {
                                st.getObject(1).toString(),
                                st.getObject(2).toString(),
                                st.getObject(3).toString(),
                                st.getObject(4).toString(),
                                st.getObject(5).toString()
                            };
                            this.modeloVenta.addRow(datos);
                        }  
                    }
                }
                catch(Exception ee)
                {
                    JOptionPane.showMessageDialog(null, "Ups! Algo salió mal" + ee);
                }
            }  
        }
        txt_parametrobusqueda.setText("");
    }//GEN-LAST:event_btn_buscrActionPerformed

    private void TablaVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaVentasMouseClicked
        int i = this.TablaVentas.getSelectedRow();
        int id = Integer.parseInt(this.TablaVentas.getModel().getValueAt(i,0).toString());
        
        cargarDetalles(id);
    }//GEN-LAST:event_TablaVentasMouseClicked

    private void cbx_periodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_periodoActionPerformed
        String seleccion = this.cbx_periodo.getSelectedItem().toString();
        
        cargarVentas(seleccion);
        modeloDetalle.setRowCount(0);
    }//GEN-LAST:event_cbx_periodoActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        txt_parametrobusqueda.setText("");
        modeloDetalle.setRowCount(0);
        cargarVentas("Hoy");
    }//GEN-LAST:event_btn_limpiarActionPerformed

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
            java.util.logging.Logger.getLogger(AdminVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDetalle;
    private javax.swing.JTable TablaVentas;
    private javax.swing.JButton btn_buscr;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton bttn_volver;
    private javax.swing.JComboBox<String> cbx_buscar;
    private javax.swing.JComboBox<String> cbx_periodo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_Detalle;
    private javax.swing.JLabel lbl_buscar;
    private javax.swing.JLabel lbl_tipobusqueda;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JTextField txt_parametrobusqueda;
    private javax.swing.JTextField txt_totalvendido;
    // End of variables declaration//GEN-END:variables
}
