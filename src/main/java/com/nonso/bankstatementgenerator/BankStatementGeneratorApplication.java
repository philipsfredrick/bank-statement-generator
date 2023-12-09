package com.nonso.bankstatementgenerator;

import com.nonso.bankstatementgenerator.entity.Transaction;
import com.nonso.bankstatementgenerator.service.DatabaseService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class BankStatementGeneratorApplication{

	public static void main(String[] args) {
		SpringApplication.run(BankStatementGeneratorApplication.class, args);
	}
}
