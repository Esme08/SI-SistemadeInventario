/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistema_los_amigos.Formularios.formEmpleados;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema_los_amigos.Sistema_Los_Amigos;
import sistema_los_amigos.marca;
import sistema_los_amigos.productos;
import sistema_los_amigos.tipo_producto;



/**
 *
 * @author esmer
 */
public class EmpleadoInventario extends javax.swing.JFrame {
    Sistema_Los_Amigos Control = new Sistema_Los_Amigos();
    DefaultTableModel modeloCategorias;
    DefaultTableModel modeloMarcas;
    DefaultTableModel modeloProductos;
    
    public void cargarCategorias ()
    {
        tipo_producto tipo = new tipo_producto();
        tipo.setConn(Control.getConn());
        this.modeloCategorias.setRowCount(0);
        try 
        {
            ResultSet st = tipo.getTipoProducto();
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
                    this.modeloCategorias.addRow(datos);
                }
            }
        }
        catch (SQLException ex) 
        { 
            JOptionPane.showMessageDialog(null, "Ups! Algo salió mal" + ex);
        }
    }
    
    public void cargarMarca ()
    {
        marca marca = new marca();
        marca.setConn(Control.getConn());
        
        this.modeloMarcas.setRowCount(0);
        try 
        {
            ResultSet st = marca.getMarca();
            if(st != null)
            {
                while(st.next()) 
                {
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
    
    public void cargarProductos (int ID)
    {
        productos productos = new productos();
        productos.setConn(Control.getConn());
        
        this.modeloProductos.setRowCount(0);
        try 
        {
            ResultSet st = productos.getProductosPorID(ID);
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
    
    public void cargarProductos (String parametro, String tipobusqueda)
    {
        productos productos = new productos();
        productos.setConn(Control.getConn());
        
        this.modeloProductos.setRowCount(0);
        if(tipobusqueda.equals("Nombre"))
        {
            try 
            {
                ResultSet st = productos.getProductosPorNombre(parametro);
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
        if(tipobusqueda.equals("Marca"))
        {
            try 
            {
                ResultSet st = productos.getProductosPorMarca(parametro);
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
    }

    /**
     * Creates new form AdminInventario
     */
    public EmpleadoInventario() {
        initComponents();
        modeloCategorias = (DefaultTableModel) this.tablaCategorias.getModel();
        modeloMarcas = (DefaultTableModel)this.tablaMarcas.getModel();
        modeloProductos = (DefaultTableModel)this.tablaProductos.getModel();
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
        bttn_volver1 = new javax.swing.JButton();
        panelProductos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(35, 100), new java.awt.Dimension(35, 100), new java.awt.Dimension(35, 100));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(35, 100), new java.awt.Dimension(35, 100), new java.awt.Dimension(35, 100));
        lbl_tipobusqueda = new javax.swing.JLabel();
        lbl_buscar = new javax.swing.JLabel();
        cbx_buscar = new javax.swing.JComboBox<>();
        btn_guardarProductos = new javax.swing.JButton();
        txt_parametrobusqueda = new javax.swing.JTextField();
        bttn_volver2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(41, 38, 67));

        PanelesInventario.setBackground(new java.awt.Color(68, 66, 110));
        PanelesInventario.setForeground(new java.awt.Color(255, 255, 255));
        PanelesInventario.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        panelCategoria.setBackground(new java.awt.Color(41, 38, 67));

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
        jScrollPane2.setViewportView(tablaCategorias);

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
                .addGroup(panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCategoriaLayout.createSequentialGroup()
                        .addComponent(filler4, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelCategoriaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bttn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelCategoriaLayout.setVerticalGroup(
            panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filler3, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
            .addGroup(panelCategoriaLayout.createSequentialGroup()
                .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelesInventario.addTab("Categorias", panelCategoria);

        panelMarcas.setBackground(new java.awt.Color(41, 38, 67));

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
                .addGroup(panelMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMarcasLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, 1074, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMarcasLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bttn_volver1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addComponent(btn_guardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(bttn_volver1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        PanelesInventario.addTab("Marcas", panelMarcas);

        panelProductos.setBackground(new java.awt.Color(41, 38, 67));

        tablaProductos.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
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
        jScrollPane1.setViewportView(tablaProductos);

        lbl_tipobusqueda.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_tipobusqueda.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tipobusqueda.setText("Parámetro de búsqueda:");

        lbl_buscar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl_buscar.setForeground(new java.awt.Color(255, 255, 255));
        lbl_buscar.setText("Buscar por:");

        cbx_buscar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        cbx_buscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nombre", "Marca" }));

        btn_guardarProductos.setBackground(new java.awt.Color(201, 101, 0));
        btn_guardarProductos.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btn_guardarProductos.setForeground(new java.awt.Color(255, 255, 255));
        btn_guardarProductos.setText("Buscar");
        btn_guardarProductos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_guardarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarProductosActionPerformed(evt);
            }
        });

        txt_parametrobusqueda.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

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
                    .addGroup(panelProductosLayout.createSequentialGroup()
                        .addComponent(lbl_buscar)
                        .addGap(115, 115, 115)
                        .addComponent(cbx_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(349, 349, 349)
                        .addComponent(bttn_volver2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelProductosLayout.createSequentialGroup()
                            .addComponent(lbl_tipobusqueda)
                            .addGap(27, 27, 27)
                            .addComponent(txt_parametrobusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(48, 48, 48)
                            .addComponent(btn_guardarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelProductosLayout.setVerticalGroup(
            panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductosLayout.createSequentialGroup()
                .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                    .addGroup(panelProductosLayout.createSequentialGroup()
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_buscar)
                            .addComponent(cbx_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bttn_volver2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_tipobusqueda)
                            .addComponent(txt_parametrobusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_guardarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );

        PanelesInventario.addTab("Productos", panelProductos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelesInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(PanelesInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttn_volverActionPerformed
        menuPrincipalEmpleado form = new menuPrincipalEmpleado();
        form.Control = this.Control;
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bttn_volverActionPerformed

    private void bttn_volver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttn_volver1ActionPerformed
        menuPrincipalEmpleado form = new menuPrincipalEmpleado();
        form.Control = this.Control;
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bttn_volver1ActionPerformed

    private void bttn_volver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttn_volver2ActionPerformed
        menuPrincipalEmpleado form = new menuPrincipalEmpleado();
        form.Control = this.Control;
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bttn_volver2ActionPerformed

    private void btn_guardarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarProductosActionPerformed
        String seleccion = cbx_buscar.getSelectedItem().toString();
        String parametro = txt_parametrobusqueda.getText();
        
        if(seleccion.equals("ID"))
        {
            cargarProductos(Integer.parseInt(parametro));
        }
        if(seleccion.equals("Nombre") || seleccion.equals("Marca"))
        {
            cargarProductos(parametro, seleccion);
        }
    }//GEN-LAST:event_btn_guardarProductosActionPerformed

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
            java.util.logging.Logger.getLogger(EmpleadoInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpleadoInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpleadoInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpleadoInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpleadoInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane PanelesInventario;
    private javax.swing.JButton btn_guardar2;
    private javax.swing.JButton btn_guardarProductos;
    private javax.swing.JButton bttn_volver;
    private javax.swing.JButton bttn_volver1;
    private javax.swing.JButton bttn_volver2;
    private javax.swing.JComboBox<String> cbx_buscar;
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
    private javax.swing.JLabel lbl_buscar;
    private javax.swing.JLabel lbl_id2;
    private javax.swing.JLabel lbl_nombre2;
    private javax.swing.JLabel lbl_tipobusqueda;
    private javax.swing.JPanel panelCategoria;
    private javax.swing.JPanel panelMarcas;
    private javax.swing.JPanel panelProductos;
    private javax.swing.JTable tablaCategorias;
    private javax.swing.JTable tablaMarcas;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txt_id2;
    private javax.swing.JTextField txt_nombre2;
    private javax.swing.JTextField txt_parametrobusqueda;
    // End of variables declaration//GEN-END:variables
}
