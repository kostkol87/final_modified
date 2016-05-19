package edu.flight_discounter.special;


public final class AuthenticationResponse {
    public final boolean isAuthenticated;
    public final String message;
    public final static String AUTHENTICATION_UNSUCCESSFUL = "Username or password incorrect, please try again!";

    public AuthenticationResponse() {
        this.isAuthenticated = false;
        this.message = AUTHENTICATION_UNSUCCESSFUL;
    }
}
