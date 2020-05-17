package com.test.reporting.reportingtool.entities;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_SUITE")
public class TestSuite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private java.lang.Long id;

    private String name;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private int testCasesPassed;

    private int testCasesFailed;

    private int testCasesWithWarnings;

    private int testsNotRun;

    private Status status;

    @OneToMany(
        mappedBy = "testSuite",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<TestCase> cases;

    public Execution getExecution() {
        return execution;
    }

    public void setExecution(final Execution execution) {
        this.execution = execution;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Execution execution;

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

    public int getTestCasesPassed() {
        return testCasesPassed;
    }

    public void setTestCasesPassed(final int testCasesPassed) {
        this.testCasesPassed = testCasesPassed;
    }

    public int getTestCasesFailed() {
        return testCasesFailed;
    }

    public void setTestCasesFailed(final int testCasesFailed) {
        this.testCasesFailed = testCasesFailed;
    }

    public int getTestCasesWithWarnings() {
        return testCasesWithWarnings;
    }

    public void setTestCasesWithWarnings(final int testCasesWithWarnings) {
        this.testCasesWithWarnings = testCasesWithWarnings;
    }

    public int getTestsNotRun() {
        return testsNotRun;
    }

    public void setTestsNotRun(final int testsNotRun) {
        this.testsNotRun = testsNotRun;
    }

    public int getTotalTestsCases() {
        return this.testsNotRun + this.testCasesPassed + this.testCasesWithWarnings + this.testCasesFailed;
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
