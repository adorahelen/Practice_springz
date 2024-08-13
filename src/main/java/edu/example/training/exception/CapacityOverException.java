package edu.example.training.exception;

public class CapacityOverException extends RuntimeException {
    public CapacityOverException(String message) {
        super(message);
    }
    // 이게 끝, exception > RuntimeException
}



