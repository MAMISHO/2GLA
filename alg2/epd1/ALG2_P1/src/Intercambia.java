/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import jss2.*;
/**
 *
 * @author MAMISHO
 */
public class Intercambia {
    private UnorderedListADT l1;
    private UnorderedListADT l2;
    
    public Intercambia(){
        l1=new ArrayUnorderedList();
        l2=new ArrayUnorderedList();
    }

    /*public UnorderedListADT getL1() {
        return l1;
    }*/

    public void setL1(int n1) {
        //this.l1 = l1;
        this.l1.addToFront(n1);
    }

    /*public UnorderedListADT getL2() {
        return l2;
    }*/

    public void setL2(int n2) {
        //this.l2 = l2;
        this.l2.addToFront(n2);
    }
    
    //luego hacer todo aqui cuando sea estatico
    public void intercambia(){
        imprimeLista();
        buscaRepetidos();
        imprimeLista();
    }
    
    private void buscaRepetidos(){
        ArrayIterator it1=(ArrayIterator)l1.iterator();
        int repeticiones=0;
        
        while(it1.hasNext()){
            int pos=(int)it1.next();
            boolean encontrado=false;
            ArrayIterator it2=(ArrayIterator)l1.iterator();
            while(it2.hasNext() && !encontrado){
                int aux=(int)it2.next();
                System.out.println("comprar "+pos+" con "+aux);
                if(pos==aux){
                    repeticiones++;
                }
                if(repeticiones>1){
                    encontrado=true;
                    System.out.println("El repetido en la lista es el: "+pos);
                    repeticiones=0;
                    if(l2.contains(pos)){
                        System.out.println("El elemento existe en l2 "+pos);
                    }
                    //it1.remove();
                }
            }
        }
    }
    
    public void imprimeLista(){
        ArrayIterator it=(ArrayIterator)l1.iterator();
        String cadena="\n{";
        while(it.hasNext()){
            cadena+=(int)it.next()+",";
        }
        System.out.println(cadena+"}");
    }
}
