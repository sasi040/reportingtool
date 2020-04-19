package com.test.reporting.reportingtool.dtos;

import com.test.reporting.reportingtool.jparepos.Status;
import java.io.Serializable;
import java.time.LocalDateTime;

public class ExecutionDto implements Serializable {

    private Long id;

    private String name;

    private String environment;

    private String browserType;

    private String operatingSystem;

    private String systemIP;

    private String systemName;

    private String executedBy;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Status status;

    private Long applicationId;

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(final Long applicationId) {
        this.applicationId = applicationId;
    }

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

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(final String environment) {
        this.environment = environment;
    }

    public String getBrowserType() {
        return browserType;
    }

    public void setBrowserType(final String browserType) {
        this.browserType = browserType;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(final String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getSystemIP() {
        return systemIP;
    }

    public void setSystemIP(final String systemIP) {
        this.systemIP = systemIP;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(final String systemName) {
        this.systemName = systemName;
    }

    public String getExecutedBy() {
        return executedBy;
    }

    public void setExecutedBy(final String executedBy) {
        this.executedBy = executedBy;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

}
