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
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import static com.codename1.ui.plaf.Style.BACKGROUND_NONE;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.myapp.MyApplication;
import static com.mycompany.myapp.MyApplication.MemberId;
import static com.mycompany.myapp.MyApplication.theme;
import service.*;
import entity.*;
import java.io.IOException;
import java.util.ArrayList;




/**
 *
 * @author bhk
 */
public class MyFront {

    Form f;
   NiveauService n = new NiveauService();
Container  All ;

    public MyFront() {        
 try {
            f = new Form(BoxLayout.y());
            Image g = Image.createImage("/h.jpg");
            Container c =new Container(BoxLayout.x());
            Container cH =new Container(BoxLayout.y());
            Button bt = new  Button("         Home        ");
            Button bt2 = new Button("     Mes Tests       ");
       
             bt.getAllStyles().setBorder(Border.createEmpty());
             bt.getAllStyles().setBackgroundType(BACKGROUND_NONE);
             bt.getAllStyles().setBgTransparency(255);
             bt.getAllStyles().setBgColor(0x7F7191);
             
             bt2.getAllStyles().setBorder(Border.createEmpty());
             bt2.getAllStyles().setBackgroundType(BACKGROUND_NONE);
             bt2.getAllStyles().setBgTransparency(255);
             bt2.getAllStyles().setBgColor(0x7F7191);
             c.add(bt);
             c.add(bt2);
  bt2.addActionListener(K77->{
           AfficheMytest();
           });
           bt.addActionListener(K5->{
           Affichetest();
           });
            f.add(g);
            f.add(c);
         ArrayList<niveau> lstC =  n.getNiveauAvecTopic();
        for (niveau c2 : lstC) {
      
             try {
                 Container mainContainer = new Container(BoxLayout.y());
                 Container bt5 = new Container(BoxLayout.x());
                 
                 Label ll = new Label(c2.getNameEvaluation_id().getLibelle());
                 ll.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
                 ll.getAllStyles().setFgColor(0x130043);
                 EncodedImage encb = EncodedImage.create("/done2.png");
                 ImageViewer img = new ImageViewer(encb);
                 img.addPointerReleasedListener(p->{
                     System.out.println("clicked");
                     Question q = new Question(c2.getId());
                     q.getF().show();
                     
                 });
                 
                 img.getAllStyles().setPaddingLeft(220);
                 mainContainer.add(buildPairLabel("Min Score  ", String.valueOf(c2.getScore())));
                 mainContainer.add(buildPairLabel("Min Temps  ", String.valueOf(c2.getTemps())));
                 mainContainer.add(buildPairLabel("Niveau", c2.getRangeLevel()));
                 mainContainer.getAllStyles().setMarginLeft(20);
                 mainContainer.getAllStyles().setMarginRight(20);
                 mainContainer.getAllStyles().setBorder(Border.createEmpty());
                 mainContainer.getAllStyles().setBackgroundType(BACKGROUND_NONE);
                 mainContainer.getAllStyles().setBgTransparency(255);
                 mainContainer.getAllStyles().setBgColor(0xEBDBF5);
                 f.add(ll);
                 f.add(mainContainer);
                 f.add(img);
             } catch (IOException ex) {
                 System.out.println("gui.MyFront.AfficheMytest()");             }
                     f.show();

                     
                       f.getToolbar().addCommandToOverflowMenu("Contact", null, (e) -> {
            new Contact().getF().show();
        });
                                      f.getToolbar().addCommandToOverflowMenu("Gestion des Quiz", null, (e) -> {
            new AffichageNiveau().getF().show();
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
             
                     

        } 
          } catch (IOException ex2) {
                 System.out.println("gui.MyFront.AfficheMytest()");             }
    }

    
 private void AfficheMytest(){
         try {

     Form f2 = new Form(BoxLayout.y());
            Image g = Image.createImage("/h.jpg");
            Container c =new Container(BoxLayout.x());
            Container cH =new Container(BoxLayout.y());
            Button bt = new  Button("         Home        ");
            Button bt2 = new Button("     Mes Tests       ");
       
             bt.getAllStyles().setBorder(Border.createEmpty());
             bt.getAllStyles().setBackgroundType(BACKGROUND_NONE);
             bt.getAllStyles().setBgTransparency(255);
             bt.getAllStyles().setBgColor(0x7F7191);
             
             bt2.getAllStyles().setBorder(Border.createEmpty());
             bt2.getAllStyles().setBackgroundType(BACKGROUND_NONE);
             bt2.getAllStyles().setBgTransparency(255);
             bt2.getAllStyles().setBgColor(0x7F7191);
             c.add(bt);
             c.add(bt2);

            f2.add(g);
            f2.add(c);
                 
                 Container mainContainer = new Container(BoxLayout.y());
                 Container bt5 = new Container(BoxLayout.x());
                 
                 Label ll = new Label("HTML");
                 ll.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
                 ll.getAllStyles().setFgColor(0x130043);
                 EncodedImage encb = EncodedImage.create("/done.png");
                // EncodedImage encb = EncodedImage.create("/done.png");
                 ImageViewer img = new ImageViewer(encb);
                 img.getAllStyles().setPaddingLeft(220);
                 mainContainer.add(buildPairLabel("Score  ", "10 reponce correcte"));
                 mainContainer.add(buildPairLabel("Min Temps  ", "30Min"));
                 mainContainer.add(buildPairLabel("Fait le  ", "27/05/2018"));
                 mainContainer.add(buildPairLabel("Niveau", "Niveau1"));
                 mainContainer.getAllStyles().setMarginLeft(20);
                 mainContainer.getAllStyles().setMarginRight(20);
                 mainContainer.getAllStyles().setBorder(Border.createEmpty());
                 mainContainer.getAllStyles().setBackgroundType(BACKGROUND_NONE);
                 mainContainer.getAllStyles().setBgTransparency(255);
                 mainContainer.getAllStyles().setBgColor(0xEBDBF5);
                 f2.add(ll);
                 f2.add(mainContainer);
                 f2.add(img);
                   bt2.addActionListener(K77->{
           AfficheMytest();
           });
           bt.addActionListener(K5->{
           Affichetest();
           });
                 
                 f2.getToolbar().addCommandToOverflowMenu("Contact", null, (e) -> {
            new Contact().getF().show();
        });
                                      f2.getToolbar().addCommandToOverflowMenu("Gestion des Quiz", null, (e) -> {
            new AffichageNiveau().getF().show();
        });      
               
                                                               
                Image icon = theme.getImage("icon.png");
            Container topBar = BorderLayout.east(new Label(icon));
            Toolbar tb = f2.getToolbar();
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
         
                                   
                                      
               f2.show();
} catch (IOException ex) {
                 System.out.println("gui.MyFront.AfficheMytest()");             }
   }       
    
 private void Affichetest(){
     try {
           Form f4 = new Form(BoxLayout.y());
            Image g = Image.createImage("/h.jpg");
            Container c =new Container(BoxLayout.x());
            Container cH =new Container(BoxLayout.y());
            Button bt = new  Button("         Home        ");
            Button bt2 = new Button("     Mes Tests       ");
       
             bt.getAllStyles().setBorder(Border.createEmpty());
             bt.getAllStyles().setBackgroundType(BACKGROUND_NONE);
             bt.getAllStyles().setBgTransparency(255);
             bt.getAllStyles().setBgColor(0x7F7191);
             
             bt2.getAllStyles().setBorder(Border.createEmpty());
             bt2.getAllStyles().setBackgroundType(BACKGROUND_NONE);
             bt2.getAllStyles().setBgTransparency(255);
             bt2.getAllStyles().setBgColor(0x7F7191);
             c.add(bt);
             c.add(bt2);
  bt2.addActionListener(K77->{
           AfficheMytest();
           });
           bt.addActionListener(K5->{
           Affichetest();
           });
            f4.add(g);
            f4.add(c);
            
         ArrayList<niveau> lstC =  n.getNiveauAvecTopic();
        for (niveau c2 : lstC) {
      
             try {
                 Container mainContainer = new Container(BoxLayout.y());
                 Container bt5 = new Container(BoxLayout.x());
                 
                 Label ll = new Label(c2.getNameEvaluation_id().getLibelle());
                 ll.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
                 ll.getAllStyles().setFgColor(0x130043);
                 EncodedImage encb = EncodedImage.create("/done2.png");
                 ImageViewer img = new ImageViewer(encb);
                 img.addPointerReleasedListener(p->{
                     System.out.println("clicked");
                     Question q = new Question(c2.getId());
                     q.getF().show();
                     
                 });
                 
                 img.getAllStyles().setPaddingLeft(220);
                 mainContainer.add(buildPairLabel("Min Score  ", String.valueOf(c2.getScore())));
                 mainContainer.add(buildPairLabel("Min Temps  ", String.valueOf(c2.getTemps())));
                 mainContainer.add(buildPairLabel("Niveau", c2.getRangeLevel()));
                 mainContainer.getAllStyles().setMarginLeft(20);
                 mainContainer.getAllStyles().setMarginRight(20);
                 mainContainer.getAllStyles().setBorder(Border.createEmpty());
                 mainContainer.getAllStyles().setBackgroundType(BACKGROUND_NONE);
                 mainContainer.getAllStyles().setBgTransparency(255);
                 mainContainer.getAllStyles().setBgColor(0xEBDBF5);
                 f4.add(ll);
                 f4.add(mainContainer);
                 f4.add(img);
                  
                     
                     
             } catch (IOException ex) {
                 System.out.println("gui.MyFront.AfficheMytest()");             }
                 
             f4.show();
   f4.getToolbar().addCommandToOverflowMenu("Contact", null, (e) -> {
            new Contact().getF().show();
        });
                                      f4.getToolbar().addCommandToOverflowMenu("Gestion des Quiz", null, (e) -> {
            new AffichageNiveau().getF().show();
        });
 
                                      
                                      
                Image icon = theme.getImage("icon.png");
            Container topBar = BorderLayout.east(new Label(icon));
            Toolbar tb = f4.getToolbar();
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
        } 
          } catch (IOException ex2) {
                 System.out.println("gui.MyFront.AfficheMytest()");             }
    } 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
    
    
    
    
    
    
 private Container buildPairLabel(String label, String value){
        Container c = new Container(BoxLayout.x());
        Label labelLabel = new Label(label+":");
        labelLabel.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
        Label labelValue = new Label(value);
        labelValue.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
        
        c.add(labelLabel);
        c.add(labelValue);
        return c;
    }

}
