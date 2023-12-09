package com.nonso.bankstatementgenerator.service.impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.nonso.bankstatementgenerator.entity.Transaction;
import com.nonso.bankstatementgenerator.service.DatabaseService;
import com.nonso.bankstatementgenerator.service.PdfGenerationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class PdfGenerationServiceImpl implements PdfGenerationService {

    private final DatabaseService databaseService;

    public void generatePdf(List<Transaction> transactions) throws DocumentException {

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\NONSO\\Desktop\\bank-statement.pdf"));
            document.open();


            PdfPTable table = new PdfPTable(2);
            addTableHeader(table);
            addRows(table);

            document.add(table);
            document.close();

//            List<Transaction> transactionList = databaseService.getAllTransactions();
            for (Transaction transaction : transactions) {
                document.add(new Paragraph(String.format("Date: %s, Amount: %.2f",
                        transaction.getTransactionDate(), transaction.getAmount())));

            }

            document.close();
        } catch (Exception e) {
            throw new DocumentException("Error generating PDF", e);
        }
    }

    private void addTableHeader(PdfPTable table) {
        Stream.of("date_of_transaction", "amount")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.MAGENTA);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table) {
        table.addCell("row 1, col 1");
        table.addCell("row 1, col 2");
        table.addCell("row 1, col 3");
    }
}
