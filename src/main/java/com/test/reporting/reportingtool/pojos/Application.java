package com.test.reporting.reportingtool.pojos;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("applications")
public class Application {

    @Id
    private String id;

    private String name;

    private String environment;

    private String applicationUrl;

    private List<Execution> executions;

    public List<Execution> getExecutions() {
        return executions;
    }

    public void setExecutions(final List<Execution> executions) {
        this.executions = executions;
    }


    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
