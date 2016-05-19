package edu.flight_discounter.exceptions;

public abstract class AbstractException extends Exception {

    public AbstractException(final Class<?> clazz, final String message) {
        super("[" + clazz.getSimpleName() + "]: " + message);
    }
}
