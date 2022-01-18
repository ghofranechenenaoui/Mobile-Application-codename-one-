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
import entity.questions;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class QuestionService {
String url = "http://localhost/project2/web/app_dev.php/portfolio/AfficheQuestionJava";
   private questions questions;
   private int ID;
public QuestionService(){}
    
  

    public questions getQuestions() {
        return questions;
    }

    public void setQuestions(questions questions) {
        this.questions = questions;
    }
  public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
   
   
   
public void DeleteQuestion(int id) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/project2/web/app_dev.php/portfolio/deleteQuestionMobile/"+id;
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }


        public questions getQuestion(int id){
        ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/project2/web/app_dev.php/portfolio/IdQuestionMobile/"+id;
        con.setUrl(url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            questions = parseExperience(str);
            
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    return questions;
        }

public void ajoutQuestion(questions ta) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/project2/web/app_dev.php/portfolio/QuestionMobile?question="+ta.getDescription()+"&rep1="+ta.getDescription()+"&rep2="+ta.getRep2()+"&rep3="+ta.getRep3()+"&correct="+ta.getCorrectReq()+"&niv_id="+ta.getNiveau_id().getId();
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

     public questions EditQuestionff(questions ta) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
         setID(ta.getId());
        String url = "http://localhost/project2/web/app_dev.php/portfolio/EditQuestionMobile/"+ta.getId();
        con.setUrl(url);
        con.setPost(true);
       //con.addArgument("id", ta.getId());
        con.addArgument("correct", ta.getCorrectReq());
        con.addArgument("rep1", ta.getRep1());
        con.addArgument("rep2", ta.getRep2());
        con.addArgument("rep3", ta.getRep3());
          con.addArgument("description", ta.getDescription());
       
              con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            questions = getQuestion(ta.getId());
        });
              
        NetworkManager.getInstance().addToQueueAndWait(con);
        return questions;

    }

          public void EditQuestion(questions ta) {
        
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/project2/web/app_dev.php/portfolio/EditQuestionMobile/"+ta.getId();
        con.setUrl(Url);
  con.setPost(true);
       //con.addArgument("id", ta.getId());
        con.addArgument("correct", ta.getCorrectReq());
        con.addArgument("rep1", ta.getRep1());
        con.addArgument("rep2", ta.getRep2());
        con.addArgument("rep3", ta.getRep3());
          con.addArgument("description", ta.getDescription());
   
        con.addResponseListener(e -> {
          String str = new String(con.getResponseData());
            System.out.println(str);
if(str!=null){
//str1="valide";
}
            
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
       
    }
        
  private questions parseExperience(String json){
        questions m = new questions();
        try {
            JSONParser j = new JSONParser();
            
            Map<String, Object> experienceMap = j.parseJSON(new CharArrayReader(json.toCharArray()));
            
            if(experienceMap != null){
                m.setId(((Double)experienceMap.get("id")).intValue());
                m.setCorrectReq((String)experienceMap.get("correctReq"));
                m.setRep1((String)experienceMap.get("rep1"));
                m.setRep2((String)experienceMap.get("rep2"));
                m.setRep3((String)experienceMap.get("rep3"));
                m.setDescription((String)experienceMap.get("description"));
              
               
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return m;
    }
public ArrayList<questions> getQuestion() {
        ConnectionRequest con = new ConnectionRequest();
        String Url = url;
        con.setUrl(Url);
        ArrayList<questions> mapQuestion = new ArrayList<>();
        con.addResponseListener((e) -> {
            String jsonRes = new String(con.getResponseData());
            try {
                JSONParser j = new JSONParser();

                Map<String, Object> events = j.parseJSON(new CharArrayReader(jsonRes.toCharArray()));

                List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("question_string");
                for (Map<String, Object> obj : list) {
                  float id = Float.parseFloat(obj.get("id").toString());
                    questions ev= new questions();
                      ev.setId((int) id);
                      ev.setDescription(obj.get("description").toString());
                      ev.setRep1(obj.get("rep1").toString());
                      ev.setRep2(obj.get("rep2").toString());
                      ev.setRep3(obj.get("rep3").toString());
                      ev.setCorrectReq(obj.get("correctReq").toString());

                      mapQuestion.add(ev);
                        System.out.println(ev);
               //    System.out.println("id commande : "+lcp.getPrixTotal());
                }

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(con);

        return mapQuestion;
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
    
    
    ArrayList<categorie_quiz> listTasks = new ArrayList<>();
    
    public ArrayList<categorie_quiz> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(url);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                QuestionService ser = new QuestionService();
                listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
    //**************************find question
     public ArrayList<questions> findQuestion(int idQ) {
        ConnectionRequest con2 = new ConnectionRequest();
        String Url = "http://localhost/project2/web/app_dev.php/portfolio/find/"+idQ;
        con2.setUrl(Url);
        ArrayList<questions> mapQuestion = new ArrayList<>();
        con2.addResponseListener((e) -> {
            String jsonRes = new String(con2.getResponseData());
          
            try {
                JSONParser j = new JSONParser();

                Map<String, Object> events = j.parseJSON(new CharArrayReader(jsonRes.toCharArray()));

                List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("A");
                for (Map<String, Object> obj : list) {
                Map<String, Object> list2 =  (Map)obj.get("m");

                  float id = Float.parseFloat(list2.get("id").toString());
                    questions ev= new questions();
                      ev.setId((int) id);
                      ev.setDescription(list2.get("description").toString());
                      ev.setRep1(list2.get("rep1").toString());
                      ev.setRep2(list2.get("rep2").toString());
                      ev.setRep3(list2.get("rep3").toString());
                      ev.setCorrectReq(list2.get("correctReq").toString());

                      mapQuestion.add(ev);
                      System.out.println(ev);
                      System.out.println(ev);
               //    System.out.println("id commande : "+lcp.getPrixTotal());
                }} catch (IOException ex) {
                System.err.println(ex.getMessage());}

        });
        NetworkManager.getInstance().addToQueueAndWait(con2);

        return mapQuestion;
    }


}
