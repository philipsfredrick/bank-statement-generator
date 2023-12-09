package com.nonso.bankstatementgenerator.exception;

import com.nonso.bankstatementgenerator.utils.ErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class StatementException extends RuntimeException{

    protected HttpStatus status;
    private ErrorCode errorCode;
    private String metadata;
    private String infoLink;

    public StatementException(final String msg) {
        super(msg);
    }

    public StatementException(final String msg, final HttpStatus status) {
        this(msg);
        this.status = status;
    }

    public StatementException(final String msg, final HttpStatus status, final ErrorCode errorCode) {
        this(msg, status);
        this.errorCode = errorCode;
    }
}
