package com.test.reporting.reportingtool.entities;

public enum Status {

    SUCCESS("Success"),
    FAILED("Failed"),
    WARNING("Warning"),
    CANCELLED("Cancelled");

    private String status;

    Status(final String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
