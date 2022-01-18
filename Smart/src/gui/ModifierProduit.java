/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import entity.Produit;
import service.ServiceProduit;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class ModifierProduit {
      Form f;
    TextField tnom;
    TextField tdescription;
    TextField tcreateur;
    TextField ttaille;
    TextField tcategorie;
    TextField tprix;
    TextField tphoto;
    TextField id;
     Button btnmodif;

    public ModifierProduit() {
        tnom = new TextField("nom");
        tdescription = new TextField("description");
        tcreateur = new TextField("createur");
        ttaille = new TextField("taille");
        tcategorie = new TextField("categorie");
        tprix = new TextField("prix");
        tphoto = new TextField("nomPhoto");
        id = new TextField("id illi theb tmodifih");
        
         btnmodif = new Button("modifier");
         
         
        f.add(tnom);
        f.add(tdescription);
        f.add(tcreateur);
        f.add(ttaille);
        f.add(tcategorie);
        f.add(tprix);
        f.add(tphoto);
        f.add(id);
        
        btnmodif.addActionListener((e) -> {
                ServiceProduit ser = new ServiceProduit();
               // DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //String todaysDate = dateFormat.format(System.currentTimeMillis());
              //  Date date1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(todaysDate);
           
                Produit t = new Produit(tnom.getText(),tdescription.getText(),tcreateur.getText(),Integer.parseInt(ttaille.getText()),tcategorie.getText(),Float.parseFloat(tprix.getText()),tphoto.getText());
                ser.modifProduit(t,Integer.parseInt(id.getText()));
        
        });
    }
     public Form getF() {
        return f;
    }
     public void setId(TextField id){
      this.id=id;
     }

    public void setTnom(TextField tnom) {
        this.tnom = tnom;
    }

    public void setTdescription(TextField tdescription) {
        this.tdescription = tdescription;
    }

    public void setTcreateur(TextField tcreateur) {
        this.tcreateur = tcreateur;
    }

    public void setTtaille(TextField ttaille) {
        this.ttaille = ttaille;
    }

    public void setTcategorie(TextField tcategorie) {
        this.tcategorie = tcategorie;
    }

    public void setTprix(TextField tprix) {
        this.tprix = tprix;
    }

    public void setTphoto(TextField tphoto) {
        this.tphoto = tphoto;
    }
     
    
     
}
