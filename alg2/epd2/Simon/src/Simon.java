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

    private IndexedListADT<LinkedStack> colores;
    private LinkedStack secuencia;
    Scanner sc;
    
    public Simon(){
        colores=new DoubleIndexedList();
        //ArrayList<StackADT> l=new ArrayList<StackADT>();
        //pila=new ArrayStack();
        secuencia=new LinkedStack();
        LinkedStack pil=new LinkedStack();
        for(int i=0;i<4;i++){
            colores.add(pil);
        }
        sc = new Scanner(System.in);
    }
    
    public void iniciarJuego(){
        boolean falla=false;
        int resp=0;
        //secuenciaInicial();
        int turno=0;
        while(!falla && turno<10){
            if(!falla){
                nuevaSecuencia(turno);
            }else{
                System.out.println("¡Game over!");
            }
            System.out.println("nueva secuencia");
            //resp=usuarioIntroduce();
            resp=1;
            //falla=comprobarEntrada(resp);
            turno++;
            //usuario introduce y comprobar van en otro método en el que pregunta por la secuencia completa            
        }
    }
    
    /*private void secuenciaInicial(){
        int color=nuevoColor();
        pila.push(color);
        muestraColor(color);
        
        color=nuevoColor();
        pila.push(color);
        muestraColor(color);
    }*/
    
    private void nuevaSecuencia(int turno){
        int color=nuevoColor();
        secuencia.push(color);
        System.out.println("tam de la secuencia: "+secuencia.size());
        //System.out.println("Mete en la pila: "+color+" el elemento "+turno);
        colores.get(color).push(turno);
        //System.out.println("****Nueva Secuencia****");
        muestraSecuencia();        
    }
    
    /*private void nuevaSecuencia(){
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
        
    }*/
    
    private boolean comprobarEntrada(int color){
        return false;//true si se equivoca else si esta bien
    }
    
    private int nuevoColor(){
        int nuevoColor=(int) Math.floor(Math.random()*4+1);
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
    
    private void muestraSecuencia(){//turo me indica cuantos colores hay de moento en las pilas
        /*IndexedListADT<LinkedStack> aux=new DoubleIndexedList();
        aux=colores;
        System.out.println("********Nueva Secuencia********");
       for (int j = turno; j>0; j--) {
            //System.out.println("DesAPila :"+j);
            
            for (int i = 0; i < aux.size()+1; i++) {
                
                
                int c=(int)aux.get(i).peek();
                //System.out.println(aux+" no es igual a "+j);
                if(j==c){
                    //System.out.println(aux.get(i).pop());
                    //aux.get(i).pop();
                    muestraColor(i);
                }
            
            }
        }*/
        //System.out.println("Nueva secuencia*****");
        LinkedStack aux=secuencia;
        while(aux.size()>0){
            muestraColor((int)aux.pop());
        }
    }
    
}
