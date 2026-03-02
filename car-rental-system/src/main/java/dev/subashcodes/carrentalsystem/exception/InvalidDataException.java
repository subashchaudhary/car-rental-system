package dev.subashcodes.carrentalsystem.exception;

import lombok.Getter;

@Getter
public class InvalidDataException extends Exception {

    private String message;

    //constructor
    public InvalidDataException(String message) {
        this.message = message;
    }
    
}
