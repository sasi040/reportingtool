package com.test.reporting.reportingtool.pojos;

public enum Status {

    SUCCESS("Success"), FAILED("Failed"),WARNING("Warning");

    private String status;

    Status(final String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
