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
    public static String titulo, autor, isbn;
    public static void pedirDatos(){
       titulo=JOptionPane.showInputDialog("Ingrese el titulo del libro");
       autor=JOptionPane.showInputDialog("Ingrese el autor del libro");
       isbn=JOptionPane.showInputDialog("Ingrese el el isbn del libro");
    }
    public static void main(String[] args) {
        Lista miLista=new Lista();
        //miLista.ListasVacia();
        int intop=0;
        do {
            int intdato, intpos;
            intop=Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción a realizar\n 1. Salir \n 2. Insertar dato en la primera posición"
                    + "\n 3. Borrar el dato en la primera posición \n 4. Borrar último dato \n 5. Borrar dato en posición especificada \n 6. Insertar entre nodos"
                    + ""));
            switch(intop){
                case 2: pedirDatos();
                        miLista.insertarPrincipio(new Libro(titulo,autor,isbn));
                        JOptionPane.showMessageDialog(null, "Libros ingresados:\n"+miLista.Listar());
                break;
                case 3: JOptionPane.showMessageDialog(null,"Antes: "+ miLista.Listar());
                        miLista.eliminaPrincipio();
                        JOptionPane.showMessageDialog(null,"Despues: "+ miLista.Listar());
                break;
                case 4: JOptionPane.showMessageDialog(null,"Antes: "+ miLista.Listar());
                        miLista.eliminarUltimo();
                        JOptionPane.showMessageDialog(null,"Despues: "+ miLista.Listar());
                break;
                case 5: intdato=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion que desea borrar"));
                        JOptionPane.showMessageDialog(null,"Antes: "+ miLista.Listar());
                        miLista.eliminarLibro(intdato);
                        JOptionPane.showMessageDialog(null,"Despues: "+ miLista.Listar());
                break;
                case 6: intpos=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion que desea insertar"));
                        pedirDatos();
                        JOptionPane.showMessageDialog(null,"Antes: "+ miLista.Listar());
                        miLista.insertarDespues(intpos,new Libro(titulo,autor,isbn));
                        JOptionPane.showMessageDialog(null,"Despues: "+ miLista.Listar());
                break;
            }
        } while (intop!=1);
    }
}
