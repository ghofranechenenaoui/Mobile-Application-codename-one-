/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import entity.Enumerations;
import com.mycompany.myapp.MyApplication;


/**
 *
 * @author asus
 */
public class SignalView {
        Form f;
        TextField tcontent;
        RadioButton inappropriateRadio;
	RadioButton racismRadio;
	RadioButton profileRadio;
        RadioButton otherRadio;
        RadioButton violenceRadio;
        RadioButton HarrasmenentRadio;
        ButtonGroup group;
        Container typeCompteContainer;
        Button btnajout;
        
        
        private Form parentForm;
        private int receiverId;


    public SignalView(Form parentForm, int receiverId) {
        this.parentForm = parentForm;
        this.receiverId = receiverId;
        f = new Form("Add your signal ");
        
        f.getToolbar().addCommandToLeftBar("Back", MyApplication.theme.getImage("back-command.png"), (e) -> {
            parentForm.showBack();
        });
           
        tcontent = new TextField();
        tcontent.setHint("Add a description");
        Label signalR = new Label();
        signalR.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        signalR.getAllStyles().setFgColor(0xFF0000);
        btnajout = new Button("Submit");
        
        Label select = new Label("Reason of the signal:");
        select.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
        select.getAllStyles().setFgColor(0x343e43);
        Label Inappropriate_content =new Label("Inappropriate_content         ");
        Inappropriate_content.getAllStyles().setMarginLeft(10);
        Inappropriate_content.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        
        Label Racism =new Label("Racism                                    ");
        Racism.getAllStyles().setMarginLeft(10);
        Racism.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
	
        Label Violence =new Label("Violence                                 ");
        Violence.getAllStyles().setMarginLeft(10);
        Violence.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        Label Harrassment =new Label("Harrasment                            ");
        Harrassment.getAllStyles().setMarginLeft(10);
        Harrassment.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        Label False_profile =new Label("False_profile                         ");
        False_profile.getAllStyles().setMarginLeft(10);
        False_profile.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        Label Other =new Label("Other                                      ");
        Other.getAllStyles().setMarginLeft(10);
        Other.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));

        Label ReasonV = new Label();
        ReasonV.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        ReasonV.getAllStyles().setFgColor(0xFF0000);
        typeCompteContainer=new Container();
	inappropriateRadio =new RadioButton();
	racismRadio=new RadioButton();
	profileRadio=new RadioButton();
        otherRadio = new RadioButton();
        violenceRadio = new RadioButton();
        HarrasmenentRadio = new RadioButton();
        Container reasonContainer = new  Container(BoxLayout.y());
        Container inappContainer=new Container(BoxLayout.x());
        Container racismContainer=new Container(BoxLayout.x());
        Container profileContainer=new Container(BoxLayout.x());
        Container otherContainer=new Container(BoxLayout.x());
        Container violenceContainer=new Container(BoxLayout.x());
        Container harrasmentContainer=new Container(BoxLayout.x());
        group = new ButtonGroup(inappropriateRadio,racismRadio, profileRadio, otherRadio, violenceRadio, HarrasmenentRadio);
        inappContainer.add(Inappropriate_content).add(inappropriateRadio);
        racismContainer.add(Racism).add(racismRadio);
        profileContainer.add(False_profile).add(profileRadio);
        otherContainer.add(Other).add(otherRadio);
        violenceContainer.add(Violence).add(violenceRadio);
        harrasmentContainer.add(Harrassment).add(HarrasmenentRadio);
        reasonContainer.add(select).add(inappContainer).add(racismContainer).add(profileContainer).add(otherContainer).add(violenceContainer).add(harrasmentContainer).add(ReasonV).add(tcontent).add(signalR);
        f.add(reasonContainer);

        f.add(btnajout);
        btnajout.getAllStyles().setBackgroundGradientEndColor(0xFF0000);
        btnajout.getAllStyles().setMarginLeft(34);
        btnajout.addActionListener((l) -> {
           
               boolean valid = true;
               
            if (!group.isSelected()) {
            ReasonV.setText("You should select a reason !");
            ReasonV.setVisible(true);
            valid = false;
        } else {
            ReasonV.setText(""); 
        }
                            
             if (tcontent.getText().equals("")) {
            signalR.setText("Field is empty !");
            signalR.setVisible(true);
            valid = false;
        } else {
            signalR.setText(""); 
        }
          if(!valid) return;

        
           });
    }

    public Form getF() {
        return f;
    }

    public RadioButton getInappropriateRadio() {
        return inappropriateRadio;
    }

    public void setInappropriateRadio(RadioButton inappropriateRadio) {
        this.inappropriateRadio = inappropriateRadio;
    }

    public RadioButton getRacismRadio() {
        return racismRadio;
    }

    public void setRacismRadio(RadioButton racismRadio) {
        this.racismRadio = racismRadio;
    }

    public RadioButton getProfileRadio() {
        return profileRadio;
    }

    public void setProfileRadio(RadioButton profileRadio) {
        this.profileRadio = profileRadio;
    }

    public RadioButton getOtherRadio() {
        return otherRadio;
    }

    public void setOtherRadio(RadioButton otherRadio) {
        this.otherRadio = otherRadio;
    }

    public RadioButton getViolenceRadio() {
        return violenceRadio;
    }

    public void setViolenceRadio(RadioButton violenceRadio) {
        this.violenceRadio = violenceRadio;
    }

    public RadioButton getHarrasmenentRadio() {
        return HarrasmenentRadio;
    }

    public void setHarrasmenentRadio(RadioButton HarrasmenentRadio) {
        this.HarrasmenentRadio = HarrasmenentRadio;
    }

    public ButtonGroup getGroup() {
        return group;
    }

    public void setGroup(ButtonGroup group) {
        this.group = group;
    }




    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTcontent() {
        return tcontent;
    }

    public void setTcontent(TextField tcontent) {
        this.tcontent = tcontent;
    }

    public Button getBtnajout() {
        return btnajout;
    }

    public void setBtnajout(Button btnajout) {
        this.btnajout = btnajout;
    }

    public Container getTypeCompteContainer() {
        return typeCompteContainer;
    }

    public void setTypeCompteContainer(Container typeCompteContainer) {
        this.typeCompteContainer = typeCompteContainer;
    }
}
