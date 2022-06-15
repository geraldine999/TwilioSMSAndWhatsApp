package com.example.twiliosmsandwhatsapp.token;

public interface SMSSender {

    void sendSMS(SMSRequest request);
    void sendWhatsApp(SMSRequest request);
}
