package com.test.reporting.reportingtool.ctrl;

import com.test.reporting.reportingtool.dtos.ApplicationDto;
import com.test.reporting.reportingtool.dtos.ExecutionDto;
import com.test.reporting.reportingtool.exceptions.EntityNotFoundException;
import com.test.reporting.reportingtool.services.AppService;
import com.test.reporting.reportingtool.services.ExecutionService;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/app")
public class AppController {

    @Autowired
    private AppService appService;

    @Autowired
    private ExecutionService executionService;


    @RequestMapping(method = RequestMethod.POST)
    public Long createApplication(@RequestBody final ApplicationDto application) {
        return this.appService.createApplication(application);
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public EntityModel<ApplicationDto> findApplicationById(@PathVariable("id") final Long id) {
        return Optional.ofNullable(this.appService.getApplication(id))
            .map(app -> new EntityModel<>(app, linkTo(methodOn(AppController.class).findApplicationById(id)).withSelfRel(),
                linkTo(methodOn(AppController.class).applications()).withRel("apps")))
            .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<EntityModel<ApplicationDto>> applications() {
        Collection<EntityModel<ApplicationDto>> applications = this.appService.findAll()
            .stream()
            .map(app -> new EntityModel<>(app,
                linkTo(methodOn(AppController.class).findApplicationById(app.getId())).withSelfRel(),
                linkTo(methodOn(AppController.class).applications()).withRel("applications")
            ))
            .collect(Collectors.toList());

        return applications;
    }

    @RequestMapping(method = RequestMethod.POST, path = "{id}/execution")
    public Long createExecution(@PathVariable("id") final Long applicationId, @RequestBody final ExecutionDto execution) {
        return this.executionService.createExecution(applicationId, execution);
    }

}
