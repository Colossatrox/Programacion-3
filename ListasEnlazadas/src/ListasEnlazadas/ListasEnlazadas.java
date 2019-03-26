/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasEnlazadas;

/**
 *
 * @author Bryan Orlando Aguirre Sagastume 
 * 0901-17-646
 */
public class ListasEnlazadas
{//se crea el nodo
    	Nodo Primero;
        //método para inicializar la el nodo como nulo
	public ListasEnlazadas()
	{
		Primero=null;
	}
        //revisa si el nodo "Primero" esta vacío y si si devuelve verdadero, de lo contrario falso
	public boolean vacia()
	{
		if (Primero==null)
		{
			return(true);
		} else
		{
			return(false);
		}
	}
        //método para ingresar el dato que se quiera al principio de la lista
	public void InsertarEnPrimero(int Dato)
	{
		Nodo Temporal=new Nodo(Dato); //Crea el nodo temporal
		Temporal.Siguiente=Primero; //corre al primero
		Primero=Temporal;   //lo coloca de primero
	}
        //método para borrar el primer nodo de la lista
	public void borrarPrimero()
	{
		Primero=Primero.Siguiente; //el primer nodo se va a cambiar igualar al nodo siguiente
	}
        //Muestra los datos que contiene la lista
	public String Listar()
	{
		String Dato=" ";
		Nodo aux=Primero;
                //ciclo para obtener los datos que contiene la lista
		while (aux!=null)
		{
			Dato+="{" + aux.info + "}";
			aux=aux.Siguiente;
		}
		return(Dato);
	}
        //método para borrar el útlimo nodo que tiene la lista
	public void borrarUltimo()
	{
		Nodo anterior=Primero;
		Nodo actual=Primero;
                //ciclo para revisar si el nodo siguiente no es vacío
		while (actual.Siguiente!=null)
		{
			anterior=actual;
			actual=actual.Siguiente;
		}
		anterior.Siguiente=null;
	}
        //método para borrar nodo de una posición determinada
	public void borrarPosicion(int pos)
	{
		Nodo anterior=Primero;
		Nodo actual=Primero;
		int k=0;
		if (pos>0)
		{
                    //ciclo para encontrar la posición que se especifico y corre los demás nodos
			while (k!=pos && actual.Siguiente != null)
			{
				anterior=actual;
				actual=actual.Siguiente;
				k++;
				System.out.println("K       "+k);
			}
			anterior.Siguiente=actual.Siguiente;
		}
	}

}
