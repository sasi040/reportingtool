package com.test.reporting.reportingtool.pojos;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("testCases")
public class TestCase {

    @Id
    private String id;

    private String name;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Integer testStepsPassed;

    private Integer testStepsFailed;

    private Integer testStepsWithWarnings;

    private Integer testStepsNotRun;

    private Status status;

    private List<TestStep> steps;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
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

    public Integer getTestStepsPassed() {
        return testStepsPassed;
    }

    public void setTestStepsPassed(final Integer testStepsPassed) {
        this.testStepsPassed = testStepsPassed;
    }

    public Integer getTestStepsFailed() {
        return testStepsFailed;
    }

    public void setTestStepsFailed(final Integer testStepsFailed) {
        this.testStepsFailed = testStepsFailed;
    }

    public Integer getTestStepsWithWarnings() {
        return testStepsWithWarnings;
    }

    public void setTestStepsWithWarnings(final Integer testStepsWithWarnings) {
        this.testStepsWithWarnings = testStepsWithWarnings;
    }

    Integer getTestStepsNotRun() {
        return testStepsNotRun;
    }

    void setTestStepsNotRun(final Integer testStepsNotRun) {
        this.testStepsNotRun = testStepsNotRun;
    }

    Integer getTotalTestSteps() {
        return this.testStepsFailed + this.testStepsNotRun + this.testStepsPassed + this.testStepsWithWarnings;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public List<TestStep> getSteps() {
        return steps;
    }

    public void setSteps(final List<TestStep> steps) {
        this.steps = steps;
    }
}
