package com.nonso.bankstatementgenerator.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @Email(message = "please enter a valid email")
    @NotBlank(message = "email must not be blank")
    @JsonProperty("user_email")
    private String userEmail;

    @JsonProperty("start_date")
    @NotNull(message = "start_date must not be blank")
    private LocalDate startDate;

    @JsonProperty("end_date")
    @NotNull(message = "end_date must not be blank")
    private LocalDate endDate;

}
