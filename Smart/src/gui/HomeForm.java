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
import service.MembreService;

/**
 *
 * @author bhk
 */
public class HomeForm {

    Form f;
    TextField employeur;
    TextField poste;
        TextField periode;
    TextField description;
    private Form parentForm;
    private Experience member;

    Button btnajout,btnaff;

    public HomeForm(int memberId) {
         this.member = ExperienceService.getInstance().getExperience(memberId);
                Dialog i = new InfiniteProgress().showInifiniteBlocking();

        f = new Form("Ajouter Experience");
        f.getToolbar().addCommandToLeftBar("Back", MyApplication.theme.getImage("back-command.png"), (e) -> {
            parentForm.showBack();
        });
        i.dispose();
        employeur = new TextField("","employeur");
        poste = new TextField("","poste");
        periode = new TextField("","periode");
        description = new TextField("","description");
        btnajout = new Button("Ajouter");
                btnaff=new Button("Annuler");
         f.add(new Label("Employeur: "));        
        f.add(employeur);
          f.add(new Label("Poste: "));  
        f.add(poste);
          f.add(new Label("Periode: "));  
         f.add(periode);
           f.add(new Label("Description: "));  
          f.add(description);
        f.add(btnajout);
        f.add(btnaff);
        btnajout.addActionListener((e) -> {
            
          /*   boolean valid = true;
            if (employeur.getText().equals("")) {
                employeur.setText("champ vide!");
                employeur.setVisible(true);
                valid = false;
            } else {
                employeur.setText("");

            }
            if (poste.getText().equals("")) {
                poste.setText("champ vide !");
                poste.setVisible(true);
                valid = false;
            } else {
                poste.setText("");

            }
            if (periode.getText().equals("")) {
                periode.setText("Champ invalide !");
                periode.setVisible(true);
                valid = false;
            } else {
                periode.setText("");

            }
            if (description.getText().equals("")) {
                description.setText("champ vide!");
                description.setVisible(true);
                valid = false;
            } else {
                description.setText("");

            }
              if (!valid) {
                return;
            }*/

            ExperienceService ser = new ExperienceService();
 Experience t = new Experience(0, employeur.getText(), poste.getText(), periode.getText(),description.getText());
            ser.ajoutExperience(t);
             Dialog.show("Experience ajouté", "Votre experience est ajouté avec succés", "OK", "Cancel");
ProfilSelfView a=new ProfilSelfView(parentForm, memberId);
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
