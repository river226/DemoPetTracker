package xyz.jriver.PetTracker.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = org.springframework.http.HttpStatus.BAD_REQUEST)
public class InvalidPetException extends Exception {
    public InvalidPetException(String message) {
        super(message);
    }
}
