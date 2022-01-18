/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

//import java.sql.Date;

import java.util.Date;





//import com.sun.jmx.snmp.Timestamp;


//import java.util.Timestamp;

/**
 *
 * @author ASUS
 */
public class Commande {
    private int id;
    private Date dateCommande;
    private int paiment;
    private int idProduit;
    private int idCompte;

    public Commande(int id, Date date, int paiment) {
        this.id=id;
        this.dateCommande=date;
        this.paiment=paiment;
    }

    public int getId() {
        return id;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public int getPaiment() {
        return paiment;
    }

    public void setPaiment(int paiment) {
        this.paiment = paiment;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }
    

   
    
}
