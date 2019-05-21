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
public class Nodo {
    public int intDato, facequilibrio;
    public Nodo nodoIzq,nodoDer;

    public Nodo(int intDato, Nodo nodoIzq, Nodo nodoDer) {
        this.intDato = intDato;
        this.nodoIzq = nodoIzq;
        this.nodoDer = nodoDer;
        this.facequilibrio=0;
    }

    public int getIntDato() {
        return intDato;
    }

    public void setIntDato(int intDato) {
        this.intDato = intDato;
    }

    public Nodo getNodoIzq() {
        return nodoIzq;
    }

    public void setNodoIzq(Nodo nodoIzq) {
        this.nodoIzq = nodoIzq;
    }

    public Nodo getNodoDer() {
        return nodoDer;
    }

    public void setNodoDer(Nodo nodoDer) {
        this.nodoDer = nodoDer;
    }
 
}
