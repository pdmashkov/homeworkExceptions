package ru.netologu.homeworkExceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg) {
        super(msg);
    }
}
