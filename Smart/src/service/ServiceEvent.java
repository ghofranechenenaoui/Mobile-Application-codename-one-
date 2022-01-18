/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.event;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class ServiceEvent {
 
    
    public void ajoutEvent(event ev) {
        ConnectionRequest con = new ConnectionRequest();
 SimpleDateFormat tempss = new SimpleDateFormat("yyyy-MM-dd");
                String datedeb = tempss.format(ev.getDateEvent());
                String datefin = tempss.format(ev.getDatefinEvent());
        String Url = "http://localhost/project2/web/app_dev.php/portfolio/tasks/new"
                +"?titreEvent=" + ev.getTitreEvent()
                + "&animateurEvent=" + ev.getAnimateurEvent()
                + "&lieuEvent=" + ev.getLieuEvent()+ 
                "&lienEvent=" + ev.getLienEvent()+ 
                "&dateEvent=" + datedeb+
                "&datefinEvent=" +datefin+
                
                
                "&nbplaceEvent=" + ev.getNbplaceEvent()+
                
                "&fraisEvent=" +ev.getFraisEvent()+
                
                "&descriptionEvent=" + ev.getDescriptionEvent()+
                
                "&afficheEvent=" + ev.getAfficheEvent()
                 ;
        
        System.out.println("L'URL est : : :" + Url);
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    
     
    
     
     
     
     
     public ArrayList<event> parseListTaskJson(String json) {

        ArrayList<event> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            
            Map<String, Object> events = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");

            for (Map<String, Object> obj : list) {
                
                event ev = new event();

                float id = Float.parseFloat(obj.get("id").toString());
     
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            String datedeb = formater.format(ev.getDateEvent());           
            String datefin = formater.format(ev.getDatefinEvent());        
                
            ev.setId((int) id);
                ev.setTitreEvent(obj.get("titreEvent").toString());
                ev.setAnimateurEvent(obj.get("animateurEvent").toString());
                ev.setLieuEvent(obj.get("lieuEvent").toString());
                ev.setLienEvent(obj.get("lienEvent").toString());
                
                
                ev.setDateEvent((Date) obj.get(datedeb));
                ev.setDatefinEvent((Date) obj.get(datefin));
                
                float nbp = Float.parseFloat(obj.get("nbplaceEvent").toString());
                double fr = Double.parseDouble(obj.get("fraisEvent").toString());
                
                ev.setNbplaceEvent((int) nbp);
                
                ev.setFraisEvent((float) fr);
                
                ev.setDescriptionEvent(obj.get("descriptionEvent").toString());
                ev.setAfficheEvent(obj.get("afficheEvent").toString());
                
                System.out.println(ev);
                
                listTasks.add(ev);

            }

        } catch (IOException ex) {
        }
        
        System.out.println(listTasks);
        return listTasks;

    }
     
     ArrayList<event> listTasks = new ArrayList<>();
     public ArrayList<event> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/project2/web/app_dev.php/portfolio/tasks/all");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceEvent ser = new ServiceEvent();
                listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        
            NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
     
}



