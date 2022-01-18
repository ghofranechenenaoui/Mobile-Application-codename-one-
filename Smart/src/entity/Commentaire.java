/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;


/**
 *
 * @author ASUS
 */
public class Commentaire {
  private int idCommentaire;
    private String nom;
    private String mail;
    private String descriptionCommentaire;
    private Date dateCommentaire;
    private int idProduit;
    public Commentaire() {
          
    }

    

    public Commentaire(String nom, String mail, String descriptionCommentaire) {
        this.nom = nom;
        this.mail = mail;
        this.descriptionCommentaire = descriptionCommentaire;
          
    }

    public Commentaire(String nom, String descriptionCommentaire,Date date) {
        this.nom = nom;
        this.descriptionCommentaire = descriptionCommentaire;
        this.dateCommentaire=date;
    }

    public Commentaire(int id, String nom, String mail, String descriptioncom, int proid, Date date) {
       this.idCommentaire=id;
        this.nom = nom;
        this.mail=mail;
        this.descriptionCommentaire = descriptioncom;
        this.idProduit=proid;
        this.dateCommentaire=date;
    }

    public Commentaire(String text) {
        this.descriptionCommentaire=text;
    }

    
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDescriptionCommentaire() {
        return descriptionCommentaire;
    }

    public void setDescriptionCommentaire(String descriptionCommentaire) {
        this.descriptionCommentaire = descriptionCommentaire;
    }

    public Date getDateCommentaire() {
        return dateCommentaire;
    }

    public void setDateCommentaire(Date dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }

    public int getIdCommentaire() {
        return idCommentaire;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }
  
}
