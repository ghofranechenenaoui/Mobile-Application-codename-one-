/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Ghofrane
 */
public class niveau {
  
    public int   id;
    private SimpleIntegerProperty score;
    private SimpleStringProperty rangeLevel;
    private SimpleIntegerProperty temps;
    private Date dateCreationNiveau ;
    //private HashSet<questions> questions ;
    private evaluation NameEvaluation_id ;
    private int nb;

 

    public niveau() {
    }

  
  
     
      public niveau( int  id,String rangeLevel,int score, int temps, int evaluation) {
        this.id= id;
        this.rangeLevel = new SimpleStringProperty(rangeLevel);
        this.score = new SimpleIntegerProperty(score);
        this.temps = new SimpleIntegerProperty(temps);
        this.NameEvaluation_id = new evaluation(evaluation);
        }
    
  
     public niveau( int id ,int score, String rangeLevel, int temps,int evaluation) {
        this.score =new SimpleIntegerProperty (score);
        this.rangeLevel = new SimpleStringProperty(rangeLevel);
        this.temps = new SimpleIntegerProperty(temps);
        this.NameEvaluation_id = new evaluation(evaluation);
   
    }
        public niveau( int  id, String rangeLevel,int score, int temps) {
                this.id= id;

            this.score =new SimpleIntegerProperty (score);
        this.temps = new SimpleIntegerProperty(temps);
        this.rangeLevel = new SimpleStringProperty(rangeLevel);
    }
     
        
        
       public niveau( int id) {
        this.id = id;
    }
    
    

  

   
    public void setScore(int score) {
        this.score = new SimpleIntegerProperty(score);
    }

    public String getRangeLevel() {
        return rangeLevel.get();
    }

    public void setRangeLevel(String rangeLevel) {
        this.rangeLevel =new SimpleStringProperty(rangeLevel);
    }

    public int getTemps() {
        return temps.get();
    }

    public void setTemps(int temps) {
        this.temps =new SimpleIntegerProperty(temps);
    }
    
     public int getScore() {
        return score.get();
    }

    

    public Date getDateCreationNiveau() {
        return dateCreationNiveau;
    }

    public void setDateCreationNiveau(Date dateCreationNiveau) {
        this.dateCreationNiveau = dateCreationNiveau;
    }
    
    
    
    
     public SimpleIntegerProperty getTempsProperty(){
        return temps;
    }
       public SimpleIntegerProperty getScoreProperty(){
        return score;
    }
        public SimpleStringProperty getRangeLevelProperty(){
        return rangeLevel;
    }   

    public int  getId() {
         return id;
    }


    public void setId(int  id) {
        this.id = id;
    }
   
         
    public Integer getNb() {
        return nb++;
    }
     
      public evaluation getNameEvaluation_id() {
        return NameEvaluation_id;
    }

    public void setNameEvaluation_id(evaluation NameEvaluation_id) {
        this.NameEvaluation_id =NameEvaluation_id;
    }


       @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        return hash;    }
    
      
    @Override
    public String toString() {
        return "niveau{" + "id=" + id + ", score=" + score + ", rangeLevel=" + rangeLevel + ", temps=" + temps + ", dateCreationNiveau=" + dateCreationNiveau + '}';
    }

   
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final niveau other = (niveau) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
   
    
    
}
