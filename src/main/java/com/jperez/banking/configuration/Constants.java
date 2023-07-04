package com.jperez.banking.configuration;

public class Constants {

    public static final String RESPONSE_MESSAGE = "response";
    public static final String ERROR_MESSAGE = "error";
    public static final String WRONG_CREDENTIALS = "Wrong credentials";
    public static final String LOAD_USER_ERROR_MESSAGE = "Error loading user";
    public static final String DOCUMENT_NUMBER_ALREADY_EXISTS_MESSAGE = "There is already a user with the document " +
            "number provided";
    public static final String EMAIL_ALREADY_EXISTS_MESSAGE = "There is already a user with the email provided";
    public static final String PASSWORD_NO_MATCH_MESSAGE = "Passwords provided do not match";

    // Exception JwtToken
    public static final String TOKEN_EXCEPTION_MESSAGE = "Token error";
    public static final String MALFORMED_TOKEN_MESSAGE = "Malformed token";
    public static final String EXPIRED_TOKEN_MESSAGE = "Expired token";
    public static final String UNSUPPORTED_TOKEN_MESSAGE = "Unsupported token";
    public static final String SIGNATURE_MESSAGE = "Signature failure";
    public static final String ILLEGAL_ARGUMENT_MESSAGE = "Illegal argument";

    private Constants() {}

}
