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
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import static com.codename1.ui.plaf.Style.BACKGROUND_NONE;
import com.codename1.ui.plaf.UIManager;
import entity.categorie_quiz;
import entity.evaluation;
import java.io.IOException;

import java.util.ArrayList;
import javafx.scene.text.TextAlignment;
import service.*;

/**
 *
 * @author bhk
 */
public class Affichage_1 {

    Form f = new Form ("Gestion des Catégorie");
    SpanLabel lb;
    private String libelle;
    public Affichage_1() {
        String Cat = "             Categorie";
        Label Titre = new Label("        Gestion des Catégorie");
        Titre.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
        f = new Form();
        Label Libelle = new Label();
        lb = new SpanLabel("");
        test serviceTask=new test();
        
        test n = new test();
        ArrayList<evaluation> lstC =  n.getEvaCat();;

      //  lb.setText(serviceTask.getList2().toString());
      //  f.add(lb);
      
        Accordion accr = new Accordion();
        for (evaluation c : lstC) {
        Container cn2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        libelle = c.getLibelle();
        Button bt2 = new Button("Edit");
        bt2.getUnselectedStyle().setBorder(RoundBorder.create().rectangle(true));
        bt2.getAllStyles().setPaddingRight(15);
        Button bt1 = new Button("Delete");
        bt1.getAllStyles().setPaddingRight(15);
        bt1.getUnselectedStyle().setBorder(RoundBorder.create().rectangle(true));
        bt1.addActionListener((e555) -> { n.DeleteCat(c.getId());});
        cn2.add(bt2);
        cn2.add(bt1); 
       Label l5 = new Label(c.getLibelle());
       l5.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
       l5.getAllStyles().setMarginLeft(120);
       l5.getAllStyles().setMarginRight(90);
       Label l6 = new Label(String.valueOf(c.getId()));
       l6.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
        accr.addContent(l5, 
        BoxLayout.encloseY(new Label("id:  "+String.valueOf(c.getId())),
        new Label("Catégorie:"+c.getCategorie_quiz().getLibelle()),
//        new Label( "Description:"+c.getDescriptionEva()),
        new Label( "Nb des test:"+c.getNb()),cn2));
        }
     accr.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
     
       ImageViewer g = new ImageViewer ();

        try {
            EncodedImage encb = EncodedImage.create("/user.png");
    g.setImage(encb);
        } catch (IOException ex) {
     System.out.println(ex.getMessage()); 
        }         
         Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
        FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_STAR_HALF, s);
        f.getToolbar().addCommandToOverflowMenu("Ajouter une catégorie",null, (e) ->{
            HomeForm_1 h=new HomeForm_1();
        h.getF().show();
});
        f.getToolbar().addCommandToOverflowMenu("Ajouter un Topic",null, (e) ->{
           
});

        Toolbar tb = f.getToolbar();
Container topBar = BorderLayout.east(g);
topBar.add(BorderLayout.SOUTH, new Label("Admin", "SidemenuTagline")); 
topBar.setUIID("SideCommand");
tb.addComponentToSideMenu(topBar);

tb.addMaterialCommandToSideMenu("Gestion des Questions", FontImage.MATERIAL_HOME, e -> {
            AffichageQuestion h=new AffichageQuestion();

}); 
tb.addMaterialCommandToSideMenu("Gestion des Niveaux", FontImage.MATERIAL_WEB, e -> {
 AffichageNiveau h=new AffichageNiveau();
        h.getF().show();
});
        tb.addMaterialCommandToSideMenu("Gestion Cat/Topic", FontImage.MATERIAL_SETTINGS, e -> {
});
Label lala = new Label("");
 f.add(Titre);  
f.add(accr);

        accr.getAllStyles().setMarginTop(10);
        accr.getAllStyles().setBgColor(0xFDFBF9);
        accr.getAllStyles().setBorder(Border.createEmpty());
        accr.getAllStyles().setBackgroundType(BACKGROUND_NONE);
        accr.getAllStyles().setBgTransparency(255);
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
