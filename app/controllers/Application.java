package controllers;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import play.Logger;
import play.libs.Mail;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void sendMail(String name, String phone, String email, String message) throws EmailException{
    	Logger.info("Message sent %s, %s, %s, %s", name, phone, email, message);
    	
    	SimpleEmail simpleEmail = new SimpleEmail();
    	simpleEmail.setFrom(email);
    	simpleEmail.addTo("vitalii.kravets@gmail.com");
    	simpleEmail.setSubject("Огляд квартири");
    	simpleEmail.setMsg(name + "\n" + phone + "\n" + message);
    	
    	Mail.send(simpleEmail);
    }

}