/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package departamentalizacionplanilla;

import static departamentalizacionplanilla.Empleados.intCod;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan
 */
public class Nomina_Detalle extends javax.swing.JFrame {

    /**
     * Creates new form Nomina_Detalle
     */
    public static Double dblSueldo;
    public void limpiar(){
        txtvalor.setText("");
        cmbfn.setSelectedIndex(0);
        cmbconcepto.setSelectedIndex(0);
        cmbemp.setSelectedIndex(0);
    }
    public Nomina_Detalle() {
        initComponents();
        cmbfn.addItem("");
        cmbcodfn.addItem("");
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/base_nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from nomina_encabezado");
            ResultSet rs = pst.executeQuery();
            
            boolean r=rs.next();
            while(r){
                cmbfn.addItem(rs.getString("fecha_inicial_nominal")+" - "+rs.getString("fecha_final_nominal"));
                cmbcodfn.addItem(rs.getString("codigo_nominal"));
                r=rs.next();
            }
        }catch (Exception e){
            System.out.println("le dio un pujaso");
        }
        cmbemp.addItem("");
        cmbcodemp.addItem("");
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/base_nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from empleados");
            ResultSet rs = pst.executeQuery();
            
            boolean r=rs.next();
            while(r){
                cmbemp.addItem(rs.getString("nombre_emp"));
                cmbcodemp.addItem(rs.getString("codigo_emp"));
                r=rs.next();
            }
        }catch (Exception e){
            System.out.println("le dio un pujaso");
        }
        cmbconcepto.addItem("");
        cmbcodconcepto.addItem("");
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/base_nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from concepto");
            ResultSet rs = pst.executeQuery();
            
            boolean r=rs.next();
            while(r){
                cmbconcepto.addItem(rs.getString("nombre_concepto"));
                cmbcodconcepto.addItem(rs.getString("codigo_concepto"));
                r=rs.next();
            }
        }catch (Exception e){
            System.out.println("le dio un pujaso");
        }
        lblvalor.setVisible(false);
        txtvalor.setVisible(false);
        lblfecha.setVisible(false);
        cmbfn.setVisible(false);
        cmbcodfn.setVisible(false);
        lblconcepto.setVisible(false);
        cmbconcepto.setVisible(false);
        cmbcodconcepto.setVisible(false);
        lblemp.setVisible(false);
        cmbemp.setVisible(false);
        cmbcodemp.setVisible(false);
        btnaccion.setVisible(false);
        btnbuscar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblfecha = new javax.swing.JLabel();
        cmbfn = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmboperacion = new javax.swing.JComboBox<>();
        btnaccion = new javax.swing.JButton();
        lblvalor = new javax.swing.JLabel();
        txtvalor = new javax.swing.JTextField();
        lblconcepto = new javax.swing.JLabel();
        cmbcodconcepto = new javax.swing.JComboBox<>();
        cmbconcepto = new javax.swing.JComboBox<>();
        btnbuscar = new javax.swing.JButton();
        cmbcodfn = new javax.swing.JComboBox<>();
        cmbemp = new javax.swing.JComboBox<>();
        lblemp = new javax.swing.JLabel();
        cmbcodemp = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NOMINA DETALLE");
        setPreferredSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblfecha.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblfecha.setText("Fecha Nomina");
        getContentPane().add(lblfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        cmbfn.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        cmbfn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbfnItemStateChanged(evt);
            }
        });
        cmbfn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbfnActionPerformed(evt);
            }
        });
        getContentPane().add(cmbfn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 210, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setText("Operación");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        cmboperacion.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        cmboperacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Agregar", "Modificar" }));
        cmboperacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmboperacionItemStateChanged(evt);
            }
        });
        cmboperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboperacionActionPerformed(evt);
            }
        });
        getContentPane().add(cmboperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 115, -1));

        btnaccion.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnaccion.setText("jButton1");
        btnaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaccionActionPerformed(evt);
            }
        });
        getContentPane().add(btnaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));

        lblvalor.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblvalor.setText("Valor del concepto");
        getContentPane().add(lblvalor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        txtvalor.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        getContentPane().add(txtvalor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 150, -1));

        lblconcepto.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblconcepto.setText("Concepto");
        getContentPane().add(lblconcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        cmbcodconcepto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbcodconceptoItemStateChanged(evt);
            }
        });
        cmbcodconcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbcodconceptoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbcodconcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 115, -1));

        cmbconcepto.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        cmbconcepto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbconceptoItemStateChanged(evt);
            }
        });
        cmbconcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbconceptoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbconcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 210, -1));

        btnbuscar.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));

        cmbcodfn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbcodfnItemStateChanged(evt);
            }
        });
        cmbcodfn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbcodfnActionPerformed(evt);
            }
        });
        getContentPane().add(cmbcodfn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 115, -1));

        cmbemp.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        cmbemp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbempItemStateChanged(evt);
            }
        });
        cmbemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbempActionPerformed(evt);
            }
        });
        getContentPane().add(cmbemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 180, -1));

        lblemp.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblemp.setText("Empleado");
        getContentPane().add(lblemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        cmbcodemp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbcodempItemStateChanged(evt);
            }
        });
        cmbcodemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbcodempActionPerformed(evt);
            }
        });
        getContentPane().add(cmbcodemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 115, -1));

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jButton1.setText("Menú");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbfnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbfnItemStateChanged
        
    }//GEN-LAST:event_cmbfnItemStateChanged

    private void cmbfnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbfnActionPerformed
        // TODO add your handling code here:
        try{
            this.cmbcodfn.setSelectedIndex(this.cmbfn.getSelectedIndex());
        }catch(Exception e){
        }
    }//GEN-LAST:event_cmbfnActionPerformed

    private void cmboperacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmboperacionItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboperacionItemStateChanged

    private void cmboperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboperacionActionPerformed
        // TODO add your handling code here:
        if (cmboperacion.getSelectedIndex()==1) {
            limpiar();
            txtvalor.setEnabled(true);
            lblvalor.setVisible(false);
            txtvalor.setVisible(false);
            lblfecha.setVisible(false);
            cmbfn.setVisible(false);
            lblconcepto.setVisible(false);
            cmbconcepto.setVisible(false);
            lblemp.setVisible(true);
            cmbemp.setVisible(true);
            btnaccion.setVisible(false);
            btnbuscar.setVisible(false);
            btnaccion.setText("Agregar");
        }else if (cmboperacion.getSelectedIndex()==2) {
            limpiar();
            txtvalor.setEnabled(false);
            lblvalor.setVisible(true);
            txtvalor.setVisible(true);
            lblfecha.setVisible(true);
            cmbfn.setVisible(true);
            lblconcepto.setVisible(true);
            cmbconcepto.setVisible(true);
            lblemp.setVisible(true);
            cmbemp.setVisible(true);
            btnaccion.setVisible(true);
            btnbuscar.setVisible(true);
            btnaccion.setText("Modificar");
        }else{
            limpiar();
            txtvalor.setEnabled(true);
            lblvalor.setVisible(false);
            txtvalor.setVisible(false);
            lblfecha.setVisible(false);
            cmbfn.setVisible(false);
            lblconcepto.setVisible(false);
            cmbconcepto.setVisible(false);
            cmbcodconcepto.setVisible(false);
            btnbuscar.setVisible(false);
        }
    }//GEN-LAST:event_cmboperacionActionPerformed

    private void btnaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaccionActionPerformed
        // TODO add your handling code here:
        if (cmboperacion.getSelectedIndex()==1) {
            if (txtvalor.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Debe de ingresar el el valor del concepto");
            }else if (cmbfn.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog(this, "Debe de seleccionar la fecha de la nomina");
            }else if (cmbconcepto.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog(this, "Debe de seleccionar el concepto");
            }else if (cmbemp.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog(this, "Debe de seleccionar el empleado");
            }else{
                try{
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/base_nomina", "root", "");
                    PreparedStatement pst = cn.prepareStatement("insert into nomina_detalle values(?,?,?,?)");
                    pst.setString(1, String.valueOf(cmbcodfn.getSelectedItem()));
                    pst.setString(2, String.valueOf(cmbcodemp.getSelectedItem()));
                    pst.setString(3, String.valueOf(cmbcodconcepto.getSelectedItem()));
                    pst.setString(4, txtvalor.getText().trim());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Datos ingresados correctamente","ÉXITO",JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                }catch (Exception e){
                    System.out.println("le dio un error");
                }
            }
        }else if (cmboperacion.getSelectedIndex()==2) {
            if (JOptionPane.showConfirmDialog(this, "Está seguro de modificar los datos?","MODIFICAR",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
                try {
                    String strCod = String.valueOf(cmbcodfn.getSelectedItem());
                    String strEmp = String.valueOf(cmbcodemp.getSelectedItem());
                    String strConcepto = String.valueOf(cmbcodconcepto.getSelectedItem());

                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/base_nomina", "root", "");
                    PreparedStatement pst = cn.prepareStatement("update nomina_detalle set valor_nominadetalle= ? where codigo_nominal= " + strCod+" and codigo_emp="+strEmp+" and codigo_concepto="+strConcepto);

                    pst.setString(1, txtvalor.getText().trim());
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Datos modificados correctamente","ÉXITO",JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                } catch (Exception e) {
                    System.out.println("le dio un pujaso");
                }
            }
        }
    }//GEN-LAST:event_btnaccionActionPerformed

    private void cmbcodconceptoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbcodconceptoItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbcodconceptoItemStateChanged

    private void cmbcodconceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbcodconceptoActionPerformed
        // TODO add your handling code here:
        try{
            this.cmbconcepto.setSelectedIndex(this.cmbcodconcepto.getSelectedIndex());
        }catch(Exception e){
        }
    }//GEN-LAST:event_cmbcodconceptoActionPerformed

    private void cmbconceptoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbconceptoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbconceptoItemStateChanged

    private void cmbcodfnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbcodfnItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbcodfnItemStateChanged

    private void cmbcodfnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbcodfnActionPerformed
        // TODO add your handling code here:
        try{
            this.cmbfn.setSelectedIndex(this.cmbcodfn.getSelectedIndex());
        }catch(Exception e){
        }
    }//GEN-LAST:event_cmbcodfnActionPerformed

    private void cmbempItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbempItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbempItemStateChanged

    private void cmbempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbempActionPerformed
        // TODO add your handling code here:
        try{
            this.cmbcodemp.setSelectedIndex(this.cmbemp.getSelectedIndex());
        }catch(Exception e){
        }
        if (cmboperacion.getSelectedIndex()==1) {
            if (cmbemp.getSelectedIndex()!=0) {
                lblconcepto.setVisible(true);
                cmbconcepto.setVisible(true);   
            }else{
                lblconcepto.setVisible(false);
                cmbconcepto.setVisible(false);
                lblvalor.setVisible(false);
                txtvalor.setVisible(false);
                lblfecha.setVisible(false);
                cmbfn.setVisible(false);
                lblemp.setVisible(false);
                cmbemp.setVisible(false);
                btnaccion.setVisible(false);
            }
        }
        
    }//GEN-LAST:event_cmbempActionPerformed

    private void cmbcodempItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbcodempItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbcodempItemStateChanged

    private void cmbcodempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbcodempActionPerformed
        // TODO add your handling code here:
        try{
            this.cmbemp.setSelectedIndex(this.cmbcodemp.getSelectedIndex());
        }catch(Exception e){
        }
    }//GEN-LAST:event_cmbcodempActionPerformed

    private void cmbconceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbconceptoActionPerformed
        // TODO add your handling code here:
        try{
            this.cmbcodconcepto.setSelectedIndex(this.cmbconcepto.getSelectedIndex());
        }catch(Exception e){
        }
        if (cmboperacion.getSelectedIndex()==1) {
            if (cmbconcepto.getSelectedIndex()!=0) {
                lblvalor.setVisible(true);
                txtvalor.setVisible(true);
                lblfecha.setVisible(true);
                cmbfn.setVisible(true);
                lblemp.setVisible(true);
                cmbemp.setVisible(true);
                btnaccion.setVisible(true);
                if (cmbconcepto.getSelectedIndex()==1 || cmbconcepto.getSelectedIndex()==4 || cmbconcepto.getSelectedIndex()==6) {
                    txtvalor.setEnabled(false);
                    try{
                        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/base_nomina", "root", "");
                        PreparedStatement pst = cn.prepareStatement("select sueldo_emp from empleados where codigo_emp="+String.valueOf(cmbcodemp.getSelectedItem()));
                        ResultSet rs = pst.executeQuery();

                        boolean r=rs.next();
                        while(r){
                            dblSueldo=Double.parseDouble(rs.getString("sueldo_emp"));
                            r=rs.next();
                        }
                    }catch (Exception e){
                        System.out.println("le dio un pujaso");
                    }
                    if (cmbconcepto.getSelectedIndex()==1) {
                        txtvalor.setText(String.valueOf(dblSueldo));
                    }else if (cmbconcepto.getSelectedIndex()==4) {
                        txtvalor.setText(String.valueOf(dblSueldo*.0483));
                    }else{
                        if (dblSueldo<2600) {
                            txtvalor.setText("0");
                        }else if (dblSueldo<=5000) {
                            txtvalor.setText(String.valueOf(dblSueldo*.03));
                        }else if (dblSueldo<=10000) {
                            txtvalor.setText(String.valueOf(dblSueldo*.05));
                        }else{
                            txtvalor.setText(String.valueOf(dblSueldo*.1));
                        }
                    }
                }else{
                    txtvalor.setEnabled(true);
                }
            }else{
                lblvalor.setVisible(false);
                txtvalor.setVisible(false);
                lblfecha.setVisible(false);
                cmbfn.setVisible(false);
                btnaccion.setVisible(false);
            }
        }
    }//GEN-LAST:event_cmbconceptoActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
            if (cmbfn.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog(this, "Debe de seleccionar la fecha de la nomina");
            }else if (cmbconcepto.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog(this, "Debe de seleccionar el concepto");
            }else if (cmbemp.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog(this, "Debe de seleccionar el empleado");
            }else{
               try{
                    String strCod = String.valueOf(cmbcodfn.getSelectedItem());
                    String strEmp = String.valueOf(cmbcodemp.getSelectedItem());
                    String strConcepto = String.valueOf(cmbcodconcepto.getSelectedItem());
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/base_nomina", "root", "");
                    PreparedStatement pst = cn.prepareStatement("select * from nomina_detalle where codigo_nominal= " + strCod+" and codigo_emp="+strEmp+" and codigo_concepto="+strConcepto);
                    ResultSet rs = pst.executeQuery();

                    boolean r=rs.next();
                    while(r){
                        txtvalor.setText(rs.getString("valor_nominadetalle"));
                        txtvalor.setEnabled(true);
                        r=rs.next();
                    }
                }catch (Exception e){
                    System.out.println("le dio un pujaso");
                } 
            }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Menú inf=new Menú();
        this.dispose();
        inf.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Nomina_Detalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nomina_Detalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nomina_Detalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nomina_Detalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nomina_Detalle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaccion;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JComboBox<String> cmbcodconcepto;
    private javax.swing.JComboBox<String> cmbcodemp;
    private javax.swing.JComboBox<String> cmbcodfn;
    private javax.swing.JComboBox<String> cmbconcepto;
    private javax.swing.JComboBox<String> cmbemp;
    private javax.swing.JComboBox<String> cmbfn;
    private javax.swing.JComboBox<String> cmboperacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblconcepto;
    private javax.swing.JLabel lblemp;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblvalor;
    private javax.swing.JTextField txtvalor;
    // End of variables declaration//GEN-END:variables
}
