/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solución.parcial;

import javax.swing.JOptionPane;

/**
 *
 * @author Bryan Orlando Aguirre Sagastume
 * 0901-17-646
 * Variante A 
 */
//El programa sirve para manejar el stock de una tienda de comestibles.
public class SoluciónParcial {
    public static double dblTotal=0;
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        String strProductos[][]=new String[10][4];
        
        //Llamada del método de llenado de datos
        LlenadoDatos(strProductos);
        //Llamada del método de total general
        TotalGeneral(strProductos);
        System.out.println("Nombre\t\t\t Precio\t\t\t Cantidad\t\t Total Asociado\n");
        //Ciclo para mostrar la matriz con los productos ingresados
        for (int intCiclo = 0; intCiclo < 10; intCiclo++) {
           System.out.println(strProductos[intCiclo][0]+"\t\t\t"+ strProductos[intCiclo][1]+ "\t\t\t"+ strProductos[intCiclo][2]+ "\t\t\t"+ strProductos[intCiclo][3] +"\n"); 
        }
        //muestra el total general de los productos
        System.out.println("TOTAL GENERAL:  Q"+dblTotal);
    }
    //método para llenar datos
    public static void LlenadoDatos(String [][] strMatriz){
        //llenado de nombres en matriz
        strMatriz[0][0]= "Cereal";
        strMatriz[1][0]= "Huevos";
        strMatriz[2][0]= "Frijol";
        strMatriz[3][0]= "Leche";
        strMatriz[4][0]= "Gas";
        strMatriz[5][0]= "Maseca";
        strMatriz[6][0]= "Salsa";
        strMatriz[7][0]= "Vegetal";
        strMatriz[8][0]= "Frutas";
        strMatriz[9][0]= "Pastas";
        //Ciclo para ingresar el precio de todos los productos
        for (int intCiclo = 0; intCiclo < 10; intCiclo++) {
            strMatriz[intCiclo][1]=JOptionPane.showInputDialog("Ingrese el precio del producto:" +strMatriz[intCiclo][0]);
        }
        //Ciclo para ingresar la cantidad de todos los productos
        for (int intCiclo = 0; intCiclo < 10; intCiclo++) {
            strMatriz[intCiclo][2]=JOptionPane.showInputDialog("Ingrese la cantidad del producto:" +strMatriz[intCiclo][0]);
        }
        //Ciclo para calcular el valor asociado
        for (int intCiclo = 0; intCiclo < 10; intCiclo++) {
            strMatriz[intCiclo][3]=String.valueOf(Double.parseDouble(strMatriz[intCiclo][1])*Integer.parseInt(strMatriz[intCiclo][2]));
        }
    }
    public static double TotalGeneral(String [][] strMatriz){
        //Ciclo para calcular el total de todos los productos ingresados
        for (int intCiclo = 0; intCiclo < 10; intCiclo++) {
            dblTotal+=Double.parseDouble(strMatriz[intCiclo][3]);
        }
        return dblTotal;
    }
}
