package com.nonso.bankstatementgenerator.service;

import com.itextpdf.text.DocumentException;
import com.nonso.bankstatementgenerator.entity.Transaction;

import java.util.List;

public interface PdfGenerationService {
    void generatePdf(List<Transaction> transactions) throws DocumentException;
}
