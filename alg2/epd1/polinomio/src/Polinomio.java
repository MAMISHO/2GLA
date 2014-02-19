/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAMISHO
 */

import jss2.*;
public class Polinomio {
    IndexedListADT l1;
    IndexedListADT l2=new DoubleIndexedList();
    
    public Polinomio (){
        l1=new DoubleIndexedList();
        l2=new DoubleIndexedList();
        l1.add(0);
        l1.add(0);
    }
    
    public void insertaL2(int base,int exponente){
        int tam=l2.size();
        if(tam>0){//caso en el que no es el primero
            if(exponente<tam){
                l2.add(exponente, base);
            }else if(exponente>tam){
                for (int i = tam; i <= exponente; i++) {
                    if(i==exponente){
                        l2.add(i, base);
                    }else{
                        l2.add(0);
                    }
                }
            }else{
                base=base+(int)l2.get(exponente);
                l2.add(exponente, base);
            }   
        }else{
            for (int i = 0; i <= exponente; i++) {
                    if(i==exponente){
                        l2.add(i, base);
                    }else{
                        l2.add(0);
                    }
                }
        }
    }
    
    public void insertaL1(int base, int exponente){
        int tam=l1.size();
        if(tam>0){//caso en el que no es el primero
            /*if(exponente<tam){
                //l1.remove(exponente);
                l1.add(exponente, base);
                
            }else*/ if(exponente>tam){
                for (int i = tam; i <= exponente; i++) {
                    if(i==exponente){
                        l1.add(base);
                    }else{
                        l1.add(0);
                    }
                }
            }else{
                base=base+(int)l1.get(exponente-1);
                l1.add(exponente-1, base);
            }   
        }else{
            for (int i = 0; i <= exponente; i++) {
                    if(i==exponente){
                        l1.add(base);
                    }else{
                        l1.add(0);
                    }
                }
        }
    }
    
    public void sumaPolinomios(){
        
    }
    
    public void imprime(){
        
        String pol1="{";
        String pol2="{";
        for(int i=0;i<l1.size();i++){
            if(i!=0){
                pol1+=",";
            }
            
            pol1+=l1.get(i);
        }
        
        for(int i=0;i<l2.size();i++){
            if(i!=0){
                pol2+=",";
            }
            
            pol1+=l2.get(i);
        }
        
        System.out.println("Polinomio 1");
        System.out.println(pol1+"}");
        System.out.println("Polinomio 2");
        System.out.println(pol2+"}");
    }
    
}
