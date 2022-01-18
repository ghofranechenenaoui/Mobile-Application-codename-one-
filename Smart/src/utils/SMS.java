/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author asus
 */
// Install the Java helper library from twilio.com/docs/java/install

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMS {
      public static final String ACCOUNT_SID = "ACc8363c8ca4f54b7514200529b2169ba9";
    public static final String AUTH_TOKEN = "8acea827ba98d7ef0f1f56d39acbcec4";
       public void sendSms(){
    // Find your Account Sid and Token at twilio.com/console
    // DANGER! This is insecure. See http://twil.io/secure
  


        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+21623669707"),
                new com.twilio.type.PhoneNumber("+12024101394"),
                "Felicitations! Vous etes Maintenant Inscrit à SmartStart ")
            .create();

        System.out.println(message.getSid());
    
}
}