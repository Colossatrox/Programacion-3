/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package departamentalizacionplanilla;

import static departamentalizacionplanilla.Usuarios.intCod;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan
 */
public class Empleados extends javax.swing.JFrame {

    /**
     * Creates new form Empleados
     */
    public static int intCod=0;
    //método para dejar en blanco los textbox y combobox
    public void limpiar(){
        txtcod.setText("");
        txtnombre.setText("");
        txtsueldo.setText("");
        cmbpuesto.setSelectedIndex(0);
        cmbdepto.setSelectedIndex(0);
    }
    //método para actualizar los combobox donde se hacen las búsquedas
    public void actualizarbusqueda(){
        //quita todos los items que tiene el combo
        cmbbusqueda.removeAllItems();
        cmbbusqueda.addItem("");
        try{
            //Conección con la base de datos
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/base_nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("select nombre_emp from empleados");
            ResultSet rs = pst.executeQuery();
            
            boolean r=rs.next();
            //mientras encuentre datos en la tabla y campo especificado
            while(r){
                //se agrega lo encontrado al combo 
                cmbbusqueda.addItem(rs.getString("nombre_emp"));
                r=rs.next();
            }
        }catch (Exception e){
            System.out.println("le dio un pujaso");
        }
    }
    public Empleados() {
        try{
            //Conección con la base de datos
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/base_nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from empleados");
            ResultSet rs = pst.executeQuery();
            
            boolean r=rs.next();
            //mientras encuentre datos en la tabla y campo especificado
            while(r){
                //intCod servirá para código automático por lo que se busca el más grande guardado en la base de datos
                if (intCod< Integer.parseInt(rs.getString("codigo_emp"))) {
                    intCod=Integer.parseInt(rs.getString("codigo_emp"));
                }
                r=rs.next();
            }
            intCod++;
            System.out.println(intCod);
        }catch (Exception e){
            System.out.println("le dio un pujaso");
        }
        initComponents();
        cmbpuesto.addItem("");
        cmbcodpuesto.addItem("");
        try{
            //Conección con la base de datos
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/base_nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from puestos");
            ResultSet rs = pst.executeQuery();
            
            boolean r=rs.next();
            //mientras encuentre datos en la tabla y campo especificado
            while(r){
                //se agrega lo encontrado al combo 
                cmbpuesto.addItem(rs.getString("nombre_puesto"));
                cmbcodpuesto.addItem(rs.getString("codigo_puesto"));
                r=rs.next();
            }
        }catch (Exception e){
            System.out.println("le dio un pujaso");
        }
        cmbdepto.addItem("");
        cmbcoddepto.addItem("");
        try{
            //Conección con la base de datos
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/base_nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from departamentos");
            ResultSet rs = pst.executeQuery();
            
            boolean r=rs.next();
            //mientras encuentre datos en la tabla y campo especificado
            while(r){
                //se agrega lo encontrado al combo 
                cmbdepto.addItem(rs.getString("nombre_depto"));
                cmbcoddepto.addItem(rs.getString("codigo_depto"));
                r=rs.next();
            }
        }catch (Exception e){
            System.out.println("le dio un pujaso");
        }
        actualizarbusqueda();
        lblbusqueda.setVisible(false);
        cmbbusqueda.setVisible(false);
        lblcodigo.setVisible(false);
        txtcod.setVisible(false);
        lblusuario.setVisible(false);
        txtnombre.setVisible(false);
        sueldo.setVisible(false);
        txtsueldo.setVisible(false);
        lblestado.setVisible(false);
        cmbpuesto.setVisible(false);
        cmbcodpuesto.setVisible(false);
        lblempleado.setVisible(false);
        cmbdepto.setVisible(false);
        cmbcoddepto.setVisible(false);
        btnaccion.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblestado = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        lblusuario = new javax.swing.JLabel();
        cmbpuesto = new javax.swing.JComboBox<>();
        txtcod = new javax.swing.JTextField();
        lblcodigo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmboperacion = new javax.swing.JComboBox<>();
        btnaccion = new javax.swing.JButton();
        cmbbusqueda = new javax.swing.JComboBox<>();
        lblbusqueda = new javax.swing.JLabel();
        sueldo = new javax.swing.JLabel();
        txtsueldo = new javax.swing.JTextField();
        lblempleado = new javax.swing.JLabel();
        cmbcoddepto = new javax.swing.JComboBox<>();
        cmbdepto = new javax.swing.JComboBox<>();
        cmbcodpuesto = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EMPLEADOS");
        setPreferredSize(new java.awt.Dimension(400, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblestado.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblestado.setText("Puesto");
        getContentPane().add(lblestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        txtnombre.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 200, -1));

        lblusuario.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblusuario.setText("Nombre");
        getContentPane().add(lblusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        cmbpuesto.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        cmbpuesto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbpuestoItemStateChanged(evt);
            }
        });
        cmbpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbpuestoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 200, -1));

        txtcod.setEditable(false);
        txtcod.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        getContentPane().add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 84, -1));

        lblcodigo.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblcodigo.setText("Código");
        getContentPane().add(lblcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setText("Operación");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        cmboperacion.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        cmboperacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Agregar", "Modificar", "Eliminar" }));
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
        getContentPane().add(cmboperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 115, -1));

        btnaccion.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnaccion.setText("jButton1");
        btnaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaccionActionPerformed(evt);
            }
        });
        getContentPane().add(btnaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));

        cmbbusqueda.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        cmbbusqueda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbbusquedaItemStateChanged(evt);
            }
        });
        cmbbusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbusquedaActionPerformed(evt);
            }
        });
        getContentPane().add(cmbbusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 200, -1));

        lblbusqueda.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblbusqueda.setText("Empleado");
        getContentPane().add(lblbusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        sueldo.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        sueldo.setText("Sueldo");
        getContentPane().add(sueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        txtsueldo.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        getContentPane().add(txtsueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 120, -1));

        lblempleado.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblempleado.setText("Departamento");
        getContentPane().add(lblempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        cmbcoddepto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbcoddeptoItemStateChanged(evt);
            }
        });
        cmbcoddepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbcoddeptoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbcoddepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 115, -1));

        cmbdepto.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        cmbdepto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbdeptoItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbdepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 200, -1));

        cmbcodpuesto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbcodpuestoItemStateChanged(evt);
            }
        });
        cmbcodpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbcodpuestoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbcodpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 115, -1));

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jButton1.setText("Menú");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbpuestoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbpuestoItemStateChanged

    }//GEN-LAST:event_cmbpuestoItemStateChanged

    private void cmbpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbpuestoActionPerformed
        // TODO add your handling code here:
        //sirve para que al cambiar un combo se cambie el otro automáticamente
        try{
            this.cmbcodpuesto.setSelectedIndex(this.cmbpuesto.getSelectedIndex());
        }catch(Exception e){
        }
    }//GEN-LAST:event_cmbpuestoActionPerformed

    private void cmboperacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmboperacionItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboperacionItemStateChanged

    private void cmboperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboperacionActionPerformed
        // TODO add your handling code here:
        //se oculta lo innecesario, se muestra lo necesario y se cambia el texto al botón
        if (cmboperacion.getSelectedIndex()==1) {
            limpiar();
            lblbusqueda.setVisible(false);
            cmbbusqueda.setVisible(false);
            lblusuario.setVisible(true);
            txtnombre.setVisible(true);
            lblcodigo.setVisible(false);
            txtcod.setVisible(false);
            sueldo.setVisible(true);
            txtsueldo.setVisible(true);
            lblestado.setVisible(true);
            cmbpuesto.setVisible(true);
            lblempleado.setVisible(true);
            cmbdepto.setVisible(true);
            btnaccion.setVisible(true);
            btnaccion.setText("Agregar");
            //se oculta lo innecesario, se muestra lo necesario y se cambia el texto al botón
        }else if (cmboperacion.getSelectedIndex()==2) {
            limpiar();
            lblbusqueda.setVisible(true);
            cmbbusqueda.setVisible(true);
            lblusuario.setVisible(true);
            txtnombre.setVisible(true);
            lblcodigo.setVisible(true);
            txtcod.setVisible(true);
            sueldo.setVisible(true);
            txtsueldo.setVisible(true);
            lblestado.setVisible(true);
            cmbpuesto.setVisible(true);
            lblempleado.setVisible(true);
            cmbdepto.setVisible(true);
            btnaccion.setVisible(false);
            btnaccion.setText("Modificar");
            //se oculta lo innecesario, se muestra lo necesario y se cambia el texto al botón
        }else if (cmboperacion.getSelectedIndex()==3) {
            limpiar();
            lblbusqueda.setVisible(true);
            cmbbusqueda.setVisible(true);
            lblusuario.setVisible(true);
            txtnombre.setVisible(true);
            lblcodigo.setVisible(true);
            txtcod.setVisible(true);
            sueldo.setVisible(true);
            txtsueldo.setVisible(true);
            lblestado.setVisible(true);
            lblempleado.setVisible(true);
            cmbdepto.setVisible(true);
            btnaccion.setVisible(false);
            btnaccion.setText("Eliminar");
            //se oculta lo innecesario, se muestra lo necesario y se cambia el texto al botón
        }else{
            limpiar();
            lblbusqueda.setVisible(false);
            cmbbusqueda.setVisible(false);
            lblcodigo.setVisible(false);
            txtcod.setVisible(false);
            lblusuario.setVisible(false);
            txtnombre.setVisible(false);
            sueldo.setVisible(false);
            txtsueldo.setVisible(false);
            lblestado.setVisible(false);
            cmbpuesto.setVisible(false);
            lblempleado.setVisible(false);
            cmbdepto.setVisible(false);
            cmbcoddepto.setVisible(false);
        }
    }//GEN-LAST:event_cmboperacionActionPerformed

    private void btnaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaccionActionPerformed
        // TODO add your handling code here:
        //se verifica que todo este ingresado y también esté ingresado correctamente
        if (cmboperacion.getSelectedIndex()==1) {
            if (txtnombre.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Debe de ingresar el nombre del empleado");
            }else if (txtsueldo.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Debe de ingresar el sueldo del empleado");
            }else if (cmbpuesto.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog(this, "Debe de seleccionar el puesto");
            }else if (cmbdepto.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog(this, "Debe de seleccionar el departamento");
            }else{
                try{
                    //Conección con la base de datos
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/base_nomina", "root", "");
                    PreparedStatement pst = cn.prepareStatement("insert into empleados values(?,?,?,?,?)");
                    pst.setString(1, String.valueOf(intCod));
                    pst.setString(2, txtnombre.getText().trim());
                    pst.setString(3, txtsueldo.getText().trim());
                    pst.setString(4, String.valueOf(cmbcodpuesto.getSelectedItem()));
                    pst.setString(5, String.valueOf(cmbcoddepto.getSelectedItem()));
                    pst.executeUpdate();
                    intCod++;
                    //se agregan los datos ingresados a la base de datos 
                    JOptionPane.showMessageDialog(this, "Datos ingresados correctamente","ÉXITO",JOptionPane.INFORMATION_MESSAGE);
                    //se llama el método de limpiar para dejar en blanco todo
                    limpiar();
                    //se llama el método para actualizar los combobox
                    actualizarbusqueda();
                }catch (Exception e){
                    System.out.println("le dio un error");
                }
            }
        }else if (cmboperacion.getSelectedIndex()==2) {
            if (JOptionPane.showConfirmDialog(this, "Está seguro de modificar los datos?","MODIFICAR",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
                try {
                    String ID = txtcod.getText().trim();
                    //Conección con la base de datos
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/base_nomina", "root", "");
                    PreparedStatement pst = cn.prepareStatement("update empleados set nombre_emp= ?, sueldo_emp= ?, codigo_puesto= ?, codigo_depto= ? where codigo_emp= " + ID);

                    pst.setString(1, txtnombre.getText().trim());
                    pst.setString(2, txtsueldo.getText().trim());
                    pst.setString(3, cmbcodpuesto.getSelectedItem().toString());
                    pst.setString(4, cmbcoddepto.getSelectedItem().toString());
                    pst.executeUpdate();
                    //se modifican los datos especificados en la base de datos 
                    JOptionPane.showMessageDialog(this, "Datos modificados correctamente","ÉXITO",JOptionPane.INFORMATION_MESSAGE);
                    //se llama el método de limpiar para dejar en blanco todo
                    limpiar();
                    //se llama el método para actualizar los combobox
                    actualizarbusqueda();
                } catch (Exception e) {
                    System.out.println("le dio un pujaso");
                }
            }
        }else if (cmboperacion.getSelectedIndex()==3) {
            if (JOptionPane.showConfirmDialog(this, "Está seguro de eliminar los datos?","MODIFICAR",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
                try {
                    String ID = txtcod.getText().trim();
                    //Conección con la base de datos
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/base_nomina", "root", "");
                    PreparedStatement pst = cn.prepareStatement("delete from empleados where codigo_emp= " + ID);

                    pst.executeUpdate();
                    //se eliminan los datos especificados en la base de datos 
                    JOptionPane.showMessageDialog(this, "Datos eliminados correctamente","ÉXITO",JOptionPane.INFORMATION_MESSAGE);
                    //se llama el método de limpiar para dejar en blanco todo
                    limpiar();
                    //se llama el método para actualizar los combobox
                    actualizarbusqueda();
                } catch (Exception e) {
                    System.out.println("le dio un pujaso");
                }
            }
        }
    }//GEN-LAST:event_btnaccionActionPerformed

    private void cmbbusquedaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbbusquedaItemStateChanged
        // TODO add your handling code here:
        //sirve para la búsqueda
        if (cmbbusqueda.getSelectedIndex()!=0) {
            try{
                //Conección con la base de datos
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/base_nomina", "root", "");
                PreparedStatement pst = cn.prepareStatement("select * from empleados where nombre_emp = ?");
                pst.setString(1,cmbbusqueda.getSelectedItem().toString());
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    //si encuentra lo especificado se muestran los valores obtenidos en pantalla
                    txtcod.setText(rs.getString("codigo_emp"));
                    txtnombre.setText(rs.getString("nombre_emp"));
                    txtsueldo.setText(rs.getString("sueldo_emp"));
                    cmbcodpuesto.setSelectedItem(rs.getString("codigo_puesto"));
                    cmbcoddepto.setSelectedItem(rs.getString("codigo_depto"));
                    btnaccion.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "No encontrado");
                }

            }catch (Exception e){
                //System.out.println("le dio un pujaso");
            }
        }else{
            //se llama el método de limpiar para dejar en blanco todo
            limpiar();
            if (cmboperacion.getSelectedIndex()!=1) {
                btnaccion.setVisible(false);
            }

        }
    }//GEN-LAST:event_cmbbusquedaItemStateChanged

    private void cmbbusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbusquedaActionPerformed

    private void cmbcoddeptoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbcoddeptoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbcoddeptoItemStateChanged

    private void cmbcoddeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbcoddeptoActionPerformed
        // TODO add your handling code here:
        //sirve para que al cambiar un combo se cambie el otro automáticamente
        try{
            this.cmbdepto.setSelectedIndex(this.cmbcoddepto.getSelectedIndex());
        }catch(Exception e){
        }
    }//GEN-LAST:event_cmbcoddeptoActionPerformed

    private void cmbdeptoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbdeptoItemStateChanged
        // TODO add your handling code here:
        //sirve para que al cambiar un combo se cambie el otro automáticamente
        try{
            this.cmbcoddepto.setSelectedIndex(this.cmbdepto.getSelectedIndex());
        }catch(Exception e){
        }
    }//GEN-LAST:event_cmbdeptoItemStateChanged

    private void cmbcodpuestoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbcodpuestoItemStateChanged
        // TODO add your handling code here:
        //sirve para que al cambiar un combo se cambie el otro automáticamente
        try{
            this.cmbdepto.setSelectedIndex(this.cmbcoddepto.getSelectedIndex());
        }catch(Exception e){
        }
    }//GEN-LAST:event_cmbcodpuestoItemStateChanged

    private void cmbcodpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbcodpuestoActionPerformed
        // TODO add your handling code here:
        //sirve para que al cambiar un combo se cambie el otro automáticamente
        try{
            this.cmbpuesto.setSelectedIndex(this.cmbcodpuesto.getSelectedIndex());
        }catch(Exception e){
        }
    }//GEN-LAST:event_cmbcodpuestoActionPerformed

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
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaccion;
    private javax.swing.JComboBox<String> cmbbusqueda;
    private javax.swing.JComboBox<String> cmbcoddepto;
    private javax.swing.JComboBox<String> cmbcodpuesto;
    private javax.swing.JComboBox<String> cmbdepto;
    private javax.swing.JComboBox<String> cmboperacion;
    private javax.swing.JComboBox<String> cmbpuesto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblbusqueda;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JLabel lblempleado;
    private javax.swing.JLabel lblestado;
    private javax.swing.JLabel lblusuario;
    private javax.swing.JLabel sueldo;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtsueldo;
    // End of variables declaration//GEN-END:variables
}
