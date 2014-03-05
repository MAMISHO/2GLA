import java.util.Scanner;
import jss2.*;
import stacks.*;

/**
 *
 * @author Edwin Mauricio Quishpe
 * @author Grabriel Valenzuela
 */
public class Simon {

    private StackADT pila;
    private DoubleIndexedList  lista;
    private IndexedListADT<LinkedStack> colores;
    Scanner sc;
    
    public Simon(){
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
        System.out.println("Los colores son");
        System.out.println("Amarillo \t--> 1");
        System.out.println("Azul \t\t--> 2");
        System.out.println("Rojo \t\t--> 3");
        System.out.println("Verde \t\t--> 4");

        while(!falla){
            if(!falla){
                nuevaSecuencia();
            }else{
                System.out.println("¡Game over!");
            }

                falla=comprobarEntrada();
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
            DoubleIterator it= (DoubleIterator)lista.iterator();
            while(it.hasNext()){
                int aux=(int)it.next();
                int resp=usuarioIntroduce();
                if(aux!=resp){
                    System.out.println("¡Game over!");
                    return true;
                }
            }
            System.out.println("Secuencia correcta");
        return false;
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
