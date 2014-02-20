/*
Este ejercicion lo implementamos con la ADT arraList
recibimos dos listas, y hacemos un primer filtro, en el que compriobamos 
que la segunda lista tenga como tamaño la mistad de la primera, ya que si
no lo tiene quiere decir que no se cumpliria el palindromo.

Luego de pasar el filtro vamos iterando(desl final al principio) sobre la segunda lista y 
comparamos sus lementos de la siguiente forma.

L1 {1,2,3,4,5,5,4,3,2,1}
L2 {1,2,3,4,5}
tomamos el ultimo elemento de la lista 2 y comparamos con los elementos 
de la mistad de la lista 1, es decir tamañoLista/2 y tamañoLista/2+1
luego implementamos una variable comodin que nos permite 
ir tanto a la izquierad como a laderecha en cada ieracion en la lista 2
de esta forma si 
no se cumple que un elemento de la lista 2 no es igual alos dos correspondientes 
en la lista 1, el programa devuelve false, y si termina todo el rrecorrido, 
se devuelve true ya que todos cumplieronn la igualdad.

esto cumple con O(n) ya que solo hacemos un bucle y su complejidad es lineal.

 */

package entrega1;

import java.util.ArrayList;
import java.util.List;

/**
 * Autores: Edwin Mauricio Quishpe Maldonado
 *          Grabriel Valenzuela
 */
public class MainCompuesta {

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
