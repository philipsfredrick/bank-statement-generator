package com.nonso.bankstatementgenerator.utils;

public class EmailUtils {

    public static final String EMAIL_SUBJECT = "Bank Statement Report";
    public static String getEmailMessage() {
        return "Hello, " + "\n\n" + "Please find your bank statement attached below";
    }
}
