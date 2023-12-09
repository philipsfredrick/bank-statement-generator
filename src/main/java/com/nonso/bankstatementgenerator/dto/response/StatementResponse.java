package com.nonso.bankstatementgenerator.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatementResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -6749539371845478334L;

    private String message;
}
