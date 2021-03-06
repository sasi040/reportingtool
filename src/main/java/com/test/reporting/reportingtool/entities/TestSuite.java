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
import javax.persistence.Transient;

@Entity
@Table(name = "TEST_SUITE")
public class TestSuite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @Transient
    private int testCasesPassed;

    @Transient
    private int testCasesFailed;

    @Transient
    private int testCasesWithWarnings;

    @Transient
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

    public Long getId() {
        return id;
    }

    public void setId(final java.lang.Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
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
