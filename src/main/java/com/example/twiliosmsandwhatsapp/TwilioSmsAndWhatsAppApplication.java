package com.example.twiliosmsandwhatsapp;

import com.example.twiliosmsandwhatsapp.token.SMSRequest;
import com.example.twiliosmsandwhatsapp.token.SMSSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class TwilioSmsAndWhatsAppApplication {

    @Autowired
    public TwilioSmsAndWhatsAppApplication(SMSSender smsSender) {
        this.smsSender = smsSender;
    }

    public static void main(String[] args) {
        SpringApplication.run(TwilioSmsAndWhatsAppApplication.class, args);
    }

    @Qualifier("twilio")
    private  final SMSSender smsSender;

    @EventListener(ApplicationReadyEvent.class)
    public void sendSMS(){
        smsSender.sendSMS(new SMSRequest("+5491155690703", "Your" +
                " token is 1234"));
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendWhatsapp(){
        smsSender.sendWhatsApp(new SMSRequest("+5491155690703", "Your" +
                " token code is 1234"));
    }
}
