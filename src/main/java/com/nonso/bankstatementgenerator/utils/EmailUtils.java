package com.nonso.bankstatementgenerator.utils;

public class EmailUtils {

    public static final String EMAIL_SUBJECT = "Bank Statement Report";
    public static String getEmailMessage(String name) {
        return "Hello " + name + ",\n\n" + "Please find your bank statement for period requested attached below";
    }
}
