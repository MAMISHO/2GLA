


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
    private IndexedListADT<LinkedStack> colores;
    Scanner sc;
    
    public SimonBueno(){
        colores=new DoubleIndexedList();
        
        for(int i=0;i<4;i++){
            //System.out.println("Entre "+i+" su tam es "+colores.size());
            
            LinkedStack pil=new LinkedStack();
            //System.out.println(colores.get(0).size());//el indice 0 no cuenta
            colores.add(pil);
        }
        pila=new ArrayStack();
        lista=new DoubleIndexedList();
        sc = new Scanner(System.in);
    }
    
    public void iniciarJuego(){
        boolean falla=false;
        System.out.println("Los colores son");
        System.out.println("Amarillo \t--> 1");
        System.out.println("Azul \t\t--> 2");
        System.out.println("Rojo \t\t--> 3");
        System.out.println("Verde \t\t--> 4");
        //int cont=0;
        //secuenciaInicial();
        while(!falla){
            if(!falla){
                nuevaSecuencia();
            }else{
                System.out.println("¡Game over!");
            }

                falla=comprobarEntrada();
              //  cmp--;
           // }
            
            //
        }
    }
    
    private void nuevaSecuencia(){
        System.out.println("\n\n******* Inicia Secuencia ********\n");
        int color=nuevoColor();
        pila.push(color);
        colores.get(color).push(color);
        
        StackADT pAux=pila;
        while(!pAux.isEmpty()){
            lista.add(pAux.pop());
        }
        
        DoubleIterator it= (DoubleIterator)lista.iterator();
        while(it.hasNext()){
            int aux=(int)it.next();
            muestraColor(aux);
        }
        System.out.println("\n******* Fin Secuencia ********");
    }
    
    private boolean comprobarEntrada(){
        
        /*for (int j = 9; j>0; j--) {
            System.out.println("DesAPila :"+j);
            
            for (int i = 0; i < colores.size()+1; i++) {
                
                int aux=(int)colores.get(i).peek();
                //System.out.println(aux+" no es igual a "+j);
                if(j==aux){
                    System.out.println(colores.get(i).pop());
                }
            
            }
        }
        IndexedListADT<LinkedStack> colAux=new DoubleIndexedList();
        colAux=colores;
        //while(colAux.size()>0){
            for(int i=1;i<5;i++){
                if(!colAux.get(i).isEmpty()){
                    int a=(int)colAux.get(i).peek();
                    if(a==color){
                        colAux.get(i).pop();
                        return false;
                    }
                }
                
                
         //}
            }*/
            DoubleIterator it= (DoubleIterator)lista.iterator();
            while(it.hasNext()){
                int aux=(int)it.next();
                int resp=usuarioIntroduce();
                if(aux!=resp){
                    System.out.println("¡Game over!");
                    return true;
                }
                //muestraColor(aux);
            }
            System.out.println("Secuencia correcta");
        return false;//true si se equivoca else si esta bien
    }
    
    private int nuevoColor(){
        int nuevoColor=(int) Math.floor(Math.random()*4+1);
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
            System.out.println("\nIntroduce el valor de la secuencia");
            resp=sc.nextInt();
            if(resp<1 || resp>4){
                System.out.println("Color invalido");
            }
        }while(resp<1 || resp>4);
        
        return resp;
    }
}
