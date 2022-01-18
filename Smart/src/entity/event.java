/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;



import java.util.Date;


/**
 *
 * @author Administrator
 */
public class event {
    private int id;
    private String titreEvent;
    private String animateurEvent;
    private String lieuEvent;
    private String lienEvent;
    private Date dateEvent;
    private Date datefinEvent;
    private int nbplaceEvent;
    private float fraisEvent;
    private String descriptionEvent;
    private String afficheEvent;
    private int id_user;
    private int id_categorie;

    public event() {
    }

    public event(int id, String titreEvent, String animateurEvent, String lieuEvent, String lienEvent, Date dateEvent, Date datefinEvent, int nbplaceEvent, float fraisEvent, String descriptionEvent, String afficheEvent, int id_user, int id_categorie) {
        this.id = id;
        this.titreEvent = titreEvent;
        this.animateurEvent = animateurEvent;
        this.lieuEvent = lieuEvent;
        this.lienEvent = lienEvent;
        this.dateEvent = dateEvent;
        this.datefinEvent = datefinEvent;
        this.nbplaceEvent = nbplaceEvent;
        this.fraisEvent = fraisEvent;
        this.descriptionEvent = descriptionEvent;
        this.afficheEvent = afficheEvent;
        this.id_user = id_user;
        this.id_categorie = id_categorie;
    }

    public event(String titreEvent, String animateurEvent, String lieuEvent, String lienEvent, Date dateEvent, Date datefinEvent, float fraisEvent, String descriptionEvent, String afficheEvent) {
        this.titreEvent = titreEvent;
        this.animateurEvent = animateurEvent;
        this.lieuEvent = lieuEvent;
        this.lienEvent = lienEvent;
        this.dateEvent = dateEvent;
        this.datefinEvent = datefinEvent;
        this.fraisEvent = fraisEvent;
        this.descriptionEvent = descriptionEvent;
        this.afficheEvent = afficheEvent;
    }
    

    public event(String titreEvent, String animateurEvent, String lieuEvent, String lienEvent, Date dateEvent, Date datefinEvent, int nbplaceEvent, float fraisEvent, String descriptionEvent, String afficheEvent) {
        this.titreEvent = titreEvent;
        this.animateurEvent = animateurEvent;
    this.lieuEvent = lieuEvent;
        this.lienEvent = lienEvent;
        this.dateEvent = dateEvent;
        this.datefinEvent = datefinEvent;
        this.nbplaceEvent = nbplaceEvent;
        this.fraisEvent = fraisEvent;
        this.descriptionEvent = descriptionEvent;
        this.afficheEvent = afficheEvent;
    }
    
    public event(int id, String titreEvent, String animateurEvent, String lieuEvent, String lienEvent, Date dateEvent, Date datefinEvent, int nbplaceEvent, float fraisEvent, String descriptionEvent, String afficheEvent) {
        this.id = id;
        this.titreEvent = titreEvent;
        this.animateurEvent = animateurEvent;
        this.lieuEvent = lieuEvent;
        this.lienEvent = lienEvent;
        this.dateEvent = dateEvent;
        this.datefinEvent = datefinEvent;
        this.nbplaceEvent = nbplaceEvent;
       this.fraisEvent = fraisEvent;
    this.descriptionEvent = descriptionEvent;
        this.afficheEvent = afficheEvent;
    }

    public event(int id,String titreEvent, String animateurEvent, String lieuEvent, String lienEvent) {
        this.id=id;
        this.titreEvent = titreEvent;
        this.animateurEvent = animateurEvent;
        this.lieuEvent = lieuEvent;
        this.lienEvent = lienEvent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitreEvent() {
        return titreEvent;
    }

    public void setTitreEvent(String titreEvent) {
        this.titreEvent = titreEvent;
    }

    public String getAnimateurEvent() {
        return animateurEvent;
    }

    public void setAnimateurEvent(String animateurEvent) {
        this.animateurEvent = animateurEvent;
    }

    public String getLieuEvent() {
        return lieuEvent;
    }

    public void setLieuEvent(String lieuEvent) {
        this.lieuEvent = lieuEvent;
    }

    public String getLienEvent() {
        return lienEvent;
    }

    public void setLienEvent(String lienEvent) {
        this.lienEvent = lienEvent;
    }

    public Date getDateEvent() {
    return dateEvent;
    }

    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
    }

    public Date getDatefinEvent() {
        return datefinEvent;
    }

    public void setDatefinEvent(Date datefinEvent) {
        this.datefinEvent = datefinEvent;
    }

    public int getNbplaceEvent() {
        return nbplaceEvent;
    }

    public void setNbplaceEvent(int nbplaceEvent) {
        this.nbplaceEvent = nbplaceEvent;
    }

    public float getFraisEvent() {
        return fraisEvent;
    }

    public void setFraisEvent(float fraisEvent) {
        this.fraisEvent = fraisEvent;
    }

    public String getDescriptionEvent() {
        return descriptionEvent;
    }

    public void setDescriptionEvent(String descriptionEvent) {
        this.descriptionEvent = descriptionEvent;
    }

    public String getAfficheEvent() {
        return afficheEvent;
    }

    public void setAfficheEvent(String afficheEvent) {
        this.afficheEvent = afficheEvent;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    

    @Override
    public String toString() {
        return "event{" + "id=" + id + ", titreEvent=" + titreEvent + ", animateurEvent=" + animateurEvent + ", lieuEvent=" + lieuEvent + ", lienEvent=" + lienEvent + '}';
    }
    
    
    
    
}
