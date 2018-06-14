/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glory.schema;

/**
 *
 * @author Hashane
 */
public class WordElement{
    
    private int noOfLetters;
    private boolean valid;

    public WordElement() {
    }
    
    public WordElement(int noOfLetters, boolean valid) {
        this.noOfLetters = noOfLetters;
        this.valid = valid;
    }
      public int getNoOfLetters() {
        return noOfLetters;
    }

    public void setNoOfLetters(int noOfLetters) {
        this.noOfLetters = noOfLetters;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
    
}
