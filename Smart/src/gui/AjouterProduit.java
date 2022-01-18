/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import static com.mycompany.myapp.MyApplication.MemberId;
import static com.mycompany.myapp.MyApplication.theme;
import service.ServiceProduit;
import java.io.IOException;



/**
 *
 * @author ASUS
 */
public class AjouterProduit {
     Form f;
      SpanLabel lb;
    //TextArea ta;
  
    public AjouterProduit(){
        
         //try {
             f = new Form();
             
             //ta = new TextArea("");
             
             
             ServiceProduit serviceProduit=new ServiceProduit();
             int j =serviceProduit.getList2().size();
             int i = 0;
             do {
                 System.out.println(serviceProduit.getList2().get(i).getNom());
                 
                 lb = new SpanLabel("");
                 f.add(lb);
                 lb.setText(serviceProduit.getList2().get(i).getNom()+" "+serviceProduit.getList2().get(i).getDescription()+" "+
                         serviceProduit.getList2().get(i).getCreateur()+" "+serviceProduit.getList2().get(i).getTaille()+" "+serviceProduit.getList2().get(i).getCategorie()
                         + " " +serviceProduit.getList2().get(i).getPrix()
                 );
                 //lb.setText("\n");
                 i++;
             }  while(i<j);
               // Image img = Image.createImage("/"+serviceProduit.getList2().get(12).getNomPhoto());
           //  ImageViewer iv = new ImageViewer(img);
          //   f.add(iv);
             
             //  System.out.println(serviceProduit.getList2().get(0).toString());
             
             
             
             
             
             f.getToolbar().addCommandToRightBar("back", null, (ev)->{ConsulterProduits h=new ConsulterProduits();
             h.getF().show();
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
         /*} catch (IOException ex) {
             System.out.println(ex.getMessage());
         }*/
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
