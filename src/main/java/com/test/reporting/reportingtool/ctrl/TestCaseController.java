package com.test.reporting.reportingtool.ctrl;

import com.test.reporting.reportingtool.exceptions.EntityNotFoundException;
import com.test.reporting.reportingtool.jparepos.TestCase;
import com.test.reporting.reportingtool.jparepos.TestStep;
import com.test.reporting.reportingtool.jparepos.TestSuite;
import com.test.reporting.reportingtool.services.TestCaseService;
import com.test.reporting.reportingtool.services.TestStepService;
import com.test.reporting.reportingtool.services.TestSuiteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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

    /*@RequestMapping(method = RequestMethod.PUT)
    public Long updateTestCase(@RequestBody final TestCase testCase) {
        return Optional.ofNullable(this.testCaseService.updateTestCase(testCase))
            .map(TestCase::getId)
            .orElseThrow(() -> new EntityNotFoundException(testCase.getId()));
    }

    @RequestMapping(method = RequestMethod.POST,path = "{id}/testStep")
    public Long createTestStep(@PathVariable("id") final Long id, @RequestBody final TestStep testStep) {
        final TestCase testCase = this.testCaseService.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        testStep.setTestCase(testCase);
        return this.testStepService.createTestStep(testStep);
    }

    @RequestMapping(method = RequestMethod.GET,path = "{id")
    public EntityModel<TestCase> findTestCaseById(@PathVariable("id") final Long id) {
        return this.testCaseService.findById(id)
            .map(t -> new EntityModel<>(t,linkTo(methodOn(TestCaseController.class).findTestCaseById(t.getId())).withSelfRel()))
            .orElseThrow(() -> new EntityNotFoundException(id));
    }*/

}
