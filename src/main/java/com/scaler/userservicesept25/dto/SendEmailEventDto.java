package com.scaler.userservicesept25.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendEmailEventDto {

    private String toEmail;
    private String subject;
    private String body;
}
