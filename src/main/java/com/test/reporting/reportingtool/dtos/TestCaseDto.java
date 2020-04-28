package com.test.reporting.reportingtool.dtos;

import com.test.reporting.reportingtool.jparepos.Status;
import java.time.LocalDateTime;
import java.util.List;

public class TestCaseDto {

    private Long id;

    private String name;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private int testStepsPassed;

    private int testStepsFailed;

    private int testStepsWithWarnings;

    private int testStepsNotRun;

    private Status status;

    private Long testSuiteId;

    public List<TestStepDto> getSteps() {
        return steps;
    }

    public void setSteps(final List<TestStepDto> steps) {
        this.steps = steps;
    }

    private List<TestStepDto> steps;

    public Long getTestSuiteId() {
        return testSuiteId;
    }

    public void setTestSuiteId(final Long testSuiteId) {
        this.testSuiteId = testSuiteId;
    }

    public java.lang.Long getId() {
        return id;
    }

    public void setId(final java.lang.Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(final LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(final LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getTestStepsPassed() {
        return testStepsPassed;
    }

    public void setTestStepsPassed(final int testStepsPassed) {
        this.testStepsPassed = testStepsPassed;
    }

    public int getTestStepsFailed() {
        return testStepsFailed;
    }

    public void setTestStepsFailed(final int testStepsFailed) {
        this.testStepsFailed = testStepsFailed;
    }

    public int getTestStepsWithWarnings() {
        return testStepsWithWarnings;
    }

    public void setTestStepsWithWarnings(final int testStepsWithWarnings) {
        this.testStepsWithWarnings = testStepsWithWarnings;
    }

    public int getTestStepsNotRun() {
        return testStepsNotRun;
    }

    public void setTestStepsNotRun(final Integer testStepsNotRun) {
        this.testStepsNotRun = testStepsNotRun;
    }

    int getTotalTestSteps() {
        return this.testStepsFailed + this.testStepsNotRun + this.testStepsPassed + this.testStepsWithWarnings;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

}
