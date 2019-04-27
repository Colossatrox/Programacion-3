/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pilas;

/**
 *
 * @author alumno
 */
public class Pilas {
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
        //metodo para ingresar la pila
	public void push(Libro libro) {
		Nodo nodo=new Nodo(libro);  //crea un  nodo con la informacion del libro ingresada
		nodo.siguiente=cabeza; //el siguiente nodo apunta al nodo cabeza
		cabeza=nodo; //cabeza se iguala a nodo
		longitud++;	
	}
        //metodo para mostrar el tope de la pila
	public String top() {
		if (cabeza==null) { //si cabeza esta vacia se iguala al nodo ya creado
			return null;
		} else { //sino se crea otro nodo
			Nodo puntero=cabeza;
			return puntero.libro.getTitulo();
		}
	}
        //metodo para obtener la longitud de la pila
	public int estaLlena() {
		return longitud;//devuelve la logitud de la pila
	}
        public boolean estaVacia() {
            return cabeza==null; //devuelve si la pila está vacía o no
        }
        //metodo para eliminar el tope de la pila
        public void pop() {
            if (cabeza!=null){
                Nodo primer = cabeza;
                cabeza=cabeza.siguiente; //cabeza se iguala al siguiente
                longitud--; //se resta uno a la longitud
            }
        }
        //metodo para ver la pila guardada
        public String Listar()
	{
		String Dato=" ";
		Nodo aux=cabeza;
                //ciclo para obtener los datos que contiene la pila
		while (aux!=null)
		{
			Dato+=(aux.libro.getTitulo()+"                  "+aux.libro.getAutor()+"                  "+aux.libro.getIsbn() + "\n");
			aux=aux.siguiente;
		}
		return(Dato); //Devuelve la información del libro
	}
        //metodo para eliminar pila completa
        public void vaciarPila() {
            if (cabeza!=null){ //Si el nodo cabeza no está vacío
                Nodo primer = cabeza;
                cabeza=cabeza.siguiente=null; //el nodo cabeza se igual al siguiente que se igual como vacío
                longitud--; //se resta uno a la longitud de la lista
            }
        }
}
