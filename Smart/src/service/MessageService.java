/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Message;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author badis
 */
public class MessageService {

    private List<Message> list;
   

    public static MessageService instance;

    public static MessageService getInstance() {
        if (instance == null) {
            instance = new MessageService();
        }
        return instance;
    }

    public List<Message> getAll(Message msg) {
        ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/project2/web/app_dev.php/portfolio/get_messages?id=" + msg.getId();
        con.setUrl(url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            list = parseThreads(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return list;
    }

    private List<Message> parseThreads(String json) {
        list = new ArrayList<>();
        try {
            JSONParser j = new JSONParser();

            Map<String, Object> postMap = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> postList = (List<Map<String, Object>>) postMap.get("root");

            for (Map<String, Object> obj : postList) {
                Message c = new Message();
                c.setSenderId((int) Float.parseFloat(obj.get("senderId").toString()));
                c.setId((int) Float.parseFloat(obj.get("id").toString()));

                c.setContent(obj.get("body").toString());
                list.add(c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    private List<Message> parseThreads2(String json) {
        list = new ArrayList<>();
        try {
            JSONParser j = new JSONParser();

            Map<String, Object> postMap = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> postList = (List<Map<String, Object>>) postMap.get("root");

            for (Map<String, Object> obj : postList) {
                Message c = new Message();
                c.setId((int) Float.parseFloat(obj.get("id").toString()));
                c.setSenderId((int) Float.parseFloat(obj.get("senderId").toString()));

                c.setContent(obj.get("body").toString());
                list.add(c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    ///
    

    public void SendMSg(Message msg) {

        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/project2/web/app_dev.php/portfolio/send_message?sender=" + msg.getSenderId() + ""
                + "&receiver=" + msg.getReceiverId() + "&body=" + msg.getContent();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public List<Message> getAllNEw(Message msg) {
        ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/project2/web/app_dev.php/portfolio/get_sff?Id=" + msg.getSenderId() + "&nbr=" + msg.getContent() + "&receiver=" + msg.getReceiverId();
        System.out.println(url);
        con.setUrl(url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            if (str != "[]" && str != null && str != "{}") {
                list = parseThreads(str);
            } else {
                return;
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return list;
    }

}
