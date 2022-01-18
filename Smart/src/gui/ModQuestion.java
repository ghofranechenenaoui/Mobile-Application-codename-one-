/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import entity.*;
import service.*;
import java.util.ArrayList;
import java.util.List;

public class ModQuestion {
    private Form parentForm;
    private Form form;
    private questions exp;
    
    
    private TextField description;
    private TextField correcte;
    private TextField rep1;
    private TextField rep2;
    private TextField rep3;
   
     AffichageQuestion a;
  
    private boolean selected = true;
    public ModQuestion(Form parentForm, questions exp){
        Dialog i = new InfiniteProgress().showInifiniteBlocking();
        this.exp = exp;
        this.parentForm = parentForm;
        form = new Form("Modifier ", new BorderLayout());
        
       
        description = new TextField(exp.getDescription(), "employeur", 60, TextField.ANY);
        rep1 = new TextField(exp.getRep1(), "poste", 60, TextField.ANY);
        rep2 = new TextField(exp.getRep2(), "¨periode", 60, TextField.ANY);
        rep3 = new TextField(exp.getRep3(), "¨periode", 60, TextField.ANY);
        correcte = new TextField(exp.getCorrectReq(), "description", 60, TextArea.ANY);
        
        final DefaultListModel<String> options = new DefaultListModel<>();
        
        
        buildContainer();
        
        //form.getToolbar().addCommandToLeftBar("Back", MyApplication.theme.getImage("back-command.png"), (e) -> {
        //    parentForm.showBack();
       // });
        i.dispose();
    }
    
    private void buildContainer(){
        Container c = new Container(BoxLayout.y());
        c.setScrollableY(true);
        c.getAllStyles().setMarginBottom(20);
        
        c.add(new Label("Question: ")).add(description);
        c.add(new Label("Rep 1: ")).add(rep1);
        c.add(new Label("Rep 2: ")).add(rep2);
        c.add(new Label("Rep 3: ")).add(rep3);
        c.add(new Label("correcte: ")).add(correcte);
     
       
        
        Button submitButton = new Button("Comfirmer");
        submitButton.getUnselectedStyle().setMarginTop(5);
          QuestionService g= new QuestionService();
          
        submitButton.addActionListener((e) -> {
          // if(checkFormValidity()){
                Dialog i = new InfiniteProgress().showInifiniteBlocking();
               
                exp.setCorrectReq(correcte.getText());
                exp.setDescription(description.getText());
                exp.setRep1(rep1.getText());
                exp.setRep2(rep2.getText());
                exp.setRep3(rep3.getText());
                g.EditQuestion(exp);
                a=new AffichageQuestion();
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



    public Form getF() {
        return form;
    }

    public void setF(Form f) {
        this.form = f;
    }
    

   
}
