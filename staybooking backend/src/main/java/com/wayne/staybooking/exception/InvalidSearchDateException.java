package com.wayne.staybooking.exception;

public class InvalidSearchDateException extends RuntimeException{
    public InvalidSearchDateException(String message) {
        super(message);
    }
}
