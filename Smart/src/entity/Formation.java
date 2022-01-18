/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class Formation {
    private int id;
    private String titre;
    private String periode;
    private String specialite;
    private String description;
    private int user_id;

   

    public Formation() {
    }
    
    public Formation(int id){
        this.id = id;
    }

    public Formation(int user_id,int id, String titre, String periode, String specialite, String description) {
       this.user_id=user_id;
        this.id = id;
        this.titre = titre;
        this.periode = periode;
        this.specialite = specialite;
        this.description = description;
    }
   public Formation(int id, String titre, String periode, String specialite, String description) {
      
        this.id = id;
        this.titre = titre;
        this.periode = periode;
        this.specialite = specialite;
        this.description = description;
    }

   
   

    @Override
    public String toString() {
        return "Formation{" + "id=" + id + ", titre=" + titre + ", periode=" + periode + ",  specialite=" + specialite + ",description=" + description+  "}\n";
    }
 
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }   

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

   
    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   
}
