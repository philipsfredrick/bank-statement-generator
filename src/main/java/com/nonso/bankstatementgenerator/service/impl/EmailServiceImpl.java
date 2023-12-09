package com.nonso.bankstatementgenerator.service.impl;

import com.nonso.bankstatementgenerator.exception.StatementException;
import com.nonso.bankstatementgenerator.service.EmailService;
import com.nonso.bankstatementgenerator.utils.EmailUtils;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import java.io.File;

import static com.nonso.bankstatementgenerator.utils.EmailUtils.EMAIL_SUBJECT;
import static com.nonso.bankstatementgenerator.utils.EmailUtils.getEmailMessage;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender emailSender;
    @Value("${spring.mail.username}")
    private String serverEmail;

    @Override
    public void sendEmailWithAttachment(File attachment, String email) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(email);
            helper.setSubject(EMAIL_SUBJECT);
            helper.setText(EmailUtils.getEmailMessage());
            helper.addAttachment("bank-statement.pdf", attachment);

            emailSender.send(message);
        } catch (MessagingException e) {
            log.error(String.format("An error occurred while sending email. " +
                    "Possible reasons: %s", e.getLocalizedMessage()));
            throw new StatementException("Email service not available, got bad greeting", BAD_REQUEST);
        }
    }
}

