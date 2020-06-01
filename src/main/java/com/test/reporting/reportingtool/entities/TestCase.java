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
@Table(name = "TEST_CASE")
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @Transient
    private int testStepsPassed;

    @Transient
    private int testStepsFailed;

    @Transient
    private int testStepsWithWarnings;

    @Transient
    private int testStepsNotRun;

    private Status status;

    @OneToMany(
        mappedBy = "testCase",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<TestStep> steps;

    @ManyToOne(fetch = FetchType.LAZY)
    private TestSuite testSuite;

    public TestSuite getTestSuite() {
        return testSuite;
    }

    public void setTestSuite(final TestSuite testSuite) {
        this.testSuite = testSuite;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
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

    public List<TestStep> getSteps() {
        return steps;
    }

    public void setSteps(final List<TestStep> steps) {
        this.steps = steps;
    }
}
