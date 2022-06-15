package com.example.twiliosmsandwhatsapp.twilio;

import com.example.twiliosmsandwhatsapp.token.SMSRequest;
import com.example.twiliosmsandwhatsapp.token.SMSSender;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
@Slf4j
public class TwilioSMSSender implements SMSSender {

    private final TwilioConfig twilioConfig;

    @Autowired
    public TwilioSMSSender(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }

    @Override
    public void sendSMS(SMSRequest request) {
        Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
        System.out.println("Twilio initialized");
        MessageCreator creator =Message.creator(
                new PhoneNumber(request.getDestinationCellphoneNumber()),
                new PhoneNumber(twilioConfig.getTrialNumber()),
                request.getMessage());
        creator.create();
        log.info("SMS SENT!");
    }

    @Override
    public void sendWhatsApp(SMSRequest request) {
        MessageCreator creator =Message.creator(
                new PhoneNumber("whatsapp:"+request.getDestinationCellphoneNumber()),
                new PhoneNumber("whatsapp:"+twilioConfig.getWhatsappTrialNumber()),
                request.getMessage());
        creator.create();
        log.info("WHATSAPP SENT!");

    }
}
