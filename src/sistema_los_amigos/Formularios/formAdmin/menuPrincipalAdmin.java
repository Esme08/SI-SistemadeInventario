package sistema_los_amigos.Formularios.formAdmin;

/**
 *
 * @author esme :3
 */
public class menuPrincipalAdmin extends javax.swing.JFrame {

    /**
     * Creates new form menuPrincipal
     */
    public menuPrincipalAdmin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_inicioSesión = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbl_Activaciones = new javax.swing.JLabel();
        lbl_bienvenida = new javax.swing.JLabel();
        btn_adminInventario = new javax.swing.JButton();
        btn_adminVentas = new javax.swing.JButton();
        btn_registrarVentas = new javax.swing.JButton();
        btn_adminClientes = new javax.swing.JButton();
        btn_adminPersonal = new javax.swing.JButton();
        btn_cerrarSesion = new javax.swing.JButton();

        btn_inicioSesión.setBackground(new java.awt.Color(68, 66, 110));
        btn_inicioSesión.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btn_inicioSesión.setForeground(new java.awt.Color(255, 255, 255));
        btn_inicioSesión.setText("Iniciar Sesión");
        btn_inicioSesión.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(41, 38, 67));

        lbl_Activaciones.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        lbl_Activaciones.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Activaciones.setText("Activaciones Los Amigos");

        lbl_bienvenida.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lbl_bienvenida.setForeground(new java.awt.Color(255, 255, 255));
        lbl_bienvenida.setText("Bienvenido ");

        btn_adminInventario.setBackground(new java.awt.Color(68, 66, 110));
        btn_adminInventario.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btn_adminInventario.setForeground(new java.awt.Color(255, 255, 255));
        btn_adminInventario.setText("Administrar Inventario");
        btn_adminInventario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_adminInventario.setMaximumSize(new java.awt.Dimension(171, 27));
        btn_adminInventario.setMinimumSize(new java.awt.Dimension(171, 27));
        btn_adminInventario.setPreferredSize(new java.awt.Dimension(171, 27));
        btn_adminInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adminInventarioActionPerformed(evt);
            }
        });

        btn_adminVentas.setBackground(new java.awt.Color(68, 66, 110));
        btn_adminVentas.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btn_adminVentas.setForeground(new java.awt.Color(255, 255, 255));
        btn_adminVentas.setText("Administrar Ventas");
        btn_adminVentas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_adminVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adminVentasActionPerformed(evt);
            }
        });

        btn_registrarVentas.setBackground(new java.awt.Color(68, 66, 110));
        btn_registrarVentas.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btn_registrarVentas.setForeground(new java.awt.Color(255, 255, 255));
        btn_registrarVentas.setText("Registrar Ventas");
        btn_registrarVentas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_registrarVentas.setMaximumSize(new java.awt.Dimension(171, 27));
        btn_registrarVentas.setMinimumSize(new java.awt.Dimension(171, 27));
        btn_registrarVentas.setPreferredSize(new java.awt.Dimension(171, 27));
        btn_registrarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarVentasActionPerformed(evt);
            }
        });

        btn_adminClientes.setBackground(new java.awt.Color(68, 66, 110));
        btn_adminClientes.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btn_adminClientes.setForeground(new java.awt.Color(255, 255, 255));
        btn_adminClientes.setText("Administrar Clientes");
        btn_adminClientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_adminClientes.setMaximumSize(new java.awt.Dimension(171, 27));
        btn_adminClientes.setMinimumSize(new java.awt.Dimension(171, 27));
        btn_adminClientes.setPreferredSize(new java.awt.Dimension(171, 27));
        btn_adminClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adminClientesActionPerformed(evt);
            }
        });

        btn_adminPersonal.setBackground(new java.awt.Color(68, 66, 110));
        btn_adminPersonal.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btn_adminPersonal.setForeground(new java.awt.Color(255, 255, 255));
        btn_adminPersonal.setText("Administrar Personal");
        btn_adminPersonal.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_adminPersonal.setMaximumSize(new java.awt.Dimension(171, 27));
        btn_adminPersonal.setMinimumSize(new java.awt.Dimension(171, 27));
        btn_adminPersonal.setPreferredSize(new java.awt.Dimension(171, 27));
        btn_adminPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adminPersonalActionPerformed(evt);
            }
        });

        btn_cerrarSesion.setBackground(new java.awt.Color(201, 101, 0));
        btn_cerrarSesion.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btn_cerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btn_cerrarSesion.setText("Cerrar Sesión");
        btn_cerrarSesion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_cerrarSesion.setMaximumSize(new java.awt.Dimension(171, 27));
        btn_cerrarSesion.setMinimumSize(new java.awt.Dimension(171, 27));
        btn_cerrarSesion.setPreferredSize(new java.awt.Dimension(171, 27));
        btn_cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_bienvenida)
                .addGap(254, 254, 254))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(lbl_Activaciones))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_adminVentas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_adminInventario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_registrarVentas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_adminClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_adminPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_Activaciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_bienvenida)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_adminInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_adminClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_adminPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(btn_adminVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_registrarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_adminInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adminInventarioActionPerformed
        AdminInventario formulario = new AdminInventario();
        formulario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_adminInventarioActionPerformed

    private void btn_adminVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adminVentasActionPerformed
        AdminVentas form = new AdminVentas();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_adminVentasActionPerformed

    private void btn_registrarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarVentasActionPerformed
        IniciarVenta form = new IniciarVenta();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_registrarVentasActionPerformed

    private void btn_adminClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adminClientesActionPerformed
        AdminCliente form = new AdminCliente();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_adminClientesActionPerformed

    private void btn_adminPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adminPersonalActionPerformed
        AdminEmppleados form = new AdminEmppleados();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_adminPersonalActionPerformed

    private void btn_cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarSesionActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cerrarSesionActionPerformed

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
            java.util.logging.Logger.getLogger(menuPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuPrincipalAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_adminClientes;
    private javax.swing.JButton btn_adminInventario;
    private javax.swing.JButton btn_adminPersonal;
    private javax.swing.JButton btn_adminVentas;
    private javax.swing.JButton btn_cerrarSesion;
    private javax.swing.JButton btn_inicioSesión;
    private javax.swing.JButton btn_registrarVentas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_Activaciones;
    private javax.swing.JLabel lbl_bienvenida;
    // End of variables declaration//GEN-END:variables
}
