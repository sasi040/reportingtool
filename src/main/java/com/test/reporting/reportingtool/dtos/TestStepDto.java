package com.test.reporting.reportingtool.dtos;

import com.test.reporting.reportingtool.entities.Status;


public class TestStepDto {

    private Long id;

    private String name;

    private String description;

    private Status status;

    private String filePath;

    private int duration;

    private Long testCaseId;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(final String filePath) {
        this.filePath = filePath;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(final int duration) {
        this.duration = duration;
    }

    public Long getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(final Long testCaseId) {
        this.testCaseId = testCaseId;
    }
}
