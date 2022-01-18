/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import java.util.HashSet;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Ghofrane
 */
public class evaluation {
  private SimpleIntegerProperty  id;
    private Date dateCreationEva;
    private categorie_quiz categorie_quiz;
    private SimpleStringProperty  nb;
    private SimpleStringProperty libelle;
    private SimpleStringProperty descriptionEva;
        public static Integer idc;
    public evaluation() {
    }

    public evaluation( String libelle, String descriptionEva) {
        this.libelle = new SimpleStringProperty(libelle);
        this.descriptionEva = new SimpleStringProperty(descriptionEva);
    }
    
        public evaluation( int id) {
        this.id = new SimpleIntegerProperty(id);
    }
    
    
 

     public evaluation(String libelle) {
                 this.libelle = new SimpleStringProperty(libelle);

    }
     
          public evaluation(String libelle, int nb) {
                 this.libelle = new SimpleStringProperty(libelle);

    }

    public evaluation(int id, String libelle, String descriptionEva) {
        this.id = new SimpleIntegerProperty(id);
        this.libelle = new SimpleStringProperty(libelle);
        this.descriptionEva = new SimpleStringProperty(descriptionEva);
    }

    
    public categorie_quiz getCategorie_quiz() {
        return categorie_quiz;
    }

    public void setCategorie_quiz(categorie_quiz categorie_quiz) {
        this.categorie_quiz = categorie_quiz;
    }
    
    public SimpleStringProperty getlibelleProperty(){
        return libelle;
    }

 
 public SimpleStringProperty getDescriptionEvaProperty(){
        return descriptionEva;
    }
 
  public SimpleIntegerProperty getIDProperty(){
        return id;
    }
   public SimpleStringProperty getNbProperty(){
        return nb;
    }
   
   
   public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public String getLibelle() {
        return libelle.get();
    }

    public void setLibelle(String libelle) {
        this.libelle = new SimpleStringProperty(libelle);
    }

    public Date getDateCreationEva() {
        return dateCreationEva;
    }

    public void setDateCreationEva(Date dateCreationEva) {
        this.dateCreationEva = dateCreationEva;
    }

    public String getDescriptionEva() {
        return descriptionEva.get();
    }

    public void setDescriptionEva(String descriptionEva) {
        this.descriptionEva = new SimpleStringProperty(descriptionEva);
    }

    public String getNb() {
        return nb.get();
    }

    public void setNb(String nb) {
        this.nb = new SimpleStringProperty(nb);
    }
    
   
  



    @Override
    public String toString() {
        return "evaluation{" + "id=" + id + ", libelle=" + libelle + ", dateCreationEva=" + dateCreationEva + ", descriptionEva=" + descriptionEva + '}';
    }

   
       @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + getId();
            return hash;    }
    
    
    
    
    
    
    
    
}
