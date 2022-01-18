/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class Projet {
    private int id;
    private String titre;
    private String periode;
    private String categorie;
    private String description;
    private int user_id;

    public Projet() {
    }
    
    public Projet(int id){
        this.id = id;
    }

    public Projet(int user_id,int id, String titre, String periode, String categorie, String description) {
        this.user_id=user_id;
        this.id = id;
        this.titre = titre;
        this.periode = periode;
        this.categorie = categorie;
        this.description = description;
    }
  public Projet(int id, String titre, String periode, String categorie, String description) {
       
        this.id = id;
        this.titre = titre;
        this.periode = periode;
        this.categorie = categorie;
        this.description = description;
    }
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

   

    @Override
    public String toString() {
        return "Projet{" + "id=" + id + ", titre=" + titre + ", periode=" + periode + ",  categorie=" + categorie + ",description=" + description+  "}\n";
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String specialite) {
        this.categorie = specialite;
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
