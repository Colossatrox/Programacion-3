/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package departamentalizacionplanilla;

import static departamentalizacionplanilla.Puesto.intCod;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan
 */
public class Departamento extends javax.swing.JFrame {

    /**
     * Creates new form Ingreso_Depto
     */
    public static int intCod=0;
    //método para dejar en blanco los textbox y combobox
    public void limpiar(){
        txtcod.setText("");
        txtdepto.setText("");
    }
    //método para actualizar los combobox donde se hacen las búsquedas
    public void actualizarbusqueda(){
        //quita todos los items que tiene el combo
        cmbbusqueda.removeAllItems();
        cmbbusqueda.addItem("");
        try{
            //Conección con la base de datos
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/base_nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("select nombre_depto from departamentos");
            ResultSet rs = pst.executeQuery();
            //mientras encuentre datos en la tabla y campo especificado
            boolean r=rs.next();
            while(r){
                //se agrega lo encontrado al combo 
                cmbbusqueda.addItem(rs.getString("nombre_depto"));
                r=rs.next();
            }
        }catch (Exception e){
            System.out.println("le dio un pujaso");
        }
    }
    public Departamento() {
        try{
            //Conección con la base de datos
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/base_nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from departamentos");
            ResultSet rs = pst.executeQuery();
            //mientras encuentre datos en la tabla y campo especificado
            boolean r=rs.next();
            while(r){
                //intCod servirá para código automático por lo que se busca el más grande guardado en la base de datos
                if (intCod< Integer.parseInt(rs.getString("codigo_depto"))) {
                    intCod=Integer.parseInt(rs.getString("codigo_depto"));
                }
                r=rs.next();
            }
            intCod++;
            System.out.println(intCod);
        }catch (Exception e){
            System.out.println("le dio un pujaso");
        }
        initComponents();
        actualizarbusqueda();
        lblcodigo.setVisible(false);
        lbldepto.setVisible(false);
        txtcod.setVisible(false);
        txtdepto.setVisible(false);
        btnaccion.setVisible(false);
        lblbusqueda.setVisible(false);
        cmbbusqueda.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        cmboperacion = new javax.swing.JComboBox<>();
        lblcodigo = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        lblbusqueda = new javax.swing.JLabel();
        cmbbusqueda = new javax.swing.JComboBox<>();
        lbldepto = new javax.swing.JLabel();
        txtdepto = new javax.swing.JTextField();
        btnaccion = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DEPARTAMENTOS");
        setPreferredSize(new java.awt.Dimension(400, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setText("Operación");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

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
        getContentPane().add(cmboperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 115, -1));

        lblcodigo.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblcodigo.setText("Código");
        getContentPane().add(lblcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        txtcod.setEditable(false);
        txtcod.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        getContentPane().add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 84, -1));

        lblbusqueda.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblbusqueda.setText("Departamento");
        getContentPane().add(lblbusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

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
        getContentPane().add(cmbbusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 200, -1));

        lbldepto.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbldepto.setText("Departamento");
        getContentPane().add(lbldepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        txtdepto.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        getContentPane().add(txtdepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 200, -1));

        btnaccion.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnaccion.setText("jButton1");
        btnaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaccionActionPerformed(evt);
            }
        });
        getContentPane().add(btnaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, -1));

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jButton1.setText("Menú");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmboperacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmboperacionItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboperacionItemStateChanged

    private void cmboperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboperacionActionPerformed
        // TODO add your handling code here:
        //se oculta lo innecesario, se muestra lo necesario y se cambia el texto al botón
        if (cmboperacion.getSelectedIndex()==1) {
            limpiar();
            lblcodigo.setVisible(false);
            lbldepto.setVisible(true);
            txtcod.setVisible(false);
            txtdepto.setVisible(true);
            btnaccion.setVisible(true);
            lblbusqueda.setVisible(false);
            cmbbusqueda.setVisible(false);
            btnaccion.setText("Agregar");
            //se oculta lo innecesario, se muestra lo necesario y se cambia el texto al botón
        }else if (cmboperacion.getSelectedIndex()==2) {
            limpiar();
            lblcodigo.setVisible(true);
            lbldepto.setVisible(true);
            txtcod.setVisible(true);
            txtdepto.setVisible(true);
            btnaccion.setVisible(false);
            lblbusqueda.setVisible(true);
            cmbbusqueda.setVisible(true);
            btnaccion.setText("Modificar");
            //se oculta lo innecesario, se muestra lo necesario y se cambia el texto al botón
        }else if (cmboperacion.getSelectedIndex()==3) {
            limpiar();
            lblcodigo.setVisible(true);
            lbldepto.setVisible(true);
            txtcod.setVisible(true);
            txtdepto.setVisible(true);
            btnaccion.setVisible(false);
            lblbusqueda.setVisible(true);
            cmbbusqueda.setVisible(true);
            btnaccion.setText("Eliminar");
            //se oculta lo innecesario, se muestra lo necesario y se cambia el texto al botón
        }else{
            limpiar();
            lblcodigo.setVisible(false);
            lbldepto.setVisible(false);
            txtcod.setVisible(false);
            txtdepto.setVisible(false);
            btnaccion.setVisible(false);
            lblbusqueda.setVisible(false);
            cmbbusqueda.setVisible(false);
        }
    }//GEN-LAST:event_cmboperacionActionPerformed

    private void cmbbusquedaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbbusquedaItemStateChanged
        // TODO add your handling code here:
        //sirve para la búsqueda
        if (cmbbusqueda.getSelectedIndex()!=0) {
            try{
                //Conección con la base de datos
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/base_nomina", "root", "");
                PreparedStatement pst = cn.prepareStatement("select * from departamentos where nombre_depto = ?");
                pst.setString(1,cmbbusqueda.getSelectedItem().toString());
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    //si encuentra lo especificado se muestran los valores obtenidos en pantalla
                    txtcod.setText(rs.getString("codigo_depto"));
                    txtdepto.setText(rs.getString("nombre_depto"));
                    btnaccion.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "No encontrado");
                }

            }catch (Exception e){
                //System.out.println("error al agregar al de busqueda");
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

    private void btnaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaccionActionPerformed
        // TODO add your handling code here:
        //se verifica que todo este ingresado y también esté ingresado correctamente
        if (cmboperacion.getSelectedIndex()==1) {
            if (txtdepto.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Debe de ingresar el nombre del departamento");
            }else{
                try{
                    //Conección con la base de datos
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/base_nomina", "root", "");
                    PreparedStatement pst = cn.prepareStatement("insert into departamentos values(?,?)");

                    pst.setString(1, String.valueOf(intCod));
                    pst.setString(2, txtdepto.getText().trim());
                    pst.executeUpdate();
                    intCod++;
                    //se agregan los datos ingresados a la base de datos 
                    JOptionPane.showMessageDialog(this, "Datos ingresados correctamente","ÉXITO",JOptionPane.INFORMATION_MESSAGE);
                    //se llama el método de limpiar para dejar en blanco todo
                    limpiar();
                    //se llama el método para actualizar los combobox
                    actualizarbusqueda();
                }catch (Exception e){
                    System.out.println("error al guardar");
                }
            }
        }else if (cmboperacion.getSelectedIndex()==2) {
            if (JOptionPane.showConfirmDialog(this, "Está seguro de modificar los datos?","MODIFICAR",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
                try {
                    String ID = txtcod.getText().trim();
                    //Conección con la base de datos
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/base_nomina", "root", "");
                    PreparedStatement pst = cn.prepareStatement("update departamentos set nombre_depto= ? where codigo_depto= " + ID);

                    pst.setString(1, txtdepto.getText().trim());
                    pst.executeUpdate();
                    //se modifican los datos especificados en la base de datos 
                    JOptionPane.showMessageDialog(this, "Datos modificados correctamente","ÉXITO",JOptionPane.INFORMATION_MESSAGE);
                    //se llama el método de limpiar para dejar en blanco todo
                    limpiar();
                    //se llama el método para actualizar los combobox
                    actualizarbusqueda();
                } catch (Exception e) {
                    System.out.println("error al modificar");
                }
            }
        }else if (cmboperacion.getSelectedIndex()==3) {
            if (JOptionPane.showConfirmDialog(this, "Está seguro de eliminar los datos?","MODIFICAR",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
                try {
                    String ID = txtcod.getText().trim();
                    //Conección con la base de datos
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/base_nomina", "root", "");
                    PreparedStatement pst = cn.prepareStatement("delete from departamentos where codigo_depto= " + ID);

                    pst.executeUpdate();
                    //se eliminan los datos especificados en la base de datos 
                    JOptionPane.showMessageDialog(this, "Datos eliminados correctamente","ÉXITO",JOptionPane.INFORMATION_MESSAGE);
                    //se llama el método de limpiar para dejar en blanco todo
                    limpiar();
                    //se llama el método para actualizar los combobox
                    actualizarbusqueda();
                } catch (Exception e) {
                    System.out.println("error al eliminar");
                }
            }
        }
    }//GEN-LAST:event_btnaccionActionPerformed

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
            java.util.logging.Logger.getLogger(Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Departamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaccion;
    private javax.swing.JComboBox<String> cmbbusqueda;
    private javax.swing.JComboBox<String> cmboperacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblbusqueda;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JLabel lbldepto;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtdepto;
    // End of variables declaration//GEN-END:variables
}
