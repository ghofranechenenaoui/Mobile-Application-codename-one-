/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.messaging.Message;
import static com.codename1.messaging.Message.sendMessage;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import static com.mycompany.myapp.MyApplication.MemberId;
import static com.mycompany.myapp.MyApplication.theme;
import service.*;
import entity.*;
import java.io.IOException;


/**
 *
 * @author bhk
 */
public class Contact {

    Form f;
    Button  confirmer =new Button("Send");
   TextField tcontent = new TextField("", "Message", 50, TextArea.ANY);
        int h = Display.getInstance().getDisplayHeight();

    public Contact() {        
        try {
             f = new Form( new BorderLayout());
            f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
    
            Button btn  = new Button();
            Label ll =new Label("Votre Message");
            Container cn = new Container(new BoxLayout(BoxLayout.X_AXIS));
            tcontent.setHint("Feedback Content");
            EncodedImage enc = EncodedImage.create("/news3.jpg");
            ImageViewer v= new ImageViewer();
            v.setImage(enc);
            ll.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
            v.getAllStyles().setMarginBottom(20);
       
            Container cn2 = BoxLayout.encloseY(v);;
        cn2.getAllStyles().setMargin(0, 0, 0, 0);
btn.getAllStyles().setBackgroundGradientEndColor(0xFF0000);
FontImage.setMaterialIcon(btn, FontImage.MATERIAL_EMAIL);
    Dialog dlg = new Dialog("Confirmer l'envoi");
    dlg.add(confirmer);
    confirmer.getAllStyles().setMarginLeft(20);   
    btn.addActionListener((l) -> {
    dlg.show(h /8 * 6, 0, 0, 0);
    });

    dlg.setDisposeWhenPointerOutOfBounds(true);
    confirmer.addActionListener(ee->{
    Message m = new Message("Nouveau  Feedback reçu");
    sendMessage(new String[] {"smartstart288@gmail.com"}, tcontent.getText() , m); 
});
f.add(cn2);
f.add(ll);
f.add(tcontent);
f.add(btn);
   f.show();
   f.getToolbar().addCommandToOverflowMenu("back", null, (e) -> {
            new MyFront().getF().show();
        });
   
         Image icon = theme.getImage("icon.png");
            Container topBar = BorderLayout.east(new Label(icon));
            Toolbar tb = f.getToolbar();
        topBar.add(BorderLayout.SOUTH, new Label("Profil", "SidemenuTagline"));
        topBar.setUIID("SideCommand");
       tb.addComponentToSideMenu(topBar);

     
    
        
        tb.addMaterialCommandToSideMenu("Profil", FontImage.MATERIAL_ACCOUNT_CIRCLE, e -> {
           //Form profileForm = (new ProfilSelfView(firstForm, MemberId));
                     new ProfileView(f, MemberId);
          //  profileForm.show();
        });
        
        tb.addMaterialCommandToSideMenu("Quiz", FontImage.MATERIAL_LIST, e -> {
                        new MyFront().getF().show();

        });
        tb.addMaterialCommandToSideMenu("Evenement", FontImage.MATERIAL_EVENT, e -> {
           new Home(theme).getF().show();
        });
        tb.addMaterialCommandToSideMenu("Vitrine", FontImage.MATERIAL_IMAGE, e -> {
            new ConsulterProduits().getF().show();
        });
        tb.addMaterialCommandToSideMenu("Forum", FontImage.MATERIAL_FORUM, e -> {
           
        });
        tb.addMaterialCommandToSideMenu("Logout", FontImage.MATERIAL_EXIT_TO_APP, e -> {});

        } catch (IOException ex) {
     System.out.println(ex.getMessage()); 
        }
        
        // f.getToolbar().addCommandToRightBar("back", null, (ev)->{MyFront h=new MyFront();
        //h.getF().show();
          //});  
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }


}
