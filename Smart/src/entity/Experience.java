/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class Experience {
    private int id;
    private String employeur;
    private String periode;
    private String poste;
    private String description;
    private int user_id;

    public Experience() {
    }
    
    public Experience(int id){
        this.id = id;
    }
       public Experience(int id, String employeur, String periode, String poste, String description) {
       
        this.id = id;
        this.employeur = employeur;
        this.periode = periode;
        this.poste = poste;
        this.description = description;
    }
          public Experience( String employeur, String periode, String poste, String description) {
       
     
        this.employeur = employeur;
        this.periode = periode;
        this.poste = poste;
        this.description = description;
    }

    public Experience(int user_id,int id, String employeur, String periode, String poste, String description) {
        this.user_id=user_id;
        this.id = id;
        this.employeur = employeur;
        this.periode = periode;
        this.poste = poste;
        this.description = description;
    }
 
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
   public Experience(int id, String employeur, String periode, String poste) {
        this.id = id;
        this.employeur = employeur;
        this.periode = periode;
        this.poste = poste;
    }
     public Experience( String employeur, String periode, String poste) {
    
        this.employeur = employeur;
        this.periode = periode;
        this.poste = poste;
    }
       public Experience( int id,String employeur, String periode) {
                this.id = id;

        this.employeur = employeur;
        this.periode = periode;
    }
   

    @Override
    public String toString() {
        return "Experience{" + "id=" + id + ", employeur=" + employeur + ", periode=" + periode + ",  poste=" + poste + ",description=" + description+  "}\n";
    }
    

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getEmployeur() {
        return employeur;
    }

    public void setEmployeur(String employeur) {
        this.employeur = employeur;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   
}
