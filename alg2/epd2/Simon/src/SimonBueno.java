


import java.util.Scanner;
import jss2.*;
import stacks.*;

/**
 *
 * @author MAMISHO
 */
public class SimonBueno {
    //creamos 2 tipos de modalidades,
    //1- el modo normal
    //2- nievl ingeniero, consiste en que el orden hay que hacerlo a la inversa.
    //explicamos que es mejor hacerlo con colas, pero queremos complicarnos la vida y hacerlo con pilas
    
    private StackADT pila;
    private DoubleIndexedList  lista;
    private IndexedListADT colores;
    Scanner sc;
    
    public SimonBueno(){
        colores=new DoubleIndexedList();
        
        for(int i=0;i<4;i++){
            LinkedStack pil=new LinkedStack();
            colores.add(pil);
        }
        pila=new ArrayStack();
        lista=new DoubleIndexedList();
        sc = new Scanner(System.in);
    }
    
    public void iniciarJuego(){
        boolean falla=false;
        int resp=0;
        //secuenciaInicial();
        while(!falla){
            if(!falla){
                nuevaSecuencia();
            }else{
                System.out.println("¡Game over!");
            }
            //usuario introduce y comprobar van en otro método en el que pregunta por la secuencia completa
            resp=usuarioIntroduce();
            falla=comprobarEntrada(resp);
            //
            
            
        }
    }
    
    private void secuenciaInicial(){
        int color=nuevoColor();
        pila.push(color);
        muestraColor(color);
        
        color=nuevoColor();
        pila.push(color);
        muestraColor(color);
    }
    
    private void nuevaSecuencia(){
        System.out.println("******* Secuencia ********");
        pila.push(nuevoColor());
        StackADT pAux=pila;
        while(!pAux.isEmpty()){
            lista.add(pAux.pop());
        }
        DoubleIterator it= (DoubleIterator)lista.iterator();
        while(it.hasNext()){
            int aux=(int)it.next();
            muestraColor(aux);
        }
        
    }
    
    private boolean comprobarEntrada(int color){
        return false;//true si se equivoca else si esta bien
    }
    
    private int nuevoColor(){
        int nuevoColor=(int) Math.floor(Math.random()*5+1);
        return nuevoColor;
    }
    
    private void muestraColor(int color){
        switch(color){
            case 1:
                System.out.println("Amarillo");
            break;
            case 2:
                System.out.println("Azul");
            break;
            case 3:
                System.out.println("Rojo");
            break;
            case 4:
                System.out.println("Verde");
            break;
        }
    }
    
    private int usuarioIntroduce(){
        int resp=0;
        do{
            System.out.println("introduce el valor de la secuencia");
            resp=sc.nextInt();
            if(resp<1 || resp>4){
                System.out.println("Color invalido");
            }
        }while(resp<1 || resp>4);
        
        return resp;
    }
}
