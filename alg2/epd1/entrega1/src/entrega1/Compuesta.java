/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entrega1;

import java.util.List;

/**
 *
 * @author MAMISHO
 */
public class Compuesta {
    List l1;
    List l2;
    
    public Compuesta(List l1, List l2){
        //this.l1=
        this.l1=l1;
        this.l2=l2;
    }
    
    public boolean comprobar(){
        int t1=l1.size();
        int t2=l2.size();
        if(l1.size()/2!=l2.size()){
            return false;
        }
        int tam=l2.size();
        int mitad=tam-1;
        int indice=0;
        int aux,izq,der;
        while(tam>0){
            aux=(int)l2.get(tam-1);
            izq=(int)l1.get(mitad-indice);
            der=(int)l1.get(mitad+indice+1);
            
            if(aux!=izq || aux!=der){
                return false;
            }
            
            tam--;
            indice++;
        }
        return true;
    }
    
}
