package com.test.reporting.reportingtool.pojos;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("suites")
public class TestSuite {

    @Id
    private String id;

    private String name;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Integer testCasesPasssed;

    private Integer testCasesFailed;

    private Integer testCasesWithWarnings;

    private Integer testsNotRun;

    private Status status;

    private List<TestCase> cases;

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

    public Integer getTestCasesPasssed() {
        return testCasesPasssed;
    }

    public void setTestCasesPasssed(final Integer testCasesPasssed) {
        this.testCasesPasssed = testCasesPasssed;
    }

    public Integer getTestCasesFailed() {
        return testCasesFailed;
    }

    public void setTestCasesFailed(final Integer testCasesFailed) {
        this.testCasesFailed = testCasesFailed;
    }

    public Integer getTestCasesWithWarnings() {
        return testCasesWithWarnings;
    }

    public void setTestCasesWithWarnings(final Integer testCasesWithWarnings) {
        this.testCasesWithWarnings = testCasesWithWarnings;
    }

    public Integer getTestsNotRun() {
        return testsNotRun;
    }

    public void setTestsNotRun(final Integer testsNotRun) {
        this.testsNotRun = testsNotRun;
    }

    public Integer getTotalTestsCases() {
        return this.testsNotRun + this.testCasesPasssed + this.testCasesWithWarnings + this.testCasesFailed;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public List<TestCase> getCases() {
        return cases;
    }

    public void setCases(final List<TestCase> cases) {
        this.cases = cases;
    }
}
