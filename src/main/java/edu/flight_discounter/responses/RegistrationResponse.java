package edu.flight_discounter.responses;


public final class RegistrationResponse {
    public final boolean isRegistered;
    public final String message;

    public RegistrationResponse() {
        message = "REGISTRATION_SUCCESSFUL";
        isRegistered = true;
    }

    public RegistrationResponse(final String email) {
        message = "REGISTRATION_UNSUCCESSFUL " + email + " is already registered!";
        isRegistered = false;
    }
}