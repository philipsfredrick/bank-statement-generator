package com.nonso.bankstatementgenerator.service.impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.nonso.bankstatementgenerator.entity.Transaction;
import com.nonso.bankstatementgenerator.exception.StatementException;
import com.nonso.bankstatementgenerator.service.PdfGenerationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;


import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@Service
@AllArgsConstructor
public class PdfGenerationServiceImpl implements PdfGenerationService {


    public File generatePdf(List<Transaction> data) {
        Document document = new Document();
        File statement = new File("bank-statement.pdf");
        try {
            PdfWriter.getInstance(document, new FileOutputStream(statement));
            document.open();

            document.add(new Paragraph("Transactions Statement"));

            PdfPTable table = new PdfPTable(2);
            table.addCell("Date");
            table.addCell("Amount");

            for (Transaction transaction : data) {
                table.addCell(transaction.getTransactionDate().toString());
                table.addCell(transaction.getAmount().toString());
            }
            document.add(table);
        } catch (Exception e) {
            log.error(String.format("An error occurred while creating file. " +
                    "Possible reasons: %s", e.getLocalizedMessage()));
            throw new StatementException("Error occurred creating file", INTERNAL_SERVER_ERROR);
        } finally {
            document.close();
        }
        return statement;
    }
}
