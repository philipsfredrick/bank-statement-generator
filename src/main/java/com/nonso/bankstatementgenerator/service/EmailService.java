package com.nonso.bankstatementgenerator.service;

public interface EmailService {
    void sendMimeMessageWithAttachment(String to, String name);
}
