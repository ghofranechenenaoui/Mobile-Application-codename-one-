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
import service.MembreService;
import java.util.ArrayList;
import java.util.List;
import service.ExperienceService;

public class ModifierExperienceView {
    private Form parentForm;
    private Form form;
    private Experience exp;
    
    
    private TextField employeur;
    private TextField poste;
    private TextField periode;
   
    
    private TextArea description;
  
    private boolean selected = true;
    public ModifierExperienceView(Form parentForm, Experience exp){
        Dialog i = new InfiniteProgress().showInifiniteBlocking();
        this.exp = exp;
        this.parentForm = parentForm;
        form = new Form("Modifier ", new BorderLayout());
        
       
     employeur = new TextField(exp.getEmployeur(), "employeur", 60, TextField.ANY);

        employeur = new TextField(exp.getEmployeur(), "employeur", 60, TextField.ANY);
        poste = new TextField(exp.getPoste(), "poste", 60, TextField.ANY);
        periode = new TextField(exp.getPeriode(), "¨periode", 60, TextField.ANY);
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
        
        c.add(new Label("Employeur: ")).add(employeur);
        c.add(new Label("Poste: ")).add(poste);
        c.add(new Label("Periode: ")).add(periode);
        c.add(new Label("Description: ")).add(description);
     
       
        
        Button submitButton = new Button("Comfirmer");
        submitButton.getUnselectedStyle().setMarginTop(5);
        submitButton.addActionListener((e) -> {
          //  if(checkFormValidity()){
                Dialog i = new InfiniteProgress().showInifiniteBlocking();
               
                
                exp.setEmployeur(employeur.getText());
                exp.setPoste(poste.getText());
                exp.setPeriode(periode.getText());
                exp.setDescription(description.getText());
                
              
                
                
                ExperienceService.getInstance().editExperience(exp);
                Dialog.show("Experience modifiée", "Votre Experience est modifiée avec succés", "OK", "Cancel");

               ProfilSelfView a=new ProfilSelfView(parentForm, 119);
        a.getF().show();
           // }
        });
        
       
        c.add(submitButton);
        
        form.removeAll();
        form.add(BorderLayout.CENTER, c);
    }
    
 
    public Form getForm(){
        return form;
    }
}
