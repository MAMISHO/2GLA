
import queues.ArrayQueue;
import queues.CircularArrayQueue;
//import queues.QueueADT;
import queues.*;

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
    ArrayQueue<ArrayQueue> ferries;
    PriorityQueueLinearNode prueba;
    
    
    public Ferry(){//El parking inicia lleno.
        prueba= new PriorityQueueLinearNode();
        parking=new CircularArrayQueue<ArrayQueue>();
        ferries=new ArrayQueue<ArrayQueue>();
        ArrayQueue fila;
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
    
    public void llenarFerries(){
        for (int i = 0; i < 1000; i++) {
            this.rellerferry();
        }
        System.out.println("La cola de ferries es: "+ferries.size());
    }
    
    public void completarParking(){
        ArrayQueue fila;
        if(ferries.isEmpty()){
            
        }
    }
    
    public void rellerferry(){
        ArrayQueue ferry= new ArrayQueue();
        
        while(ferry.size()<219){
            //aqui hay que sacar una fila de coches, y luego meterlas en una cola auxiliar, luego meterla y controlar tamaños.
            //por eso esta implementación falla, arreglar.
            boolean limite=false;
            //System.out.println(parking.size());
            ArrayQueue aux=new ArrayQueue();
            aux=parking.dequeue();
            while(aux.size()>0 && !limite){
                
                
                if(ferry.size()==218){
                    limite=true;
                }
                ferry.enqueue(aux.dequeue());
            }
            //System.out.println("El ferry tiene coches: "+ferry.size());
        }
        System.out.println("El ferry tiene coches: "+ferry.size());
        ferries.enqueue(ferry);
    }
    
    public void imprime(){
        QueueADT q=new ArrayQueue();
        int cont=0;
        while(parking.size()>0){
            ArrayQueue colaAux=new ArrayQueue();
            colaAux=parking.dequeue();
            System.out.println("Se ha desencolado la cola "+cont);
            while(colaAux.size()>0){
                System.out.println(colaAux.dequeue());
            }
            cont++;
        }
    }
    
    public void imprimeFerry(){
        while(ferries.size()>0){
            System.out.println(ferries.dequeue().dequeue());
        }
    }
    
}
