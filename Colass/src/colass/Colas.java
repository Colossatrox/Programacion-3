/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colass;

/**
 *
 * @author alumno
 */
public class Colas {
    private Nodo cabeza=null;
	private int longitud=0;
        //crear clase de nodo
	private class Nodo {
		public Libro libro;
                //se crea puntero de siguiente 
		public Nodo siguiente=null;
		public Nodo(Libro libro) {
			this.libro=libro;
		}
	}
        //metodo para ingresar la cola
	public void queue(Libro libro) {
		Nodo nodo=new Nodo(libro); //crea un  nodo con la informacion del libro ingresada
		if (cabeza==null) { //si cabeza esta vacia se iguala al nodo ya creado
			cabeza=nodo;
		} else { //sino se crea otro nodo
			Nodo puntero=cabeza;
                        //mientras el siguiente no este vacio el puntero va ir apuntando al siguiente
			while (puntero.siguiente!=null) {
				puntero=puntero.siguiente;
			}
			puntero.siguiente=nodo; //el nodo puntero del siguiente apunta al nodo
		}
		longitud++;	
	}
        //metodo para mostrar el tope de la cola
	public String top() {
		if (cabeza==null) { //si cabeza esta vacia se iguala al nodo ya creado
			return null;
		} else { //sino se crea otro nodo
			Nodo puntero=cabeza;
			return puntero.libro.getTitulo();
		}
	}
        //metodo para obtener la longitud de la cola
	public int estaLlena() {
		return longitud;//devuelve la logitud de la cola
	}
        public boolean estaVacia() {
            return cabeza==null; //devuelve si la cola está vacía o no
        }
        //metodo para eliminar el tope de la cola
        public void dequeue() {
            if (cabeza!=null){
                Nodo primer = cabeza;
                cabeza=cabeza.siguiente; //cabeza se iguala al siguiente
                longitud--; //se resta uno a la longitud
            }
        }
        //metodo para ver la cola guardada
        public String Listar()
	{
		String Dato=" ";
		Nodo aux=cabeza;
                //ciclo para obtener los datos que contiene la cola
		while (aux!=null)
		{
			Dato+=(aux.libro.getTitulo()+"                  "+aux.libro.getAutor()+"                  "+aux.libro.getIsbn() + "\n");
			aux=aux.siguiente;
		}
		return(Dato); //Devuelve la información del libro
	}
        //metodo para eliminar cola completa
        public void vaciarCola() {
            if (cabeza!=null){ //Si el nodo cabeza no está vacío
                Nodo primer = cabeza;
                cabeza=cabeza.siguiente=null; //el nodo cabeza se igual al siguiente que se igual como vacío
                longitud--; //se resta uno a la longitud de la lista
            }
        }
}
