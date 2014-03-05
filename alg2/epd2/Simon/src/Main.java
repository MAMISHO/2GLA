
import stacks.ArrayStack;
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Simon s=new Simon();
        //s.iniciarJuego();
        //Prueba p=new Prueba();
        
        SimonBueno s=new SimonBueno();
        s.iniciarJuego();
        
        /*String[] prueba={"holadfgred","asdfasdf"};
        
        for (int i = 0; i < prueba.length; i++) {
            System.out.println(prueba[i]);
        }*/
        
        
        StackADT pila=new ArrayStack();
        pila.push(0);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);
        pila.push(6);
        System.out.println("mide "+pila.size());
        System.out.println(pila.pop());
        System.out.println(pila.pop());
        System.out.println(pila.pop());
        System.out.println(pila.pop());
        System.out.println(pila.pop());
    }
    
}
