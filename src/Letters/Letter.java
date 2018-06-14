/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Letters;

import DatabaseClass.DBConnection;
import glory.schema.LetterValueElement;
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
    
    private char letter;
    private int score;
    private int letterType;
    
    
    Random random = new Random();
    char specialLetter;

    public Letter(char letter, int score, int letterType) {
        this.letter = letter;
        this.score = score;
        this.letterType = letterType;
    }
    
    public char[] FirstThreeLetters() {
        char[] firstThreeLetters = new char[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j >= 0; j++) {
                specialLetter = (char) (random.nextInt(26) + 'A');
               
                //if (firstThreeLetters[0] != specialLetter && firstThreeLetters[1] != specialLetter && firstThreeLetters[2] != specialLetter) {
                    firstThreeLetters[i] = specialLetter;
                   // break;
                //}
            }
        }
       return firstThreeLetters;
    }
    public List<LetterValueElement> SelecteSpecial(){
    List<LetterValueElement> returnList=null;
        try {
                DBConnection dbManager=new DBConnection();
                String query="SELECT letter,score,letterType FROM letter ORDER BY RAND() LIMIT 3";
                ResultSet rst= (ResultSet) dbManager.fetch(query);
              //  while(){}
                for(int i=0;rst.next();i++){
                    //LetterValueElement new Letter
               //     returnList.add(this);
                } 
                
            } catch (Exception ex) {
                Logger.getLogger(Letter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnList;
    }
    
    public LetterValueElement SelectVowel(){
        LetterValueElement returnObj=new LetterValueElement();
        try{
            DBConnection dbManager=new DBConnection();
            String query="SELECT letter,score,letterType FROM letter WHERE letterType=1 ORDER BY RAND() LIMIT 1";
            ResultSet rst= (ResultSet) dbManager.fetch(query);
            while(rst.next()){
                LetterValueElement newVowel=new LetterValueElement();
                newVowel.setLetter(rst.getString("letter"));
                newVowel.setScore(rst.getInt("score"));
                newVowel.setLetterType(rst.getString("letterType"));                
                returnObj=newVowel;
            }          
            
        }catch(Exception ex){
        Logger.getLogger(Letter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnObj;
    }
    
    public LetterValueElement SelectConsonants (){
        LetterValueElement returnObj=null;
        try{
            DBConnection dbManager=new DBConnection();
            String query="SELECT letter,score,letterType FROM letter WHERE letterType=2 ORDER BY RAND() LIMIT 1";
            ResultSet rst= (ResultSet) dbManager.fetch(query);
            while(rst.next()){
                LetterValueElement newConsonants=new LetterValueElement();
                newConsonants.setLetter(rst.getString("letter"));
                newConsonants.setScore(rst.getInt("score"));
                newConsonants.setLetterType(rst.getString("letterType"));                
                returnObj=newConsonants;
            } 
            
        }catch(Exception ex){
        Logger.getLogger(Letter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnObj;
    }
    
}
