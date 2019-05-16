/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pilas;

import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class Inicio {
    public static Pilas miPila=new Pilas();
    public static String titulo, autor, isbn;
    //método para pedir los datos del libro
    public static void pedirDatos(){
       titulo=JOptionPane.showInputDialog("Ingrese el titulo del libro");
       autor=JOptionPane.showInputDialog("Ingrese el autor del libro");
       isbn=JOptionPane.showInputDialog("Ingrese el el isbn del libro");
    }
    //método para mostrar los encabezados y los datos de la pila
    public static void mostrar(String Tiempo){
       JOptionPane.showMessageDialog(null,Tiempo+ "\nTitulo                 Autor               Isbn                \n"+miPila.Listar()); 
    }
    public static void main(String[] args) {
        
        //miLista.ListasVacia();
        int intop=0;
        do {
            int intdato, intpos;
            //se muestra el menú de opciones que puede escoger
            intop=Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción a realizar\n 1. Salir \n 2. Push"
                    + "\n 3. Pop"
                    + "\n 4. Esta Llena \n 5. Esta vacía \n 6. Top \n 7. Listar \n 8. Vaciar Pila" ));
            switch(intop){
                case 2: pedirDatos();
                        mostrar("Antes:");
                        miPila.push(new Libro(titulo,autor,isbn));
                        mostrar("Después:");
                break;
                case 3: mostrar("Antes:");
                        miPila.pop();
                        mostrar("Después:");
                break;
                case 4: JOptionPane.showMessageDialog(null,"La lista tiene: "+ miPila.estaLlena()+" datos");  
                        mostrar("Actual:");
                break;
                case 5: JOptionPane.showMessageDialog(null,"La lista esta vacía: "+ miPila.estaVacia());
                        mostrar("Actual:");
                break;
                case 6: mostrar("Actual:");
                        JOptionPane.showMessageDialog(null,"El nombre del libro tope de la pila es: "+ miPila.top());
                break;
                case 7: mostrar("Actual:");
                break;
                case 8: mostrar("Antes:");
                        miPila.vaciarPila();
                        mostrar("Después:");
                break;
            }
        } while (intop!=1);
    }
}
