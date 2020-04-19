package com.test.reporting.reportingtool.repositories;

import com.test.reporting.reportingtool.pojos.Application;
import com.test.reporting.reportingtool.pojos.Execution;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AppRepository extends MongoRepository<Application, String> {

    @Query(value = "{'name': ?0 }")
    public Optional<Application> findByName(final String name);


    @Query(value = "{'executions.name' : ?0}", fields = "{'executions.$': 1}")
    public List<Execution> findByExecutions(final String executionName);
}
