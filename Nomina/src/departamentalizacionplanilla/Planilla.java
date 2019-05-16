/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package departamentalizacionplanilla;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *Bryan Orlando Aguirre Sagastume
*0901-17-646
*Planilla para calcular el sueldo líquido de trabajadores y obtener los totales devengados por departamento 
 * @author Bryan
 */
public class Planilla extends javax.swing.JFrame {
String strDep[]=new String [9];
String strPlanilla[][]=new String [11][12];
DecimalFormat dfformato = new DecimalFormat("####.##");
int intRandom;
    /**
     * Creates new form Planilla
     */
    public Planilla() {
        //se iguala el vector a 0
        for (int i = 0; i < 5; i++) {
            strDep[i]="0";
        }
        funRegistroEmpleado();
        funOpAfectan();
        funCalcPercepciones();
        funISR();
        funCalcDeducciones();
        funTotalLiquido();
        funTotDepartamento();
        initComponents();
        funMostrarTabla();
        
    }
    //método para registrar el nombre de los empleados, datos aleatoriamente como sueldo y bonificación, así como el departamento al que pertenecen
    public void funRegistroEmpleado(){
        //ciclo para llenar los datos de todos los empleados
        for (int i = 0; i < 10; i++) {
            strPlanilla[i][0]=JOptionPane.showInputDialog("Ingrese el nombre completo de la persona No. "+(i+1));
            strPlanilla[i][1]=String.valueOf((int)(Math.random()*7500)+2500);
            strPlanilla[i][2]=String.valueOf((int)(Math.random()*2250)+250);
            strPlanilla[i][3]=String.valueOf((int)(Math.random()*3500)+500);
            strPlanilla[i][5]=String.valueOf((int)(Math.random()*2000)+1000);
            strPlanilla[i][8]=String.valueOf((int)(Math.random()*5)+1);
        }
    }
    //método para especificar si al empleado le afecta o no el IGSS
    public void funOpAfectan(){
        for (int i = 0; i < 10; i++) {
            int intafecta=0,interror;
            do {
                interror=0;
                //pregunta si afecta o no
                intafecta=Integer.parseInt(JOptionPane.showInputDialog("La persona "+strPlanilla[i][0]+" paga IGSS\n 1)SI\n 2)NO"));
                switch(intafecta){
                    //si si afecta se calcula el IGSS
                    case 1: strPlanilla[i][4]=String.valueOf(dfformato.format(Integer.parseInt(strPlanilla[i][1])*.0483));
                        break;
                        //si no afecta el IGSS se iguala a 0
                    case 2: strPlanilla[i][4]="0";
                        break;
                    default: JOptionPane.showMessageDialog(null, "Debe de seleccionar una opcion valida"); interror=1;
                }
            } while (interror==1);
        }
    }
    //método para calcular todas las percepciones de todos los trabajadores
    public void funCalcPercepciones(){
        for (int i = 0; i < 10; i++) {
            strPlanilla[i][10]=String.valueOf(Integer.parseInt(strPlanilla[i][1])+Integer.parseInt(strPlanilla[i][2])+Integer.parseInt(strPlanilla[i][3]));
        }
    }
    //método para calcular todas las deducciones de todos los trabajadores
    public void funCalcDeducciones(){
        for (int i = 0; i < 10; i++) {
            strPlanilla[i][11]=String.valueOf(Double.parseDouble(strPlanilla[i][4])+Double.parseDouble(strPlanilla[i][5])+Double.parseDouble(strPlanilla[i][6]));
        }
    }
    //método para calcular el ISR de los trabajadores
    public void funISR(){
        for (int i = 0; i < 10; i++) {
            Double dtot1;
            //se obtiene el valor del suelod
            dtot1=Double.parseDouble(strPlanilla[i][1]);
            //si sueldo es menor a 2600 el ISR es igual a 0
            if (dtot1<2600) {
                strPlanilla[i][6]="0";
                //si es entre 2600-5000 se calcula multiplicando por el 3%
            }else if (dtot1<=5000) {
                strPlanilla[i][6]=String.valueOf(dfformato.format(dtot1*.03));
                //si es entre 5000-10000 se calcula multiplicando por el 5%
            }else if (dtot1<=10000) {
                strPlanilla[i][6]=String.valueOf(dfformato.format(dtot1*.05));
                //si es mayor de 10000 se calcula multiplicando por el 10%
            }else{
                strPlanilla[i][6]=String.valueOf(dfformato.format(dtot1*.1));
            }
        }
    }
    //método para calcular el total devengado de cada trabajador
    public void funTotalLiquido(){
        for (int i = 0; i < 10; i++) {
           strPlanilla[i][7]=String.valueOf(Integer.parseInt(strPlanilla[i][10])+Double.parseDouble(strPlanilla[i][11]));
        }
    }
    //método para calcular el total devengado por cada departamento
    public void funTotDepartamento(){
        for (int i = 0; i < 10; i++) {
            if (Integer.parseInt(strPlanilla[i][8])==1) {
                strDep[0]=String.valueOf(dfformato.format(Double.parseDouble(strPlanilla[i][7])+Double.parseDouble(strDep[0])));
            }else if (Integer.parseInt(strPlanilla[i][8])==2) {
                strDep[1]=String.valueOf(dfformato.format(Double.parseDouble(strPlanilla[i][7])+Double.parseDouble(strDep[1])));
            }else if (Integer.parseInt(strPlanilla[i][8])==3) {
                strDep[2]=String.valueOf(dfformato.format(Double.parseDouble(strPlanilla[i][7])+Double.parseDouble(strDep[2])));
            }else if (Integer.parseInt(strPlanilla[i][8])==4) {
                strDep[3]=String.valueOf(dfformato.format(Double.parseDouble(strPlanilla[i][7])+Double.parseDouble(strDep[3])));
            }else{
                strDep[4]=String.valueOf(dfformato.format(Double.parseDouble(strPlanilla[i][7])+Double.parseDouble(strDep[4])));
            }
        }
    }
    //método para mostrar los encabezados de la tabla y todos los datos
    public void funMostrarTabla(){
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            
             strPlanilla,
            new String [] {
                "Nombre", "Sueldo Base", "Bonificación", "Comisión", "IGSS", "Descuento Judicial", "ISR", "Sueldo Liquido", "Departamento"
            }
        ));
        
        DefaultTableModel dtmTabla= new DefaultTableModel(new String[] {"Total por departamento"},0);
        for (int i = 0; i < 5; i++) {
            Object[] obTotal={strDep[i]};
            dtmTabla.addRow(obTotal);
        }
        jTable3.setModel(dtmTabla);
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
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Sueldo Base", "Bonificación", "Comisión", "IGSS", "Descuento Judicial", "ISR", "Sueldo Liquido", "Departamento"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 770, 242));

        jButton1.setText("Realizar de nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, -1, -1));

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"2600-5000", "3"},
                {"5001-10000", "5"},
                {"10001-100000", "10"}
            },
            new String [] {
                "Intervalo de sueldo", "% ISR"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 180, 190, 80));

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Total Departamento"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, 141, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        funRegistroEmpleado();
        funOpAfectan();
        funCalcPercepciones();
        funISR();
        funCalcDeducciones();
        funTotalLiquido();
        funTotDepartamento();
        initComponents();
        funMostrarTabla();
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
            java.util.logging.Logger.getLogger(Planilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Planilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Planilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Planilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Planilla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
