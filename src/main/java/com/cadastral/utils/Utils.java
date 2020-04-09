package com.cadastral.utils;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Utils {

    public static boolean isValidEmail(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public static boolean isUniqueViolation(String exceptionMessage) {
        return exceptionMessage.contains("Unique index or primary key violation");
    }
}
