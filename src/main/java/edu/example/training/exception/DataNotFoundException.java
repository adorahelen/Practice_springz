package edu.example.training.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String message) {
        super(message);
    }
    // 이게 끝, exception > RuntimeException
}



