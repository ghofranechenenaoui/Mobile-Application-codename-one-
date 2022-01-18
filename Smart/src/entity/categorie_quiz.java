/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.HashSet;
import java.util.Date;


import com.codename1.l10n.SimpleDateFormat;
/**
 *
 * @author Ghofrane
 */
public class categorie_quiz {
    private int  id;
    private String libelle;
    private String dateCreationCat;

    public categorie_quiz() {
    }

    public categorie_quiz(int id, String libelle, String dateCreationCat) {
        this.id = id;
        this.libelle = libelle;
        this.dateCreationCat = dateCreationCat;
    }
    
    
    public categorie_quiz( String libelle, String dateCreationCat) {
        this.libelle = libelle;
        this.dateCreationCat = dateCreationCat;
    }
    
       public categorie_quiz(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
      public categorie_quiz(String libelle) {
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDateCreationCat() {
        return dateCreationCat;
    }

    public void setDateCreationCat(String dateCreationCat) {
        this.dateCreationCat = dateCreationCat;
    }

    @Override
    public String toString() {
        return "categorie Quiz{" + "id=" + id + ", libelle=" + libelle + ", dateCreationCat=" + dateCreationCat + '}';
    }
      
    
    
}
