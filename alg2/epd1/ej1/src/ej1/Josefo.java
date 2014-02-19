/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ej1;

//import jss2.ArrayList;
//import jss2.DoubleIndexedList;
import jss2.*;

/**
 *
 * @author MAMISHO
 */
public class Josefo {
    DoubleIndexedList soldados;
    
    public Josefo(int numero){
        int i;
        soldados=new DoubleIndexedList();
        for(i=1;i<=numero;i++){
            soldados.add(i);
        }
    }
    
    public int matar(int saltos){
        imprimeLista();
        int cont=1;
        int acumulado=0;
        int tam=soldados.size();
        
        while(soldados.size()>0){
            if(cont==tam){
                cont=acumulado;
                acumulado=0;
            }
            if(cont%saltos==0){
                System.out.println("remueve "+soldados.get(cont));
                soldados.remove(cont);
                acumulado=1;
                tam--;
                
            }
            cont ++;
            acumulado++;
            
            //if(acumulado<1){
                this.imprimeLista();
            //}
        }
        return (int)soldados.get(0);
    }
    
    public void imprimeLista(){
        String cadena="";
        DoubleIterator it=(DoubleIterator)soldados.iterator();
        while(it.hasNext()){
            cadena+=","+it.next();
        }
        System.out.println("{"+cadena+"}");
    }
    
}
