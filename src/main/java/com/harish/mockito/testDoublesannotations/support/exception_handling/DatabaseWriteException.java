package com.harish.mockito.testDoublesannotations.support.exception_handling;

public class DatabaseWriteException extends RuntimeException {
    public DatabaseWriteException(String message)
    {
        super(message);
    }
}
