package com.test.reporting.reportingtool.controller;

import com.test.reporting.reportingtool.pojos.Application;
import com.test.reporting.reportingtool.pojos.Execution;
import com.test.reporting.reportingtool.repositories.ApplicationRepository;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ApplicationController {

    @Autowired
    private ApplicationRepository repository;

    @GetMapping("/applications")
    public CollectionModel<EntityModel<Application>> getApplications() {
        List<EntityModel<Application>> applications = this.repository.findAll()
            .stream()
            .map(app -> new EntityModel<>(app,
                linkTo(methodOn(ApplicationController.class).getOne(app.getId())).withSelfRel(),
                linkTo(methodOn(ApplicationController.class).getApplications()).withRel("applications")))
            .collect(Collectors.toList());

        return new CollectionModel<>(applications, linkTo(methodOn(ApplicationController.class).getApplications()).withSelfRel());
    }

    @GetMapping("/applications/{id}")
    public EntityModel<Application> getOne(@PathVariable("id") final String id) {
        return repository.findById(id)
            .map(app -> new EntityModel<>(app, linkTo(methodOn(ApplicationController.class).getOne(app.getId())).withSelfRel(),
                linkTo(methodOn(ApplicationController.class).getApplications()).withRel("applications")))
            .orElseThrow(RuntimeException::new);
    }

    @PostMapping(value = "/applications/{id}/execution", consumes = MediaType.APPLICATION_JSON_VALUE)
    public EntityModel<String> insertExecution(@PathVariable("id") final String id, @RequestBody final Execution execution) {
        long count = repository.AddExecutionsInApplication(id, Arrays.asList(execution));
        if (count > 0) {
            return new EntityModel<>("Update successful", linkTo(methodOn(ApplicationController.class).getApplications()).withRel("applications"));
        }

        return new EntityModel<>("Update Failed!", linkTo(methodOn(ApplicationController.class).getApplications()).withRel("applications"));
    }

    @GetMapping("/applications/execution/{name}")
    public EntityModel<Execution> findExecution(@PathVariable("name") final String name) {
        return repository.findExecution(name)
            .stream()
            .findFirst()
            .map(e -> new EntityModel<>(e, linkTo(methodOn(ApplicationController.class).findExecution(name)).withSelfRel(),
                linkTo(methodOn(ApplicationController.class).getApplications()).withRel("applications")))
            .orElseThrow(RuntimeException::new);
    }

}
