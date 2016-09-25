/* not authorized for copy or distribute or reuse */
package fuzzysemafor;

import java.awt.Color;


/* Tia SHami*/
public class FuzzySemafor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
    int   randomNum = 20 + (int)(Math.random()*40);
    SemaFrame ss = new SemaFrame();
    ss.show();
    
     Fuzzyclass cc=new Fuzzyclass();
     float b= cc.fuzzify2val(50, 34);
     System.out.println(b);
     
     

    }
}

  

       