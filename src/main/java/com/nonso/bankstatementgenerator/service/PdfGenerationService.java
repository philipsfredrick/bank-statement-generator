package com.nonso.bankstatementgenerator.service;

import com.itextpdf.text.DocumentException;
import com.nonso.bankstatementgenerator.entity.Transaction;

import java.io.File;
import java.util.List;

public interface PdfGenerationService {
    File generatePdf(List<Transaction> transactions);
}
