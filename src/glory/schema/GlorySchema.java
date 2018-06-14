/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glory.schema;

import Letters.Letter;

/**
 *
 * @author Hashane
 */
public class GlorySchema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Letter letter=new Letter('a', 1, 1);
        System.out.println(letter.FirstThreeLetters()); 
        
    }
    
}
