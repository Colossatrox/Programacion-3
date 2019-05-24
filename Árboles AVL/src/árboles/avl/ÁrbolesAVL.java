/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package árboles.avl;

import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author Bryan
 */
public class ÁrbolesAVL {

    /**
     * @param args the command line arguments
     */
    ArbolBB miArbol = new ArbolBB();
    public ÁrbolesAVL() {
    }
    
    public boolean insertar(Integer dato) {
        return (this.miArbol.insertar(dato));
    }
    //metodo para obtener el recorrido preorden del arbol
    public String preOrden() {
        LinkedList it = this.miArbol.preOrden();
        return (recorrido(it, "Recorrido PreOrden"));
    }
    //metodo para obtener el recorrido inorden del arbol
    public String inOrden() {
        LinkedList it = this.miArbol.inOrden();
        return (recorrido(it, "Recorrido InOrden"));
    }
    //metodo para obtener el recorrido postorden del arbol
    public String postOrden() {
        LinkedList it = this.miArbol.postOrden();
        return (recorrido(it, "Recorrido PosOrden"));
    }
    
    //metodo para poder mostrar los tipos d recorrido
    private String recorrido(LinkedList it, String msg) {
        int i = 0;
        String r = msg + "\n";
        while (i < it.size()) {
            r += "\t" + it.get(i).toString() + "";
            i++;
        }
        //devuelve el recorrido
        return (r);
    }
    
    
    //Metodo para buscar dato en el nodo
    public String buscar(Integer dato) {
        boolean siEsta = this.miArbol.existe(dato);
        String r = "El dato:" + dato.toString() + "\n";
        r += siEsta ? "Si se encuentra en el arbol" : "No se encuentra en el arbol";
        //devuelve lo encontrado
        return (r);
    }
    //método para obtener el dibujo del arbol
    public JPanel getDibujo() {
        return this.miArbol.getdibujo();
    }
    
}
