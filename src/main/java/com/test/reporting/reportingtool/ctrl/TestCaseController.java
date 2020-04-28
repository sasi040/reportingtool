package com.test.reporting.reportingtool.ctrl;

import com.test.reporting.reportingtool.dtos.TestCaseDto;
import com.test.reporting.reportingtool.dtos.TestStepDto;
import com.test.reporting.reportingtool.exceptions.EntityNotFoundException;
import com.test.reporting.reportingtool.services.TestCaseService;
import com.test.reporting.reportingtool.services.TestStepService;
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
@RequestMapping(value = "/testCase")
public class TestCaseController {


    @Autowired
    private TestStepService testStepService;

    @Autowired
    private TestCaseService testCaseService;

    @RequestMapping(method = RequestMethod.PUT)
    public Long updateTestSuite(@RequestBody final TestCaseDto dto) {
        return Optional.ofNullable(this.testCaseService.updateTestCase(dto))
            .orElseThrow(() -> new EntityNotFoundException(dto.getId()));
    }

    @RequestMapping(method = RequestMethod.POST, path = "{id}/testStep")
    public Long createTestStep(@PathVariable("id") final Long id, @RequestBody final TestStepDto testStep) {
        return this.testStepService.createTestStep(id, testStep);
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id")
    public EntityModel<TestCaseDto> findTestCaseById(@PathVariable("id") final Long id) {
        return Optional.ofNullable(this.testCaseService.getTestCase(id))
            .map(t -> new EntityModel<>(t, linkTo(methodOn(TestSuiteController.class)).withSelfRel()))
            .orElseThrow(() -> new EntityNotFoundException(id));
    }

}
