/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.mycompany.myapp.MyApplication;
import service.ExperienceService;
import entity.Experience;
import entity.Formation;
import service.FormationService;

/**
 *
 * @author bhk
 */
public class AjouterFormationView {

    Form f;
    TextField employeur;
    TextField poste;
        TextField periode;
    TextField description;
    private Form parentForm;

    Button btnajout,btnaff;

    public AjouterFormationView(int memberId) {
                Dialog i = new InfiniteProgress().showInifiniteBlocking();

        f = new Form("Ajouter Formtaion");
        f.getToolbar().addCommandToLeftBar("Back", MyApplication.theme.getImage("back-command.png"), (e) -> {
            parentForm.showBack();
        });
        i.dispose();
        employeur = new TextField("","Titre");
        poste = new TextField("","Periode");
        periode = new TextField("","Specialite");
        description = new TextField("","description");
        btnajout = new Button("Ajouter");
                btnaff=new Button("Annuler");
         f.add(new Label("Titre: "));        
        f.add(employeur);
          f.add(new Label("Periode: "));  
        f.add(poste);
          f.add(new Label("Specialite: "));  
         f.add(periode);
           f.add(new Label("Description: "));  
          f.add(description);
        f.add(btnajout);
        f.add(btnaff);
        btnajout.addActionListener((e) -> {
            FormationService ser = new FormationService();
 Formation t = new Formation(0, employeur.getText(), poste.getText(), periode.getText(),description.getText());
            ser.ajoutFormation(t);
             Dialog.show("Formation ajouté", "Votre Formation est ajouté avec succés", "OK", "Cancel");
ProfilSelfView a=new ProfilSelfView(parentForm, 0);
        a.getF().show();
        });
        btnaff.addActionListener((e)->{
        ProfilSelfView a=new ProfilSelfView(parentForm, memberId);
        a.getF().show();
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getEmployeur() {
        return employeur;
    }

    public void setEmployeur(TextField employeur) {
        this.employeur = employeur;
    }
     public TextField getPoste() {
        return poste;
    }

    public void setPoste(TextField poste) {
        this.poste = poste;
    }
  public TextField getPeriode() {
        return periode;
    }

    public void setPeriode(TextField periode) {
        this.periode = periode;
    }
      public TextField getDescription() {
        return description;
    }

    public void setDescription(TextField description) {
        this.description = description;
    }
}
