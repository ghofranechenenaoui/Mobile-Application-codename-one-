/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Ghofrane
 */
public class questions {
    private int  id;
    private SimpleStringProperty rep1;
    private SimpleStringProperty rep2;
    private SimpleStringProperty rep3;
    private SimpleStringProperty correctReq;
    private SimpleStringProperty description;
    private niveau Niveau_id;
    private evaluation NameEvaluation_id;
    private Date dateCreationQuestion  ;

    public questions() {
    }

    public questions( String description , String rep1, String rep2, String rep3, 
            String correctReq,int Niveau_id ) {
        this.rep1 = new SimpleStringProperty(rep1);
        this.rep2 = new SimpleStringProperty(rep2);
        this.rep3 = new SimpleStringProperty(rep3);
        this.correctReq = new SimpleStringProperty(correctReq);
        this.description = new SimpleStringProperty(description);
        this.Niveau_id = new niveau(Niveau_id) ;

    }
    
      public questions( String description , String rep1, String rep2, String rep3, 
            String correctReq) {
        this.rep1 = new SimpleStringProperty(rep1);
        this.rep2 = new SimpleStringProperty(rep2);
        this.rep3 = new SimpleStringProperty(rep3);
        this.correctReq = new SimpleStringProperty(correctReq);
        this.description = new SimpleStringProperty(description);

    }
    
       public questions( int id) {
        this.id =id;
        

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public niveau getNiveau_id() {
        return Niveau_id;
    }

    public void setNiveau_id(niveau Niveau_id) {
        this.Niveau_id = Niveau_id;
    }

    public evaluation getNameEvaluation_id() {
        return NameEvaluation_id;
    }

    public void setNameEvaluation_id(evaluation NameEvaluation_id) {
        this.NameEvaluation_id = NameEvaluation_id;
    }

   
   
    public String getRep1() {
        return rep1.get();
    }

    public void setRep1(String rep1) {
       this.rep1 = new SimpleStringProperty(rep1);
    }
    
 public SimpleStringProperty getRep1Property(){
        return rep1;
    }
 
 public SimpleStringProperty getRep2Property(){
        return rep2;
    }
 
 public SimpleStringProperty getRep3Property(){
        return rep3;
    }
 
 public SimpleStringProperty getCorrectReqProperty(){
        return correctReq;
    }
  
 public SimpleStringProperty getDescriptionProperty(){
        return description;
    }
 
    public String getRep2() {
        return rep2.get();
    }

    public void setRep2(String rep2) {
        this.rep2 = new SimpleStringProperty(rep2);
    }

    public String getRep3() {
        return rep3.get();
    }

    public void setRep3(String rep3) {
        this.rep3 = new SimpleStringProperty(rep3);
    }

    public String getCorrectReq() {
        return correctReq.get();
    }

    public void setCorrectReq(String correctReq) {
        this.correctReq = new SimpleStringProperty(correctReq);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description = new SimpleStringProperty(description);
    }

    
     public Date getDateCreationQuestion() {
        return dateCreationQuestion;
    }

    public void setDateCreationQuestion(Date dateCreationQuestion) {
        this.dateCreationQuestion = dateCreationQuestion;
    }

   
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
 

    @Override
    public String toString() {
        return "les Questions" + "id=" + id + ", rep1=" + rep1 + ", rep2=" + rep2 + ", rep3=" + rep3 + ", correctReq=" + correctReq + ", description=" + description +" ,  dateCreationQuestion  "+
                dateCreationQuestion+"Niveau_idIndex"+Niveau_id+'}';
    }
    
    
    

    
}
