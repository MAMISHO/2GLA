
import queues.ArrayQueue;
import queues.QueueADT;
import jss2.*;

/*
 * La forma en la que hemos planteado este ejerciccio es usando la ADT de la cola circular
 * En la cual vamos a simular el parking en el que esperan los coches. De esta forma ya no 
 * nos preocupamos de controlar el final de las filas de los coches que están esperand,
 * y tambin y con eso nos ahorramos un bucle, lo que se resume en un bucle menos.
 */

/**
 *
 * @author EDWIN
 */
public class Ferry {
    IndexedListADT<ArrayQueue> parking;
    ArrayQueue<ArrayQueue> ferries;
    
    public Ferry(){//El parking inicia lleno.
        parking=new DoubleIndexedList();
        ferries=new ArrayQueue<>();
        ArrayQueue fila;
        for (int i = 0; i < 5; i++) {
            fila=new ArrayQueue();
            
            for (int j = 0; j < 50; j++) {
                   fila.enqueue(j);
            }
            parking.add(fila);
        }
        for (int i = 0; i < 5; i++) {
            fila=new ArrayQueue();
            
            for (int j = 0; j < 40; j++) {
                   fila.enqueue(j);
            }
//            parking.add(fila);
            parking.add(fila);
            parking.set(i, fila);
        }
        
        
    }
   
    public void rellerferry(){
        ArrayQueue ferry= new ArrayQueue();
        /*int i = 0;
        while(ferry.size()<220){
            //aqui hay que sacar una fila de coches, y luego meterlas en una cola auxiliar, luego meterla y controlar tamaños.
            //por eso esta implementación falla, arreglar.
            boolean limite=false;
            //System.out.println(parking.size());
            
            //aux=parking.getNext();
            while(parking.get(i).size()>0 && !limite){
                
                ferry.enqueue(parking.get(i).dequeue());
                if(ferry.size()==219){
                    limite=true;
                }
            }
            if (parking.get(i).isEmpty()&&i<10){
                i++;
            }
            System.out.println("Entra "+ferry.size());
        }
        ferries.enqueue(ferry);
        //nuevo
        ArrayQueue ferry= new ArrayQueue();*/
        int i=0;
        while(ferry.size()<220){
            //aqui hay que sacar una fila de coches, y luego meterlas en una cola auxiliar, luego meterla y controlar tamaños.
            //por eso esta implementación falla, arreglar.
            boolean limite=false;
            //System.out.println(parking.size());
            
            //ArrayQueue aux=new ArrayQueue();
            //aux=parking.dequeue();
            while(parking.get(i).size()>0 && !limite){
                
                ferry.enqueue(parking.get(i).dequeue());
                if(ferry.size()>=219){
                    limite=true;
                }
            }
            if(parking.get(i).isEmpty()){
                i++;
            }
            System.out.println(ferry.size());
        }
        ferries.enqueue(ferry);
    }
    
    public void imprime(){
        for (int i = 1; i <=parking.size(); i++) {
            System.out.println("\nFila de "+i);
            
            while(parking.get(i).size()>0){
                
                System.out.println(parking.get(i).dequeue());
            }  
        }
    }
    
    public void imprimeFerry(){
        while(ferries.size()>0){
            ArrayQueue aux=ferries.dequeue();
            System.out.println("Feerie desencola\n");
            while(!aux.isEmpty()){
                System.out.println(aux.dequeue());
            }
            
        }
    }
    
}
