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
    public static void pedirDatos(){
       titulo=JOptionPane.showInputDialog("Ingrese el titulo del libro");
       autor=JOptionPane.showInputDialog("Ingrese el autor del libro");
       isbn=JOptionPane.showInputDialog("Ingrese el el isbn del libro");
    }
    public static void mostrar(){
       JOptionPane.showMessageDialog(null, "Titulo                 Autor               Isbn                \n"+miPila.Listar()); 
    }
    public static void main(String[] args) {
        
        //miLista.ListasVacia();
        int intop=0;
        do {
            int intdato, intpos;
            intop=Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción a realizar\n 1. Salir \n 2. Push"
                    + "\n 3. Pop"
                    + "\n 4. Esta Llena \n 5. Esta vacía \n 6. Top \n 7. Listar \n 8. Vaciar Pila" ));
            switch(intop){
                case 2: pedirDatos();
                        miPila.push(new Libro(titulo,autor,isbn));
                        mostrar();
                break;
                case 3: mostrar();
                        miPila.pop();
                        mostrar();
                break;
                case 4: JOptionPane.showMessageDialog(null,"La lista tiene: "+ miPila.estaLlena()+" datos");  
                        mostrar();
                break;
                case 5: JOptionPane.showMessageDialog(null,"La lista esta vacía: "+ miPila.estaVacia());
                        mostrar();
                break;
                case 6: mostrar();
                        JOptionPane.showMessageDialog(null,"El tope de la pila es: "+ miPila.top());
                break;
                case 7: mostrar();
                break;
                case 8: mostrar();
                        miPila.vaciarPila();
                        mostrar();
                break;
            }
        } while (intop!=1);
    }
}
