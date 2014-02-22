
import queues.ArrayQueue;
import queues.CircularArrayQueue;
import queues.QueueADT;

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
    CircularArrayQueue<ArrayQueue> parking;
    ArrayQueue fila;
    
    public Ferry(){
        parking=new CircularArrayQueue<ArrayQueue>();
        
        for (int i = 0; i < 5; i++) {
            fila=new ArrayQueue();
            
            for (int j = 0; j < 50; j++) {
                   fila.enqueue(j);
            }
            parking.enqueue(fila);
        }
        for (int i = 0; i < 5; i++) {
            fila=new ArrayQueue();
            
            for (int j = 0; j < 40; j++) {
                   fila.enqueue(j);
            }
            parking.enqueue(fila);
        }
        
        
    }
   
    public void rellerferry(){
        
    }
    
    public void imprime(){
        QueueADT q=new ArrayQueue();
       
    }
    
}
