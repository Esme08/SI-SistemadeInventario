package sistema_los_amigos.Formularios.formAdmin;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema_los_amigos.Sistema_Los_Amigos;
import sistema_los_amigos.marca;
import sistema_los_amigos.productos;
import sistema_los_amigos.tipo_producto;

/*
 * @author esmer
 */

public class AdminInventario extends javax.swing.JFrame {
    
    Sistema_Los_Amigos Control = new Sistema_Los_Amigos();
    DefaultTableModel modeloCategorias;
    DefaultTableModel modeloMarcas;
    DefaultTableModel modeloProductos;
    boolean nuevoTipo;
    boolean nuevoMarca;
    boolean nuevoProducto;
    
    // Métodos para panel Categorias
    
    public void cargarCategorias ()
    {
        tipo_producto tipo = new tipo_producto();
        tipo.setConn(Control.getConn());
        this.modeloCategorias.setRowCount(0);
        cbx_tipoProductos.removeAllItems();
        try 
        {
            ResultSet st = tipo.getTipoProducto();
            if(st != null)
            {
                while(st.next()) 
                {
                    cbx_tipoProductos.addItem(st.getObject(2).toString());
                    String datos[] = 
                    {
                        st.getObject(1).toString(),
                        st.getObject(2).toString(),
                        st.getObject(3).toString()
                    };
                    this.modeloCategorias.addRow(datos);
                }
            }
        }
        catch (SQLException ex) 
        { 
            JOptionPane.showMessageDialog(null, "Ups! Algo salió mal" + ex);
        }
    }
    
    public void limpiarCategoria ()
    {
        txt_idCategoria.setText("");
        txt_nombreCategoria.setText("");
        txt_descripcionCategoria.setText("");
    }
    
    public void cargarRegistroCategoria ()
    {
        int i = this.tablaCategorias.getSelectedRow();
        String idCategorias= this.tablaCategorias.getModel().getValueAt(i,0).toString();
        String nombre= this.tablaCategorias.getModel().getValueAt(i,1).toString();
        String descripciin= this.tablaCategorias.getModel().getValueAt(i,2).toString();
        
        this.txt_idCategoria.setText(idCategorias);
        this.txt_nombreCategoria.setText(nombre);
        this.txt_descripcionCategoria.setText(descripciin);
    }
    
    // Panel Marca
    
    public void cargarMarca ()
    {
        marca marca = new marca();
        marca.setConn(Control.getConn());
        
        this.modeloMarcas.setRowCount(0);
        cbx_marcaProductos.removeAllItems();
        try 
        {
            ResultSet st = marca.getMarca();
            if(st != null)
            {
                while(st.next()) 
                {
                    cbx_marcaProductos.addItem(st.getObject(2).toString());
                    String datos[] = 
                    {
                        st.getObject(1).toString(),
                        st.getObject(2).toString(),
                    };
                    this.modeloMarcas.addRow(datos);
                }
            }
        }
        catch (SQLException ex) 
        { 
            JOptionPane.showMessageDialog(null, "Ups! Algo salió mal" + ex);
        }
    }

    public void limpiarMarca ()
    {
        txt_idMarcas.setText("");
        txt_nombreMarcas.setText("");
    }
    
    public void cargarRegistroMarca ()
    {
        int i = this.tablaMarcas.getSelectedRow();
        String idMarcas= this.tablaMarcas.getModel().getValueAt(i,0).toString();
        String nombre= this.tablaMarcas.getModel().getValueAt(i,1).toString();
        
        this.txt_idMarcas.setText(idMarcas);
        this.txt_nombreMarcas.setText(nombre);
    }

    // Métodos para Panel Productos
    
    public void cargarProductos ()
    {
        productos productos = new productos();
        productos.setConn(Control.getConn());
        
        this.modeloProductos.setRowCount(0);
        try 
        {
            ResultSet st = productos.getProductos();
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
                        st.getObject(5).toString(),
                        st.getObject(6).toString(),
                        st.getObject(7).toString()
                    };
                    this.modeloProductos.addRow(datos);
                }
            }
        }
        catch (SQLException ex) 
        { 
            JOptionPane.showMessageDialog(null, "Ups! Algo salió mal" + ex);
        }
    }

    public void limpiarProducto ()
    {
        txt_idProductos.setText("");
        txt_nombreProductos.setText("");
        txt_descripcionProductos.setText("");
        txt_precio.setText("");
        txt_cantidadProductos.setText("");
        cbx_marcaProductos.setSelectedIndex(0);
        cbx_tipoProductos.setSelectedIndex(0);
    }
    
    public void cargarRegistroProducto()
    {
        int i = this.tablaProductos.getSelectedRow();
        String idProducto= this.tablaProductos.getModel().getValueAt(i,0).toString();
        String nombre= this.tablaProductos.getModel().getValueAt(i,1).toString();
        String descripcion= this.tablaProductos.getModel().getValueAt(i,2).toString();
        String precio= this.tablaProductos.getModel().getValueAt(i,3).toString();
        String cantidad= this.tablaProductos.getModel().getValueAt(i,4).toString();
        String marca= this.tablaProductos.getModel().getValueAt(i, 5).toString();
        String tipo= this.tablaProductos.getModel().getValueAt(i, 6).toString();
        
        this.txt_idProductos.setText(idProducto);
        this.txt_nombreProductos.setText(nombre);
        this.txt_descripcionProductos.setText(descripcion);
        this.txt_precio.setText(precio);
        this.txt_cantidadProductos.setText(cantidad);
        //falta el manejo de combobox
        
        cbx_marcaProductos.setSelectedItem(marca);
        cbx_tipoProductos.setSelectedItem(tipo);
    }
    
    
    /*
     * Creates new form AdminInventario
     */
    public AdminInventario() {
        initComponents();
        modeloCategorias = (DefaultTableModel) this.tablaCategorias.getModel();
        modeloMarcas = (DefaultTableModel)this.tablaMarcas.getModel();
        modeloProductos = (DefaultTableModel)this.tablaProductos.getModel();
        this.nuevoTipo = true;
        this.nuevoMarca = true;
        this.nuevoProducto = true;
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
        PanelesInventario = new javax.swing.JTabbedPane();
        panelCategoria = new javax.swing.JPanel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(35, 100), new java.awt.Dimension(35, 100), new java.awt.Dimension(35, 100));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(35, 100), new java.awt.Dimension(35, 100), new java.awt.Dimension(35, 100));
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCategorias = new javax.swing.JTable();
        lbl_idCategoria = new javax.swing.JLabel();
        txt_idCategoria = new javax.swing.JTextField();
        lbl_nombreCategoria = new javax.swing.JLabel();
        txt_nombreCategoria = new javax.swing.JTextField();
        lbl_descripcionCategoria = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txt_descripcionCategoria = new javax.swing.JTextArea();
        btn_EliminarCategorias = new javax.swing.JButton();
        btn_guardarCategorias = new javax.swing.JButton();
        bttn_volver = new javax.swing.JButton();
        panelMarcas = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaMarcas = new javax.swing.JTable();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(35, 100), new java.awt.Dimension(35, 100), new java.awt.Dimension(35, 100));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(35, 100), new java.awt.Dimension(35, 100), new java.awt.Dimension(35, 100));
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(35, 100), new java.awt.Dimension(35, 100), new java.awt.Dimension(35, 100));
        lbl_id2 = new javax.swing.JLabel();
        txt_id2 = new javax.swing.JTextField();
        lbl_nombre2 = new javax.swing.JLabel();
        txt_nombre2 = new javax.swing.JTextField();
        btn_guardar2 = new javax.swing.JButton();
        lbl_idMarcas = new javax.swing.JLabel();
        txt_idMarcas = new javax.swing.JTextField();
        lbl_nombreMarcas = new javax.swing.JLabel();
        txt_nombreMarcas = new javax.swing.JTextField();
        btn_guardarMarcas = new javax.swing.JButton();
        btn_EliminarMarcas = new javax.swing.JButton();
        bttn_volver1 = new javax.swing.JButton();
        panelProductos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(35, 100), new java.awt.Dimension(35, 100), new java.awt.Dimension(35, 100));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(35, 100), new java.awt.Dimension(35, 100), new java.awt.Dimension(35, 100));
        lbl_idProductos = new javax.swing.JLabel();
        txt_idProductos = new javax.swing.JTextField();
        lbl_nombreProductos = new javax.swing.JLabel();
        txt_nombreProductos = new javax.swing.JTextField();
        lbl_precioProductos = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        lbl_descripcionProductos = new javax.swing.JLabel();
        lbl_cantidadProductos = new javax.swing.JLabel();
        txt_cantidadProductos = new javax.swing.JTextField();
        lbl_marcaProductos = new javax.swing.JLabel();
        cbx_marcaProductos = new javax.swing.JComboBox<>();
        lbl_tipoProductos = new javax.swing.JLabel();
        cbx_tipoProductos = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_descripcionProductos = new javax.swing.JTextArea();
        btn_guardarProductos = new javax.swing.JButton();
        btn_EliminarProductos = new javax.swing.JButton();
        bttn_volver2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(41, 38, 67));

        PanelesInventario.setBackground(new java.awt.Color(68, 66, 110));
        PanelesInventario.setForeground(new java.awt.Color(255, 255, 255));
        PanelesInventario.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        panelCategoria.setBackground(new java.awt.Color(41, 38, 67));

        tablaCategorias.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tablaCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Descripción"
            }
        ));
        tablaCategorias.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCategoriasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaCategorias);

        lbl_idCategoria.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_idCategoria.setForeground(new java.awt.Color(255, 255, 255));
        lbl_idCategoria.setText("ID:");

        txt_idCategoria.setEditable(false);
        txt_idCategoria.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        lbl_nombreCategoria.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_nombreCategoria.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nombreCategoria.setText("Nombre:");

        txt_nombreCategoria.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        lbl_descripcionCategoria.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_descripcionCategoria.setForeground(new java.awt.Color(255, 255, 255));
        lbl_descripcionCategoria.setText("Descripción:");

        txt_descripcionCategoria.setColumns(20);
        txt_descripcionCategoria.setRows(5);
        jScrollPane5.setViewportView(txt_descripcionCategoria);

        btn_EliminarCategorias.setBackground(new java.awt.Color(201, 101, 0));
        btn_EliminarCategorias.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btn_EliminarCategorias.setForeground(new java.awt.Color(255, 255, 255));
        btn_EliminarCategorias.setText("Eliminar");
        btn_EliminarCategorias.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_EliminarCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarCategoriasActionPerformed(evt);
            }
        });

        btn_guardarCategorias.setBackground(new java.awt.Color(201, 101, 0));
        btn_guardarCategorias.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btn_guardarCategorias.setForeground(new java.awt.Color(255, 255, 255));
        btn_guardarCategorias.setText("Guardar");
        btn_guardarCategorias.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_guardarCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarCategoriasActionPerformed(evt);
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

        javax.swing.GroupLayout panelCategoriaLayout = new javax.swing.GroupLayout(panelCategoria);
        panelCategoria.setLayout(panelCategoriaLayout);
        panelCategoriaLayout.setHorizontalGroup(
            panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(filler4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCategoriaLayout.createSequentialGroup()
                        .addGroup(panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCategoriaLayout.createSequentialGroup()
                                .addComponent(lbl_descripcionCategoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelCategoriaLayout.createSequentialGroup()
                                    .addGroup(panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelCategoriaLayout.createSequentialGroup()
                                            .addComponent(lbl_nombreCategoria)
                                            .addGap(37, 37, 37)
                                            .addGroup(panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txt_idCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_nombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(lbl_idCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(84, 84, 84)
                                    .addGroup(panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn_guardarCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_EliminarCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(256, 256, 256)
                                    .addComponent(bttn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelCategoriaLayout.setVerticalGroup(
            panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filler3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelCategoriaLayout.createSequentialGroup()
                .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_idCategoria)
                    .addComponent(txt_idCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_guardarCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nombreCategoria)
                    .addComponent(txt_nombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_EliminarCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_descripcionCategoria)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        PanelesInventario.addTab("Categorias", panelCategoria);

        panelMarcas.setBackground(new java.awt.Color(41, 38, 67));

        tablaMarcas.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tablaMarcas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nombre"
            }
        ));
        tablaMarcas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMarcasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaMarcas);

        lbl_id2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_id2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_id2.setText("ID:");

        txt_id2.setEditable(false);
        txt_id2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        lbl_nombre2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_nombre2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nombre2.setText("Nombre:");

        txt_nombre2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        btn_guardar2.setBackground(new java.awt.Color(201, 101, 0));
        btn_guardar2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btn_guardar2.setForeground(new java.awt.Color(255, 255, 255));
        btn_guardar2.setText("Guardar");
        btn_guardar2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_idMarcas.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_idMarcas.setForeground(new java.awt.Color(255, 255, 255));
        lbl_idMarcas.setText("ID:");

        txt_idMarcas.setEditable(false);
        txt_idMarcas.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        lbl_nombreMarcas.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_nombreMarcas.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nombreMarcas.setText("Nombre:");

        txt_nombreMarcas.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        btn_guardarMarcas.setBackground(new java.awt.Color(201, 101, 0));
        btn_guardarMarcas.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btn_guardarMarcas.setForeground(new java.awt.Color(255, 255, 255));
        btn_guardarMarcas.setText("Guardar");
        btn_guardarMarcas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_guardarMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarMarcasActionPerformed(evt);
            }
        });

        btn_EliminarMarcas.setBackground(new java.awt.Color(201, 101, 0));
        btn_EliminarMarcas.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btn_EliminarMarcas.setForeground(new java.awt.Color(255, 255, 255));
        btn_EliminarMarcas.setText("Eliminar");
        btn_EliminarMarcas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_EliminarMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarMarcasActionPerformed(evt);
            }
        });

        bttn_volver1.setBackground(new java.awt.Color(68, 66, 110));
        bttn_volver1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        bttn_volver1.setForeground(new java.awt.Color(255, 255, 255));
        bttn_volver1.setText("Volver");
        bttn_volver1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bttn_volver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttn_volver1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMarcasLayout = new javax.swing.GroupLayout(panelMarcas);
        panelMarcas.setLayout(panelMarcasLayout);
        panelMarcasLayout.setHorizontalGroup(
            panelMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMarcasLayout.createSequentialGroup()
                .addComponent(filler7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMarcasLayout.createSequentialGroup()
                        .addGroup(panelMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, 1074, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelMarcasLayout.createSequentialGroup()
                                .addComponent(lbl_nombreMarcas)
                                .addGap(37, 37, 37)
                                .addGroup(panelMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_idMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_nombreMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(58, 58, 58)
                                .addGroup(panelMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_EliminarMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_guardarMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbl_idMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(panelMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMarcasLayout.createSequentialGroup()
                                .addComponent(lbl_nombre2)
                                .addGap(37, 37, 37)
                                .addGroup(panelMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbl_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(339, 339, 339)
                        .addComponent(btn_guardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMarcasLayout.createSequentialGroup()
                        .addGap(684, 684, 684)
                        .addComponent(bttn_volver1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMarcasLayout.setVerticalGroup(
            panelMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filler7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelMarcasLayout.createSequentialGroup()
                .addGroup(panelMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMarcasLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(panelMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_id2)
                            .addComponent(txt_id2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(panelMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nombre2)
                            .addComponent(txt_nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_guardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(filler5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(274, 274, 274))
            .addGroup(panelMarcasLayout.createSequentialGroup()
                .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_idMarcas)
                    .addComponent(txt_idMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttn_volver1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_guardarMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(panelMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nombreMarcas)
                    .addComponent(txt_nombreMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_EliminarMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 41, Short.MAX_VALUE))
        );

        PanelesInventario.addTab("Marcas", panelMarcas);

        panelProductos.setBackground(new java.awt.Color(41, 38, 67));

        tablaProductos.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Descripción", "Precio", "Cantidad", "Marca", "Tipo"
            }
        ));
        tablaProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tablaProductos.setAutoscrolls(false);
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        lbl_idProductos.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_idProductos.setForeground(new java.awt.Color(255, 255, 255));
        lbl_idProductos.setText("ID:");

        txt_idProductos.setEditable(false);
        txt_idProductos.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        lbl_nombreProductos.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_nombreProductos.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nombreProductos.setText("Nombre:");

        txt_nombreProductos.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        lbl_precioProductos.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_precioProductos.setForeground(new java.awt.Color(255, 255, 255));
        lbl_precioProductos.setText("Precio:");

        txt_precio.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        lbl_descripcionProductos.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_descripcionProductos.setForeground(new java.awt.Color(255, 255, 255));
        lbl_descripcionProductos.setText("Descripción:");

        lbl_cantidadProductos.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_cantidadProductos.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cantidadProductos.setText("Cantidad:");

        txt_cantidadProductos.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        lbl_marcaProductos.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_marcaProductos.setForeground(new java.awt.Color(255, 255, 255));
        lbl_marcaProductos.setText("Marca:");

        cbx_marcaProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        lbl_tipoProductos.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_tipoProductos.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tipoProductos.setText("Categoria:");

        cbx_tipoProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        txt_descripcionProductos.setColumns(20);
        txt_descripcionProductos.setRows(5);
        jScrollPane4.setViewportView(txt_descripcionProductos);

        btn_guardarProductos.setBackground(new java.awt.Color(201, 101, 0));
        btn_guardarProductos.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btn_guardarProductos.setForeground(new java.awt.Color(255, 255, 255));
        btn_guardarProductos.setText("Guardar");
        btn_guardarProductos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_guardarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarProductosActionPerformed(evt);
            }
        });

        btn_EliminarProductos.setBackground(new java.awt.Color(201, 101, 0));
        btn_EliminarProductos.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btn_EliminarProductos.setForeground(new java.awt.Color(255, 255, 255));
        btn_EliminarProductos.setText("Eliminar");
        btn_EliminarProductos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_EliminarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarProductosActionPerformed(evt);
            }
        });

        bttn_volver2.setBackground(new java.awt.Color(68, 66, 110));
        bttn_volver2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        bttn_volver2.setForeground(new java.awt.Color(255, 255, 255));
        bttn_volver2.setText("Volver");
        bttn_volver2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bttn_volver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttn_volver2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelProductosLayout = new javax.swing.GroupLayout(panelProductos);
        panelProductos.setLayout(panelProductosLayout);
        panelProductosLayout.setHorizontalGroup(
            panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelProductosLayout.createSequentialGroup()
                            .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelProductosLayout.createSequentialGroup()
                                    .addComponent(lbl_nombreProductos)
                                    .addGap(37, 37, 37)
                                    .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_nombreProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_idProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(84, 84, 84)
                                    .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_precioProductos)
                                        .addComponent(lbl_cantidadProductos))
                                    .addGap(20, 20, 20)
                                    .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_cantidadProductos)
                                        .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(panelProductosLayout.createSequentialGroup()
                                    .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_descripcionProductos)
                                        .addComponent(lbl_idProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelProductosLayout.createSequentialGroup()
                                    .addGap(84, 84, 84)
                                    .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_tipoProductos)
                                        .addComponent(lbl_marcaProductos))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbx_marcaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbx_tipoProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(panelProductosLayout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btn_EliminarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_guardarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelProductosLayout.createSequentialGroup()
                            .addGap(711, 711, 711)
                            .addComponent(bttn_volver2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelProductosLayout.setVerticalGroup(
            panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductosLayout.createSequentialGroup()
                .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelProductosLayout.createSequentialGroup()
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelProductosLayout.createSequentialGroup()
                                .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_marcaProductos)
                                    .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbl_idProductos)
                                        .addComponent(txt_idProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_precioProductos)
                                        .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(19, 19, 19)
                                .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_nombreProductos)
                                    .addComponent(txt_nombreProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_cantidadProductos)
                                    .addComponent(txt_cantidadProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_tipoProductos)))
                            .addGroup(panelProductosLayout.createSequentialGroup()
                                .addComponent(cbx_marcaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(cbx_tipoProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelProductosLayout.createSequentialGroup()
                                .addComponent(btn_guardarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_EliminarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bttn_volver2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbl_descripcionProductos)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        PanelesInventario.addTab("Productos", panelProductos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(PanelesInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelesInventario)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttn_volverActionPerformed
        menuPrincipalAdmin form = new menuPrincipalAdmin();
        form.Control = this.Control;
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bttn_volverActionPerformed

    private void bttn_volver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttn_volver1ActionPerformed
        menuPrincipalAdmin form = new menuPrincipalAdmin();
        form.Control = this.Control;
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bttn_volver1ActionPerformed

    private void bttn_volver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttn_volver2ActionPerformed
        menuPrincipalAdmin form = new menuPrincipalAdmin();
        form.Control = this.Control;
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bttn_volver2ActionPerformed

    private void tablaCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCategoriasMouseClicked
        cargarRegistroCategoria();
        this.nuevoTipo = false;
    }//GEN-LAST:event_tablaCategoriasMouseClicked

    private void btn_guardarCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarCategoriasActionPerformed
        String nombrecat = txt_nombreCategoria.getText();
        String drescripcioncat = txt_descripcionCategoria.getText();
        if(nombrecat.isEmpty())
        {   
            JOptionPane.showMessageDialog(null, "Asegurate de haber ingresado el nombre");       
        }
        else
        {
            if (this.nuevoTipo)
            {
                tipo_producto tipo = new tipo_producto( nombrecat, drescripcioncat, this.Control.getConn());
                tipo.guardarTipoProducto();
                limpiarCategoria();
                cargarCategorias();
                this.nuevoTipo = true;
            }
            else 
            {
                tipo_producto tipo = new tipo_producto(Integer.parseInt(txt_idCategoria.getText()), nombrecat, drescripcioncat, this.Control.getConn());
                tipo.modificarTipoProducto();
                limpiarCategoria();
                cargarCategorias();
                this.nuevoTipo = true;
            }
        }
    }//GEN-LAST:event_btn_guardarCategoriasActionPerformed

    private void btn_EliminarCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarCategoriasActionPerformed
        int resultado= JOptionPane.showConfirmDialog(this, "Desea borrar el registro?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if(resultado==JOptionPane.YES_OPTION) {
            tipo_producto tipo= new tipo_producto();
            tipo.setConn(this.Control.getConn());
            tipo.setIdtipo_producto(Integer.parseInt(this.txt_idCategoria.getText()));
            tipo.borrarTipoProducto();
            this.limpiarCategoria();
            this.cargarCategorias();
            
        }
    }//GEN-LAST:event_btn_EliminarCategoriasActionPerformed

    private void btn_guardarMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarMarcasActionPerformed
        String nombreMarca = txt_nombreMarcas.getText();
        if(nombreMarca.isEmpty())
        {   
            JOptionPane.showMessageDialog(null, "Asegurate de haber ingresado el nombre");       
        }
        else
        {
            if (this.nuevoMarca)
            {
                marca marca = new marca( nombreMarca, this.Control.getConn());
                marca.guardarMarca();
                limpiarMarca();
                cargarMarca();
                this.nuevoMarca = true;
            }
            else 
            {
                marca marca = new marca(Integer.parseInt(txt_idMarcas.getText()), nombreMarca, this.Control.getConn());
                marca.modificarMarca();
                limpiarMarca();
                cargarMarca();
                this.nuevoMarca = true;
            }
        }
    }//GEN-LAST:event_btn_guardarMarcasActionPerformed

    private void btn_EliminarMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarMarcasActionPerformed
        int resultado= JOptionPane.showConfirmDialog(this, "Desea borrar el registro?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if(resultado==JOptionPane.YES_OPTION) {
            marca marca= new marca();
            marca.setConn(this.Control.getConn());
            marca.setId_marca(Integer.parseInt(this.txt_idMarcas.getText()));
            marca.borrarMarca();
            this.limpiarMarca();
            this.cargarMarca();
        }
    }//GEN-LAST:event_btn_EliminarMarcasActionPerformed

    private void tablaMarcasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMarcasMouseClicked
        cargarRegistroMarca();
        this.nuevoMarca = false;
    }//GEN-LAST:event_tablaMarcasMouseClicked

    private void btn_guardarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarProductosActionPerformed
        String idProducto= txt_idProductos.getText();
        String nombre= txt_nombreProductos.getText();
        String descripcion= txt_descripcionProductos.getText();
        Double precio= Double.valueOf(txt_precio.getText());
        int cantidad= Integer.parseInt(txt_cantidadProductos.getText());
        String marca= cbx_marcaProductos.getSelectedItem().toString();
        String tipo= cbx_tipoProductos.getSelectedItem().toString(); 
        int idMarca = 0;
        int idTipo = 0;
        
        try
        {
            marca Omarca = new marca();
            Omarca.setConn(this.Control.getConn());
            ResultSet listaMarcas = Omarca.getMarca();
            if(listaMarcas != null)
            {
                while(listaMarcas.next()) 
                {
                    int posibleIdMarca= Integer.parseInt(listaMarcas.getObject(1).toString());
                    String posibleMarca = listaMarcas.getObject(2).toString();
                    if(posibleMarca.equals(marca))
                    {
                        idMarca = posibleIdMarca;
                    }
                }
            }

            tipo_producto Otipoproducto = new tipo_producto();
            Otipoproducto.setConn(this.Control.getConn());
            ResultSet listaTipos = Otipoproducto.getTipoProducto();
            if(listaTipos != null)
            {
                while(listaTipos.next()) 
                {
                    int posibleIdTipo = Integer.parseInt(listaTipos.getObject(1).toString());
                    String posibleTipo = listaTipos.getObject(2).toString();
                    if(posibleTipo.equals(tipo))
                    {
                        idTipo = posibleIdTipo;
                    }
                }
            }
        }
        catch(Exception ee)
        {
            JOptionPane.showMessageDialog(null, ee);     
        }

       
        if(nombre.isEmpty() || precio <= 0|| marca.isEmpty() || tipo.isEmpty() || cantidad <= 0 || idMarca == 0 || idTipo == 0)
        {   
            JOptionPane.showMessageDialog(null, "Asegurate de haber ingresado todos los datos");       
        }
        else
        {
            if (this.nuevoProducto)
            {
                productos producto = new productos( nombre, descripcion, precio, cantidad, idMarca, idTipo, this.Control.getConn());
                producto.guardarProductos();
                limpiarProducto();
                cargarProductos();
                this.nuevoProducto = true;
            }
            else 
            {
                productos producto = new productos(Integer.parseInt(txt_idProductos.getText()), nombre, descripcion, precio, cantidad, idMarca, idTipo, this.Control.getConn());
                producto.modificarProductos();
                limpiarProducto();
                cargarProductos();
                this.nuevoProducto = true;
            }
        }
    }//GEN-LAST:event_btn_guardarProductosActionPerformed

    private void btn_EliminarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarProductosActionPerformed
        int resultado= JOptionPane.showConfirmDialog(this, "Desea borrar el registro?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if(resultado==JOptionPane.YES_OPTION) {
            productos producto= new productos();
            producto.setConn(this.Control.getConn());
            producto.setIdProducto(Integer.parseInt(this.txt_idProductos.getText()));
            producto.borrarProductos();
            this.limpiarProducto();
            this.cargarProductos();
        }
    }//GEN-LAST:event_btn_EliminarProductosActionPerformed

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        cargarRegistroProducto();
        this.nuevoProducto = false;
    }//GEN-LAST:event_tablaProductosMouseClicked

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
            java.util.logging.Logger.getLogger(AdminInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane PanelesInventario;
    private javax.swing.JButton btn_EliminarCategorias;
    private javax.swing.JButton btn_EliminarMarcas;
    private javax.swing.JButton btn_EliminarProductos;
    private javax.swing.JButton btn_guardar2;
    private javax.swing.JButton btn_guardarCategorias;
    private javax.swing.JButton btn_guardarMarcas;
    private javax.swing.JButton btn_guardarProductos;
    private javax.swing.JButton bttn_volver;
    private javax.swing.JButton bttn_volver1;
    private javax.swing.JButton bttn_volver2;
    private javax.swing.JComboBox<String> cbx_marcaProductos;
    private javax.swing.JComboBox<String> cbx_tipoProductos;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lbl_cantidadProductos;
    private javax.swing.JLabel lbl_descripcionCategoria;
    private javax.swing.JLabel lbl_descripcionProductos;
    private javax.swing.JLabel lbl_id2;
    private javax.swing.JLabel lbl_idCategoria;
    private javax.swing.JLabel lbl_idMarcas;
    private javax.swing.JLabel lbl_idProductos;
    private javax.swing.JLabel lbl_marcaProductos;
    private javax.swing.JLabel lbl_nombre2;
    private javax.swing.JLabel lbl_nombreCategoria;
    private javax.swing.JLabel lbl_nombreMarcas;
    private javax.swing.JLabel lbl_nombreProductos;
    private javax.swing.JLabel lbl_precioProductos;
    private javax.swing.JLabel lbl_tipoProductos;
    private javax.swing.JPanel panelCategoria;
    private javax.swing.JPanel panelMarcas;
    private javax.swing.JPanel panelProductos;
    private javax.swing.JTable tablaCategorias;
    private javax.swing.JTable tablaMarcas;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txt_cantidadProductos;
    private javax.swing.JTextArea txt_descripcionCategoria;
    private javax.swing.JTextArea txt_descripcionProductos;
    private javax.swing.JTextField txt_id2;
    private javax.swing.JTextField txt_idCategoria;
    private javax.swing.JTextField txt_idMarcas;
    private javax.swing.JTextField txt_idProductos;
    private javax.swing.JTextField txt_nombre2;
    private javax.swing.JTextField txt_nombreCategoria;
    private javax.swing.JTextField txt_nombreMarcas;
    private javax.swing.JTextField txt_nombreProductos;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
