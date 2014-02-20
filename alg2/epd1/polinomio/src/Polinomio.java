/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * Autores: Edwin Mauricio Quishpe
 *          Grabriel Valenzuela
 */

import jss2.*;
public class Polinomio {
    IndexedListADT l1;
    IndexedListADT l2;
    
    public Polinomio (){
        l1=new DoubleIndexedList();
        l2=new DoubleIndexedList();
        //l1.add(0);
        //l1.add(0);
    }
    
    public void insertaL2(int base,int exponente){
        int tam=l2.size();
        if(tam>0){
            if(exponente<tam){
                l2.set(exponente, base);
            }else if(exponente>tam){
                for (int i = tam; i <= exponente; i++) {
                    if(i==exponente){
                        l2.add(base);
                    }else{
                        l2.add(0);
                    }
                }
            }else{
                base=base+(int)l2.get(exponente);
                //l2.set(exponente, base);
            }   
        }else{
            for (int i = 0; i <= exponente; i++) {
                //int igual=i-1;
                    if(exponente==i){
                        l2.add(base);
                    }else{
                        l2.add(0);
                    }
                }
        }
    }
    
    public void insertaL1(int base, int exponente){
        int tam=l1.size();
        if(tam>0){
            if(exponente<tam){
                l1.set(exponente, base);
            }else if(exponente>tam){
                for (int i = tam; i <= exponente; i++) {
                    if(i==exponente){
                        l1.add(base);
                    }else{
                        l1.add(0);
                    }
                }
            }else{
                base=base+(int)l1.get(exponente);
                //l1.set(exponente, base);
            }   
        }else{
            for (int i = 0; i <= exponente; i++) {
                //int igual=i-1;
                    if(exponente==i){
                        l1.add(base);
                    }else{
                        l1.add(0);
                    }
                }
        }
    }
    
    public void sumaPolinomios(){
        String result="{";
        String poli="";
        int tam1=l1.size();
        int tam2=l2.size();
        
        if(tam1<tam2){
            for (int i = 1; i <=tam2; i++) {
                int aux=0;
                if(tam1<=i){
                    aux=(int)l1.get(i)+(int)l2.get(i);
                }else{
                    aux=(int)l2.get(i);
                }
                //l2.set(i, aux);
                result+=aux+",";
                if(aux!=0){
                    poli+=aux;
                    if(i>1){
                        poli+="x"+i;
                    }
                    if(i!=tam1){
                        poli+="+";
                    }
                }
            }
        }else{
            for (int i = 1; i <=tam1; i++) {
                int aux=0;
                if(i<=tam2){
                aux=(int)l1.get(i)+(int)l2.get(i);
                }else{
                    aux=(int)l1.get(i);
                }
                //l1.set(i, aux);
                result+=aux+",";
                if(aux!=0){
                    poli+=aux;
                    if(i>1){
                        poli+="x^"+i;
                    }
                    if(i!=tam1){
                        poli+="+";
                    }
                }
            }
        }

        System.out.println("Resultado :"+result+"}");
        System.out.println(poli);
    }
    
    public void imprime(){
        
        String pol1="{";
        String pol2="{";
        for(int i=1;i<=l1.size();i++){
            if(i!=1){
                pol1+=",";
            }
            
            pol1+=l1.get(i);
        }
        
        for(int i=1;i<=l2.size();i++){
            if(i!=1){
                pol2+=",";
            }
            
            pol2+=l2.get(i);
        }
        
        System.out.println("Polinomio1:"+pol1+"}");
        System.out.println("Polinomio2:"+pol2+"}");
    }
    
}
