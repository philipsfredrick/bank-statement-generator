package com.nonso.bankstatementgenerator.exception;

import com.nonso.bankstatementgenerator.utils.ErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Getter
@Setter
@NoArgsConstructor
public class UnAuthorizedException extends StatementException {

    @Serial
    private static final long serialVersionUID = -199394942841186634L;

    public UnAuthorizedException(String msg) {
        super(msg, UNAUTHORIZED);
    }

    public UnAuthorizedException(String msg, ErrorCode errorCode) {
        super(msg, UNAUTHORIZED, errorCode);
    }
}
