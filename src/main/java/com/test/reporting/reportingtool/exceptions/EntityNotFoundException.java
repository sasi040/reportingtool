package com.test.reporting.reportingtool.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id) {
        super("No entity found with Id :" + id);
    }
}
