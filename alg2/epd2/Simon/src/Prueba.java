
import jss2.ArrayList;
import jss2.DoubleIndexedList;
import jss2.IndexedListADT;
import jss2.ListADT;
import stacks.LinkedStack;
import stacks.StackADT;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAMISHO
 */
public class Prueba {
   private IndexedListADT<LinkedStack> colores;
   
    public Prueba(){
        colores=new DoubleIndexedList();
        
        
        for(int i=0;i<4;i++){
            LinkedStack pil=new LinkedStack();
            for (int j = 0; j < 10; j++) {
                pil.push(j);
            }
            colores.add(pil);
        }
        
        for (int i = 0; i < colores.size(); i++) {
            System.out.println("Pila :"+i);
            System.out.println(colores.get(i).toString());
            
        }
        for (int j = 9; j>0; j--) {
            System.out.println("DesAPila :"+j);
            
            for (int i = 0; i < colores.size()+1; i++) {
                
                
                int aux=(int)colores.get(i).peek();
                //System.out.println(aux+" no es igual a "+j);
                if(j==aux){
                    System.out.println(colores.get(i).pop());
                }
            
            }
        }
    }
}
