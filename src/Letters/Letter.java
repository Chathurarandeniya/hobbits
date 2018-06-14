/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Letters;

import DatabaseClass.DBConnection;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.Random;
/**
 *
 * @author User
 */
public class Letter {
    
    private DBConnection dbManager;
    private char letter;
    private int score;
    private int letterType;
    
    
    Random random = new Random();
    char uniqueLetter;

    public Letter(char letter, int score, int letterType) {
        this.letter = letter;
        this.score = score;
        this.letterType = letterType;
    }
    
    public char[] FirstThreeLetters() {
        char[] firstThreeLetters = new char[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j >= 0; j++) {
                uniqueLetter = (char) (random.nextInt(26) + 'A');
               // System.out.println(uniqueLetter);
                if (firstThreeLetters[0] != uniqueLetter && firstThreeLetters[1] != uniqueLetter && firstThreeLetters[2] != uniqueLetter) {
                    firstThreeLetters[i] = uniqueLetter;
                    break;
                }
            }
        }
       return firstThreeLetters;
    }
    public List<Letter> SelecteSpecial(){
    List<Letter> returnList=null;
        try {
                String query="SELECT letter,score,letterType FROM letter ORDER BY RAND() LIMIT 3";
                ResultSet rst= (ResultSet) dbManager.fetch(query);
                for(int i=0;rst.next();i++){
                    returnList.add(this);
                } 
                
            } catch (Exception ex) {
                Logger.getLogger(Letter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnList;
    }
    
    public Letter SelectVowel(){
        Letter returnObj=null;
        try{
            String query="SELECT letter,score,letterType FROM letter WHERE letterType=1 ORDER BY RAND() LIMIT 1";
            ResultSet rst= (ResultSet) dbManager.fetch(query);
            for(int i=0;rst.next();i++){
                    returnObj = this;
                }           
            
        }catch(Exception ex){
        Logger.getLogger(Letter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnObj;
    }
    
    public Letter SelectConsonants (){
        Letter returnObj=null;
        try{
            String query="SELECT letter,score,letterType FROM letter WHERE letterType=2 ORDER BY RAND() LIMIT 1";
            
        }catch(Exception ex){
        Logger.getLogger(Letter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnObj;
    }
    
}
