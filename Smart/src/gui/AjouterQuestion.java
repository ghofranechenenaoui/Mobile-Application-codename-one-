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
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.MyApplication;
import service.*;
import entity.*;
import static gui.AjouterNiveau.seteva;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author bhk
 */
public class AjouterQuestion {

    Form f;
    TextField Rep1;
    TextField Rep2;
    TextField Rep3;
    TextField RepC;
    TextField Question;
    ComboBox  combo ;
    Button btnajout,btnaff;
    private  static int niveau; 
    questions t ;
   
      public static int getNv() {
        return niveau;
    }

     public static void setNv(int eva) {
        niveau = eva;
    }

    public AjouterQuestion() {
        Container A = new Container(BoxLayout.y());
        Container bt1 = new Container(BoxLayout.x());
        Container bt2 = new Container(BoxLayout.x());
        Container bt3 = new Container(BoxLayout.x());
        Container bt4 = new Container(BoxLayout.x());
        Container bt5 = new Container(BoxLayout.x());
        Container bt6 = new Container(BoxLayout.x());
        bt3.getAllStyles().setPaddingTop(60);
        QuestionService ser = new QuestionService();
        NiveauService ser2 = new NiveauService();

        f = new Form("Ajouter Question");
        Label LRep1 = new Label("Reponse 1");
        LRep1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        Rep1 = new TextField("", "Reponse 1", 20, TextField.ANY);
        LRep1.getAllStyles().setMarginLeft(1);
        bt1.add(LRep1);
        bt1.add(Rep1);
        
        Label LRep2 = new Label("Reponse 2");
        Rep2 = new TextField("", "Reponse 2", 20, TextField.ANY
        );
        LRep2.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        Rep2.getAllStyles().setMarginLeft(1);
        
        bt2.add(LRep2);
        bt2.add(Rep2);
        Label LNiv = new Label("Question");
        Question = new TextField("", "Question");
        LNiv.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        Question.getAllStyles().setMarginLeft(3);
        bt3.add(LNiv);
        bt3.add(Question);
        Label Lrep3= new Label("Reponse 3");
        Rep3 = new TextField("", "Reponse 3", 20, TextField.ANY
        );
                Rep3.getAllStyles().setMarginLeft(1);
        Lrep3.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        bt5.add(Lrep3);
        bt5.add(Rep3);
         Label LrepC = new Label("Reponse Correcte");
        LrepC.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        RepC = new TextField("", "Reponse Correcte", 20, TextField.ANY
        );
        
        bt6.add(LrepC);
        bt6.add(RepC);
        btnajout = new Button("ajouter");
        btnajout.getAllStyles().setMarginLeft(37);
        
        ArrayList<niveau> lstC = ser2.getNiveau();
        
        btnajout.addActionListener((e) -> {
        }); 
         Label TN = new Label("Topic /Niveau");
        TN.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
         combo = new ComboBox();        
        for (niveau c : lstC) {
            String ss=c.getRangeLevel() +"/"+c.getNameEvaluation_id().getLibelle();
        combo.addItem(ss);
        combo.addActionListener(e2 ->{
            setNv(c.getId());
        String test =combo.getSelectedItem().toString();
        });
         }
         f.getToolbar().addCommandToRightBar("back", null, (ev)->{AffichageQuestion h=new AffichageQuestion();
        h.getF().show();
          });  
    
  
        
        btnajout.addActionListener((e) -> {
        t = new questions(Question.getText(),Rep1.getText(),Rep2.getText(),Rep3.getText(),RepC.getText(),getNv());
            ser.ajoutQuestion(t);
            System.out.println("Ajouter nchlh");}); 
  
        f.getToolbar().addCommandToRightBar("back", null, (ev)->{AffichageQuestion h=new AffichageQuestion();
        h.getF().show();
          });                

        f.add(bt3);
        f.add(bt1);
        f.add(bt2);
        f.add(bt5);
        f.add(bt6);
        f.add(TN);
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
