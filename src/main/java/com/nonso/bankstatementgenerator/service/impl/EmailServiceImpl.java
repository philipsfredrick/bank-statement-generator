package com.nonso.bankstatementgenerator.service.impl;

import com.nonso.bankstatementgenerator.service.EmailService;
import com.nonso.bankstatementgenerator.service.PdfGenerationService;
import com.nonso.bankstatementgenerator.utils.EmailUtils;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.nonso.bankstatementgenerator.utils.EmailUtils.getEmailMessage;


@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    public static final String UTF_8_ENCODING = "UTF-8";
    private final JavaMailSender emailSender;

//    private final PdfGenerationService pdfGenerationService;

    @Value("${spring.mail.username}")
    private final String serverEmail;


    @Override
    public void sendMimeMessageWithAttachment(String to, String name) {
        try {
            final MimeMessage message = getMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, UTF_8_ENCODING);
            helper.setPriority(1);
            helper.setFrom(serverEmail);
            helper.setTo(to);
            helper.setSubject(EmailUtils.EMAIL_SUBJECT);
            helper.setText(getEmailMessage(name));
//            Add attachments
//            FileSystemResource file = new FileSystemResource(pdfGenerationService.generatePdf(new ArrayList<>()));
//            helper.addAttachment("bankstatement.pdf", file);
            emailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    private MimeMessage getMimeMessage() {
        return emailSender.createMimeMessage();
    }
}

