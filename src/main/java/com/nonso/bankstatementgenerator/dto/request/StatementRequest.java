package com.nonso.bankstatementgenerator.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatementRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 4645692964573307260L;

    private String userEmail;
    private LocalDate startDate;
    private LocalDate endDate;
}
