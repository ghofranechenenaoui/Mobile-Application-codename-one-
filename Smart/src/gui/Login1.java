/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import com.codename1.components.ImageViewer;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import org.json.*;



import java.io.IOException;



import com.codename1.components.ScaleImageLabel;
import com.codename1.facebook.FaceBookAccess;
import com.codename1.facebook.User;
import com.codename1.io.Storage;
import com.codename1.social.FacebookConnect;
import com.codename1.social.LoginCallback;
import com.codename1.ui.Button;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import com.codename1.components.ScaleImageLabel;
import com.codename1.facebook.FaceBookAccess;
import com.codename1.facebook.User;
import com.codename1.io.JSONParser;
import com.codename1.io.Storage;
import com.codename1.messaging.Message;
import static com.codename1.messaging.Message.sendMessage;
import com.codename1.social.FacebookConnect;
import com.codename1.social.Login;
import com.codename1.social.LoginCallback;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.FBLogin6;
//import com.mycompany.myapp.FBLogin;
//import com.mycompany.myapp.UserForm;
import com.mycompany.myapp.MyApplication;
import java.util.Random;

import java.io.IOException;

import jdk.nashorn.internal.objects.NativeString;





public class Login1 {

    private static final String QR_CODE_IMAGE_PATH = "./MyQRCode.png";
     public static int MEMBER_ID = 0;
    TextField loginField;
    TextField mdpField;
    Container loginContainer;
    Button confirmerBtn;
    Button registerBtn;
    Button fbButton;
    Form smartstart;
   // private String url = "http://localhost/project/web/app_dev.php/portfolio/Login/";
        private String url = "http://localhost/project2/web/app_dev.php/portfolio/Login2/";

    private ConnectionRequest connectionRequest;
    String login = "root";
    String pw = "";
    String status = "";
    String appSecret = "15378d7426361fe464f5af2e08f780e3";
    String domain = "http://localhost";
    String appId = "212394559315715";
    Button qr ;
    Button msg ;
private Resources theme;
   
    public Login1(Resources res) {
        Random r = new Random();
        r.setSeed(12151532);
        System.out.println((r.toString()).substring(17));
        
   
        loginField = new TextField();
        mdpField = new TextField();
        loginField.setHint("Pseudo");
        mdpField.setHint("Mot de passe");
        mdpField.setConstraint(TextField.PASSWORD);
        
        confirmerBtn = new Button("Connexion");
         confirmerBtn.setUIID("RadioButton");
            confirmerBtn.getAllStyles().setBackgroundGradientEndColor(0xFF0000);
           
             FontImage.setMaterialIcon(confirmerBtn, FontImage.MATERIAL_ACCOUNT_CIRCLE); 
            
            confirmerBtn.setWidth(30);
        registerBtn = new Button("Inscription");
        fbButton = new Button("Facebook Login");
        qr = new Button("qr");
        msg = new Button("msg");
        Button convs = new Button("convs");
          EncodedImage enc;
          EncodedImage enc2;
          EncodedImage enc3;


        
        try {
            enc = EncodedImage.create("/flohin.png");
        
               ImageViewer iv =new ImageViewer(enc);
               
                enc2 = EncodedImage.create("/logo2.png");
        
               ImageViewer iv2 =new ImageViewer(enc2);
                 enc3 = EncodedImage.create("/google2.png");
        
               ImageViewer iv3 =new ImageViewer(enc3);
         
      msg.addActionListener(ff->{
         
         Recovery fb = new Recovery();
        fb.Go();
         // Message m = new Message("hello from smartstart");
        // sendSMS s=new sendSMS("","");
//                m.getAttachments().put(textAttachmentUri, "text/plain");
//                   m.getAttachments().put(imageAttachmentUri, "image/png");
               //   sendMessage(new String[] {"nihel.haddad@esprit.tn"}, "Vous etes " , m); 
            

        
        });
        registerBtn.addActionListener(e->{
        InscriptionView cv = new InscriptionView();
        cv.getF().show();
        });

        /*confirmerBtn.addActionListener(e -> {
            connectionRequest = new ConnectionRequest();
            connectionRequest.setUrl(url + loginField.getText() + "/" + mdpField.getText());
            NetworkManager.getInstance().addToQueueAndWait(connectionRequest);
            if (!new String(connectionRequest.getResponseData()).equals("no")){
                MEMBER_ID = Integer.parseInt(new String(connectionRequest.getResponseData()));
                new ProfileView(smartstart, MEMBER_ID).getContainer().show();
            }
        });*/
        
         confirmerBtn.addActionListener(e -> {
            connectionRequest = new ConnectionRequest();
            connectionRequest.setPost(false);
            connectionRequest.setUrl(url + loginField.getText() + "/" + mdpField.getText());
            connectionRequest.addResponseListener(a -> {

                try {
                    String resultat = new String(connectionRequest.getResponseData());

                    JSONArray jsonarray = new JSONArray(resultat);
                    for (int i = 0; i < jsonarray.length(); i++) {
                        JSONObject jsonobject = jsonarray.getJSONObject(i);
                        String name = jsonobject.getString("firstname");
                        String url = jsonobject.getString("lastname");
                        final int id = jsonobject.getInt("id");
                        MEMBER_ID = id;
                        System.out.println(name + "  , " + url + " ; id : " + id);
                    }
                    if (MEMBER_ID != 0) {
//             Message m = new Message("<html><body>Check out <a href=\"https://www.codenameone.com/\">Codename One</a></body></html>");
//m.setMimeType(Message.MIME_HTML);
//
//// notice that we provide a plain text alternative as well in the send method
//boolean success = m.sendMessageViaCloudSync("Codename One", "badis.maalej@gmail.com", "Name Of User", "Message Subject",
//                            "Check out Codename One at https://www.codenameone.com/");
//                Display.getInstance().sendMessage(new String[] {"someone@gmail.com"}, "Subject of message", m);

                
//                        Form page2 = new Form("Welcome");
//                        Button back = new Button("Back");
//                        back.addActionListener(b -> {
//                            show();
//                        });
//                        page2.add(back);
//                        page2.show();
                        MyApplication.MemberId= MEMBER_ID;
                         new ProfileView(smartstart, MEMBER_ID).getContainer().show();

                    } else {
                        Dialog.show("Pseudo ou mot de passe incorrect", "Error", "OK", "Cancel");

                    }

                } catch (JSONException ex) {

                }

            });
            NetworkManager.getInstance().addToQueueAndWait(connectionRequest);
        });
         
         
         
        
        fbButton.addActionListener(e -> {
       FBLogin6 fb = new FBLogin6();
            fb.start();
            


        });
        iv.addPointerReleasedListener(e2 -> {
           FBLogin6 fb = new FBLogin6();
            fb.start();
            


        });
      
        loginContainer = new Container(BoxLayout.y());
        loginContainer.add(iv2);
        loginContainer.add(loginField);
        loginContainer.add(mdpField);
        loginContainer.add(confirmerBtn);
        loginContainer.add(registerBtn);
      // loginContainer.add(fbButton);
     //  loginContainer.add(msg);
       loginContainer.add(iv);
       loginContainer.add(iv3);
        
  smartstart = new Form("SmartStart");
        smartstart.add(loginContainer);
} catch (IOException ex) {
           System.out.println(ex);
        }
    }

    public void show() {
        smartstart.show();
    }
  public Form getSmartstart() {
        return smartstart;
    }

    public void setSmartstart(Form smartstart) {
        this.smartstart = smartstart;
    }
}
