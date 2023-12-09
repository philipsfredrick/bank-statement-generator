package com.nonso.bankstatementgenerator.service;

import com.nonso.bankstatementgenerator.dto.request.StatementRequest;

public interface StatementService {
    void generateStatement(StatementRequest request);
}
