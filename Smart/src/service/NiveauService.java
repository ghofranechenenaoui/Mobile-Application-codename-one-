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
import entity.niveau;
import entity.questions;
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
public class NiveauService {
String url = "http://localhost/project2/web/app_dev.php/portfolio/AfficheNiveauJava";
   

   
public void DeleteNiveau(int id) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/project2/web/app_dev.php/portfolio/deleteNiveauMobile/"+id;
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

public void ajoutNiveau(niveau ta) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/project2/web/app_dev.php/portfolio/addNiveauMobile?temps="+ta.getTemps()+"&rangeLevel="+ta.getRangeLevel()+"&score="+ta.getScore()+"&eva_id="+ta.getNameEvaluation_id().getId();
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }



    public ArrayList<niveau> getNiveau() {
        ConnectionRequest con = new ConnectionRequest();
        String Url = url;
        con.setUrl(Url);
        ArrayList<niveau> mapNiveau = new ArrayList<>();
        con.addResponseListener((e) -> {
            String jsonRes = new String(con.getResponseData());
            try {
                JSONParser j = new JSONParser();

                Map<String, Object> events = j.parseJSON(new CharArrayReader(jsonRes.toCharArray()));

                List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("niveau");
                for (Map<String, Object> obj : list) {

                  float id = Float.parseFloat(obj.get("id").toString());
                    niveau ev= new niveau();
                      ev.setId((int) id);
                      ev.setRangeLevel(obj.get("rangeLevel").toString());
                      ev.setScore(((int)Float.parseFloat(obj.get("score").toString())));
                      ev.setTemps(((int)Float.parseFloat(obj.get("temps").toString())));     
                     evaluation a = new evaluation();
                     Map<String, Object> evaMap = (Map<String, Object>)obj.get("evaluation");
                      
                      ev.setNameEvaluation_id(new evaluation(evaMap.get("libelle").toString()));
                                     
                  // evaluation eva = new evaluation();
               //     Map<String, Object> evaluation = (Map<String, Object>)events.get("evaluation");
                  
               /*List<Map<String, Object>> list2 = (List<Map<String, Object>>) events.get("evaluation");
                         System.out.println("/////////////////////////////////////////////////////");
                   for (Map<String, Object> obj2 : list2) {
                       int ideva =((int)Float.parseFloat(obj2.get("id").toString()));
                                                System.out.println("id eva"+ideva);

                       
                        System.out.println("id niveau"+ideva2);
                      
                   if (25==(ideva)) {
                   eva.setLibelle(obj2.get("libelle").toString());
                    
                       }
                       
                   }*/
  //                    System.out.println( ev.setNameEvaluation_id(((Map<String, Object>) events.get("evaluation"))));

                      mapNiveau.add(ev);
                        System.out.println(ev);
                }

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(con);

        return mapNiveau;
    }

    public ArrayList<categorie_quiz> parseListTaskJson(String json) {

        ArrayList<categorie_quiz> listTasks = new ArrayList<>();
        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

    
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
            
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Map<String, Object> memberMap = j.parseJSON(new CharArrayReader(json.toCharArray()));
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
    
    
    ArrayList<categorie_quiz> listTasks = new ArrayList<>();
    
    public ArrayList<categorie_quiz> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(url);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                NiveauService ser = new NiveauService();
                listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
    
     public ArrayList<niveau> getNiveauAvecTopic() {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/project2/web/app_dev.php/portfolio/NiveauavecTopic";
        con.setUrl(Url);
        ArrayList<niveau> mapNiveau = new ArrayList<>();
        con.addResponseListener((e) -> {
            String jsonRes = new String(con.getResponseData());
            try {
                JSONParser j = new JSONParser();

                Map<String, Object> events = j.parseJSON(new CharArrayReader(jsonRes.toCharArray()));
                List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("A");
                for (Map<String, Object> obj : list) {
                  float id = Float.parseFloat(obj.get("id").toString());
                    niveau ev= new niveau();
                      ev.setId((int) id);
                      ev.setRangeLevel(obj.get("nn").toString());
                      ev.setScore(((int)Float.parseFloat(obj.get("score").toString())));
                      ev.setTemps(((int)Float.parseFloat(obj.get("temps").toString())));  
                      ev.setNameEvaluation_id(new evaluation(obj.get("topic").toString()));
                      mapNiveau.add(ev);
                      System.out.println(ev);
                }

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(con);

        return mapNiveau;
    }
    
    
    
    
    

}
