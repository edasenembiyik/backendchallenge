package com.enoca.backendchallenge.exception;
import lombok.Getter;

@Getter
public class ChallengeException extends RuntimeException{
    private final ErrorType errorType;

    public ChallengeException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public ChallengeException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }
}