/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.messaging.Message;
import static com.codename1.messaging.Message.sendMessage;
import com.codename1.ui.Button;
import com.codename1.ui.Display;

import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;

import com.mycompany.myapp.MyApplication;




/**
 *
 * @author asus
 */
public class ContactView {
    
    Form f;
    TextField tcontent;
    Button btnajout;
    private Form parentForm;

    public ContactView(Form parentForm) {
        this.parentForm = parentForm;
        f = new Form("Ajouter votre mail",BoxLayout.y());
        tcontent = new TextField();
        tcontent.setHint("Mail Content");
        tcontent.getAllStyles().setMarginTop(10);
        Label Vcontent = new Label();
        btnajout = new Button("Submit");
        Button btn = new Button();
        f.add(tcontent);
        f.add(Vcontent);
        f.add(btnajout);
        f.add(btn);
    
        
        
        btnajout.addActionListener((l) -> {
            
            boolean valid = true;
             if (tcontent.getText().equals("")) {
            Vcontent.setText("Field is empty !");
            Vcontent.setVisible(true);
            valid = false;
        } else {
            Vcontent.setText("");
        }
          
              });
            btn.setUIID("RadioButton");
            btn.getAllStyles().setBackgroundGradientEndColor(0xFF0000);
            FontImage.setMaterialIcon(btn, FontImage.MATERIAL_EMAIL);
            
            btn.addActionListener((l) -> {
           
              Message m = new Message("Nouveau message reçu"); 
                      

                     //     m.getAttachments().put(textAttachmentUri, "text/plain");               
                     //     m.getAttachments().put(imageAttachmentUri, "image/png");
                  sendMessage(new String[] {"nihelhaddad5@gmail.com"}, tcontent.getText() , m);
                  
                                     ProfileView a=new ProfileView(parentForm, 0);
        a.getContainer().show();
                  //sendSMS m2 = new sendSMS("Nouveau message reçu",""); 
                    

              
//                m.getAttachments().put(textAttachmentUri, "text/plain");
//                   m.getAttachments().put(imageAttachmentUri, "image/png");
                  //sendMessage(new String[] {"nihelhaddad5@gmail.com"}, tcontent.getText() , m);
            } 

        );

            

            
      
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTcontent() {
        return tcontent;
    }

    public void setTcontent(TextField tcontent) {
        this.tcontent = tcontent;
    }

    public Button getBtnajout() {
        return btnajout;
    }

    public void setBtnajout(Button btnajout) {
        this.btnajout = btnajout;
    }
    
    
}
