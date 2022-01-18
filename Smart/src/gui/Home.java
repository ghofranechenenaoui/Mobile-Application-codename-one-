/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entity.event;
import service.ServiceEvent;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Administrator
 */
public class Home extends Form{
    //Form hi = new Form();
   Form f;
    private Label titreEror;
    TextField ttitre;
    TextField tanim;
    TextField tlieu;
    TextField tlien;
    TextField frais;
    TextField nbplaceeLabel;
    
    Button btnajout,btnaff;

    public Home(Resources theme)  {
       
        
      f = new Form("Ajouter un Event");
        ttitre = new TextField("","titre");
        tanim = new TextField("","animateur");
        tlieu = new TextField("","lieu");
        tlien = new TextField("","lien");
       
        frais = new TextField("","Frais");
        nbplaceeLabel = new TextField("","nbplaceeLabel");
        btnajout = new Button("ajouter");
        btnaff=new Button("Affichage");
        
        Container dateContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Picker datedeb = new Picker();
        Label temp = new Label("date de debut");
        dateContainer.add(temp);
        dateContainer.add(datedeb);
        
        Container dateContainer2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Picker datefin = new Picker();
        Label temp2 = new Label("date de fin");
        dateContainer2.add(temp2);
        dateContainer2.add(datefin);
      
       SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
       
        
        
        Label descriptionLabel = new Label("Description : ");
        TextArea descriptionArea = new TextArea(3, 20);
        Container descriptionContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        descriptionContainer.add(descriptionLabel);
        descriptionContainer.add(descriptionArea);
        
        
        Label photoLabel = new Label("Photo");
        Button selectPhoto = new Button("parcourir");
        TextField photoField = new TextField("", "Importer une photo", 10, TextArea.ANY);
        photoField.setEditable(false);
        selectPhoto.addActionListener((evt) -> {
            if (Dialog.show("Photo!", "une annonce avec des  photos est 10 fois plus visible", "app photo", "Gallerie") == false) {
                Display.getInstance().openGallery((e) -> {
                    if (e != null && e.getSource() != null) {
                        String file = (String) e.getSource();
                        photoField.setText(file.substring(file.lastIndexOf('/') + 1));
                    }
                }, Display.GALLERY_IMAGE);
            } else {
                System.out.println("ici on va accerder à l'appareille photo");
            }
        });
        Container photoContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
        photoContainer.add(photoLabel);
        photoContainer.add(photoField);
        photoContainer.add(selectPhoto);

        f.add(ttitre);
        f.add(tanim);
        f.add(tlieu);
        f.add(tlien);
        f.add(dateContainer);
        f.add(dateContainer2);
        
        f.add(nbplaceeLabel);
        f.add(frais);
        f.add(descriptionContainer);
        f.add(photoContainer);
        f.add(btnajout);
        f.add(btnaff);
         
        btnajout.addActionListener((e) -> {
            
            if (ttitre.getText().equals("")) {
                
                Dialog.show("ERREUR SAISIE","TITRE VIDE","OK","ANNULER");
            }
            
            else if (tanim.getText().equals("")) {
                
                Dialog.show("ERREUR SAISIE","Animateur VIDE","OK","ANNULER");
            }
            else if (tlieu.getText().equals("")) {
                
                Dialog.show("ERREUR SAISIE","Lieu VIDE","OK","ANNULER");
            }
            else if (tlien.getText().equals("")) {
                
                Dialog.show("ERREUR SAISIE","Lien VIDE","OK","ANNULER");
            }
            
             else if (frais.getText().equals("")) {
                
                Dialog.show("ERREUR SAISIE","Frais Vide","OK","ANNULER");
            }
             else if (nbplaceeLabel.getText().equals("")) {
                
                Dialog.show("ERREUR SAISIE","Nbplaces Vide","OK","ANNULER");
            }
             
             else if (!isAFloat(frais.getText())) {
                
                Dialog.show("ERREUR SAISIE","Frais doit etre numeric","OK","ANNULER");
            }
             else if (!isAEntier(nbplaceeLabel.getText())) {
                
                Dialog.show("ERREUR SAISIE","nbplaces doit etre numeric","OK","ANNULER");
            }
            else if (descriptionArea.getText().equals("")) {
                
                Dialog.show("ERREUR SAISIE","Description VIDE","OK","ANNULER");
            }
            else if (photoField.getText().equals("")) {
                
                Dialog.show("ERREUR SAISIE","Choisisez une image","OK","ANNULER");
            }
             
            else{

            ServiceEvent ser = new ServiceEvent();
            event ev = new event(ttitre.getText(), tanim.getText(), tlieu.getText(), tlien.getText()
                    ,datedeb.getDate(),datefin.getDate(),
            Integer.parseInt(nbplaceeLabel.getText()),Float.parseFloat(frais.getText()),
            descriptionArea.getText(),photoField.getText()
            
            );
            ser.ajoutEvent(ev);
           Dialog.show("felicitation", " votre evenement a ete ajoute", "ok", null);            

           Message m = new Message("<html><body>Check out <a href=\"https://www.codenameone.com/\">Codename One</a></body></html>");
m.setMimeType(Message.MIME_HTML);

// notice that we provide a plain text alternative as well in the send method
boolean success = m.sendMessageViaCloudSync("Codename One", "espritblackswan@gmail.com", "Name Of User", "Message Subject",
                            "Check out Codename One at https://www.codenameone.com/");
            }
        });
       
        btnaff.addActionListener((e)->{
        Affichage a =new Affichage();
        a.show();
        });
        
        
       
    }
//
//    public Form getF() {
//        return f;
//    }
//
//    public void setF(Form f) {
//        this.f = f;
//    }

   

    public TextField getTtitre() {
        return ttitre;
    }

    public void setTtitre(TextField ttitre) {
        this.ttitre = ttitre;
    }

    public TextField getTanim() {
        return tanim;
    }

    public void setTanim(TextField tanim) {
        this.tanim = tanim;
    }

    public TextField getTlieu() {
        return tlieu;
    }

    public void setTlieu(TextField tlieu) {
        this.tlieu = tlieu;
    }

    public TextField getTlien() {
        return tlien;
    }

    public void setTlien(TextField tlien) {
        this.tlien = tlien;
    }

    public boolean isAFloat(String x) {
        try {
            Float.parseFloat(x);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    
public boolean isAEntier(String x) {
        try {
            Integer.parseInt(x);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
    
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
