/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package árboles.avl;

/**
 *
 * @author
 */
//se crea la clase de nodo
public class Nodo {
    //se declaran las variables a utilizar
    public int intDato, facequilibrio;
    public Nodo nodoIzq,nodoDer;
    
    //se declara la estructura del arbol
    public Nodo(int intDato, Nodo nodoIzq, Nodo nodoDer) {
        this.intDato = intDato;
        this.nodoIzq = nodoIzq;
        this.nodoDer = nodoDer;
        this.facequilibrio=0;
    }
    //método para obtener el dato
    public int getIntDato() {
        return intDato;
    }
    //método para poner el dato
    public void setIntDato(int intDato) {
        this.intDato = intDato;
    }
    //método para obtener el nodo izquierdo
    public Nodo getNodoIzq() {
        return nodoIzq;
    }
    //método para poner el nodo izquierdo
    public void setNodoIzq(Nodo nodoIzq) {
        this.nodoIzq = nodoIzq;
    }
    //método para obtener el nodo derecho
    public Nodo getNodoDer() {
        return nodoDer;
    }
    //método para poner el nodo derecho
    public void setNodoDer(Nodo nodoDer) {
        this.nodoDer = nodoDer;
    }
 
}
