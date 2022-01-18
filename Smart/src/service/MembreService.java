/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.db.Row;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import entity.fosuser;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class MembreService {
    private fosuser member;
    
    private static MembreService instance;
    
    private MembreService(){}
    
    public static MembreService getInstance(){
        if(instance == null)
            instance = new MembreService();
        return instance;
    }
    
    public fosuser getFosuser(int id){
        ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/project2/web/app_dev.php/portfolio/getuser/"+id;
        con.setUrl(url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            member = parseMember(str);
        });
       /* con.addExceptionListener((ev) -> {
            member = null;
        });*/
        NetworkManager.getInstance().addToQueueAndWait(con);
        return member;
    }
    
    public fosuser editMemeber(fosuser m){
        ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/project2/web/app_dev.php/portfolio/edituser/"+member.getId();
        con.setUrl(url);
        con.setPost(true);
        
        con.addArgument("firstname", m.getFirstname());
        con.addArgument("lastname", m.getLastname());
        con.addArgument("username", m.getUsername());
        con.addArgument("gender", String.valueOf(m.isGender()?1:0));
      //  con.addArgument("birth_date", m.getBirth_date().toString());
       
        con.addArgument("phone", String.valueOf(m.getPhone()));
        con.addArgument("email", m.getEmail());
       
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            member = getFosuser(m.getId());
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return member;
    }
    
    private fosuser parseMember(String json){
        fosuser m = new fosuser();
        try {
            JSONParser j = new JSONParser();
            
            Map<String, Object> memberMap = j.parseJSON(new CharArrayReader(json.toCharArray()));
            
            if(memberMap != null){
              // m.setBirth_date(new Date((((Double)((Map<String, Object>)memberMap.get("birth_date")).get("date")).longValue()*1000)));
//               m.setId(((Double)memberMap.get("id")).intValue());
                m.setUsername((String)memberMap.get("username"));
                m.setFirstname((String)memberMap.get("firstname"));
                m.setLastname((String)memberMap.get("lastname"));
                m.setGender(Boolean.valueOf((String)memberMap.get("gender")));
//                m.setCreated_at(new Date((((Double)((Map<String, Object>)memberMap.get("created_at")).get("timestamp")).longValue()*1000)));
                m.setDescription((String)memberMap.get("description"));
               // m.setPhone(((Double)memberMap.get("phone")).intValue());
               
                m.setEmail((String)memberMap.get("email"));
                 m.setPath((String)memberMap.get("path"));
                
              
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return m;
    }
}

