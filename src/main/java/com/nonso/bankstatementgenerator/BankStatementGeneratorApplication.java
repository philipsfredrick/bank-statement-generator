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
public class BankStatementGeneratorApplication implements CommandLineRunner {

	private final DatabaseService databaseService;

	public static void main(String[] args) {
		SpringApplication.run(BankStatementGeneratorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		LocalDate date1 =LocalDate.parse("2023-03-01");
		LocalDate date2 = LocalDate.parse("2023-04-01");

//		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
//		LocalDate  d1 = LocalDate.parse(date1, df);
//		LocalDate  d2 = LocalDate.parse(date2, df);

//		Long datediff = ChronoUnit.DAYS.between(d1,d2);

		String email = "judy.ehrman@gmail.com";
//		LocalDate start = LocalDate.parse("2023-02-03");
//		LocalDate end = LocalDate.parse("2023-12-03");

		List<Transaction> transactions = databaseService.getAllTransactions(email,date1, date2);
		transactions.forEach(System.out::println);
	}
}
