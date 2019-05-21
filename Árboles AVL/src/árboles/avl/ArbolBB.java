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
 * @author .
 */

public class ArbolBB {
    //se declara el nodo, numero de nodos y la altura
    private Nodo nodoRaiz;
    int intCantNodos;
    int intAlturaArbol;

    public ArbolBB() {
        nodoRaiz = null;
    }
    public int obtenerfe(Nodo r){
        //si el nodo esta vacío devuelve -1
        if(r==null){
            return -1;
        //si no está vacío devuelve el factor de equilibrio
        }else{
            return r.facequilibrio;
        } 
    }
    //método para rotar el nodo a la izquierda
    public Nodo rotacionIzq(Nodo r){
        //se hace un nodo auxiliar que se iguala al nodo izquierdo
        Nodo aux= r.nodoIzq;
        //nodo izquierdo se iguala a la parte derecha del nodo auxiliar
        r.nodoIzq=aux.nodoDer;
        //la parte derecha del nodo auxiliar se iguala al nodo mandado al método
        aux.nodoDer=r;
        //se saca el factor de equilibrio máximo del nodo r entre la parte derecha e izquierda
        r.facequilibrio=Math.max(obtenerfe(r.nodoIzq), obtenerfe(r.nodoDer))+1;
        //se saca el factor de equilibrio máximo del nodo auxiliar entre la parte derecha e izquierda
        aux.facequilibrio=Math.max(obtenerfe(aux.nodoIzq),obtenerfe(aux.nodoDer))+1;
        //devuelve auxiliar
        return aux;
    }
    //método para rotar el nodo a la izquierda
    public Nodo rotacionDer(Nodo r){
        //se hace un nodo auxiliar que se iguala al nodo derecho
        Nodo aux= r.nodoDer;
        //nodo derecho se iguala a la parte izquierda del nodo auxiliar
        r.nodoDer=aux.nodoIzq;
        //la parte izquierda del nodo auxiliar se iguala al nodo mandado al método
        aux.nodoIzq=r;
        //se saca el factor de equilibrio máximo del nodo r entre la parte derecha e izquierda
        r.facequilibrio=Math.max(obtenerfe(r.nodoIzq), obtenerfe(r.nodoDer))+1;
        //se saca el factor de equilibrio máximo del nodo auxiliar entre la parte derecha e izquierda
        aux.facequilibrio=Math.max(obtenerfe(aux.nodoIzq),obtenerfe(aux.nodoDer))+1;
        //devuelve auxiliar
        return aux;
    }
    //método para rotar doblemente el nodo a la izquierda
    public Nodo rotacionDobleIzq(Nodo r){
        //se crea nodo auxiliar
        Nodo aux;
        //la parte izquierda del nodo r se iguala al resultado de llamar al método de rotar a la derecha
        //mandando de parámetro el lado izquierdo del nodo r
        r.nodoIzq=rotacionDer(r.nodoIzq);
        //el nodo auxiliar se iguala al resultado de llamar al método de rotar a la izquierda del nodo r
        aux=rotacionIzq(r);
        //devuelve auxiliar
        return aux;
    }
    public Nodo rotacionDobleDer(Nodo r){
        //se crea nodo auxiliar
        Nodo aux;
        //la parte derecha del nodo r se iguala al resultado de llamar al método de rotar a la izquierda
        //mandando de parámetro el lado derecho del nodo r
        r.nodoDer=rotacionIzq(r.nodoDer);
        //el nodo auxiliar se iguala al resultado de llamar al método de rotar a la derecha del nodo r
        aux=rotacionDer(r);
        //devuelve auxiliar
        return aux;
    }
    public Nodo insertAVL(Nodo nuevo, Nodo actual){
        //se crea nodo auxiliar y se iguala a 
        Nodo auxiliar=actual;
        //si el dato del nodo nuevo es menor al dato del nodo actual
         if(nuevo.intDato<actual.intDato){
             //si el nodo actual no tiene parte izquierda entonces se inserta el nodo
             //nuevo en la parte izquierda del nodo actual
            if(actual.nodoIzq==null){
                actual.nodoIzq=nuevo;
            //sino
            }else{
                //la parte izquierda del nodo actual se iguala al resultado de llamar el método de insertarAVL
                //mandando como parámetro el valor nuevo y la parte izquierda del nodo actual
                actual.nodoIzq=insertAVL(nuevo, actual.nodoIzq);
                //si el factor de equilibrio de el lado izquierdo con el derecho es igual a 2
                if(obtenerfe(actual.nodoIzq)-obtenerfe(actual.nodoDer)==2){
                    //si el dato del nodo nuevo es menor al dato de la parte izquierda del nodo actual
                    if(nuevo.intDato<actual.nodoIzq.intDato){
                        //auxiliar se iguala al resutltado de enviar el nodo actual en el método de rotación de izquierda
                        auxiliar=rotacionIzq(actual);
                    }else{
                        //auxiliar se iguala al resutltado de enviar el nodo actual en el método de rotación doble de izquierda
                        auxiliar=rotacionDobleIzq(actual);
                    }
                }
            }
            //si el dato del nodo nuevo es menor al dato del nodo actual
         }else if(nuevo.intDato>actual.intDato){
             //si el nodo actual no tiene parte derecha entonces se inserta el nodo
             //nuevo en la parte derecha del nodo actual
            if(actual.nodoDer==null){
                actual.nodoDer=nuevo;
            //sino
            }else{
                //la parte derecha del nodo actual se iguala al resultado de llamar el método de insertarAVL
                //mandando como parámetro el valor nuevo y la parte derecha del nodo actual
                actual.nodoDer=insertAVL(nuevo,actual.nodoDer);
                //si el factor de equilibrio de el lado derecho con el izquierdo es igual a 2
                if(obtenerfe(actual.nodoDer)-obtenerfe(actual.nodoIzq)==2){
                    //si el dato del nodo nuevo es mayor al dato de la parte derecha del nodo actual
                    if(nuevo.intDato>actual.nodoDer.intDato){
                        //auxiliar se iguala al resutltado de enviar el nodo actual en el método de rotación de derecha
                        auxiliar=rotacionDer(actual);
                    }else{
                        //auxiliar se iguala al resutltado de enviar el nodo actual en el método de rotación doble de derecha
                        auxiliar=rotacionDobleDer(actual);
                    }
                }
            }
            //de lo contrario se muestra de que no se pueden colocar nodos duplicados
         }else{
            System.out.println("Nodo duplicado, no se puede colocar nodos duplicados");
         }
         //actualizando altura
         //si la parte izquierda del nodo actual está vacía y la parte derecha del nodo actual no está vacía
         if((actual.nodoIzq==null)&&(actual.nodoDer!=null)){
             //el factor de equilibrio es igual al factor de equilibrio de la parte derecha del nodo actual +1
            actual.facequilibrio=actual.nodoDer.facequilibrio+1;
        //si la parte derecha del nodo actual está vacía y la parte izquierda del nodo actual no está vacía
         }else if((actual.nodoDer==null)&&(actual.nodoIzq!=null)){
             //el factor de equilibrio es igual al factor de equilibrio de la parte izquierda del nodo actual +1
            actual.facequilibrio=actual.nodoIzq.facequilibrio+1;         
         }else{
             //el factor de equilibrio es igual valor máximo del valor de equilibrio entre la parte izquierda y la parte derecha
            actual.facequilibrio=Math.max(obtenerfe(actual.nodoIzq),obtenerfe(actual.nodoDer))+1;         
         }
         //devuleve auxiliar
         return auxiliar;
    }
    public boolean insertar(int d){
        Nodo nuevo= new Nodo(d,null,null);
        //si la raiz esta vacía
        if(nodoRaiz==null){
            //se ingresa el nodo nuevo en la raíz
            nodoRaiz=nuevo;
        }else{
            //sino en la raiz se inserta lo obtenido de llamar el método de insertarAVL mandando como parámetro el 
            //valor nuevo y la raiz
            nodoRaiz=insertAVL(nuevo,nodoRaiz);
        }
        //devuelve verdadero
        return true;
    }
    //método para obtener la raíz del arbol
    public Nodo getNodoRaiz() {
        return nodoRaiz;
    } 
    //método para cambiar la raíz
    public void setNodoRaiz(Nodo nodoRaiz) {
        this.nodoRaiz = nodoRaiz;
    }

    //Recorrido preorden, recibe el nodo a empezar (nodoRaiz) y una linkedlist para ir guardando el recorrido
    public LinkedList preOrden() {
        LinkedList rec = new LinkedList();
        preorden(nodoRaiz, rec);
        return rec;
    }
    
    public void preorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            recorrido.add(aux.getIntDato());
            preorden(aux.getNodoIzq(), recorrido);
            preorden(aux.getNodoDer(), recorrido);
        }
    }

    //Recorrido inorden, recibe el nodo a empezar (nodoRaiz) y una linkedlist para ir guardando el recorrido
    public LinkedList inOrden() {
        LinkedList rec = new LinkedList();
        inorden(nodoRaiz, rec);
        return rec;
    }
    
    public void inorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            inorden(aux.getNodoIzq(), recorrido);
            recorrido.add(aux.getIntDato());
            inorden(aux.getNodoDer(), recorrido);
        }
    }

    //Recorrido postorden, recibe el nodo a empezar (nodoRaiz) y una linkedlist para ir guardando el recorrido
    public LinkedList postOrden() {
        LinkedList rec = new LinkedList();
        postorden(nodoRaiz, rec);
        return rec;
    }
    public void postorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            postorden(aux.getNodoIzq(), recorrido);
            postorden(aux.getNodoDer(), recorrido);
            recorrido.add(aux.getIntDato());
        }
    }

    //Metodo para verificar si hay un nodo en el arbol
    public boolean existe(int dato) {
        Nodo aux = nodoRaiz;
        while (aux != null) {
            if (dato == aux.getIntDato()) {
                return true;
            } else if (dato > aux.getIntDato()) {
                aux = aux.getNodoDer();
            } else {
                aux = aux.getNodoIzq();
            }
        }
        return false;
    }

     public JPanel getdibujo() {
        return new ArbolExpresionGrafico(this);
    }
}
