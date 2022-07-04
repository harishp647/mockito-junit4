package com.harish.mockito.testDoublesannotations.support.exception_handling;

public class DatabaseReadException extends RuntimeException {
    public DatabaseReadException(String message) {
        super(message);
    }
}
