
import queues.ArrayQueue;
import jss2.*;

/**
 *
 * @Autores
 * Edwin Mauricio Quishpe
 * Grabriel Valenzuela
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
            parking.add(fila);
        }

    }

    public int rellenaFerry(int poscont) {
        ArrayQueue ferry = new ArrayQueue();
        
        int pos = poscont;
        boolean limite = false;
        while ( !limite) {

            while (parking.get(pos).size() > 0 && !limite) {

                ferry.enqueue(parking.get(pos).dequeue());
                
                if (ferry.size() > 218) {
                    limite = true;
                    
                }

            }
            //System.out.println("\nSeñal indice: " + pos);
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
        for (int i = 0; i < 1000; i++) {
            int pos = rellenaFerry(poscont);
            poscont = cargarParking(pos);
        }
        System.out.println("\ntam Ferries: " + ferries.size());
    }

    public int cargarParking(int pos) {
        boolean resta=false;
        if (!parking.get(pos).isEmpty()){
            pos = pos - 1;
            resta=true;
        }
        if(parking.get(10).isEmpty()){//comprobamos si no viene de la ultima fila de coches.
                cargarFila(10);
        }
        for (int i = 1; i <= pos; i++) {
            
            if (parking.get(i).isEmpty()) {
                cargarFila(i);
                System.out.println("LLenamos la fila: "+i);
            }
            System.out.println("la fila "+i+" tiene "+parking.get(i).size()+" coches");
        }
        
        if(resta){
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
            System.out.println("Ferie desencola\n");
            while (!aux.isEmpty()) {
                System.out.println(aux.dequeue());
            }
        }
    }
}
