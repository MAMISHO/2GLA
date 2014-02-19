
import java.util.Comparator;
import jss2.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAMISHO
 */
public class Ordena implements Comparator{
    
    @Override
    public int compare(Object o1, Object o2) {
        IndexedListADT l1=(IndexedListADT)o1;
        IndexedListADT l2=(IndexedListADT)o2;
        int exp1=(int)l1.first();
        int exp2=(int)l2.first();
        
        return exp1 - exp2;
    }
}
