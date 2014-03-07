/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prueba;
import java.util.*;
/**
 *
 * @author MAMISHO
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List l = new LinkedList();
        for (int i = 0; i < 6; i++) {
            l.add(i);
            
        }
        
        System.out.println(l.get(0) + "  -  "+l.get(1));
    }
    
}
