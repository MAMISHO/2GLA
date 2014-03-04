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
        Intercambia i=new Intercambia();
        i.setL1(1);
        i.setL1(2);
        i.setL1(3);
        i.setL1(3);
        i.setL1(4);
        i.setL1(2);
        i.setL1(1);
        i.setL1(5);
        i.setL1(4);
        //elemntos en L2
        i.setL2(1);
        i.setL2(3);
        i.setL2(1);
        i.intercambia();
    }
    
}
