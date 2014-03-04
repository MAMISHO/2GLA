/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;
import jss2.*;
import stacks.*;

/**
 *
 * @author MAMISHO
 */
public class Simon {
    //creamos 2 tipos de modalidades,
    //1- el modo normal
    //2- nievl ingeniero, consiste en que el orden hay que hacerlo a la inversa.
    //explicamos que es mejor hacerlo con colas, pero queremos complicarnos la vida y hacerlo con pilas
    
    private StackADT pila;
    private DoubleIndexedList  lista;
    Scanner sc;
    
    public Simon(){
        ArrayList<StackADT> l=new ArrayList<StackADT>();
        pila=new ArrayStack();
        lista=new DoubleIndexedList();
        for(int i=0;i<4;i++){
            lista.add(pila);
        }
        sc = new Scanner(System.in);
    }
    
    public void iniciarJuego(){
        boolean falla=false;
        int resp=0;
        //secuenciaInicial();
<<<<<<< HEAD
        int turno=0;
=======
>>>>>>> FETCH_HEAD
        while(!falla){
            if(!falla){
                nuevaSecuencia(turno);
            }else{
                System.out.println("¡Game over!");
            }
<<<<<<< HEAD
            resp=usuarioIntroduce();
            falla=comprobarEntrada(resp);
            turno++;
=======
            //usuario introduce y comprobar van en otro método en el que pregunta por la secuencia completa
            resp=usuarioIntroduce();
            falla=comprobarEntrada(resp);
            //
            
            
>>>>>>> FETCH_HEAD
        }
    }
    
    private void secuenciaInicial(){
        int color=nuevoColor();
        pila.push(color);
        muestraColor(color);
        
        color=nuevoColor();
        pila.push(color);
        muestraColor(color);
    }
    
<<<<<<< HEAD
    private void nuevaSecuencia(int turno){
        int color=nuevoColor();
        StackADT aux=(StackADT)lista.get(color);
        aux.push(turno);
        lista.add(color, aux);
        muestraSecuencia(turno);
=======
    private void nuevaSecuencia(){
        System.out.println("******* Secuencia ********");
        pila.push(nuevoColor());
        StackADT pAux=pila;
        while(!pAux.isEmpty()){
            lista.add(pAux.pop());
        }
        DoubleIterator it= (DoubleIterator)lista.iterator();
        while(it.hasNext()){
            int aux=(int)it.next();
            muestraColor(aux);
        }
        
        /*duerme por un momento y limpiamos la pantalla
        try{          
            Thread.currentThread().sleep(3000);
            //Runtime.getRuntime().exec("command clear");
            for (int i = 0; i < 25; i++) {
                System.out.println(" 1");
            }
          }
          catch(Exception ie){
          
              System.out.println(ie);
          }*/
        
>>>>>>> FETCH_HEAD
    }
    
    private boolean comprobarEntrada(int color){
        return false;//true si se equivoca else si esta bien
    }
    
    private int nuevoColor(){
        int nuevoColor=(int) Math.floor(Math.random()*5+1);
        /*int ultimoColor=0;
        if(pila.size()>0){
            ultimoColor=(int)pila.pop();
            pila.push(ultimoColor);
        }
        
        while(nuevoColor-ultimoColor==0){
            nuevoColor=(int) Math.floor(Math.random()*5+1);
        }*/
        return nuevoColor;
    }
    
    private void muestraColor(int color){
        switch(color){
            case 1:
                System.out.println("Amarillo");
            break;
            case 2:
                System.out.println("Azul");
            break;
            case 3:
                System.out.println("Rojo");
            break;
            case 4:
                System.out.println("Verde");
            break;
        }
    }
    
    private int usuarioIntroduce(){
        int resp=0;
        do{
            System.out.println("introduce el valor de la secuencia");
            resp=sc.nextInt();
            if(resp<1 || resp>4){
                System.out.println("Color invalido");
            }
        }while(resp<1 || resp>4);
        
        return resp;
    }
    
    private void muestraSecuencia(int turno){
        DoubleIndexedList aux=lista;
        while(turno>0){
            int i=0;
            boolean encontrado=false;
            while(i < 4|| !encontrado) {
                if(!((StackADT)aux.get(i)).isEmpty()){
                    StackADT pilaAux=((StackADT)aux.get(i));
                    if(!pilaAux.isEmpty()){
                        if(turno==(int)pilaAux.peek()){
                        muestraColor((int)pilaAux.pop());
                        encontrado=true;

                        }
                    }
                }
                
                i++;
            }
            turno--;   
        }
    }
    
}
