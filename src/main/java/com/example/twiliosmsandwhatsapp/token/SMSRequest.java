package com.example.twiliosmsandwhatsapp.token;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SMSRequest {

    private final String destinationCellphoneNumber;
    private final String message;
}
