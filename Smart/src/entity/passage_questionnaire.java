/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.fosuser;
import java.util.Date;

/**
 *
 * @author Ghofrane
 */
public class passage_questionnaire {
    
    private int  id;
    private Date dateCreationPas;
    private niveau evaluation_idIndex;
    private int num;
    private fosuser User_id;

    public passage_questionnaire() {
    }

    public passage_questionnaire(int id, Date dateCreationPas,niveau evaluation_idIndex) {
        this.id = id;
        this.dateCreationPas = dateCreationPas;
        this.evaluation_idIndex = evaluation_idIndex;

    }
    
       public passage_questionnaire(Date dateCreationPas,niveau evaluation_idIndex,fosuser User_id) {
        this.dateCreationPas = dateCreationPas;
        this.evaluation_idIndex = evaluation_idIndex;
         this.User_id= User_id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public fosuser getUser_id() {
        return User_id;
    }

    public void setUser_id(fosuser User_id) {
        this.User_id = User_id;
    }

   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateCreationPas() {
        return dateCreationPas;
    }

    public void setDateCreationPas(Date dateCreationPas) {
        this.dateCreationPas = dateCreationPas;
    }
    
     public niveau getEvaluation_idIndex() {
        return evaluation_idIndex;
    }

    public void setEvaluation_idIndex(niveau evaluation_idIndex) {
        this.evaluation_idIndex = evaluation_idIndex;
    }


    @Override
    public String toString() {
        return "passage_questionnaire{" + "id=" + id + ", dateCreationPas=" + dateCreationPas + '}';
    }
    
    
}
