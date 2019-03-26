/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasEnlazadas;

import javax.swing.JOptionPane;

/**
 *
 * @author Bryan Orlando Aguirre Sagastume 
 * 0901-17-646
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListasEnlazadas miLista=new ListasEnlazadas();
        miLista.ListasVacia();
        int intop=0;
        do {
            int intdato, intpos;
            intop=Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción a realizar\n 0. Salir \n 1. Ver si la lista es vacía\n 2. Insertar dato en la primera posición"
                    + "\n 3. Borrar el dato en la primera posición \n 4. Borrar último dato \n 5. Borrar dato en posición especificada \n 6. Insertar entre nodos"
                    + "\n 7. Localizar posición de un dato"));
            switch(intop){
                case 1: if (miLista.Esvacia()==true) {
                            JOptionPane.showMessageDialog(null, "Lista Vacia");
                        }else{
                            JOptionPane.showMessageDialog(null, "Lista con datos");
                        }
                    break;
                case 2: intdato=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato que desea "));
                        miLista.InsertarEnPrimero(intdato);
                        JOptionPane.showMessageDialog(null, miLista.Listar());
                break;
                case 3: JOptionPane.showMessageDialog(null,"Antes"+ miLista.Listar());
                        miLista.borrarPrimero();
                        JOptionPane.showMessageDialog(null,"Despues"+ miLista.Listar());
                break;
                case 4: JOptionPane.showMessageDialog(null,"Antes"+ miLista.Listar());
                        miLista.borrarUltimo();
                        JOptionPane.showMessageDialog(null,"Despues"+ miLista.Listar());
                break;
                case 5: intdato=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion que desea borrar"));
                        JOptionPane.showMessageDialog(null,"Antes"+ miLista.Listar());
                        miLista.borrarPosicion(intdato);
                        JOptionPane.showMessageDialog(null,"Despues"+ miLista.Listar());
                break;
                case 6: intdato=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato que desea insertar"));
                        intpos=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion que desea insertar"));
                        JOptionPane.showMessageDialog(null,"Antes"+ miLista.Listar());
                        miLista.InsertarEntreNodos(intdato, intpos);
                        JOptionPane.showMessageDialog(null,"Despues"+ miLista.Listar());
                break;
                case 7: intdato=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato que desea buscar"));
                        JOptionPane.showMessageDialog(null,"Posicion "+ miLista.Localizar(intdato));
                break;
            }
        } while (intop!=0);
    }
    
}
