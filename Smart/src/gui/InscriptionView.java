/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.AutoCompleteTextField;
//import javax.mail.Message;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.Constraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import entity.UserRegister;
import entity.fosuser;
import utils.SMS;

import service.InscriptionService;
import java.util.ArrayList;
import java.util.List;
//import com.sun.mail.smtp.SMTPTransport;
//import java.util.Date;
////import java.util.Properties;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;

/**
 *
 * @author asus
 */
public class InscriptionView {

    Form f;
    TextField tfirstname;
    TextField tlastname;
    TextField tpseudo;
    TextField tphone;
    
    RadioButton maleRadio;
    RadioButton femaleRadio;
    ButtonGroup group;
   
    Picker birthdate;
   
    Button btnajout;
    public static UserRegister u1;

    private boolean selected;

//    Picker body;
    public InscriptionView() {
        f = new Form("Inscription", BoxLayout.y());
        tfirstname = new TextField();
        tfirstname.setHint("Firstname");
        Label labelname = new Label();
        labelname.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        labelname.getAllStyles().setFgColor(0xFF0000);
        tlastname = new TextField();
        tlastname.setHint("Lastname");
        Label labelLast = new Label();
        labelLast.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        labelLast.getAllStyles().setFgColor(0xFF0000);
        TextField email = new TextField("", "E-Mail", 30, TextField.EMAILADDR);
        Label labelemail = new Label();
        labelemail.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        labelemail.getAllStyles().setFgColor(0xFF0000);
        Label labelemailV = new Label();
        labelemailV.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        labelemailV.getAllStyles().setFgColor(0xFF0000);
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD);
        Label labelPassword = new Label();
        labelPassword.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        labelPassword.getAllStyles().setFgColor(0xFF0000);
        TextField confirmPassword = new TextField("", "Confirm Password", 30, TextField.PASSWORD);
        Label labelRPassword = new Label();
        labelRPassword.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        labelRPassword.getAllStyles().setFgColor(0xFF0000);
        tpseudo = new TextField();
        tpseudo.setHint("pseudo");
        Label labelPseudo = new Label();
        labelPseudo.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        labelPseudo.getAllStyles().setFgColor(0xFF0000);
        tphone = new TextField();
        tphone.setHint("phone");
        Label labelPhone = new Label();
        labelPhone.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        labelPhone.getAllStyles().setFgColor(0xFF0000);
       
        Container genderContainer = new Container(BoxLayout.x());
        Label Gender = new Label("Gender :");
        Gender.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        Gender.getAllStyles().setFgColor(0x09345E);
        Label male = new Label("Male");
        male.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        Label female = new Label("Female");
        female.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        maleRadio = new RadioButton();
        femaleRadio = new RadioButton();
        Label Vgender = new Label();
        Vgender.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        Vgender.getAllStyles().setFgColor(0xFF0000);
        genderContainer.add(Gender).add(male).add(maleRadio).add(female).add(femaleRadio);
        group = new ButtonGroup(maleRadio, femaleRadio);

   
        Container cntBirth = new Container(BoxLayout.x());
        birthdate = new Picker();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(this.birthdate.getDate());
        Label birthText = new Label("Birth Date :");
        cntBirth.add(birthText).add(birthdate);
        birthText.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        birthText.getAllStyles().setFgColor(0x09345E);

       
        btnajout = new Button("Continuer");
        f.add(tfirstname);
        f.add(labelname);
        f.add(tlastname);
        f.add(labelLast);
        f.add(tpseudo);
        f.add(labelPseudo);
        f.add(email);
        f.add(labelemail);
        f.add(labelemailV);
        f.add(tphone);
        f.add(labelPhone);
        f.add(password);
        f.add(labelPassword);
        f.add(confirmPassword);
        f.add(labelRPassword);
        f.add(genderContainer);
        f.add(Vgender);
        maleRadio.isSelected();
       // f.add(cntBirth);
       
      
       
        f.add(btnajout);

      //  Validator v = new Validator();
       // v.addConstraint(email, RegexConstraint.validEmail("Unvalid email!"));
       // v.addSubmitButtons(btnajout);

        btnajout.addActionListener((l) -> {
            boolean valid = true;
            if (tfirstname.getText().equals("")) {
                labelname.setText("Field is empty !");
                labelname.setVisible(true);
                valid = false;
            } else {
                labelname.setText("");

            }
            if (tlastname.getText().equals("")) {
                labelLast.setText("Field is empty !");
                labelLast.setVisible(true);
                valid = false;
            } else {
                labelLast.setText("");

            }
            if (email.getText().equals("")) {
                labelemail.setText("Field is empty !");
                labelemail.setVisible(true);
                valid = false;
            } else {
                labelemail.setText("");

            }
           /* if (!email.getText().equals("")) {
                labelemailV.setText("Mail not valid !");
                labelemailV.setVisible(true);
                valid = false;
            } else {
                labelemailV.setText("");

            }*/

            if (tpseudo.getText().equals("")) {
                labelPseudo.setText("Field is empty !");
                labelPseudo.setVisible(true);
                valid = false;
            } else {
                labelPseudo.setText("");

            }

            if (tphone.getText().equals("")) {
                labelPhone.setText("Field is empty !");
                labelPhone.setVisible(true);
                valid = false;
            } else {
                labelPhone.setText("");

            }
         

            
            
            if (password.getText().equals("")) {
                labelPassword.setText("Field is empty !");
                labelPassword.setVisible(true);
                valid = false;
            } else {
                labelPassword.setText("");
            }

            if (confirmPassword.getText().equals("")) {
                labelRPassword.setText("Field is empty !");
                labelRPassword.setVisible(true);
                valid = false;
            }

            if (!password.getText().equals(confirmPassword.getText())) {
                labelRPassword.setText("Password doesn't match !");
                labelRPassword.setVisible(true);
                valid = false;
            } else if (password.getText().equals(confirmPassword.getText()) && !password.getText().equals("")) {
                labelRPassword.setText("Password match !");
                labelRPassword.getAllStyles().setFgColor(0x388D38);
                labelRPassword.setVisible(true);
          
            if (!maleRadio.isSelected() && !femaleRadio.isSelected()) {
                Vgender.setText("You should select a choice !");
                Vgender.setVisible(true);
                valid = false;
            } else {
                Vgender.setText("");
            }
          
            if (!valid) {
                return;
            }

            u1 = new UserRegister();


            InscriptionService ins = new InscriptionService();
                UserRegister utilis = new UserRegister (tpseudo.getText(), tfirstname.getText(), tlastname.getText(), email.getText(), password.getText(),Integer.parseInt(tphone.getText()), maleRadio.isSelected());
            
            ins.Inscription(utilis);
            
            Dialog.show("Vous etes maintenant inscris à smartstart","Votre inscription est effectuée avec succés", "OK", "Cancel");
            SMS s=new SMS();
            s.sendSms();
             System.out.println("Message Reçu");
           
             Login1 a=new Login1(Resources.getGlobalResources());
        a.getSmartstart().show();
//            Mail sm = new Mail(u1.getEmail(), " Confirmation d'inscription ", " Bonjour " + u1.getFirstname() + "Felicitations! Vous etes maintenant inscrit à smartstart");
//                            try {
//               
//                Properties props = new Properties();
//                props.put("mail.transport.protocol", "smtp");
//                props.put("mail.smtps.host", "smtp.gmail.com");
//                props.put("mail.smtps.auth", "true");
//                Session session = Session.getDefaultInstance(null, null);
//                
//                MimeMessage msg = new MimeMessage(session);
//                
//                msg.setFrom(new InternetAddress("SocialPro <my_email@myDomain.com>"));
//                msg.setRecipients(Message.RecipientType.TO, email.getText());
//                msg.setSubject("Bienvenue sur SocialPro ");
//                msg.setSentDate(new Date(System.currentTimeMillis()));
//                
//                String txt = "Bonjour,\n "+tpseudo.getText()+"\n Cordialement";
//                
//                msg.setText(txt);
//                SMTPTransport st = (SMTPTransport)session.getTransport("smtps");
//                st.connect("smtp.gmail.com","nihelhaddad5@gmail.com","nihelhaddad23");
//                st.sendMessage(msg, msg.getAllRecipients());
//                System.out.println("ServerResponse : " + st.getLastServerResponse());
//                 
//            } catch (MessagingException ex) {
//            }
            } });
            }
    
    
                
                
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
