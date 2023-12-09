package com.nonso.bankstatementgenerator.service.impl;

import com.nonso.bankstatementgenerator.entity.Transaction;
import com.nonso.bankstatementgenerator.service.DatabaseService;
import lombok.AllArgsConstructor;
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

@Service
@AllArgsConstructor
public class DatabaseServiceImpl implements DatabaseService {
    private static final String CSV_FILE_PATH = "C:\\Users\\NONSO\\Desktop\\IdeaProjects\\bank-statement-generator\\bank-statement-generator\\transactions.csv";

        @Override
        public List<Transaction> getAllTransactions(String userEmail, LocalDate startDate, LocalDate endDate) throws IOException {
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

//                    System.out.println(email);
//                    System.out.println(date);
//                    System.out.println(amount);

                    if (email.equals(userEmail) && (isDateInRange(date, startDate, endDate))) {
                        transactions.add(new Transaction(email, date, amount));
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return transactions;
        }


//    @Override
//    public List<Transaction> getAllTransactions(String userEmail, LocalDate startDate, LocalDate endDate) throws IOException {
//        return Files.lines(Paths.get(CSV_FILE_PATH))
//                .skip(1) // Skip header
//                .map(line -> {
//                    String[] parts = line.split(",");
//
//                    return new Transaction(parts[0], LocalDate.parse(parts[1], DateTimeFormatter.ofPattern("M/d/yyyy")), Double.parseDouble(parts[2]));
//                })
//                .filter(transaction -> transaction.getUserEmail().equals(userEmail)
//                        && transaction.getTransactionDate().isAfter(startDate)
//                        && transaction.getTransactionDate().isBefore(endDate))
//                .toList();
//    }

    private boolean isDateInRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }
}
