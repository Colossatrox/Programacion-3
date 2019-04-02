/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuralibros;

/**
 *
 * @author Bryan Orlando
 * Aguirre Sagastume 
 * 0901-17-646
 */
public class Lista {
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
        //metodo para ingresar el nodo al principio
	public void insertarPrincipio(Libro libro) {
		Nodo nodo=new Nodo(libro);  //crea un  nodo con la informacion del libro ingresada
		nodo.siguiente=cabeza; //el siguiente nodo apunta al nodo cabeza
		cabeza=nodo; //cabeza se iguala a nodo
		longitud++;	
	}
        //metodo para ingresar el nodo al final
	public void insertarFinal(Libro libro) {
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
        //metodo para ingresar el nodo en una posicion especificada
	public void insertarDespues(int n, Libro libro) {
		Nodo nodo=new Nodo(libro); //crea un  nodo con la informacion del libro ingresada
		if (cabeza==null) { //si cabeza esta vacia se iguala al nodo ya creado
			cabeza=nodo;
		} else { //sino se crea otro nodo
			Nodo puntero=cabeza;
			int contador=0;
			while (contador<n && puntero.siguiente!=null) { //mientras el contador sea menor a la posicion dada y el siguiente no este vacio
				puntero=puntero.siguiente; //puntero apunta al siguiente
				contador++; //se suma uno al contador
			}
			nodo.siguiente=puntero.siguiente;  
			puntero.siguiente=nodo;
		}
		longitud++;
	}
        //metodo para obtener la direccion de la posicion ingresada
	public Libro obtener(int n) {
		if (cabeza==null) { //si cabeza esta vacia se iguala al nodo ya creado
			return null;
		} else { //sino se crea otro nodo
			Nodo puntero=cabeza;
			int contador=0;
			while (contador<n && puntero.siguiente!=null) { //mientras el contador sea menor a la posicion dada y el siguiente no este vacio
				puntero=puntero.siguiente;
				contador++;
			}
			if (contador!=n) { //si contador no es igual a la posición dada, devuelve nulo
				return null;
			} else { //sino devuelve la direccion del libro de la posicion dada
				return puntero.libro;
			}
		}
	}
        //metodo para obtener la longitud de la lista
	public int contar() {
		return longitud;//devuelve la logitud de la lista
	}
        public boolean estaVacia() {
            return cabeza==null; //devuelve si la lista está vacía o no
        }
        //metodo para eliminar el primer nodo
        public void eliminaPrincipio() {
            if (cabeza!=null){
                Nodo primer = cabeza;
                cabeza=cabeza.siguiente; //cabeza se iguala al siguiente
                longitud--; //se resta uno a la longitud
            }
        }
        //metodo para eliminar el ultimo nodo
        public void eliminarUltimo() {
            if (cabeza!= null) { //si el primero no es vacío
                if (cabeza.siguiente==null) { //si el siguiente no está vacío vuelve vacío el nodo cabeza
                    cabeza=null;  
                    longitud--;  //se resta uno a la longitud
                } else { //si el siguiente si esta vacío
                    Nodo puntero=cabeza;
                    while (puntero.siguiente.siguiente!=null) { //mientras el siguiente del siguiente del nodo puntero no sea nulo
                        puntero=puntero.siguiente; //nodo puntero se igual al siguiente
                    }
                    puntero.siguiente=null;
                    longitud--;  //se resta uno a la longitud
                }
            }
        }
        //metodo para eliminar un libro elegido
        public void eliminarLibro(int n) {
            //si la lista no es vacia
            if (cabeza!=null){
                if (n==0){ //si la posición ingresada es igual a 0
                    Nodo primer=cabeza;
                    cabeza=cabeza.siguiente; //nodo cabeza se iguala al siguiente
                    primer.siguiente=null; 
                    longitud--;//se resta uno a la longitud
                } else if (n<longitud) {
                    Nodo puntero=cabeza;
                    int contador=0;
                    while (contador<(n-1)){ //mientras el contador sea menor a la posicion dada menos 1
                        puntero=puntero.siguiente; //nodo puntero apunta al siguiente
                        contador++;
                    }
                    Nodo temp=puntero.siguiente;
                    puntero.siguiente=temp.siguiente; 
                    temp.siguiente=null;
                    longitud--;//se resta uno a la longitud
                }
            }
        }
        //metodo para ver la lista guardada
        public String Listar()
	{
		String Dato=" ";
		Nodo aux=cabeza;
                //ciclo para obtener los datos que contiene la lista
		while (aux!=null)
		{
			Dato+=(aux.libro.getTitulo()+"                  "+aux.libro.getAutor()+"                  "+aux.libro.getIsbn() + "\n");
			aux=aux.siguiente;
		}
		return(Dato); //Devuelve la información del libro
	}
        //metodo para eliminar el primer nodo
        public void vaciarLista() {
            if (cabeza!=null){ //Si el nodo caeza no está vacío
                Nodo primer = cabeza;
                cabeza=cabeza.siguiente=null; //el nodo cabeza se igual al siguiente que se igual como vacío
                longitud--; //se resta uno a la longitud de la lista
            }
        }
}
