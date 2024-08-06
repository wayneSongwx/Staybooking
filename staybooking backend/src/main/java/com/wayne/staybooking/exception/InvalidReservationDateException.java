package com.wayne.staybooking.exception;

public class InvalidReservationDateException extends RuntimeException{
    public InvalidReservationDateException(String message) {
        super(message);
    }
}
