/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entity.categorie_quiz;
import entity.evaluation;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class test {
String url = "http://localhost/project2/web/app_dev.php/portfolio/JavaQuestion123";
   

public void ajoutTask(categorie_quiz ta) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/project2/web/app_dev.php/portfolio/addCatMobile?libelle="+ta.getLibelle();
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

public void DeleteCat(int id) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/project2/web/app_dev.php/portfolio/deleteCatMobile/"+id;
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

    public ArrayList<categorie_quiz> getCat() {
        ConnectionRequest con = new ConnectionRequest();
        String Url = url;
        con.setUrl(Url);
        ArrayList<categorie_quiz> mapCat = new ArrayList<>();
        con.addResponseListener((e) -> {
            String jsonRes = new String(con.getResponseData());
            try {
                JSONParser j = new JSONParser();

                Map<String, Object> events = j.parseJSON(new CharArrayReader(jsonRes.toCharArray()));

                List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");
                for (Map<String, Object> obj : list) {
                  float id = Float.parseFloat(obj.get("id").toString());
                    categorie_quiz ev= new categorie_quiz();
                      ev.setId((int) id);
                      ev.setLibelle(obj.get("libelle").toString());
                        mapCat.add(ev);
               //    System.out.println("id commande : "+lcp.getPrixTotal());
                }

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(con);

        return mapCat;
    }




    
    public ArrayList<categorie_quiz> parseListTaskJson(String json) {

        ArrayList<categorie_quiz> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

    
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Map<String, Object> memberMap = j.parseJSON(new CharArrayReader(json.toCharArray()));

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
              categorie_quiz  e = new categorie_quiz();
                float id = Float.parseFloat(obj.get("id").toString());
                String gg = obj.get("dateCreationCat").toString();
                
                e.setId((int) id);
                e.setLibelle(obj.get("libelle").toString());
               // e.setDateCreationCat(obj.get("dateCreationCat").toString());
            // e.setDateCreationCat(gg);
           //     e.setDateCreationCat(new Date((((Double)((Map<String, Object>)memberMap.get("dateCreationCat")).get("6/12/11 5:59:00")).longValue()*1000)));
                System.out.println(e);
                
                listTasks.add(e);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listTasks);
        return listTasks;

    }
    
     public ArrayList<evaluation> getEva() {
        ConnectionRequest con = new ConnectionRequest();
        String Url2 = "http://localhost/project2/web/app_dev.php/portfolio/evaMobile";
        con.setUrl(Url2);
        ArrayList<evaluation> mapEva = new ArrayList<>();
        con.addResponseListener((e) -> {
            String jsonRes = new String(con.getResponseData());
            try {
                JSONParser j = new JSONParser();

                Map<String, Object> events = j.parseJSON(new CharArrayReader(jsonRes.toCharArray()));

                List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("eva_string");
                for (Map<String, Object> obj : list) {
                  float id = Float.parseFloat(obj.get("id").toString());
                    evaluation eva= new evaluation();
                      eva.setId((int) id);
                      eva.setLibelle(obj.get("libelle").toString());
                      eva.setDescriptionEva(obj.get("descriptionEva").toString());
                      mapEva.add(eva);
               //    System.out.println("id commande : "+lcp.getPrixTotal());
                }

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(con);

        return mapEva;
    } 
    ArrayList<categorie_quiz> listTasks = new ArrayList<>();
    
    public ArrayList<categorie_quiz> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(url);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                test ser = new test();
                listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
    
        public ArrayList<evaluation> getEvaCat() {
        ConnectionRequest con = new ConnectionRequest();
        String Url2 = "http://localhost/project2/web/app_dev.php/portfolio/CatEvaMobile";
        con.setUrl(Url2);
        ArrayList<evaluation> mapEva = new ArrayList<>();
        con.addResponseListener((e) -> {
            String jsonRes = new String(con.getResponseData());
            try {
                JSONParser j = new JSONParser();

                Map<String, Object> events = j.parseJSON(new CharArrayReader(jsonRes.toCharArray()));

                List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("A");
                for (Map<String, Object> obj : list) {
                  Map<String, Object> evaMap = (Map<String, Object>)obj.get("n");
                  float id = Float.parseFloat(evaMap.get("id").toString());
                    evaluation eva= new evaluation();
                      eva.setId((int) id);
                      eva.setLibelle(evaMap.get("libelle").toString());
                  //    eva.setDescriptionEva(evaMap.get("descriptionEva").toString());
                      eva.setNb(obj.get("bcount").toString());
                      eva.setCategorie_quiz(new categorie_quiz(obj.get("coco").toString()));
                      mapEva.add(eva);
               //    System.out.println("id commande : "+lcp.getPrixTotal());
                }

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(con);

        return mapEva;
    } 

}
