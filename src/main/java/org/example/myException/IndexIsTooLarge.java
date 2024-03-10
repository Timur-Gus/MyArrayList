package org.example.myException;

public class IndexIsTooLarge extends RuntimeException{

    public IndexIsTooLarge() {
    }

    public IndexIsTooLarge(String message) {
        super(message);
    }

    public IndexIsTooLarge(String message, Throwable cause) {
        super(message, cause);
    }

    public IndexIsTooLarge(Throwable cause) {
        super(cause);
    }

    public IndexIsTooLarge(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
