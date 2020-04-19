package com.test.reporting.reportingtool.jparepos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "APPLICATION")
public class Application implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private java.lang.Long id;

    private String name;

    private String environment;

    private String applicationUrl;

    @OneToMany(
        mappedBy = "application",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Execution> executions = new ArrayList<>();

    public List<Execution> getExecutions() {
        return executions;
    }

    public void setExecutions(final List<Execution> executions) {
        this.executions = executions;
    }


    public java.lang.Long getId() {
        return id;
    }

    public void setId(final java.lang.Long id) {
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
