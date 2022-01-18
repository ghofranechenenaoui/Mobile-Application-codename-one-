/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import service.*;
import entity.*;
import com.codename1.components.Accordion;
import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.SpanLabel;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.List;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.mycompany.myapp.MyApplication;
import entity.Experience;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import service.ExperienceService;

/**
 *
 * @author bhk
 */
public class ProfilSelfView {
    private Experience ex;
    private Formation fo;

    private Projet pr;

   
     SpanLabel lb;
    ExperienceService cs = new ExperienceService();
    ArrayList<Experience> lstC = cs.getAllExperiences();

    FormationService cs2 = new FormationService();
    ArrayList<Formation> lstC2 = cs2.getAllExperiences();

    ProjetService cs3 = new ProjetService();
    ArrayList<Projet> lstC3 = cs3.getAllProjets();
    
    Form f;
    private Form parentForm;
    TextField tnom;
    TextField tetat;
    Button btnajout, btnaff;
    Container big;
    Container postContainer;
    private fosuser member;
    
 private void updateView(){
        Dialog i = new InfiniteProgress().showInifiniteBlocking();
        member = MembreService.getInstance().getFosuser(member.getId());

        buildContainer();
        f.revalidate();
        i.dispose();
    }

    public ProfilSelfView(Form parentForm, int memberId) {
        this.parentForm = parentForm;
        this.member = MembreService.getInstance().getFosuser(memberId);

        Label profileImg;
        Label coverImg;
        Label l1 = new Label("                            ");
        f = new Form("Profil");

        Image i = MyApplication.theme.getImage("cover.jpg");
        Image i1 = MyApplication.theme.getImage("chat.png");
        Image i8 = MyApplication.theme.getImage("chat.png");

        f.getToolbar().addCommandToOverflowMenu("Edit", MyApplication.theme.getImage("edit_black.png"), (e) -> {
            (new EditFormView(parentForm, member)).getForm().show();
        });
        
        
        
        
        

       
        f.getToolbar().addCommandToLeftBar("Back", MyApplication.theme.getImage("back-command.png"), (e) -> {
            parentForm.showBack();
        });
        
        
        
        
        
        i = i.scaledHeight(250);
        i = i.scaledWidth(550);
        coverImg = new Label(i);
        Label l2= new Label(i1);
        coverImg.getAllStyles().setMarginLeft(0);
        coverImg.getAllStyles().setMarginRight(0);
        coverImg.getAllStyles().setPaddingTop(0);

        Image i2 = MyApplication.theme.getImage("Profile2.jpg");
        i2 = i2.scaledHeight(90);
        profileImg = new Label(i);
       
        profileImg.getAllStyles().setMarginLeft(0);

       
      Button btn2=new Button();      
            
        f.add(i);
        // f.add(sinceLabel); 
         //f.add(i2);
         f.add(l1);
          f.add(buildTopProfileInfo());
        f.add(buildProfileInfo());
       
  
      //f.add(aboutContainer);
         
//        f.add(buildContainer());
///////////////////CRUD exerience///////////////////////////////////////
         EncodedImage enc2;
         EncodedImage edit;
         EncodedImage add;
          try {
              enc2 = EncodedImage.create("/delete_photo.png");
               ImageViewer iv2=new ImageViewer(enc2);
               
                 edit = EncodedImage.create("/edit_black.png");
               ImageViewer ive=new ImageViewer(edit);
               
                 add = EncodedImage.create("/add_photo.png");
               ImageViewer iva=new ImageViewer(add);
          //  Form f = new Form("Accordion", new BorderLayout());
   Label label3=new Label("                     ");
   Label label4=new Label("                     ");
   Label label5=new Label("                     ");
   Label label6=new Label("                     ");
   Label label7=new Label("                     ");
    Image i5 = MyApplication.theme.getImage("experience.png");

 Label label2=new Label("           Liste des Experiences",i5);
              f.add(label5);
              f.add(label3);
              f.add(label4);

              f.add(label2);
              f.add(label6);
              f.add(label7);
        for (Experience c2 : lstC){
        
Accordion accr1 = new Accordion();
//accr.addContent("Experience "+c2.getId(),BoxLayout.encloseY( new SpanLabel("Employeur: "+c2.getEmployeur()+"\n"+
     //   "Poste: "+c2.getPoste()+"\n"+"Periode: "+c2.getPeriode()+"\n"+new ImageViewer(enc2))));

  
accr1.addContent("Experience "+c2.getId()+"                                             ", BoxLayout.encloseY(new SpanLabel("Employeur: "+c2.getEmployeur()+"\n"+
        "Poste: "+c2.getPoste()+"\n"+"Periode: "+c2.getPeriode()+"\n"),BoxLayout.encloseX( new Label("            "),iva= new ImageViewer(add), new Label("     "),ive=new ImageViewer(edit),new Label("     "),iv2= new ImageViewer(enc2))));
      
iv2.addPointerReleasedListener(e -> {
		ExperienceService.getInstance().delete(c2.getId());
		ProfilSelfView a=new ProfilSelfView(parentForm, memberId);
        a.getF().show();
      
                 });
    ive.addPointerReleasedListener(e2 -> 
{
          new ModifierExperienceView(f, c2).getForm().show();
        });     
    
      iva.addPointerReleasedListener(e3 -> {
     new HomeForm(memberId).getF().show();		
                 });
      
  
//accr.addContent("Item3", BoxLayout.encloseY(new Label("Label"), new TextField(), new Button("Button"), new CheckBox("CheckBox")));

        
         
          
          ///////////////////////////////////////////*
            f.add(accr1);
           

        }
            } catch (IOException ex) {
              System.out.println(ex.getMessage());
          }  
          
       
//////////////////////////////////CRUD formation///////////////////////////////////////

         EncodedImage removef;
         EncodedImage editf;
         EncodedImage addf;
          try {
              removef = EncodedImage.create("/delete_photo.png");
               ImageViewer iv2=new ImageViewer(removef);
               
                 editf = EncodedImage.create("/edit_black.png");
               ImageViewer ive=new ImageViewer(editf);
               
                 addf = EncodedImage.create("/add_photo.png");
               ImageViewer iva=new ImageViewer(addf);
          //  Form f = new Form("Accordion", new BorderLayout());
   Label label3=new Label("                     ");
   Label label4=new Label("                     ");
   Label label5=new Label("                     ");
   Label label6=new Label("                     ");
   Label label7=new Label("                     ");
    Image i6 = MyApplication.theme.getImage("formation.png");
 Label label2=new Label("           Liste des Formations",i6);
          f.add(label5); 
         f.add(label3);
           f.add(label4);

          f.add(label2);
           f.add(label6);
           f.add(label7);
        for (Formation c3 : lstC2){
        
Accordion accr2 = new Accordion();
//accr.addContent("Experience "+c2.getId(),BoxLayout.encloseY( new SpanLabel("Employeur: "+c2.getEmployeur()+"\n"+
     //   "Poste: "+c2.getPoste()+"\n"+"Periode: "+c2.getPeriode()+"\n"+new ImageViewer(enc2))));

  
accr2.addContent("Formation "+c3.getId()+"                                             ", BoxLayout.encloseY(new SpanLabel("Titre: "+c3.getTitre()+"\n"+
        "Specialite: "+c3.getSpecialite()+"\n"+"Periode: "+c3.getPeriode()+"\n"),BoxLayout.encloseX( new Label("            "),iva= new ImageViewer(addf), new Label("     "),ive=new ImageViewer(editf),new Label("     "),iv2= new ImageViewer(removef))));
      
iv2.addPointerReleasedListener(e -> {
		FormationService.getInstance().delete(c3.getId());
		ProfilSelfView a=new ProfilSelfView(parentForm, memberId);
                
        a.getF().show();
      
                 });
    ive.addPointerReleasedListener(e2 -> 
{
          new ModifierFormationView(f, c3,memberId).getForm().show();
        });     
    
      iva.addPointerReleasedListener(e3 -> {
     new AjouterFormationView(memberId).getF().show();		
                 });
      
  
//accr.addContent("Item3", BoxLayout.encloseY(new Label("Label"), new TextField(), new Button("Button"), new CheckBox("CheckBox")));
Label label=new Label("         ");
        
         
         // f.add(label);
          ///////////////////////////////////////////*
            f.add(accr2);
           

        }
            } catch (IOException ex) {
              System.out.println(ex.getMessage());
          } 


//////////////////////////////////CRUD projet/////////////////////////////////////////

 EncodedImage removep;
         EncodedImage editp;
         EncodedImage addp;
          try {
              removep = EncodedImage.create("/delete_photo.png");
               ImageViewer iv2=new ImageViewer(removep);
               
                 editp = EncodedImage.create("/edit_black.png");
               ImageViewer ive=new ImageViewer(editp);
               
                 addp = EncodedImage.create("/add_photo.png");
               ImageViewer iva=new ImageViewer(addp);
          //  Form f = new Form("Accordion", new BorderLayout());
 Label label3=new Label("                     ");
   Label label4=new Label("                     ");
   Label label5=new Label("                     ");
   Label label6=new Label("                     ");
   Label label7=new Label("                     ");
    Image i4 = MyApplication.theme.getImage("feedback.png");
    Image i5 = MyApplication.theme.getImage("experience.png");
    Image i6 = MyApplication.theme.getImage("formation.png");
    Image i7 = MyApplication.theme.getImage("projet .png");
  Label label8=new Label(i4);
 Label label2=new Label("           Liste des Projets",i7);
 
          f.add(label5); 
         f.add(label3);
           f.add(label4);

          f.add(label2);
           f.add(label6);
           f.add(label7);
        for (Projet c4 : lstC3){
        
Accordion accr2 = new Accordion();
//accr.addContent("Experience "+c2.getId(),BoxLayout.encloseY( new SpanLabel("Employeur: "+c2.getEmployeur()+"\n"+
     //   "Poste: "+c2.getPoste()+"\n"+"Periode: "+c2.getPeriode()+"\n"+new ImageViewer(enc2))));

  
accr2.addContent("Projet "+c4.getId()+"                                                   ", BoxLayout.encloseY(new SpanLabel("Titre: "+c4.getTitre()+"\n"+
        "Categorie: "+c4.getCategorie()+"\n"+"Periode: "+c4.getPeriode()+"\n"),BoxLayout.encloseX( new Label("            "),iva= new ImageViewer(addp), new Label("     "),ive=new ImageViewer(editp),new Label("     "),iv2= new ImageViewer(removep))));
      
iv2.addPointerReleasedListener(e -> {
		ProjetService.getInstance().delete(c4.getId());
		ProfilSelfView a=new ProfilSelfView(parentForm, memberId);
        a.getF().show();
      
                 });
    ive.addPointerReleasedListener(e2 -> 
{
          new ModifierProjetView(f, c4).getForm().show();
        });     
    
      iva.addPointerReleasedListener(e3 -> {
     new AjouterProjetView(memberId).getF().show();		
                 });
      
  
//accr.addContent("Item3", BoxLayout.encloseY(new Label("Label"), new TextField(), new Button("Button"), new CheckBox("CheckBox")));
Label label=new Label("         ");
           // f.add(label);
            f.add(accr2);
           

        }
            } catch (IOException ex) {
              System.out.println(ex.getMessage());
          } 


        }
    
      
    private Container buildProfileInfo(){
        Container c = new Container(BoxLayout.y());
        c.getAllStyles().setMarginLeft(40);
        c.getAllStyles().setPaddingTop(20);
        
        Label infoLabel = new Label("A propos");
        infoLabel.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        
        Container mainContainer = new Container(BoxLayout.y());
        mainContainer.getAllStyles().setMarginLeft(30);
        mainContainer.add(buildPairLabel("Sex", member.isGender()?"Homme":"Femme"));
        mainContainer.add(buildPairLabel("Date de naissance", (new SimpleDateFormat("dd MMMM, yyy").format(member.getBirth_date()))));
       
        
        c.add(infoLabel);
        c.add(mainContainer);
        return c;
    }
    private Container buildPairLabel(String label, String value){
        Container c = new Container(BoxLayout.x());
        
        Label labelLabel = new Label(label+":");
        labelLabel.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
        
        Label labelValue = new Label(value);
        labelValue.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
        
        c.add(labelLabel);
        c.add(labelValue);
        return c;
    }
      private void buildContainer(){
        Container c = new Container(BoxLayout.y());
        c.getAllStyles().setMarginBottom(20);
        
        //Cover Picture
        Label coverImg;
        Container coverContainer = new Container();
        
        //About
        Container aboutContainer = new Container(BoxLayout.y());
        aboutContainer.getAllStyles().setMarginLeft(40);
        
        Label aboutLabel = new Label("About");
        aboutLabel.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        
        SpanLabel aboutSpan = new SpanLabel(member.getDescription());
        aboutSpan.getAllStyles().setMarginLeft(20);
        aboutSpan.getTextAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
        
        aboutContainer.add(aboutLabel);
        aboutContainer.add(aboutSpan);
        
         c.add(buildTopProfileInfo());
        c.add(buildProfileInfo());
      c.add(aboutContainer);
       
        
        c.setScrollableY(true);
        f.add(BorderLayout.CENTER, c);
    }
         private Container buildTopProfileInfo(){
        //Profile Picture
        Label profileImg;
        Container profileContainer = new Container();
        Button bProfile = new Button();
        profileContainer.setLeadComponent(bProfile);
   /*   Photo ProfilePhoto = PhotoService.getInstance().getProfilePhoto(member.getId());
      if(ProfilePhoto != null){
           EncodedImage enc = EncodedImage.createFromImage(MyApplication.theme.getImage("loading.png"), false);
          URLImage urlImage = URLImage.createToStorage(enc, (new Random()).nextInt()+"", ProfilePhoto.getPhotoUri());
           profileImg = new Label(urlImage);
            bProfile.addActionListener((e) -> {
             //   (new PhotoDetailsView(form, ProfilePhoto)).getForm().show();
            });
        }else{*/
            Image i = MyApplication.theme.getImage("Profile2.jpg");
           i = i.scaledHeight(90);
            profileImg = new Label(i);
      //  }
       profileImg.getAllStyles().setMarginLeft(0);
        profileContainer.add(profileImg);
        
        Container profileSideContainer = new Container(BoxLayout.y());
        
        //Name
        Container nameAgeContainer = new Container(BoxLayout.x());
        nameAgeContainer.getAllStyles().setMarginLeft(5);
        
        Label nameLabel = new Label(member.getFirstname()+""+member.getLastname());
          Label nameLabel2 = new Label("Nihel Haddad");
        nameLabel.getAllStyles().setPaddingTop(0);
        nameLabel.getAllStyles().setPaddingRight(0);
        nameLabel.getAllStyles().setPaddingBottom(0);
        nameLabel.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
            nameAgeContainer.add(nameLabel);

         //Label ageLabel = new Label("("+member.getAge()+")");
          Label ageLabel = new Label("(23)");
        ageLabel.getAllStyles().setPaddingTop(0);
        ageLabel.getAllStyles().setPaddingBottom(0);
        ageLabel.getAllStyles().setMarginRight(0);
        ageLabel.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        nameAgeContainer.add(ageLabel);
        
        profileSideContainer.add(nameAgeContainer);
        
        
        //Since
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM, yyyy");
        Label sinceLabel = new Label("Memebre depuis: "+sdf.format(member.getCreated_at()));
        sinceLabel.getAllStyles().setMarginLeft(20);
        sinceLabel.getAllStyles().setPaddingTop(0);
        sinceLabel.getAllStyles().setPaddingBottom(0);
        sinceLabel.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
        profileSideContainer.add(sinceLabel);
        
        Container profileAddressContainer = new Container(BoxLayout.x());
        profileAddressContainer.add(profileContainer);
        profileAddressContainer.add(profileSideContainer);
        
        return profileAddressContainer;
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
