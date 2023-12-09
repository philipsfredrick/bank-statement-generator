package com.nonso.bankstatementgenerator.controller;

import com.nonso.bankstatementgenerator.dto.request.StatementRequest;
import com.nonso.bankstatementgenerator.dto.response.StatementResponse;
import com.nonso.bankstatementgenerator.service.DatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/generate-statement")
public class RequestController {

    private final DatabaseService databaseService;

    @PostMapping
    public ResponseEntity<StatementResponse> generateBankStatement(@RequestBody StatementRequest request) throws IOException {
        databaseService.getAllTransactions(request.getUserEmail(), request.getStartDate(), request.getEndDate());
        return new ResponseEntity<>(new StatementResponse(), OK);
    }
}
