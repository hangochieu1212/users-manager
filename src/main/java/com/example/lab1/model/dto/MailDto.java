package com.example.lab1.model.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;
@Getter
@Setter
public class MailDto {
    private String from;
    private String to;
    private String subject;
    private String content;
    private Map<String, Object> props;

}
