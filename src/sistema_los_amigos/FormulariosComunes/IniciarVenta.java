/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistema_los_amigos.FormulariosComunes;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema_los_amigos.Sistema_Los_Amigos;
import sistema_los_amigos.clientes;
import sistema_los_amigos.empleados;
import sistema_los_amigos.productos;

/*
 * @author esme
 */

public class IniciarVenta extends javax.swing.JFrame {
    private Sistema_Los_Amigos Control = new Sistema_Los_Amigos();
    DefaultTableModel modeloClientes;
    clientes cliente = new clientes();
    
    
    //métodos para cargar registros de Clientes
    public void cargarClientes ()
    {
        clientes clientes = new clientes();
        clientes.setConn(Control.getConn());
        this.modeloClientes.setRowCount(0);
        try 
        {
            ResultSet st = clientes.getClientes();
            if(st != null)
            {
                while(st.next()) 
                {
                    String datos[] = 
                    {
                        st.getObject(1).toString(),
                        st.getObject(2).toString(),
                        st.getObject(3).toString()
                    };
                    this.modeloClientes.addRow(datos);
                }
            }
        }
        catch (SQLException ex) 
        { 
            JOptionPane.showMessageDialog(null, "Ups! Algo salió mal" + ex);
        }
    }
    
    public void cargarClientes (String cliente)
    {
        clientes clientes = new clientes();
        clientes.setConn(Control.getConn());
        clientes.setNombre(cliente);
        this.modeloClientes.setRowCount(0);
        try 
        {
            ResultSet st = clientes.getClientes(cliente);
            if(st != null)
            {
                while(st.next()) 
                {
                    String datos[] = 
                    {
                        st.getObject(1).toString(),
                        st.getObject(2).toString(),
                        st.getObject(3).toString()
                    };
                    this.modeloClientes.addRow(datos);
                }
            }
        }
        catch (SQLException ex) 
        { 
            JOptionPane.showMessageDialog(null, "Ups! Algo salió mal" + ex);
        }
    }
    
    public void cargarEmpleados ()
    {
        empleados empleados = new empleados();
        empleados.setConn(Control.getConn());
        cbx_empleado.removeAllItems();
        try 
        {
            ResultSet st = empleados.getEmpleados();
            if(st != null)
            {
                while(st.next()) 
                {
                    cbx_empleado.addItem(st.getObject(2).toString());
                }
            }
        }
        catch (SQLException ex) 
        { 
            JOptionPane.showMessageDialog(null, "Ups! Algo salió mal" + ex);
        }
    }
    
    public void cargarProductos ()
    {
        productos productos = new productos();
        productos.setConn(Control.getConn());
        cbx_empleado.removeAllItems();
        try 
        {
            ResultSet st = productos.getProductos();
            if(st != null)
            {
                while(st.next()) 
                {
                    cbx_producto.addItem(st.getObject(2).toString());
                }
            }
        }
        catch (SQLException ex) 
        { 
            JOptionPane.showMessageDialog(null, "Ups! Algo salió mal" + ex);
        }
    }
    
    
    /*
     * Creates new form IniciarVenta
     */
    public IniciarVenta() {
        initComponents();
        modeloClientes = (DefaultTableModel) this.TablaClientes.getModel();
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
        txt_nombre = new javax.swing.JTextField();
        lbl_nombre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaClientes = new javax.swing.JTable();
        lbl_nombre1 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        lbl_empleado = new javax.swing.JLabel();
        cbx_empleado = new javax.swing.JComboBox<>();
        lbl_producto = new javax.swing.JLabel();
        cbx_producto = new javax.swing.JComboBox<>();
        btn_agregar = new javax.swing.JButton();
        btn_agregar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaDetalle = new javax.swing.JTable();
        txt_cantidad = new javax.swing.JSpinner();
        lbl_cantidad = new javax.swing.JLabel();
        lbl_nombre2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(41, 38, 67));

        jTabbedPane1.setBackground(new java.awt.Color(68, 66, 110));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(41, 38, 67));

        txt_nombre.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        lbl_nombre.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_nombre.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nombre.setText("Nombre:");

        TablaClientes.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        TablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaClientes);

        lbl_nombre1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_nombre1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nombre1.setText("Seleccione al empleado y cliente:");

        btn_buscar.setBackground(new java.awt.Color(201, 101, 0));
        btn_buscar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscar.setText("Buscar");
        btn_buscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        lbl_empleado.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_empleado.setForeground(new java.awt.Color(255, 255, 255));
        lbl_empleado.setText("Empleado:");

        cbx_empleado.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        cbx_empleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        lbl_producto.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_producto.setForeground(new java.awt.Color(255, 255, 255));
        lbl_producto.setText("Producto:");

        cbx_producto.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        btn_agregar.setBackground(new java.awt.Color(201, 101, 0));
        btn_agregar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btn_agregar.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregar.setText("Agregar");
        btn_agregar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btn_agregar1.setBackground(new java.awt.Color(201, 101, 0));
        btn_agregar1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btn_agregar1.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregar1.setText("Finalizar");
        btn_agregar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        TablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Producto", "Cantidad"
            }
        ));
        jScrollPane2.setViewportView(TablaDetalle);

        txt_cantidad.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        lbl_cantidad.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_cantidad.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cantidad.setText("Cantidad:");

        lbl_nombre2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_nombre2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nombre2.setText("Agregue productos:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_empleado)
                            .addComponent(lbl_nombre))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbx_empleado, 0, 134, Short.MAX_VALUE)
                            .addComponent(txt_nombre))
                        .addGap(22, 22, 22)
                        .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_nombre1))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_nombre2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbl_producto)
                                .addGap(18, 18, 18)
                                .addComponent(cbx_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbl_cantidad)
                                .addGap(23, 23, 23)
                                .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_agregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbl_nombre1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbx_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_empleado))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nombre)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_nombre2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_producto)
                            .addComponent(cbx_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_agregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_cantidad))
                        .addGap(17, 17, 17)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("Realizar venta", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaClientesMouseClicked
        int i = this.TablaClientes.getSelectedRow();
        String ID = this.TablaClientes.getModel().getValueAt(i,0).toString();
        int idCliente= Integer.parseInt(ID);
        String nombre= this.TablaClientes.getModel().getValueAt(i,1).toString();
        String correo= this.TablaClientes.getModel().getValueAt(i,2).toString();
        
        cliente.setIdCliente(idCliente);
        cliente.setNombre(nombre);
        cliente.setCorreo(correo);
        
        txt_nombre.setText(nombre);
        txt_cantidad.setEnabled(false);
        TablaClientes.setEnabled(false);
    }//GEN-LAST:event_TablaClientesMouseClicked

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        cargarClientes(txt_nombre.getText());
    }//GEN-LAST:event_btn_buscarActionPerformed

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
            java.util.logging.Logger.getLogger(IniciarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IniciarVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaClientes;
    private javax.swing.JTable TablaDetalle;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_agregar1;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JComboBox<String> cbx_empleado;
    private javax.swing.JComboBox<String> cbx_producto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_cantidad;
    private javax.swing.JLabel lbl_empleado;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_nombre1;
    private javax.swing.JLabel lbl_nombre2;
    private javax.swing.JLabel lbl_producto;
    private javax.swing.JSpinner txt_cantidad;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

    public Sistema_Los_Amigos getControl() {
        return Control;
    }

    public void setControl(Sistema_Los_Amigos Control) {
        this.Control = Control;
    }
}