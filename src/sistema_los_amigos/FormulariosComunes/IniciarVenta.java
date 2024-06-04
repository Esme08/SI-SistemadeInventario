package sistema_los_amigos.FormulariosComunes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema_los_amigos.FacturaElectrónica;
import sistema_los_amigos.Formularios.formAdmin.menuPrincipalAdmin;
import sistema_los_amigos.Formularios.formEmpleados.menuPrincipalEmpleado;
import sistema_los_amigos.Sistema_Los_Amigos;
import sistema_los_amigos.clientes;
import sistema_los_amigos.detalles_ventas;
import sistema_los_amigos.empleados;
import sistema_los_amigos.productos;
import sistema_los_amigos.ventas;

/*
 * @author esme
 */

public class IniciarVenta extends javax.swing.JFrame {
    private Sistema_Los_Amigos Control = new Sistema_Los_Amigos();
    DefaultTableModel modeloClientes;
    DefaultTableModel modeloproducto;
    ArrayList<clientes> Listaclientes = new ArrayList<>();
    ArrayList<empleados> ListaEmpleados = new ArrayList<>();
    ArrayList<productos> ListaProductos = new ArrayList<>();
    ArrayList<detalles_ventas> detalle = new ArrayList<>();
    double total =0;
    
    
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
                    clientes Registro = new clientes();
                    Registro.setIdCliente(Integer.parseInt(st.getObject(1).toString()));
                    Registro.setNombre(st.getObject(2).toString());
                    Registro.setCorreo(st.getObject(3).toString());
                    Listaclientes.add(Registro);
                    
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
                    empleados Registro = new empleados();
                    Registro.setIdEmpleado(Integer.parseInt(st.getObject(1).toString()));
                    Registro.setNombre(st.getObject(2).toString());
                    ListaEmpleados.add(Registro);
                    
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
                    productos Registro = new productos();
                    Registro.setIdProducto(Integer.parseInt(st.getObject(1).toString()));
                    Registro.setNombre(st.getObject(2).toString());
                    Registro.setPrecio(Double.parseDouble(st.getObject(4).toString()));
                    Registro.setCantidad(Integer.parseInt(st.getObject(5).toString()));
                    ListaProductos.add(Registro);
                    
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
        modeloproducto = (DefaultTableModel) this.TablaDetalle.getModel();
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
        btn_finalizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaDetalle = new javax.swing.JTable();
        txt_cantidad = new javax.swing.JSpinner();
        lbl_cantidad = new javax.swing.JLabel();
        lbl_nombre2 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();

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
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        btn_finalizar.setBackground(new java.awt.Color(201, 101, 0));
        btn_finalizar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btn_finalizar.setForeground(new java.awt.Color(255, 255, 255));
        btn_finalizar.setText("Finalizar");
        btn_finalizar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_finalizarActionPerformed(evt);
            }
        });

        TablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad", "Precio"
            }
        ));
        jScrollPane2.setViewportView(TablaDetalle);

        txt_cantidad.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        txt_cantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        lbl_cantidad.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_cantidad.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cantidad.setText("Cantidad:");

        lbl_nombre2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_nombre2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nombre2.setText("Agregue productos:");

        lbl_total.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_total.setForeground(new java.awt.Color(255, 255, 255));
        lbl_total.setText("Total:");

        txt_total.setEditable(false);
        txt_total.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

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
                            .addComponent(btn_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_total)
                        .addGap(18, 18, 18)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                            .addComponent(btn_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_cantidad))
                        .addGap(17, 17, 17)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_total)
                            .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void btn_finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finalizarActionPerformed
        int idCliente = 0;
        int idEmpleado = 0;
        String CorreoReceptor = "";
        String Contenido = "Estimado Cliente este es su comprobante de pago \n"
                + "\n"
                +"Factura: \n"
                +"Producto:           Cantidad:           Precio: \n";

        for (int i = 0; i < Listaclientes.size(); i++)
        {
            if(txt_nombre.getText().equals(Listaclientes.get(i).getNombre()))
            {
                idCliente = Listaclientes.get(i).getIdCliente();
                CorreoReceptor = Listaclientes.get(i).getCorreo();
            }
        }

        for (int i = 0; i < ListaEmpleados.size(); i++)
        {
            if(cbx_empleado.getSelectedItem().toString().equals(ListaEmpleados.get(i).getNombre()))
            {
                idEmpleado = ListaEmpleados.get(i).getIdEmpleado();
            }
        }

        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String fechaFormateada = fechaActual.format(formateador);
        String fechaComoCadena = fechaFormateada;

        ventas RealizarVenta = new ventas(idCliente, idEmpleado, fechaComoCadena, total, this.Control.getConn());

        int IdVenta = RealizarVenta.guardarVentas();

        for (int i = 0; i < detalle.size(); i++)
        {
            detalles_ventas DetalleAGuardar = new detalles_ventas(IdVenta, detalle.get(i).getId_producto(), detalle.get(i).getCantidad_vendida(), Control.getConn());
            DetalleAGuardar.guardarDetalleVentas();
            
            productos ProductoActualizado = new productos();
            ProductoActualizado.setConn(this.Control.getConn());
            
            for (int j = 0; j < ListaProductos.size(); j++)
            {
                if(detalle.get(i).getId_producto() == ListaProductos.get(j).getIdProducto())
                {
                    ProductoActualizado.ActualizarStock(detalle.get(i).getId_producto(), ListaProductos.get(j).getCantidad()-detalle.get(i).getCantidad_vendida());
                    Contenido += ListaProductos.get(j).getNombre() + "     " + detalle.get(i).getCantidad_vendida() + "     " + ListaProductos.get(j).getPrecio() + "\n";
                }
                            
            }
        }
        
        Contenido += "Total: " + total;
        
        FacturaElectrónica facturar = new FacturaElectrónica();
        facturar.CrearYEnviarFactura(CorreoReceptor, Contenido);
        
        if(Control.getRol() == 3)
        {
            menuPrincipalAdmin form = new menuPrincipalAdmin();
            form.setControl(Control);
            form.setVisible(true);
            this.dispose();
        }
        if(Control.getRol() == 4)
        {
            menuPrincipalEmpleado form = new menuPrincipalEmpleado();
            form.setControl(Control);
            form.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btn_finalizarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        String NombreProducto = cbx_producto.getSelectedItem().toString();
        int CantidadComprada = Integer.parseInt(txt_cantidad.getValue().toString());

        int IdProducto;

        for (int i = 0; i < ListaProductos.size(); i++)
        {
            if(NombreProducto.equals(ListaProductos.get(i).getNombre()))
            {
                if(ListaProductos.get(i).getCantidad() >= CantidadComprada)
                {
                    IdProducto = ListaProductos.get(i).getIdProducto();
                    total += ListaProductos.get(i).getPrecio()*CantidadComprada;

                    String Datos[] =
                    {
                        NombreProducto, 
                        String.valueOf(CantidadComprada), 
                        String.valueOf( ListaProductos.get(i).getPrecio())

                    };
                    modeloproducto.addRow(Datos);
                    detalles_ventas Registro = new detalles_ventas();
                    Registro.setId_producto(IdProducto);
                    Registro.setCantidad_vendida(CantidadComprada);

                    detalle.add(Registro);
                    txt_total.setText(String.valueOf(total));
                    txt_nombre.setEnabled(false);
                    cbx_empleado.setEnabled(false);
                    TablaClientes.setEnabled(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "El producto no tiene suficientes existencias");
                }
            }
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        cargarClientes(txt_nombre.getText());
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void TablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaClientesMouseClicked
        int i = this.TablaClientes.getSelectedRow();

        String nombre= this.TablaClientes.getModel().getValueAt(i,1).toString();

        txt_nombre.setText(nombre);
    }//GEN-LAST:event_TablaClientesMouseClicked

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
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_finalizar;
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
    private javax.swing.JLabel lbl_total;
    private javax.swing.JSpinner txt_cantidad;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables

    public Sistema_Los_Amigos getControl() {
        return Control;
    }

    public void setControl(Sistema_Los_Amigos Control) {
        this.Control = Control;
    }
}
