package com.nonso.bankstatementgenerator.service.impl;

import com.nonso.bankstatementgenerator.entity.Transaction;
import com.nonso.bankstatementgenerator.exception.StatementException;
import com.nonso.bankstatementgenerator.service.DatabaseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@Service
@AllArgsConstructor
public class DatabaseServiceImpl implements DatabaseService {
    private static final String CSV_FILE_PATH = "C:\\Users\\NONSO\\Desktop\\IdeaProjects\\bank-statement-generator\\bank-statement-generator\\src\\main\\resources\\transactions.csv";

        @Override
        public List<Transaction> getAllTransactions(String userEmail, LocalDate startDate, LocalDate endDate) {
            List<Transaction> transactions = new ArrayList<>();
            String[] headers = {"user_email", "date_of_transaction", "amount"};
            try {
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
                    CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                            .setHeader(headers)
                        .setSkipHeaderRecord(true)
                        .build();

                Iterable<CSVRecord> records = csvFormat.parse(reader);

                for (CSVRecord csvRecord : records) {
                    String email = csvRecord.get("user_email");
                    LocalDate date = LocalDate.parse(csvRecord.get("date_of_transaction"), DateTimeFormatter.ofPattern("M/d/yyyy"));
                    Double amount = Double.parseDouble(csvRecord.get("amount"));

                    if (email.equals(userEmail) && (isDateInRange(date, startDate, endDate))) {
                        transactions.add(new Transaction(email, date, amount));
                    }
                }
            } catch (IOException e) {
                log.error(String.format("An error occurred while reading database file. " +
                        "Possible reasons: %s", e.getLocalizedMessage()));
                throw new StatementException("Could not access data", INTERNAL_SERVER_ERROR);
            }
            return transactions;
        }

    private boolean isDateInRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }
}
