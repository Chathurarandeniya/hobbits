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
public class LetterValueElement extends WordElement{

private char letter;
private int letterValue;
private char letterType;

    public LetterValueElement(char letter, int letterValue, char letterType,int noOfLetters, boolean valid) {
        super(noOfLetters,valid);
        this.letter = letter;
        this.letterValue = letterValue;
        this.letterType = letterType;
       
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public void setLetterValue(int letterValue) {
        this.letterValue = letterValue;
    }

    public void setLetterType(char letterType) {
        this.letterType = letterType;
    }

    public char getLetter() {
        return letter;
    }

    public int getLetterValue() {
        return letterValue;
    }

    public char getLetterType() {
        return letterType;
    }
    

    
}
