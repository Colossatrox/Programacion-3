/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoi;

import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class Hanoi {

    /**
     * @param args the command line arguments
     */
    public static Pilas pPilaOrigen=new Pilas();
    public static Pilas pPilaAuxiliar=new Pilas();
    public static Pilas pPilaDestino=new Pilas();
    public static int intCima;
    public static void main(String[] args) {
        int intCantDiscos;
        //se pide al usuario con cuantos discos desea jugar
        intCantDiscos=Integer.parseInt(JOptionPane.showInputDialog("Cuantos discos desea?"));
        //ciclo para agregar la cantidad de discos a la pila de origen
           for (int i = intCantDiscos; i >= 1; i--) {
               pPilaOrigen.Push(i);
           }
        mostrar();
       PasosHanoi(intCantDiscos,1,2,3);
    }     
    //método recursivo para mover los discos 
    public static void PasosHanoi(int Numero, int iOrigen, int iAuxiliar, int iDestino){
        if (Numero==1) {
          //origen a destino
          System.out.println("mover disco de " + iOrigen + " a " + iDestino);
          PushPop(iOrigen,iDestino);
          mostrar();
        }else{
            PasosHanoi(Numero-1,iOrigen,iDestino,iAuxiliar);
            System.out.println("mover disco de " + iOrigen + " a " + iDestino);
            PushPop(iOrigen,iDestino);
            mostrar();
            PasosHanoi(Numero-1,iAuxiliar,iOrigen,iDestino);
            
        }
    }
    //método para sacar los discos de una pila a otra
    public static void PushPop(int iOrigen,int iDestino){
        //si origen es 1 se toma el tope de la pila de origen y se saca
            if (iOrigen==1) {
                intCima=Integer.parseInt(pPilaOrigen.Top());
                pPilaOrigen.Pop();
                //si origen es 2 se toma el tope de la pila de auxiliar y se saca
            }else if (iOrigen==2) {
                intCima=Integer.parseInt(pPilaAuxiliar.Top());
                 pPilaAuxiliar.Pop();
                 //si origen es 3 se toma el tope de la pila de destino y se saca
            }else if (iOrigen==3) {
                intCima=Integer.parseInt(pPilaDestino.Top());
                pPilaDestino.Pop(); 
            }
            //si destino es 1 ingresa a la pila de origen el valor tope obtenido
            if (iDestino==1) {
                pPilaOrigen.Push(intCima);
                //si destino es 2 ingresa a la pila de auxiliar el valor tope obtenido
            }else if (iDestino==2) {
                 pPilaAuxiliar.Push(intCima);
                 //si destino es 3 ingresa a la pila de destino el valor tope obtenido
            }else if (iDestino==3) {
                pPilaDestino.Push(intCima); 
            }
    }
    //método para mostrar los pasos que se dan con los discos
    public static void mostrar(){
        System.out.println("Origen    "+pPilaOrigen.Listar()+ "\nAuxiliar  "+pPilaAuxiliar.Listar()+"\nDestino   "+pPilaDestino.Listar()+"\n"
                + "**************************************************************\n");
        Delay();
    }
    //método para hacer pausas mientras se muestran las torres
    public static void Delay(){
        try{
            //aquí se especifica el tiempo que se desea pausar
            Thread.sleep(5000);
        }catch(InterruptedException e){
        }
    }
}
