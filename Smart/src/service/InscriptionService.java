/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import entity.UserRegister;


/**
 *
 * @author asus
 */
public class InscriptionService {
        public void Inscription(UserRegister u) {
        ConnectionRequest con = new ConnectionRequest();
       
        
        String Url = "http://localhost/project2/web/app_dev.php/portfolio/inscription?firstname=" +u.getFirstname() +"&lastname=" +u.getLastname()+"&email="+u.getEmail()+"&password="+u.getPassword()+"&username="+u.getUsername()+"&phone=" +u.getPhone()+"&gender="+u.isGender();
        con.setUrl(Url);
            
       System.out.println("register sucess");

        con.addResponseListener((l) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    
}
