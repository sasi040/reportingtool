package com.test.reporting.reportingtool.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_STEP")
public class TestStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Status status;

    private String filePath;

    @ManyToOne(fetch = FetchType.LAZY)
    private TestCase testCase;

    public TestCase getTestCase() {
        return testCase;
    }

    public void setTestCase(final TestCase testCase) {
        this.testCase = testCase;
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
}
