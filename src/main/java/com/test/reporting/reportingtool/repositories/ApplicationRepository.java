package com.test.reporting.reportingtool.repositories;

import com.mongodb.client.result.UpdateResult;
import com.test.reporting.reportingtool.pojos.Application;
import com.test.reporting.reportingtool.pojos.Execution;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.WriteResultChecking;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class ApplicationRepository {

    private MongoOperations mongoTemplate;

    public ApplicationRepository(MongoTemplate mongoTemplate) {
        mongoTemplate.setWriteResultChecking(WriteResultChecking.EXCEPTION);
        this.mongoTemplate = mongoTemplate;
    }

    public List<Application> findAll() {
        return this.mongoTemplate.findAll(Application.class);
    }

    public Optional<Application> findById(String id) {
        return Optional.ofNullable(this.mongoTemplate.findOne(new Query(where("id").is(id)), Application.class));
    }

    public long AddExecutionsInApplication(final String id, final List<Execution> executions) {
        executions.forEach(e -> e.setId(ObjectId.get().toString()));
        UpdateResult result = this.mongoTemplate.updateFirst(new Query(where("id").is(id)), new Update().push("executions").each(executions),
            Application.class);
        return result.getModifiedCount();
    }

    public Optional<Application> findExecution(final String executionName) {

        final Query query = new Query(Criteria.where("executions.name").is(executionName));

        query.fields().elemMatch("executions",Criteria.where("name").is(executionName));

        return Optional.ofNullable(this.mongoTemplate.findOne(query, Application.class));

    }
}
