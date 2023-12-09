package com.nonso.bankstatementgenerator.exception.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

    @JsonIgnore
    private int status;
    private String message;
    private String path;
    private String errorCode;
    private String infoLink;
    private Object details;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timeStamp;

    public ApiError(final String message, final Object details) {
        timeStamp = LocalDateTime.now();
        this.details = details;
        this.message = message;
    }

    public ApiError(final String message, final Object details, final String errorCode) {
        timeStamp = LocalDateTime.now();
        this.details = details;
        this.message = message;
        this.errorCode = errorCode;
    }
}
