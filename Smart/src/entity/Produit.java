/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
//import java.util.concurrent.atomic.AtomicInteger;


/**
 *
 * @author ASUS
 */
public class Produit {
     //Sql s = new Sql();
     private int idProduit;// = s.id_increment();
    private String nom;
    private String description;
    private String createur;
    private int taille;
    private String categorie;
    private float prix;
    private String nomPhoto;
    private Date dateProduit;
    private int nbVus=0;
 
    public Produit() {
        
    }
    

    public Produit(String nom,String description, String createur, int taille, String categorie, float prix, String nomPhoto) {
        this.nom = nom;
        this.description = description;
        this.createur = createur;
        this.taille = taille;
        this.categorie = categorie;
        this.prix = prix;
        this.nomPhoto = nomPhoto;
       
    }
    public Produit(int id,String nom,String description, String createur, int taille, String categorie, float prix, String nomPhoto) {
        this.idProduit=id;
        this.nom = nom;
        this.description = description;
        this.createur = createur;
        this.taille = taille;
        this.categorie = categorie;
        this.prix = prix;
        this.nomPhoto = nomPhoto;
       
    }
       public Produit(int idProduit,String nom, String createur, float prix, Date dateProduit, String nomPhoto) {
        this.idProduit=idProduit;
        this.nom = nom;
        this.createur = createur;
        this.prix = prix;
        this.dateProduit=dateProduit;
        this.nomPhoto = nomPhoto;
    }

    public Produit( String nom, String description, String createur, int taille, String categorie, float prix, Date date, String nomPhoto, int nbvus) {
        
         this.nom = nom;
         this.description=description;
          this.createur = createur;
          this.taille=taille;
          this.categorie = categorie;
        this.prix = prix;
        this.dateProduit=date;
        this.nomPhoto = nomPhoto;
        this.nbVus=nbvus;
    }

    public Produit(String nom, float prix, String np) {
        this.nom=nom;
        this.prix=prix;
        this.nomPhoto=np;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateur() {
        return createur;
    }

    public void setCreateur(String createur) {
        this.createur = createur;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getNomPhoto() {
        return nomPhoto;
    }

    public void setNomPhoto(String nomPhoto) {
        this.nomPhoto = nomPhoto;
    }

    public Date getDateProduit() {
        return dateProduit;
    }

    public void setDateProduit(Date dateProduit) {
        this.dateProduit = dateProduit;
    }

    public int getNbVus() {
        return nbVus;
    }

    public void setNbVus(int nbVus) {
        this.nbVus = nbVus;
    }

    public int getIdProduit() {
        return idProduit;
    }
    
    
    
}
