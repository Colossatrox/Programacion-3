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
        intCantDiscos=Integer.parseInt(JOptionPane.showInputDialog("Cuantos discos desea?"));
           for (int i = intCantDiscos; i >= 1; i--) {
               pPilaOrigen.Push(i);
           }
        mostrar();
       PasosHanoi(intCantDiscos,1,2,3);
    }          
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
    public static void PushPop(int iOrigen,int iDestino){
            if (iOrigen==1) {
                intCima=Integer.parseInt(pPilaOrigen.Top());
                pPilaOrigen.Pop();
            }else if (iOrigen==2) {
                intCima=Integer.parseInt(pPilaAuxiliar.Top());
                 pPilaAuxiliar.Pop();
            }else if (iOrigen==3) {
                intCima=Integer.parseInt(pPilaDestino.Top());
                pPilaDestino.Pop(); 
            }
            if (iDestino==1) {
                pPilaOrigen.Push(intCima);
            }else if (iDestino==2) {
                 pPilaAuxiliar.Push(intCima);
            }else if (iDestino==3) {
                pPilaDestino.Push(intCima); 
            }
    }
    public static void mostrar(){
        System.out.println("Origen    "+pPilaOrigen.Listar()+ "\nAuxiliar  "+pPilaAuxiliar.Listar()+"\nDestino   "+pPilaDestino.Listar()+"\n"
                + "**************************************************************\n");
        Delay();
    }
    public static void Delay(){
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
        }
    }
}
