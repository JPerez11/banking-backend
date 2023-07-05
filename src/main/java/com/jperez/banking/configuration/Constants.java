package com.jperez.banking.configuration;

public class Constants {

    public static final String RESPONSE_MESSAGE = "Response";
    public static final String ERROR_MESSAGE = "Error";
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

    // OpenApi
    // Server
    public static final String SERVER_DEV_URL = "http://localhost:9999";
    public static final String SERVER_DEV_DESCRIPTION = "Server URL in development";
    // Contact
    public static final String CONTACT_EMAIL = "jhoansebas0301@gmail.com";
    public static final String CONTACT_NAME = "Jhoan Perez";
    public static final String CONTACT_URL_WEBSITE = "https://jperez11.netlify.app";
    // License
    public static final String LICENSE_NAME = "Apache license";
    public static final String LICENSE_URL = "https://www.apache.org/licenses/LICENSE-2.0";
    // Info
    public static final String SWAGGER_TITLE = "Banking App";
    public static final String SWAGGER_VERSION = "1.0";
    public static final String SWAGGER_DESCRIPTION = "This API exposes endpoints to manage users";
    public static final String SWAGGER_TERMS_OF_SERVICE = "https://swagger.io/terms/";

    private Constants() {}

}
