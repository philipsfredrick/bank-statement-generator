package com.nonso.bankstatementgenerator.service;

import com.nonso.bankstatementgenerator.entity.Transaction;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
public interface DatabaseService {
    List<Transaction> getAllTransactions(String userEmail, LocalDate startDate, LocalDate endDate);
}
