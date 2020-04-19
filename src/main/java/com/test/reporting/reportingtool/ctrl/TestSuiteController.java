package com.test.reporting.reportingtool.ctrl;

import com.test.reporting.reportingtool.exceptions.EntityNotFoundException;
import com.test.reporting.reportingtool.jparepos.Execution;
import com.test.reporting.reportingtool.jparepos.TestCase;
import com.test.reporting.reportingtool.jparepos.TestSuite;
import com.test.reporting.reportingtool.services.TestCaseService;
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
@RequestMapping(value = "/suite")
public class TestSuiteController {


    @Autowired
    private TestCaseService testCaseService;

    @Autowired
    private TestSuiteService testSuiteService;

    /*@RequestMapping(method = RequestMethod.PUT)
    public Execution updateTestSuite(@RequestBody final TestSuite suite) {
        return Optional.ofNullable(this.testSuiteService.updateSuite(suite))
            .map(TestSuite::getId)
            .orElseThrow(() -> new EntityNotFoundException(suite.getId()));
    }

    @RequestMapping(method = RequestMethod.POST,path = "{id}/testCase")
    public Execution createTestCase(@PathVariable("id") final Execution id, @RequestBody final TestCase testCase) {
        final TestSuite suite = this.testSuiteService.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        testCase.setTestSuite(suite);
        return this.testCaseService.createTestCase(testCase);
    }

    @RequestMapping(method = RequestMethod.GET,path = "{id")
    public EntityModel<TestSuite> findTestSuiteById(@PathVariable("id") final Execution id) {
        return this.testSuiteService.findById(id)
            .map(t -> new EntityModel<>(t,linkTo(methodOn(TestCaseController.class).findTestCaseById(t.getId())).withSelfRel()))
            .orElseThrow(() -> new EntityNotFoundException(id));
    }*/

}
