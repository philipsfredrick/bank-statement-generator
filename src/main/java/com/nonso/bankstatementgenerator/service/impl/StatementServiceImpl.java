package com.nonso.bankstatementgenerator.service.impl;

import com.nonso.bankstatementgenerator.dto.request.StatementRequest;
import com.nonso.bankstatementgenerator.entity.Transaction;
import com.nonso.bankstatementgenerator.service.DatabaseService;
import com.nonso.bankstatementgenerator.service.EmailService;
import com.nonso.bankstatementgenerator.service.PdfGenerationService;
import com.nonso.bankstatementgenerator.service.StatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatementServiceImpl implements StatementService {

    private final EmailService emailService;
    private final DatabaseService databaseService;
    private final PdfGenerationService pdfGenerationService;


    public void generateStatement(StatementRequest request) {
        List<Transaction> transactions = databaseService.getAllTransactions(
                request.getUserEmail(), request.getStartDate(), request.getEndDate());

        File report = pdfGenerationService.generatePdf(transactions);

        emailService.sendEmailWithAttachment(report, request.getUserEmail());
    }
}
