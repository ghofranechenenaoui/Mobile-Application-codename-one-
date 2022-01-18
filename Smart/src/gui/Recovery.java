/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import java.util.List;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import static gui.Login1.MEMBER_ID;
import java.util.ArrayList;
import static java.util.Collections.list;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.codename1.io.JSONParser;
import com.codename1.ui.Command;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.SwipeBackSupport;
import java.util.Map;
import entity.Message;
import service.MessageService;
import java.util.Timer;
import com.codename1.ui.util.UITimer;
import com.mycompany.myapp.MyApplication;
import static java.lang.Thread.sleep;

/**
 *
 * @author badis
 */
public class Recovery {

    protected com.codename1.ui.util.UITimer refresherTimer = null;
    public static int thrd = 1;
    public static int receiver;
    static Form SmartStart;
    public static int MEMBER_ID ;
    Container conty;
    Container contx;
    Container cntt;
    private ConnectionRequest connectionRequest;
    private List<Message> list;
    TextField txf;
    static Container chatArea;
    static Form chatForm;
    static TextField write;
    Button ok;
    public static List<Message> old;
    public static List<Message> nnn;

    public void setReceiverId(int id, int thrd) {
        this.receiver = 1;
        this.thrd = thrd;
        this.MEMBER_ID = 14 ;
        Go();

        initiatefield(thrd, id, MEMBER_ID);
        MyThread2 thr = new MyThread2();
        refresherTimer.timer(3000, true, thr);

    }

    public void setOld(List<Message> mm) {
        this.old = mm;

    }

    public List<Message> getOld() {
        System.out.println("getter" + old);
        return old;

    }

    private Component say(Container chatArea, String text) {
        Component t = sayNoLayout(chatArea, text);
        t.setY(chatArea.getHeight());
        t.setWidth(chatArea.getWidth());
        t.setHeight(40);
        chatArea.animateLayoutAndWait(300);
        chatArea.scrollComponentToVisible(t);
        return t;
    }

    private Component sayYsar(Container chatArea, String text) {
        Component t = sayNoLayoutYsar(chatArea, text);
        t.setY(chatArea.getHeight());
        t.setWidth(chatArea.getWidth());
        t.setHeight(40);
        chatArea.animateLayoutAndWait(300);
        chatArea.scrollComponentToVisible(t);
        return t;
    }

    private Component sayNoLayout(Container chatArea, String text) {
        SpanLabel t = new SpanLabel(text);

        t.setTextBlockAlign(Component.RIGHT);
        chatArea.addComponent(t);
        return t;
    }

    private Component sayNoLayoutYsar(Container chatArea, String text) {
        SpanLabel t = new SpanLabel(text);

        t.setTextBlockAlign(Component.LEFT);
        chatArea.addComponent(t);
        return t;
    }

    public Recovery() {
    }

    public void Go() {
        chatForm = new Form();
        chatForm.setLayout(new BorderLayout());
        Toolbar tb = new Toolbar();
        chatArea = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        chatArea.setScrollableY(true);
        chatArea.setName("ChatArea");
        write = new TextField(30);
        ok = new Button();
        write.setHint("Write your message ");
        chatForm.addComponent(BorderLayout.CENTER, chatArea);

        chatForm.addComponent(BorderLayout.SOUTH, write);

        write.addActionListener((e) -> {
            if (write.getText() == "") {
                return;
            } else {
                String text = write.getText();
                final Component t = say(chatArea, text);

                Message msg = new Message();
                msg.setContent(write.getText());
                msg.setSenderId(MEMBER_ID);
                msg.setReceiverId(receiver);
                write.setText("");
                MessageService.getInstance().SendMSg(msg);

            }
        });
        chatForm.show();

    }

    public void show() {

    }

    public void initiatefield(int thrd, int senderId, int receiverId) {

        Message msg = new Message();
        msg.setId(thrd);
        System.out.println(thrd);
        List<Message> msgs = MessageService.getInstance().getAll(msg);
        setOld(msgs);

        for (Message c : msgs) {
            String text = c.getContent();

            SpanLabel t = new SpanLabel(text);
            if (c.getSenderId() == MEMBER_ID) {
                t.setTextBlockAlign(Component.RIGHT);
                chatArea.addComponent(t);
                t.setY(chatArea.getHeight());
                t.setWidth(chatArea.getWidth());
                t.setHeight(40);
                chatForm.scrollComponentToVisible(t);
            } else {
                t.setTextBlockAlign(Component.LEFT);
                chatArea.addComponent(t);
                t.setY(chatArea.getHeight());
                t.setWidth(chatArea.getWidth());
                t.setHeight(40);
                chatForm.scrollComponentToVisible(t);
            }
            chatForm.scrollComponentToVisible(t);

        }

    }

    public void Update(List<Message> msges, int thrd, int senderId, int receiverId) {

        System.out.println("=======================================================================");

        for (Message c : msges) {
            String text = c.getContent();
            System.out.println(text);

            SpanLabel t = new SpanLabel(text);
            if (c.getSenderId() == MEMBER_ID) {
                return;
            } else {
                t.setTextBlockAlign(Component.LEFT);
                chatArea.addComponent(t);
                t.setY(chatArea.getHeight());
                t.setWidth(chatArea.getWidth());
                t.setHeight(40);

            }

            chatForm.scrollComponentToVisible(t);
            MyThread2 thr = new MyThread2();
            refresherTimer.timer(3000, true, thr);

        }
        chatForm.scrollComponentToVisible(chatArea);

        try {
            sleep(1000);
        } catch (InterruptedException ex) {
        }

    }

    public List<Message> refresh(int thrd) {

        Message msg = new Message();
        msg.setId(thrd);
        System.out.println(thrd);
        List<Message> msgs = MessageService.getInstance().getAll(msg);
        return msgs;
    }

    protected void stopRefreshing() {
        if (refresherTimer != null) {
            refresherTimer.cancel();
            refresherTimer = null;
        }
    }

    public static class MyThread implements Runnable {

        protected com.codename1.ui.util.UITimer refresherTimer = null;

        @Override
        public void run() {

            Recovery rc = new Recovery();
            MyThread2 thr = new MyThread2();
            System.out.println("jdid size" + rc.nnn.size());
            System.out.println("9dim size" + rc.old.size());
            if (rc.nnn.size() > rc.old.size()) {
                

                rc.nnn.removeAll(rc.old);
                
                rc.Update(rc.nnn, rc.thrd, rc.MEMBER_ID, rc.receiver);
                rc.old = rc.refresh(rc.thrd);
                

            } else {

                return;
            }

        }

    }

    public static class MyThread2 implements Runnable {

        protected com.codename1.ui.util.UITimer refresherTimer = null;

        @Override
        public void run() {

            Recovery rc = new Recovery();
            List<Message> msgs = rc.refresh(rc.thrd);
            rc.nnn = msgs;
            MyThread thr = new MyThread();
            refresherTimer.timer(3000, false, thr);

        }
    }
  public Form getSmartStart(){
        return SmartStart;
    }
}
