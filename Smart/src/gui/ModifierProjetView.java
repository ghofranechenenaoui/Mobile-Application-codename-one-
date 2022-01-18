package gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.l10n.ParseException;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.CheckBox;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;

import entity.fosuser;
import com.mycompany.myapp.MyApplication;
import entity.Experience;
import entity.Projet;
import service.MembreService;
import java.util.ArrayList;
import java.util.List;
import service.ExperienceService;
import service.ProjetService;

public class ModifierProjetView {
    private Form parentForm;
    private Form form;
    private Projet exp;
    
    
    private TextField employeur;
    private TextField poste;
    private TextField periode;
   
    
    private TextArea description;
  
    private boolean selected = true;
    public ModifierProjetView(Form parentForm, Projet exp){
        Dialog i = new InfiniteProgress().showInifiniteBlocking();
        this.exp = exp;
        this.parentForm = parentForm;
        form = new Form("Modifier ", new BorderLayout());
        
       
     employeur = new TextField(exp.getTitre(), "titre", 60, TextField.ANY);

        poste = new TextField(exp.getPeriode(), "periode", 60, TextField.ANY);
         periode= new TextField(exp.getCategorie(), "categorie", 50, TextField.ANY);
       // periode = new TextField(exp.getPeriode(), "¨periode", 60, TextField.ANY);
        description = new TextField(exp.getDescription(), "description", 60, TextArea.ANY);
        
        final DefaultListModel<String> options = new DefaultListModel<>();
        
        
        buildContainer();
        
        form.getToolbar().addCommandToLeftBar("Back", MyApplication.theme.getImage("back-command.png"), (e) -> {
            parentForm.showBack();
        });
        i.dispose();
    }
    
    private void buildContainer(){
        Container c = new Container(BoxLayout.y());
        c.setScrollableY(true);
        c.getAllStyles().setMarginBottom(20);
        
        c.add(new Label("Titre: ")).add(employeur);
        c.add(new Label("Periode: ")).add(poste);
        c.add(new Label("Categorie: ")).add(periode);
        c.add(new Label("Description: ")).add(description);
     
       
        
        Button submitButton = new Button("Comfirmer");
        submitButton.getUnselectedStyle().setMarginTop(5);
        submitButton.addActionListener((e) -> {
          //  if(checkFormValidity()){
                Dialog i = new InfiniteProgress().showInifiniteBlocking();
               
                
                exp.setTitre(employeur.getText());
                exp.setPeriode(poste.getText());
                exp.setCategorie(periode.getText());
                exp.setDescription(description.getText());
                
              
                
                
                ProjetService.getInstance().editProjet(exp);
                Dialog.show("Projt modifier", "Votre Projet est modifié avec succés", "OK", "Cancel");

               ProfilSelfView a=new ProfilSelfView(parentForm, 0);
        a.getF().show();
           // }
        });
        
       
        c.add(submitButton);
        
        form.removeAll();
        form.add(BorderLayout.CENTER, c);
    }
    
  /*  private boolean checkFormValidity(){
        fosuser m = new fosuser();
        m.setBirth_date(birthdateField.getDate());
         if(usernameField.getText().isEmpty()){
            Dialog.show("Error", "Username is mandatory!", "Ok", null);
            return false;
        }else if(firstnameField.getText().isEmpty()){
            Dialog.show("Error", "Firstname is mandatory!", "Ok", null);
            return false;
        }else if(lastnameField.getText().isEmpty()){
            Dialog.show("Error", "Lastname is mandatory!", "Ok", null);
            return false;
        }else if(phoneField.getText().isEmpty()){
            Dialog.show("Error", "Phone number is mandatory!", "Ok", null);
            return false;
        }else if(phoneField.getText().length() != 8){
            Dialog.show("Error", "Phone number must contain exactly 8 digits!", "Ok", null);
            return false;
        }
            try{
                Integer.parseInt(phoneField.getText());
            }catch(NumberFormatException ex){
                Dialog.show("Error", "Phone number must contain only degits!", "Ok", null);
                return false;
            }
        
        return true;
    }
    */
    public Form getForm(){
        return form;
    }
}
