/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import service.*;
import entity.*;
import java.util.Date;
import javafx.scene.control.DatePicker;

/**
 *
 * @author bhk
 */
public class HomeForm_1 {

    Form f;
    TextField tnom;
    DatePicker Date;
    Button btnajout;

    public HomeForm_1() {
        f = new Form("  Ajouter des Catégories");
        tnom = new TextField("","Libelle");
        Label Label = new Label("Libelle");
        btnajout = new Button("ajouter");
        f.add(Label);
        f.add(tnom);
        f.add(btnajout);
        
        btnajout.getAllStyles().setMarginLeft(37);
        btnajout.addActionListener((e) -> {
            test ser = new test();
            categorie_quiz t = new categorie_quiz(0,tnom.getText());
            ser.ajoutTask(t);});
        
        f.getToolbar().addCommandToRightBar("back", null, (ev)->{Affichage_1 h=new Affichage_1();
        h.getF().show();
          });  
        
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTnom() {
        return tnom;
    }

    public void setTnom(TextField tnom) {
        this.tnom = tnom;
    }

}
