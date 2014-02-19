/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entrega1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MAMISHO
 */
public class Entrega1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List l1=new ArrayList();
        List l2=new ArrayList();
        int tam=10;
        int cont=0;
        
        //Descomentar para ver prueba de fallo
        //l1.add(6);
        //l1.add(7);
        
        for(int i=1;i<=tam;i++){
            
            if(i<=tam/2){
                l2.add(i);
            }
            
            if(i<tam/2){
                l1.add(i);
            }else{
                if(i==tam/2){
                    l1.add(i-cont);
                }else{
                    l1.add(1+i-cont);
                }
                    cont+=2;    
            }
        }
        
        //Descomentar para ver prueba de fallo
        //l1.add(6);
        //l1.add(7);
        
        String cl1="{";
        String cl2="{";
        for(int i=0; i<l1.size();i++){
            cl1+=l1.get(i) + ",";
        }
        for(int i=0; i<l2.size();i++){
            cl2+=l2.get(i) + ",";
        }
        System.out.println("Datos l1: \n"+cl1+"}");
        System.out.println("Datos l2: \n"+cl2+"}");
        
        
        
        System.out.println("Comprobamos");
        
        Compuesta c=new Compuesta(l1, l2);
        if(c.comprobar()){
            System.out.println("SI, esta compuesta");
        }else{
            System.out.println("NO, esta compuesta");
        }
        
    }
    
}
