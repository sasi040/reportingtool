package com.test.reporting.reportingtool.ctrl;

import com.test.reporting.reportingtool.dtos.ExecutionDto;
import com.test.reporting.reportingtool.dtos.TestSuiteDto;
import com.test.reporting.reportingtool.exceptions.EntityNotFoundException;
import com.test.reporting.reportingtool.services.ExecutionService;
import com.test.reporting.reportingtool.services.TestSuiteService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/exec")
public class ExecController {


    @Autowired
    private ExecutionService executionService;

    @Autowired
    private TestSuiteService testSuiteService;


    @RequestMapping(method = RequestMethod.PUT)
    public Long updateExecution(@RequestBody final ExecutionDto execution) {
        return Optional.ofNullable(this.executionService.updateExecution(execution))
            .orElseThrow(() -> new EntityNotFoundException(execution.getId()));
    }

    @RequestMapping(method=RequestMethod.GET,path = "{id}")
    public EntityModel<ExecutionDto> findByExecutionId(@PathVariable("id") final Long id) {
        return Optional.ofNullable(this.executionService.getExecution(id))
            .map(exec -> new EntityModel<>(exec,
                linkTo(methodOn(ExecController.class)).withSelfRel(),
                linkTo(methodOn(AppController.class).applications()).withRel("apps")))
            .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @RequestMapping(method = RequestMethod.POST,path = "{id}/suite")
    public java.lang.Long createTestSuite(@PathVariable("id") final Long executionId, @RequestBody final TestSuiteDto dto) {
        return this.testSuiteService.createTestSuite(executionId,dto);
    }

}
