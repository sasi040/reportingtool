package com.test.reporting.reportingtool.dtos;

import java.util.ArrayList;
import java.util.List;

public class ApplicationDto {

    private Long id;

    private String name;

    private String environment;

    private String applicationUrl;

    private List<ExecutionDto> executions = new ArrayList<>();

    public List<ExecutionDto> getExecutions() {
        return executions;
    }

    public void setExecutions(final List<ExecutionDto> executions) {
        this.executions = executions;
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

    public String getApplicationUrl() {
        return applicationUrl;
    }

    public void setApplicationUrl(final String applicationUrl) {
        this.applicationUrl = applicationUrl;
    }

}
