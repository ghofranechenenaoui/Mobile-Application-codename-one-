/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import static com.codename1.ui.plaf.Style.BACKGROUND_NONE;
import service.*;
import entity.*;
import java.util.ArrayList;
import java.util.Date;
import javafx.scene.control.DatePicker;

/**
 *
 * @author bhk
 */
public class Question {

    Form f;
    TextField tnom;
    DatePicker Date;
    Button btnajout;
       private ArrayList<String> listReponses ;
    public int qcount,faux;
final Button showPopup = new Button("Ok");

Label Ques;
    public Question(int id) {
        
        f = new Form("  Test");
         MyFront fff = new MyFront();
        Container QuestionBox = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        QuestionService nn = new QuestionService();
        MyFront nh = new MyFront();
       listReponses = new ArrayList<>();
                    Button ok =new Button("Ok");

        ArrayList<questions> lstC = nn.findQuestion( id
);
                Button T = new Button("Terminer");  
        
                for (questions e : lstC) {
               Label Ques2 =new Label(e.getDescription());
               Label fa =new Label(e.getDescription());
                               fa.getAllStyles().setPaddingRight(50);

                CheckBox rep1 = new CheckBox(e.getRep1());
                CheckBox rep2 = new CheckBox(e.getRep2());
                CheckBox rep3 = new CheckBox(e.getRep3());
                CheckBox repCorect = new CheckBox(e.getCorrectReq());
              
                rep1.addActionListener((event)->{
                if (listReponses.contains(e.getCorrectReq()))
                    listReponses.remove(e.getCorrectReq());
                if (listReponses.contains(e.getRep2()))
                    listReponses.remove(e.getRep2());
                if (listReponses.contains(e.getRep3()))
                    listReponses.remove(e.getRep3());    
                if (!listReponses.contains(e.getRep1()))    
                    listReponses.add(e.getRep1());
                System.out.println("9a3din ntastiw");
                    System.out.println(listReponses);
            });
                
                rep2.addActionListener((event)->{
                if (listReponses.contains(e.getCorrectReq()))
                    listReponses.remove(e.getCorrectReq());
                if (listReponses.contains(e.getRep1()))
                    listReponses.remove(e.getRep1());
                if (listReponses.contains(e.getRep3()))
                    listReponses.remove(e.getRep3());    
                if (!listReponses.contains(e.getRep2()))    
                    listReponses.add(e.getRep2());
                System.out.println("9a3din ntastiw");
                    System.out.println(listReponses);
            });
                
                rep3.addActionListener((event)->{
                if (listReponses.contains(e.getCorrectReq()))
                    listReponses.remove(e.getCorrectReq());
                if (listReponses.contains(e.getRep2()))
                    listReponses.remove(e.getRep2());
                if (listReponses.contains(e.getRep1()))
                    listReponses.remove(e.getRep1());    
                if (!listReponses.contains(e.getRep3()))    
                    listReponses.add(e.getRep3());
                System.out.println("9a3din ntastiw");

                    System.out.println(listReponses);
                });
                
                
                repCorect.addActionListener((event)->{
                if (listReponses.contains(e.getRep2()))
                    listReponses.remove(e.getRep2());
                if (listReponses.contains(e.getRep3()))
                    listReponses.remove(e.getRep3());
                   if (listReponses.contains(e.getRep1()))
                    listReponses.remove(e.getRep1());
                if (!listReponses.contains(e.getCorrectReq()))    
                    listReponses.add(e.getCorrectReq());
                System.out.println("9a3din ntastiw");
                    System.out.println(listReponses);
            });
               qcount=0; 
               faux=0;
                T.addActionListener(mm->{
                 for (int j = 0; j < listReponses.size(); j++) {
                     if (listReponses.get(j).equals(lstC.get(j).getCorrectReq()) ) {
                     qcount++;
                     }else{
                     faux++;
                     }}
                    setFaux(faux);
                    setFaux(qcount);
                    if (getQcount() >= getFaux()) {
                     Dialog.show("Bravo", "Vos réponse correct est:  "+getQcount(), "Ok", null);
                     fff.getF().show();  
                    }else if (getQcount()< getFaux()) {
                          Dialog.show("Mauvaise Resultat", "Vos réponse correct est:  "+getQcount(), "Essayer de nouveau", null);
                     fff.getF().show();  
                    
                    }
{
                  
                    }
          
                
                
                });
                
                
                
                
                
                
                QuestionBox.add(Ques2);
                QuestionBox.add(rep3);
                QuestionBox.add(rep1);
                QuestionBox.add(rep2);
                QuestionBox.add(repCorect);
                QuestionBox.add(fa);
                
                
                
                
                
                
                 repCorect.getAllStyles().setBorder(Border.createEmpty());
                 repCorect.getAllStyles().setBackgroundType(BACKGROUND_NONE);
                 repCorect.getAllStyles().setBgTransparency(255);
                 repCorect.getAllStyles().setBgColor(0xC0BFC1);
                 
                 rep3.getAllStyles().setBorder(Border.createEmpty());
                 rep3.getAllStyles().setBackgroundType(BACKGROUND_NONE);
                 rep3.getAllStyles().setBgTransparency(255);
                 rep3.getAllStyles().setBgColor(0xC0BFC1);
                 
                   rep1.getAllStyles().setBorder(Border.createEmpty());
                 rep1.getAllStyles().setBackgroundType(BACKGROUND_NONE);
                 rep1.getAllStyles().setBgTransparency(255);
                 rep1.getAllStyles().setBgColor(0xC0BFC1);
                 
                           rep2.getAllStyles().setBorder(Border.createEmpty());
                 rep2.getAllStyles().setBackgroundType(BACKGROUND_NONE);
                 rep2.getAllStyles().setBgTransparency(255);
                 rep2.getAllStyles().setBgColor(0xC0BFC1);
               //   f.add(Ques2);

            //    rep1.getAllStyles().setMarginLeft(80);
                }
                      f.add(QuestionBox);
                      f.add(T);
f.show();
                f.getToolbar().addCommandToRightBar("back", null, (ev)->{MyFront h=new MyFront();
        h.getF().show();
          });  
        
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

    public int getQcount() {
        return qcount;
    }

    public void setQcount(int qcount) {
        this.qcount = qcount;
    }

    public int getFaux() {
        return faux;
    }

    public void setFaux(int faux) {
        this.faux = faux;
    }
    
    
    

}
