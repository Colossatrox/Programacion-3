/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuralibros;

import javax.swing.JOptionPane;

/**
 *
 * @author Bryan
 */
public class Inicio {
    public static Lista miLista=new Lista();
    public static String titulo, autor, isbn;
    public static void pedirDatos(){
       titulo=JOptionPane.showInputDialog("Ingrese el titulo del libro");
       autor=JOptionPane.showInputDialog("Ingrese el autor del libro");
       isbn=JOptionPane.showInputDialog("Ingrese el el isbn del libro");
    }
    public static void mostrar(){
       JOptionPane.showMessageDialog(null, "Titulo                 Autor               Isbn                \n"+miLista.Listar()); 
    }
    public static void main(String[] args) {
        
        //miLista.ListasVacia();
        int intop=0;
        do {
            int intdato, intpos;
            intop=Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción a realizar\n 1. Salir \n 2. Insertar dato en la primera posición"
                    + "\n 3. Insertar al final \n 4. Borrar el dato en la primera posición \n 5. Borrar último dato \n 6. Borrar dato en posición especificada "
                    + "\n 7. Insertar entre nodos"
                    + "\n 8. Vaciar lista \n 9. Esta vacía \n 10. Longitud de la lista \n 11. Buscar" ));
            switch(intop){
                case 2: pedirDatos();
                        miLista.insertarPrincipio(new Libro(titulo,autor,isbn));
                        mostrar();
                break;
                case 3: pedirDatos();
                        miLista.insertarFinal(new Libro(titulo,autor,isbn));
                        mostrar();
                break;
                case 4: mostrar();
                        miLista.eliminaPrincipio();
                        mostrar();
                break;
                case 5: mostrar();
                        miLista.eliminarUltimo();
                        mostrar();
                break;
                case 6: intdato=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion que desea borrar"));
                        mostrar();
                        miLista.eliminarLibro(intdato);
                        mostrar();
                break;
                case 7: intpos=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion que desea insertar"));
                        pedirDatos();
                        mostrar();
                        miLista.insertarDespues(intpos,new Libro(titulo,autor,isbn));
                        mostrar();
                break;
                case 8: mostrar();
                        miLista.vaciarLista();
                        mostrar();
                break;
                case 9: JOptionPane.showMessageDialog(null,"La lista esta vacía: "+ miLista.estaVacia());
                break;
                case 10: JOptionPane.showMessageDialog(null,"Longitud de la lista: "+ miLista.contar());
                break;
                case 11: intpos=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion que desea buscar"));
                         JOptionPane.showMessageDialog(null,"La posición especificada tiene dirección: "+ miLista.obtener(intpos));
                break;
            }
        } while (intop!=1);
    }
}
