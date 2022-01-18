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
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import static com.codename1.ui.plaf.Style.BACKGROUND_NONE;
import com.codename1.ui.plaf.UIManager;
import entity.categorie_quiz;
import entity.questions;
import java.io.IOException;

import java.util.ArrayList;

import javafx.scene.text.TextAlignment;
import service.*;

/**
 *
 * @author bhk
 */
public class AffichageQuestion {
    Form f = new Form ("Gestion des Catégorie");
    SpanLabel lb;
    private String libelle;
  private  static questions  questions;
    public AffichageQuestion() {
         try {
         Label Titre = new Label("         Gestion des Questions");
        Titre.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
        f = new Form(new BoxLayout(BoxLayout.Y_AXIS));
        lb = new SpanLabel("");
        QuestionService Question=new QuestionService();
        QuestionService n = new QuestionService();
        ArrayList<questions> lstC =  n.getQuestion();;
        SpanLabel lb;
       // Container cn = new Container(new BoxLayout(BoxLayout.Y_AXIS));
       //Container cn2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        BoxLayout b =   new BoxLayout(BoxLayout.X_AXIS);
        Accordion accr = new Accordion();
        f.add(Titre); 
     for (questions c : lstC) {
        Container bt = new Container(BoxLayout.x());
        bt.setX(1);
        ImageViewer delete;
        ImageViewer edit;
        EncodedImage enc = EncodedImage.create("/delete.png");
        EncodedImage enc2 = EncodedImage.create("/edit.png");
        delete =new ImageViewer(enc);
        edit =new ImageViewer(enc2);
        
        bt.add(delete);
        bt.add(edit);
        
        
  
        bt.getAllStyles().setMarginLeft(230);
        
        Container mainContainer = new Container(BoxLayout.y());
        mainContainer.getAllStyles().setMarginLeft(30);
       
        mainContainer.getAllStyles().setMarginRight(30);
        mainContainer.getAllStyles().setBorder(Border.createEmpty());
        mainContainer.getAllStyles().setBackgroundType(BACKGROUND_NONE);
        mainContainer.getAllStyles().setBgTransparency(255);
        mainContainer.getAllStyles().setBgColor(0x99CCCCCC);
        Label ll = new Label("Question :"+ c.getDescription());
        ll.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        mainContainer.add(buildPairLabel("reponse 1 ", c.getRep1()));
        mainContainer.add(buildPairLabel("reponse 2 ", c.getRep2()));
        mainContainer.add(buildPairLabel("reponse 3 ",c.getRep3()));
        mainContainer.add(buildPairLabel("reponse Correcte ", c.getCorrectReq()));
         f.add(ll);
         f.add(mainContainer);
         f.add(bt);
         
       delete.addPointerReleasedListener(e555 ->{
       n.DeleteQuestion(c.getId());});
 System.out.println("//////////////////////////////////");
     
 //***************************************************************************       

 edit.addPointerReleasedListener(E->{
       questions = c;
       ModQuestion mod =new ModQuestion(f,c);
       mod.getF().show();
  System.out.println("******************************test************************");
 System.out.println(getQuestion());
System.out.println("******************************test************************");

 });

 
//***************************************************************************       
     }

accr.getAllStyles().setPaddingTop(40);
 } catch (IOException ex) {
     System.out.println(ex.getMessage()); 
     }

       ImageViewer g = new ImageViewer ();

        try {
            EncodedImage encb = EncodedImage.create("/user.png");
    g.setImage(encb);
        } catch (IOException ex) {
     System.out.println(ex.getMessage()); 
        }         
 
Toolbar tb = f.getToolbar();
Container topBar = BorderLayout.east(g);
topBar.add(BorderLayout.SOUTH, new Label("Admin", "SidemenuTagline")); 
topBar.setUIID("SideCommand");
tb.addComponentToSideMenu(topBar);

tb.addMaterialCommandToSideMenu("Gestion des Questions", FontImage.MATERIAL_HOME, e -> {
}); 
tb.addMaterialCommandToSideMenu("Gestion des Niveaux", FontImage.MATERIAL_WEB, e -> {
 AffichageNiveau h=new AffichageNiveau();
        h.getF().show();
});
        tb.addMaterialCommandToSideMenu("Gestion Cat/Topic", FontImage.MATERIAL_SETTINGS, e -> {
        Affichage_1 h=new Affichage_1();
        h.getF().show();
});
        
        Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
        FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_STAR_HALF, s);
        f.getToolbar().addCommandToOverflowMenu("Ajouter un Question",null, (e) ->{
            AjouterQuestion h=new AjouterQuestion();
        h.getF().show();
});        
        
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
    

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

      public  static questions getQuestion() {
        return questions; }
        
        public  static void setQuestion(questions questions){
            questions=questions;
        }
    
    
    

}
