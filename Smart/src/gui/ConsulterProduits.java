/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.capture.Capture;
import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.components.ToastBar;
import com.codename1.io.CharArrayReader;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.ImageIO;
import static com.mycompany.myapp.MyApplication.MemberId;
import static com.mycompany.myapp.MyApplication.theme;
import entity.Produit;
import service.ServiceProduit;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;



/**
 *
 * @author ASUS
 */
public class ConsulterProduits {
    
    Form f;
    TextField tnom;
    TextField tdescription;
    TextField tcreateur;
    TextField ttaille;
    Label cat;
   // TextField tcategorie;
           String[] tabs = {"Design","Photo","Logo","Affiche"};
          
    TextField tprix;
    TextField tphoto;
    TextField supp;
    Button btnajout,btnaff,btnsupp,btnupdate,btnupload,stat;

    public ConsulterProduits() {
        f = new Form("Ajouter Produit");
        tnom = new TextField("","nom");
        tdescription = new TextField("","description");
        tcreateur = new TextField("","createur");
        ttaille = new TextField("","taille");
        cat = new Label("Choisir catégorie");
        ComboBox tcategorie = new ComboBox(tabs);
       // tcategorie = new TextField("","categorie");
        tprix = new TextField("","prix");
        tphoto = new TextField("","nomPhoto");
        supp = new TextField("","7ot id illi theb tfas5ou");
       
        btnajout = new Button("ajouter");
        btnaff=new Button("afficher");
        btnsupp=new Button("supprimer");
        btnupdate=new Button("modifier");
        btnupload=new Button("choisir fichier");
        stat=new Button("stat");
        f.add(tnom);
        f.add(tdescription);
        f.add(tcreateur);
        f.add(ttaille);
        f.add(cat);
        f.add(tcategorie);
        f.add(tprix);
        f.add(tphoto);
        f.add(btnupload);
        f.add(supp);
       // f.add(tetat);
         btnupload.addActionListener((e)->{
                String jobPic = Capture.capturePhoto();
                if(jobPic != null)
                try{
                Image img = Image.createImage(jobPic);
                ImageIO imgIO= ImageIO.getImageIO();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                imgIO.save(img, out,ImageIO.FORMAT_JPEG, 1);
                byte[] bytesdata = out.toByteArray();
                tphoto.setText(jobPic.toString());
                btnupload.setIcon(img);
                
                }catch(IOException err) {
                ToastBar.showErrorMessage("An error occured while loading the image: " + err);
                Log.e(err);
                }
               
                
              /*  MultipartRequest cr = new MultipartRequest();
                String  filePath = Capture.capturePhoto(Display.getInstance().getDisplayWidth(), -1);
                cr.setUrl("http://localhost/projet/web/app_dev.php/ajout");
                cr.setPost(true);
                String mime="image/jpeg";
                cr.addData("file", filePath, mime);
                cr.setFilename("file", "MyImage.jpg");//any unique name you want
                
                InfiniteProgress prog = new InfiniteProgress();
                Dialog dlg = prog.showInifiniteBlocking();
                cr.setDisposeOnCompletion(dlg);
                 cr.addArgument("nomPhoto",mime);
                NetworkManager.getInstance().addToQueueAndWait(cr);*/
           
         } );
        btnajout.addActionListener((e) -> {
            try {
                ServiceProduit ser = new ServiceProduit();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String todaysDate = dateFormat.format(System.currentTimeMillis());
                Date date1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(todaysDate);
                Produit t = new Produit(tnom.getText(),tdescription.getText(),tcreateur.getText(),Integer.valueOf(ttaille.getText()), (String) tcategorie.getSelectedItem(),Float.parseFloat(tprix.getText()),date1,tphoto.getText(),0);
                ser.ajoutProduit(t);
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
            

        });
                                   
                                      
                Image icon = theme.getImage("icon.png");
            Container topBar = BorderLayout.east(new Label(icon));
            Toolbar tb = f.getToolbar();
        topBar.add(BorderLayout.SOUTH, new Label("Profil", "SidemenuTagline"));
        topBar.setUIID("SideCommand");
       tb.addComponentToSideMenu(topBar);

     
    
        
        tb.addMaterialCommandToSideMenu("Profil", FontImage.MATERIAL_ACCOUNT_CIRCLE, e -> {
           //Form profileForm = (new ProfilSelfView(firstForm, MemberId));
                     new ProfileView(f, MemberId);
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
        
        btnaff.addActionListener((e)->{
 
      AjouterProduit a=new AjouterProduit();
       a.getF().show();
   
        });
         btnsupp.addActionListener((e)->{
      ServiceProduit ser = new ServiceProduit();
      ser.suppressionproduit(Integer.parseInt(supp.getText()));
        });
           btnupdate.addActionListener((e)->{
       ModifierProduit a=new ModifierProduit();
       a.setId(supp);
        a.getF().show();
   
        });
            stat.addActionListener((e)->{
         stat s = new stat();
         s.createPieChartForm().show();
});
        f.add(btnajout);
        f.add(btnaff);
        f.add(btnsupp);
        f.add(stat);
       
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
     public TextField getSupp() {
        return supp;
    }
}
