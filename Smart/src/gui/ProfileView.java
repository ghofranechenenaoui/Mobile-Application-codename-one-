/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import com.codename1.components.Accordion;
import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.SpanLabel;
import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.db.Row;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

import entity.fosuser;
import com.mycompany.myapp.MyApplication;
import static com.mycompany.myapp.MyApplication.MemberId;
import static com.mycompany.myapp.MyApplication.firstForm;
import static com.mycompany.myapp.MyApplication.theme;

import entity.Experience;
import entity.Formation;
import entity.Photo;
import entity.Projet;
import service.MembreService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import service.ExperienceService;
import service.FormationService;
import service.PhotoService;
import service.ProjetService;

public final class ProfileView {
    
    private Form form;
    private Form parentForm;
    private fosuser member;
    private Experience ex;
     SpanLabel lb;
    ExperienceService cs = new ExperienceService();
      ArrayList<Experience> lstC = cs.getAllExperiences();
        FormationService cs2 = new FormationService();
      ArrayList<Formation> lstC2 = cs2.getAllExperiences();
        ProjetService cs3 = new ProjetService();
      ArrayList<Projet> lstC3 = cs3.getAllProjets();
    
    private static ProfileView instance;
    
    public static void update(){
        if(instance != null)
            instance.updateView();
    }
      public ProfileView() {
          
         
       

        
          
           form.add(ExperienceInfo());
             form.add(FormationInfo());

           
         
    

    }
  public void show() {
 
    }
 
    private void updateView(){
        Dialog i = new InfiniteProgress().showInifiniteBlocking();
        member = MembreService.getInstance().getFosuser(member.getId());
        
        buildContainer();
        form.revalidate();
        i.dispose();
    }
    
    public ProfileView(Form parentForm, int memberId){
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        instance = this;
        this.parentForm = parentForm;
        form = new Form("Profil", new BorderLayout());
         form.getToolbar().addCommandToOverflowMenu("Profil", MyApplication.theme.getImage("edit_black.png"), (e) -> {
            (new ProfilSelfView(parentForm, MemberId)).getF().show();
        });

       
      
         Image icon = theme.getImage("icon.png");
            Container topBar = BorderLayout.east(new Label(icon));
            Toolbar tb = form.getToolbar();
        topBar.add(BorderLayout.SOUTH, new Label("Profil", "SidemenuTagline"));
        topBar.setUIID("SideCommand");
       tb.addComponentToSideMenu(topBar);

     
    
        
        tb.addMaterialCommandToSideMenu("Profil", FontImage.MATERIAL_ACCOUNT_CIRCLE, e -> {
           //Form profileForm = (new ProfilSelfView(firstForm, MemberId));
                     new ProfileView(parentForm, MemberId).getContainer().show();
          //  profileForm.show();
        });
        
        tb.addMaterialCommandToSideMenu("Quiz", FontImage.MATERIAL_LIST, e -> {
                        new MyFront().getF().show();

        });
        tb.addMaterialCommandToSideMenu("Evenement", FontImage.MATERIAL_EVENT, e -> {
           new Home(theme).getF().show();
        });
        tb.addMaterialCommandToSideMenu("Vitrine", FontImage.MATERIAL_IMAGE, e -> {
            new ConsulterProduits().getF().show();
        });
        tb.addMaterialCommandToSideMenu("Forum", FontImage.MATERIAL_FORUM, e -> {
           
        });
        tb.addMaterialCommandToSideMenu("Logout", FontImage.MATERIAL_EXIT_TO_APP, e -> {});

        
//       this.member = MembreService.getInstance().getFosuser(memberId);
       this.member = MembreService.getInstance().getFosuser(memberId);
       
       /* if(member == null){
         getMemberFromLocal();
        }else{
     populateBd();
        }*/
        buildContainer();
        ip.dispose();
    }
    
  private void populateBd(){
        try {
            Database database = Database.openOrCreate("user");
            database.execute("create table if not exists fosuser(id INTEGER, firstname text, lastname text,"
                    + "username text, gender boolean, birth_date date,"
                    + "phone int, email text, created_at date);");
            String deleteQuery = "delete from fosuser";
            database.execute(deleteQuery);
            String insertQuery = "insert into fosuser values("+member.getId()+", '"+member.getFirstname()+"', '"+member.getLastname()
                    +"', '"+member.getUsername()+"', "+(member.isGender()?1:0)+", '"+(new SimpleDateFormat("dd-MM-yyyy")).format(member.getBirth_date())
    
                    +", "+member.getPhone()+", '"+member.getEmail()
                    +(new SimpleDateFormat("dd-MM-yyyy")).format(member.getCreated_at())+"')";
                    
            database.execute(insertQuery);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void getMemberFromLocal(){
        try {
            Database database = Database.openOrCreate("user");
            Cursor c = database.executeQuery("select * from fosuser");
            c.next();
            Row r = c.getRow();
            member = new fosuser();
           member.setBirth_date((new SimpleDateFormat("dd-MM-yyyy").parse(r.getString(5))));
           member.setId(r.getInteger(0));
          member.setUsername(r.getString(3));
            member.setFirstname(r.getString(1));
            member.setLastname(r.getString(2));
            member.setGender(r.getShort(4)==1?true:false);
           
            member.setPhone(r.getInteger(15));
            
            member.setEmail(r.getString(16));

           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void buildContainer(){
        Container c = new Container(BoxLayout.y());
        c.getAllStyles().setMarginBottom(20);
        
        //Cover Picture
        Label coverImg;
        Container coverContainer = new Container();
        Button bCover = new Button();
        coverContainer.setLeadComponent(bCover);
    /*  Photo coverPhoto = PhotoService.getInstance().getCoverPhoto(member.getId());
        if(coverPhoto != null){
           EncodedImage enc = EncodedImage.createFromImage(MyApplication.theme.getImage("loading_cover.png"), false);
            URLImage urlImage = URLImage.createToStorage(enc, (new Random()).nextInt()+"", coverPhoto.getPhotoUri());
           coverImg = new Label(urlImage);
            bCover.addActionListener((e) -> {
                //(new PhotoDetailsView(form, coverPhoto)).getForm().show();
            });
        }else{*/
            Image i = MyApplication.theme.getImage("cover.jpg");
            i = i.scaledHeight(140);
          coverImg = new Label(i);
        //}
        coverImg.getAllStyles().setMarginLeft(0);
        coverContainer.add(coverImg);
        
        //About
        Container aboutContainer = new Container(BoxLayout.y());
        aboutContainer.getAllStyles().setMarginLeft(40);
        
        Label aboutLabel = new Label("About");
        aboutLabel.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        
       SpanLabel aboutSpan = new SpanLabel(member.getDescription());
        aboutSpan.getAllStyles().setMarginLeft(20);
        aboutSpan.getTextAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
        
          EncodedImage contact;
          EncodedImage phone;

          try {
              contact = EncodedImage.create("/mail.png");
               ImageViewer iv2=new ImageViewer(contact);
               
                phone = EncodedImage.create("/phone.png");
               ImageViewer sms=new ImageViewer(phone);
           iv2.addPointerReleasedListener(e2 -> 
{
          new ContactView(parentForm).getF().show();
        });     
        aboutContainer.add(aboutLabel);
       aboutContainer.add(aboutSpan);
        Button btn=new Button("Contacter");
        Label l1=new Label("                                                  ");
        Label l2=new Label(" ");
        c.add(coverContainer);
        
c.add(BoxLayout.encloseX(l1,iv2,l2,
        sms));
        c.add(buildTopProfileInfo());
        c.add(buildProfileInfo());
      c.add(aboutContainer);
        c.add(ExperienceInfo());
        c.add(FormationInfo());
        c.add(ProjetInfo());

        } catch (IOException ex) {
              System.out.println(ex.getMessage());
          }  
        
        c.setScrollableY(true);
        form.add(BorderLayout.CENTER, c);
    }
    
    public Form getContainer(){
        return this.form;
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
       private Container ExperienceInfo() {
           

        // ImageViewer iv=new ImageViewer(enc);
         
        Container c = new Container(BoxLayout.y());
        c.getAllStyles().setMarginLeft(40);
        c.getAllStyles().setPaddingTop(20);
         
           
               
       
                 
                  
      
       // EncodedImage enc= EncodedImage.create("/delete_photo.png");
 // ImageViewer iv=new ImageViewer(); 
         Image i = MyApplication.theme.getImage("experience1.png");

     Label l1=new Label(" Liste des Experiences  ",i);
c.add(l1);
         for (Experience c2 : lstC) {
       Label infoLabel = new Label("Experience "+c2.getId());
        infoLabel.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        
        Container mainContainer = new Container(BoxLayout.y());
        mainContainer.getAllStyles().setMarginLeft(30);
         
        mainContainer.add(buildPairLabel("Employeur:", c2.getEmployeur()));
        mainContainer.add(buildPairLabel("Poste:", c2.getPoste()));
       mainContainer.add(buildPairLabel("Periode:", c2.getPeriode()));
         mainContainer.add(buildPairLabel("       ","             "));
            //siv.setImage(enc);
  Button btn =new Button("edit");
         
    
 c.add(infoLabel);
 //c.addComponent(btn);
 //c.add(iv);
 c.add(mainContainer);}
        


        
//     form.add(c);
      return c;
    }
    ////////////////////////////////formation//////////////////////
        private Container FormationInfo() {
           

        // ImageViewer iv=new ImageViewer(enc);
         
        Container c = new Container(BoxLayout.y());
        c.getAllStyles().setMarginLeft(40);
        c.getAllStyles().setPaddingTop(20);
         
           
   
         
                 
                  
      
       // EncodedImage enc= EncodedImage.create("/delete_photo.png");
 // ImageViewer iv=new ImageViewer(); 
     
         Image i = MyApplication.theme.getImage("formation2.png");

     Label l1=new Label(" Liste des Formations  ",i);
     c.add(l1);
         for (Formation c3 : lstC2) {
      Label infoLabel = new Label("Formation "+c3.getId());
        infoLabel.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        
        Container mainContainer = new Container(BoxLayout.y());
        mainContainer.getAllStyles().setMarginLeft(30);
        mainContainer.add(buildPairLabel("Titre:", c3.getTitre()));
        mainContainer.add(buildPairLabel("Periode:", c3.getPeriode()));
       mainContainer.add(buildPairLabel("Specialité:", c3.getSpecialite()));
         mainContainer.add(buildPairLabel("       ","             "));
            //siv.setImage(enc);
  Button btn =new Button("edit");
         
         
 c.add(infoLabel);
 //c.addComponent(btn);
 //c.add(iv);
 c.add(mainContainer);}
        


        
      return c;
    }
    
     private Container ProjetInfo() {
           

        // ImageViewer iv=new ImageViewer(enc);
         
        Container c = new Container(BoxLayout.y());
        c.getAllStyles().setMarginLeft(40);
        c.getAllStyles().setPaddingTop(20);
         
           
   
         
                 
                  
      
       // EncodedImage enc= EncodedImage.create("/delete_photo.png");
 // ImageViewer iv=new ImageViewer(); 
              Image i2 = MyApplication.theme.getImage("projet2.png");

     Label l1=new Label(" Liste des Projets  ", i2);
     c.add(l1);
         for (Projet c3 : lstC3) {
      Label infoLabel = new Label("Projet  "+c3.getId());
        infoLabel.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        
        Container mainContainer = new Container(BoxLayout.y());
        mainContainer.getAllStyles().setMarginLeft(30);
        mainContainer.add(buildPairLabel("Titre:", c3.getTitre()));
        mainContainer.add(buildPairLabel("Periode:", c3.getPeriode()));
       mainContainer.add(buildPairLabel("Categorie:", c3.getCategorie()));
         mainContainer.add(buildPairLabel("       ","             "));
            //siv.setImage(enc);
  Button btn =new Button("edit");
         
         
 c.add(infoLabel);
 //c.addComponent(btn);
 //c.add(iv);
 c.add(mainContainer);}
        


        

      return c;
    }
    
    private Container buildPairLabel(String label, String value){
        Container c = new Container(BoxLayout.x());
        
        Label labelLabel = new Label(label+"");
        labelLabel.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
        
        Label labelValue = new Label(value);
        labelValue.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
        
        c.add(labelLabel);
        c.add(labelValue);
        return c;
    }
    
    private Container buildTopProfileInfo(){
        //Profile Picture
        Label profileImg;
        Container profileContainer = new Container();
        Button bProfile = new Button();
        profileContainer.setLeadComponent(bProfile);
    //  Photo ProfilePhoto = PhotoService.getInstance().getProfilePhoto(member.getId());
      //if(ProfilePhoto != null){
         //  EncodedImage enc = EncodedImage.createFromImage(MyApplication.theme.getImage("loading.png"), false);
        //  URLImage urlImage = URLImage.createToStorage(enc, (new Random()).nextInt()+"", ProfilePhoto.getPhotoUri());
        //   profileImg = new Label(urlImage);
            bProfile.addActionListener((e) -> {
             //   (new PhotoDetailsView(form, ProfilePhoto)).getForm().show();
            });
        //}else{
            Image i = MyApplication.theme.getImage("Profile2.jpg");
           i = i.scaledHeight(90);
            profileImg = new Label(i);
       // }
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
}
