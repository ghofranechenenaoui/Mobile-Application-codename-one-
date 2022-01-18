/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.codename1.components.MultiButton;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionListener;
import entity.Produit;
import gui.AjouterProduit;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class ServiceProduit {
      public void ajoutProduit(Produit p) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        //con.setPost(false);
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String todaysDate = dateFormat.format(System.currentTimeMillis());
  
// String Url = "http://localhost/projet/web/app_dev.php/ajout/" + p.getNom() + "/" + p.getDescription()+ "/" + p.getCreateur()+ "/" + p.getTaille()+ "/" + p.getCategorie()+ "/" + p.getPrix()+ "/" + todaysDate +"/"+ p.getNomPhoto()+"/"+0;// création de l'URL
 //con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
 con.setPost(false);
        con.setUrl("http://localhost/project2/web/app_dev.php/portfolio/ajoute14");
        con.addArgument("nom",p.getNom());
        con.addArgument("description",p.getDescription());
        con.addArgument("createur",p.getCreateur());
        con.addArgument("taille", String.valueOf(p.getTaille()));
        con.addArgument("categorie",p.getCategorie());
        con.addArgument("prix",String.valueOf(p.getPrix()));
        con.addArgument("dateProduit",todaysDate);
        con.addArgument("nomPhoto",p.getNomPhoto());
        con.addArgument("nbVus",String.valueOf(0));
     
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

    public ArrayList<Produit> parseListProduitsJson(String json) {

       ArrayList<Produit> listProduits = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
            */
            Map<String, Object> produits = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
            List<Map<String, Object>> list = (List<Map<String, Object>>) produits.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
          float taille = Float.parseFloat(obj.get("taille").toString());
          Produit e = new Produit();
                //float taille = Float.parseFloat(obj.get("taille").toString());

               e.setNom(obj.get("nom").toString());
               e.setDescription(obj.get("description").toString());
               e.setCreateur(obj.get("createur").toString());
                e.setTaille((int) taille);
             //e.setTaille(Integer.valueOf(obj.get("taille").toString()));
               e.setPrix(Float.parseFloat(obj.get("prix").toString()));
               e.setNomPhoto(obj.get("nomPhoto").toString());
                e.setCategorie(obj.get("categorie").toString());
               float v = Float.parseFloat(obj.get("nbVus").toString());
               e.setNbVus((int) v);
               // System.out.println(e.getNom());  
              // e.setNom(obj.get("nom").toString());
                //e.setEtat(obj.get("state").toString());
                //e.setNom(obj.get("name").toString());
                //System.out.println(e);
                
                listProduits.add(e);
                
            }
              // System.out.println(listProduits);
              // System.out.println(listProduits.get(0));


        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
       
        return listProduits;
        

    }
    
    ArrayList<Produit> listProduits = new ArrayList<>();
    
    public ArrayList<Produit> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setPost(false);
        con.setUrl("http://localhost/project2/web/app_dev.php/portfolio/show");  
        con.addResponseListener((NetworkEvent evt) -> {
            ServiceProduit ser = new ServiceProduit();
            listProduits = ser.parseListProduitsJson(new String(con.getResponseData()));
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println(listProduits.get(0).getNom());
        System.out.println(listProduits.size());
        return listProduits;
        
    }

public java.util.List<Map<String, Object>> fetchPropertyData() {
    try {
        ConnectionRequest r = new ConnectionRequest();
        r.addArgument("nom",listProduits.get(listProduits.size()).getNom());
        r.addArgument("description",listProduits.get(listProduits.size()).getDescription());
        r.addArgument("createur",listProduits.get(listProduits.size()).getCreateur());
        r.addArgument("taille",String.valueOf(listProduits.get(listProduits.size()).getTaille()));
        r.addArgument("categorie",listProduits.get(listProduits.size()).getCategorie());
        r.addArgument("prix",String.valueOf(listProduits.get(listProduits.size()).getPrix()));
        r.addArgument("dateProduit",String.valueOf(listProduits.get(listProduits.size()).getDateProduit()));
        r.addArgument("nomPhoto",listProduits.get(listProduits.size()).getNomPhoto());
        r.addArgument("nbVus",String.valueOf(listProduits.get(listProduits.size()).getNbVus()));
        
        NetworkManager.getInstance().addToQueueAndWait(r);
        Map<String,Object> result = new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(r.getResponseData()), "UTF-8"));
        Map<String, Object> response = (Map<String, Object>)result.get("response");
        return (java.util.List<Map<String, Object>>)response.get("listings");
    } catch(Exception err) {
        System.out.println(err.getMessage());
        return null;
    }
}
 public void suppressionproduit(int id){
       ConnectionRequest con = new ConnectionRequest();
        con.setPost(false);
        con.setUrl("http://localhost/project2/web/app_dev.php/portfolio/supp"+id);
         con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
      public void modifProduit(Produit p,int id) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        //con.setPost(false);
      //  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   // String todaysDate = dateFormat.format(System.currentTimeMillis());
  
// String Url = "http://localhost/projet/web/app_dev.php/ajout/" + p.getNom() + "/" + p.getDescription()+ "/" + p.getCreateur()+ "/" + p.getTaille()+ "/" + p.getCategorie()+ "/" + p.getPrix()+ "/" + todaysDate +"/"+ p.getNomPhoto()+"/"+0;// création de l'URL
 //con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
 con.setPost(false);
        con.setUrl("http://localhost/project2/web/app_dev.php/portfolio/modif"+id);
        con.addArgument("nom",p.getNom());
        con.addArgument("description",p.getDescription());
        con.addArgument("createur",p.getCreateur());
        con.addArgument("taille", String.valueOf(p.getTaille()));
        con.addArgument("categorie",p.getCategorie());
        con.addArgument("prix",String.valueOf(p.getPrix()));
       // con.addArgument("dateProduit",todaysDate);
        con.addArgument("nomPhoto",p.getNomPhoto());
       
      //  con.addArgument("nbVus",String.valueOf(0));
     
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    
    
}
