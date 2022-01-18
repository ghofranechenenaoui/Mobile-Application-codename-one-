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
import service.MembreService;
import java.util.ArrayList;
import java.util.List;

public class EditFormView {
    private Form parentForm;
    private Form form;
    private fosuser member;
    
    private Picker birthdateField;
    private TextField usernameField;
    private TextField firstnameField;
    private TextField lastnameField;
    private RadioButton maleField;
    private RadioButton femaleField;
   
    private TextField phoneField;
    
    private TextField emailField;
  
    private boolean selected = true;
    public EditFormView(Form parentForm, fosuser member){
        Dialog i = new InfiniteProgress().showInifiniteBlocking();
        this.member = member;
        this.parentForm = parentForm;
        form = new Form("Edit", new BorderLayout());
        
       
        birthdateField = new Picker();
        birthdateField.setDate(member.getBirth_date());
        usernameField = new TextField(member.getUsername(), "Username", 60, TextField.ANY);
        firstnameField = new TextField(member.getFirstname(), "Firstname", 60, TextField.ANY);
        lastnameField = new TextField(member.getLastname(), "Firstname", 60, TextField.ANY);
        maleField = new RadioButton("Male");
        femaleField = new RadioButton("Female");
        new ButtonGroup(maleField, femaleField);
        if(member.isGender()) maleField.setSelected(true); else femaleField.setSelected(true);
       
        phoneField = new TextField(member.getPhone()+"", "Photo Number", 8, TextField.PHONENUMBER);
      
        emailField = new TextField(member.getEmail(), "Email", 60, TextField.EMAILADDR);
       
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
        
        c.add(new Label("Email: ")).add(emailField);
        c.add(new Label("Username: ")).add(usernameField);
        c.add(new Label("Firstname: ")).add(firstnameField);
        c.add(new Label("Lastname: ")).add(lastnameField);
        c.add(new Label("Birthdate: ")).add(birthdateField);
        c.add(new Label("Phone Number: ")).add(phoneField);
        Container genderContainer = new Container(BoxLayout.x());
        c.add(new Label("Gender: "));
        genderContainer.add(maleField).add(femaleField);
        c.add(genderContainer);
       
        
        Button submitButton = new Button("Confirm");
        submitButton.getUnselectedStyle().setMarginTop(5);
        submitButton.addActionListener((e) -> {
          //  if(checkFormValidity()){
                Dialog i = new InfiniteProgress().showInifiniteBlocking();
                member.setBirth_date(birthdateField.getDate());
                member.setUsername(usernameField.getText());
                member.setFirstname(firstnameField.getText());
                member.setLastname(lastnameField.getText());
                member.setGender(maleField.isSelected());
              
                member.setPhone(Integer.parseInt(phoneField.getText()));
               
                member.setEmail(emailField.getText());
                
                MembreService.getInstance().editMemeber(member);
Dialog.show("Profil modifier", "Votre profil est modifiée avec succés", "OK", "Cancel");

                               ProfilSelfView a=new ProfilSelfView(parentForm, 0);
        a.getF().show();
           // }
        });
        
        Validator v = new Validator();
        v.addConstraint(emailField, RegexConstraint.validEmail("Unvalid email!"));
        v.addSubmitButtons(submitButton);
        
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
