/*
 * Suma de polinomios:
    Supongo dos fromas de hacerlo:
    primera forma: ADT Indexlist.
Consiste en que la base sea posicionada en el orden de su exponente. Ejemplo
si el usuario quiere representar 7x^+10x+3 (en el indice 0 se colocara al termino independiente)
Los datos de entrada son "base" y "exponente"
    en los dos casos(entradas del polinomio 1 y 2), distingo si es la primea vez y si
la lista ya contiene elementos.

Priemera vez: En este caso hago un bucle y como limite uso el exponente que me pasan por parametros,
Como se que el usuario quiere representar 7x5, metemos "0" en los indices menores a 5, por lo que
la lista hasta el moemnto nos quedaría {0,0,0,0,0,7}

No es la primera vez: En este caso tenemos en cuenta dos distinciones más, si el exponente que nos 
pasan es menor, mayor o igual al tamaño.
Ìndice menor al tamaño: Este caso es simple, como sabemos que el indice ya existe, insertamos la base
en el orden del exponente.

Índice mayor al tamaño: Ahora sabemos que el indice que expresa el exponente aún no existe, por lo tanto lo
vamos a crear, sabemos que ya no tenemos que iterar por toda la lista, así que comenazamos por el final y como limite usamos el exponente,
de la misma forma insertamos "0" excepto en el final que es donde metemos la base.

Índice igual al tamaño: Tambíen es simple, ademas solucionamos un caso en el que el usuario inserte un vector extendido,
es decir que hay bases del mismo exponente, asi que se susman los elementos de la misma base.
Luego, como sabemos que el indice existe, sumamos la base con el valor que tengo el elemento en la lista.

De esta forma tratamos también la segunda lista.

Ahora para realizar la suma, iteramos sobre el de mayor tamaño y vamos realizando la suma

Inconvenientes: El inconveniente esta en el derroche de memoeria y tiempo, en el caso en el que el usuario
quiera lo siguiente 2x^999999+ 3x^+5, para esos tres elementos vamos a tener una lista inmensa y su 
iteración supone mas tiempo, por lo que 
planteamos otra solucion que corrige el problema.

Segunda forma: ADT ArrayOrderedList e IndexedList
De la misma forma solicitamos base y exponente, luego creamos un indexdlist de tres elementos
los cuales son exponente, base(polinomio 1), base(polinimio 2), en el contructor se inicializan a 0

Inserta primer polinomio: vamos insertando en la priemra posición de la lista el exponete, seguido de 
la base del primer polinomio, ahora se añade el indexedlist al ArrayOrderedList.

Inserta el segundo polinomio: Ahora simplemente comprobamos que el exponente exista o no en la lista ordenanda
Existe: en este caso accedemos a su posición(haciendo uso de un iterator, ya que no podemos hacerlo por inidice)
y colocamos la base en la tercera posición de la lista indexada que conteien la lista ordenada.

No existe: se crea la lista indexada y se coloca la base en la tercera posición, y en la primera dejamos el exponente,
ahora añadimos la lista indexada a la ordenada.

Como sabemos que es una lista ordenada, ya no necesitamos preocuparnos de tener espacios con 0, por lo que es una mejor opcion, 
y nos ahora espacio en memoria, pero tambien mejora los recorridos al realizar la suma, ya que para la misma lo que hacemos es
usar un iterator y sumar las posiciones 2 y 3 de cada indexedlist.

inconvenientes: El inconveniente es que al tener una lista ordenada es necesario indicarle el orden que van a tener
sus elementos, por lo que necesitamos crear un comparator, lo intentamos, pero no fuimos capaces de modificar las ADT que 
nos sumisnistraron para realizar los ejercicios, por lo que potamos por la primera forma.

Tmabién sabemos que no era necesario un lista ordenada y que lo podíamos hacer con un lista indexada que contendría 
a listas indexadas de tres elementos, pero la lsita iba a estar desordenada, y teniamos que implememntar un algoritmo
de ordenación, llegamos a la conculsión de que ese no es el objetivo de los ejercicios, si no que es que trabajemos
con listas y resolver problemas con los elementos que tenemos, por lo cual descartamos posisbilidades como el crearnos
un clase que le llamaba elementnPolinomio el cual contiene los atributos exponente y base y ademas le podíamos
dar un orden implementando la interfaz comparable.
 */



/**
 *
 * Autores: Edwin Mauricio Quishpe Maldonado
 *          Grabriel Valenzuela
 */
public class MainPolinomio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Polinomio p=new Polinomio();
        p.insertaL1(4, 6);
        p.insertaL1(3, 11);
        p.insertaL1(9, 3);
        p.insertaL1(2, 9);
        p.insertaL1(6, 1);
        p.insertaL1(8, 0);
        
        p.insertaL2(2, 2);
        p.insertaL2(5, 1);
        p.insertaL2(1, 1);
        p.insertaL2(3, 5);
        
        
        p.imprime();
        
        p.sumaPolinomios();
    }
    
}
