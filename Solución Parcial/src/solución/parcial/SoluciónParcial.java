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
 */
//El programa sirve para manejar el stock de una tienda de comestibles.
public class SoluciónParcial {
    
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        String strProductos[][]=new String[10][4];
        double dblTotal=0;
        //llenado de nombres en matriz
        strProductos[0][0]= "Cereal";
        strProductos[1][0]= "Huevos";
        strProductos[2][0]= "Frijol";
        strProductos[3][0]= "Leche";
        strProductos[4][0]= "Gas";
        strProductos[5][0]= "Maseca";
        strProductos[6][0]= "Salsa";
        strProductos[7][0]= "Vegetal";
        strProductos[8][0]= "Frutas";
        strProductos[9][0]= "Pastas";
        //Ciclo para ingresar el precio de todos los productos
        for (int intCiclo = 0; intCiclo < 10; intCiclo++) {
            strProductos[intCiclo][1]=JOptionPane.showInputDialog("Ingrese el precio del producto:" +strProductos[intCiclo][0]);
        }
        //Ciclo para ingresar la cantidad de todos los productos
        for (int intCiclo = 0; intCiclo < 10; intCiclo++) {
            strProductos[intCiclo][2]=JOptionPane.showInputDialog("Ingrese la cantidad del producto:" +strProductos[intCiclo][0]);
        }
        //Ciclo para calcular el valor asociado
        for (int intCiclo = 0; intCiclo < 10; intCiclo++) {
            strProductos[intCiclo][3]=String.valueOf(Double.parseDouble(strProductos[intCiclo][1])*Integer.parseInt(strProductos[intCiclo][2]));
        }
        //Ciclo para calcular el total de todos los productos ingresados
        for (int intCiclo = 0; intCiclo < 10; intCiclo++) {
            dblTotal+=Double.parseDouble(strProductos[intCiclo][3]);
        }
        System.out.println("Nombre\t\t\t Precio\t\t\t Cantidad\t\t Total Asociado\n");
        //Ciclo para mostrar la matriz con los productos ingresados
        for (int intCiclo = 0; intCiclo < 10; intCiclo++) {
           System.out.println(strProductos[intCiclo][0]+"\t\t\t"+ strProductos[intCiclo][1]+ "\t\t\t"+ strProductos[intCiclo][2]+ "\t\t\t"+ strProductos[intCiclo][3] +"\n"); 
        }
        //muestra el total general de los productos
        System.out.println("TOTAL GENERAL:  Q"+dblTotal);
    }
}
