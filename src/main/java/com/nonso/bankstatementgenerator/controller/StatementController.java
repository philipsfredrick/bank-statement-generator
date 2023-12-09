package com.nonso.bankstatementgenerator.controller;

import com.nonso.bankstatementgenerator.dto.request.StatementRequest;
import com.nonso.bankstatementgenerator.dto.response.StatementResponse;
import com.nonso.bankstatementgenerator.service.StatementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class StatementController {

     private final StatementService statementService;

    @PostMapping(value = "/generate-statement", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> generateBankStatement(@RequestBody @Valid StatementRequest request) {
        statementService.generateStatement(request);
        return new ResponseEntity<>(new StatementResponse("Your statement has been sent to your email"), CREATED);
    }
}
