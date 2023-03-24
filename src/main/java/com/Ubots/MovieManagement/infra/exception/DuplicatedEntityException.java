package com.Ubots.MovieManagement.infra.exception;

public class DuplicatedEntityException extends RuntimeException{
    public DuplicatedEntityException(String msg) {
        super(msg);
    }
}
