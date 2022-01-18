/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.MyApplication;
import service.*;
import entity.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author bhk
 */
public class AjouterNiveau {

    Form f;
    TextField ttemps;
    TextField tscore;
    TextField tniveau;
    TextField tevaluation;
    ComboBox  combo ;
    Button btnajout,btnaff;
    private  static int evaluation; 
    niveau t ;
    public static int geteva() {
        return evaluation;
    }

     public static void seteva(int eva) {
        evaluation = eva;
    }

    public AjouterNiveau() {
        Container A = new Container(BoxLayout.y());
        Container bt1 = new Container(BoxLayout.x());
        Container bt2 = new Container(BoxLayout.x());
        Container bt3 = new Container(BoxLayout.x());
        Container bt4 = new Container(BoxLayout.x());
        bt3.getAllStyles().setPaddingTop(60);
        NiveauService ser = new NiveauService();
                   test ser2 = new test();

        f = new Form("Ajouter Niveau");
        Label LScore = new Label("Score");
        tscore = new TextField("", "score", 20, TextField.DECIMAL);
        tscore.getAllStyles().setMarginLeft(6);
        bt1.add(LScore);
        bt1.add(tscore);
        Label Ltemps = new Label("temps");
        ttemps = new TextField("", "temps", 20, TextField.DECIMAL);
        ttemps.getAllStyles().setMarginLeft(5);
        bt2.add(Ltemps);
        bt2.add(ttemps);
        Label LNiv = new Label("Niveau");
        tniveau = new TextField("", "Niveau");
        tniveau.getAllStyles().setMarginLeft(5);
        bt3.add(LNiv);
        bt3.add(tniveau);
        Label LEva = new Label("Evaluation");
        bt4.add(LEva);
        btnajout = new Button("ajouter");
        btnajout.getAllStyles().setMarginLeft(37);
        btnaff=new Button("Affichage");
        evaluation eva = new evaluation();
        ArrayList<evaluation> lstC = ser2.getEva();
        combo = new ComboBox();        
        for (evaluation c : lstC) {
        combo.addItem(c.getLibelle());
        combo.addActionListener(e2 ->{
        String test =combo.getSelectedItem().toString();
        seteva(c.getId());});
         } 

        btnajout.addActionListener((e) -> {
        t = new niveau(0,tniveau.getText(),(Integer.parseInt(tscore.getText())),Integer.parseInt(ttemps.getText()),geteva());
            ser.ajoutNiveau(t);
            System.out.println("Ajouter nchlh");}); 
        
       ImageViewer g = new ImageViewer ();
        try {
            EncodedImage encb = EncodedImage.create("/user.png");
    g.setImage(encb);
        } catch (IOException ex) {
     System.out.println(ex.getMessage()); 
        }
       
         f.getToolbar().addCommandToRightBar("back", null, (ev)->{AffichageNiveau h=new AffichageNiveau();
        h.getF().show();
          });                
  
               

        f.add(bt3);
        f.add(bt1);
        f.add(bt2);
        f.add(bt4);
        f.add(combo);
        f.add(btnajout);

        
       
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
   
}
