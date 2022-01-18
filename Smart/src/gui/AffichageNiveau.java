/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.Accordion;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.Log;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import static com.codename1.ui.plaf.Style.BACKGROUND_NONE;
import com.codename1.ui.plaf.UIManager;
import entity.categorie_quiz;
import entity.niveau;
import entity.questions;
import java.io.IOException;

import java.util.ArrayList;


import service.*;

/**
 *
 * @author bhk
 */
public class AffichageNiveau {

    Form f = new Form ("Gestion des Niveaux");
    SpanLabel lb;
    private String libelle;
    public AffichageNiveau() {
       // String Cat = "             Question";
     // String Cat = "             Question";
   
     Label Titre = new Label("        Gestion des Niveaux");
        
        Titre.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
        f = new Form(new BoxLayout(BoxLayout.Y_AXIS));
        lb = new SpanLabel("");
        NiveauService n=new NiveauService();
        
        ArrayList<niveau> lstC =  n.getNiveau();;

      //  lb.setText(serviceTask.getList2().toString());
      //  f.add(lb);
       
        SpanLabel lb;

        Container cn = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container cn2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        BoxLayout b =   new BoxLayout(BoxLayout.X_AXIS);
        Accordion accr = new Accordion();
        f.add(Titre); 
        for (niveau c : lstC) {
        libelle = c.getRangeLevel();
       //bt1.getAllStyles().setMarginTop(10);
      
        Label infoLabel = new Label("Info");
        infoLabel.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        Container mainContainer = new Container(BoxLayout.y());
        Container bt = new Container(BoxLayout.x());
        bt.setX(1);
        bt.getAllStyles().setMarginLeft(170);
        mainContainer.getAllStyles().setMarginLeft(30);
        mainContainer.getAllStyles().setMarginRight(30);
        mainContainer.getAllStyles().setBorder(Border.createEmpty());
        mainContainer.getAllStyles().setBackgroundType(BACKGROUND_NONE);
        mainContainer.getAllStyles().setBgTransparency(255);
        mainContainer.getAllStyles().setBgColor(0x99CCCCCC);
        Label ll = new Label(c.getRangeLevel());
        ll.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        ll.getAllStyles().setMarginLeft(20);
        mainContainer.add(buildPairLabel("Score  ", String.valueOf(c.getScore())));
        mainContainer.add(buildPairLabel("temps  ", String.valueOf(c.getTemps())));
        mainContainer.add(buildPairLabel("evaluation  ",c.getNameEvaluation_id().getLibelle()));
    try {
        
      EncodedImage enc = EncodedImage.create("/delete.png");
      EncodedImage enc2 = EncodedImage.create("/edit.png");
     ImageViewer delete =new ImageViewer(enc);
     ImageViewer edit =new ImageViewer(enc2);
     delete.addPointerReleasedListener(e555 ->{
     n.DeleteNiveau(c.getId());}
);


     bt.getAllStyles().setMarginLeft(230);
     bt.add(delete);
     bt.add(edit);
     } catch (IOException ex) {
     System.out.println(ex.getMessage()); 
     }          
     f.add(ll);
     f.add(mainContainer);
     f.add(bt);
        }
        
        
    
       ImageViewer g = new ImageViewer ();

        try {
            EncodedImage encb = EncodedImage.create("/user.png");
    g.setImage(encb);
        } catch (IOException ex) {
     System.out.println(ex.getMessage()); 
        }
        Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
        FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_STAR_HALF, s);
        f.getToolbar().addCommandToOverflowMenu("Ajouter un Niveau",null, (e) ->{
            AjouterNiveau h=new AjouterNiveau();
        h.getF().show();
});
        
        
        
        

Toolbar tb = f.getToolbar();
Container topBar = BorderLayout.east(g);
topBar.add(BorderLayout.SOUTH, new Label("Admin", "SidemenuTagline")); 
topBar.setUIID("SideCommand");
tb.addComponentToSideMenu(topBar);

tb.addMaterialCommandToSideMenu("Gestion des Questions", FontImage.MATERIAL_HOME, e -> {
  AffichageQuestion h=new AffichageQuestion();
        h.getF().show();
}); 
tb.addMaterialCommandToSideMenu("Gestion des Niveaux", FontImage.MATERIAL_WEB, e -> {});
tb.addMaterialCommandToSideMenu("Gestion Cat/Topic", FontImage.MATERIAL_SETTINGS, e -> {
        Affichage_1 h=new Affichage_1();
        h.getF().show();
});
accr.getAllStyles().setPaddingTop(40);}
    
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
    

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}

