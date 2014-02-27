
import queues.ArrayQueue;
import jss2.*;

/*
 * La forma en la que hemos planteado este ejerciccio es usando la ADT de la cola circular
 * En la cual vamos a simular el parking en el que esperan los coches. De esta forma ya no 
 * nos preocupamos de controlar el final de las filas de los coches que están esperand,
 * y tambin y con eso nos ahorramos un bucle, lo que se resume en un bucle menos.
 */
/**
 *
 * @author EDWIN y Gabri
 */
public class Ferry {

    IndexedListADT<ArrayQueue> parking;
    ArrayQueue<ArrayQueue> ferries;

    public Ferry() {//El parking inicia lleno.
        parking = new DoubleIndexedList();
        ferries = new ArrayQueue<>();
        ArrayQueue fila;
        for (int i = 0; i < 5; i++) {
            fila = new ArrayQueue();

            for (int j = 1; j <= 50; j++) {
                fila.enqueue(j);
            }
            parking.add(fila);
        }
        for (int i = 0; i < 5; i++) {
            fila = new ArrayQueue();

            for (int j = 1; j <= 40; j++) {
                fila.enqueue(j);
            }
//            parking.add(fila);
            parking.add(fila);
            //parking.set(i, fila);
        }

    }

    public int rellenaFerry(int poscont) {
        ArrayQueue ferry = new ArrayQueue();
        //int i = poscont; bucle infinito
        int pos = poscont;
        boolean limite = false;
        while ( !limite) {
            //aqui hay que sacar una fila de coches, y luego meterlas en una cola auxiliar, luego meterla y controlar tamaños.
            //por eso esta implementación falla, arreglar.
            
            // revisar poscont que significa que es la pos desde donde tenemos que cargar los coches
            //
            while (parking.get(pos).size() > 0 && !limite) {

                ferry.enqueue(parking.get(pos).dequeue());
                
                if (ferry.size() > 218) {
                    limite = true;
                    
                }

            }
            System.out.println("\nSeñal indice: " + pos);
            System.out.println("\nTamaño del ferri" + ferry.size());
            if (parking.get(pos).isEmpty()) {
                pos++;
            }
            if (pos > 10) {
                pos = 1;
            }

            
        }
        ferries.enqueue(ferry);
        return pos;
    }

    public void imprime() {
        for (int i = 1; i <= parking.size(); i++) {
            System.out.println("\nFila de " + i);

            while (parking.get(i).size() > 0) {

                System.out.println(parking.get(i).dequeue());
            }
        }
    }

    public void cargarFerries() {
        int poscont = 1;
        for (int i = 0; i < 10; i++) {
            int pos = rellenaFerry(poscont);
            //System.out.println("\nseñal indice cola: "+poscont);
            
            poscont = cargarParking(pos);//esto es lo que pasamos para cargar los ferries desde la posission poscont
        }
        System.out.println("\ntam Ferries: " + ferries.size());
    }

    public int cargarParking(int pos) {
        boolean resta = false;
        if (!parking.get(pos).isEmpty()) {
            pos = pos - 1;
            resta = true;
        }
        if (parking.get(10).isEmpty()){
            cargarFila(10);
        }
        for (int i = 1; i <= pos; i++) {
            if (parking.get(i).isEmpty()) {
                cargarFila(i);
            }
        }
        
        if (resta){
            return pos+1;
        }else{
            return pos;
        }
        
    }

    public void cargarFila(int limite) {
        int tam;
        if (limite < 6) {
            tam = 50;
        } else {
            tam = 40;
        }
        for (int i = 1; i <= tam; i++) {

            parking.get(limite).enqueue(i);
        }
    }

    public void imprimeFerry() {
        while (ferries.size() > 0) {
            ArrayQueue aux = ferries.dequeue();
            System.out.println("Feerie desencola\n");
            while (!aux.isEmpty()) {
                System.out.println(aux.dequeue());
            }
        }
    }
}
