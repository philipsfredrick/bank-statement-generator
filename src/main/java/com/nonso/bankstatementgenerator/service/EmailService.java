package com.nonso.bankstatementgenerator.service;

import java.io.File;

public interface EmailService {
    void sendEmailWithAttachment(File attachment, String email);

}
