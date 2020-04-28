package com.test.reporting.reportingtool.ctrl;

import com.test.reporting.reportingtool.dtos.TestCaseDto;
import com.test.reporting.reportingtool.dtos.TestSuiteDto;
import com.test.reporting.reportingtool.exceptions.EntityNotFoundException;
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

    @RequestMapping(method = RequestMethod.PUT)
    public Long updateTestSuite(@RequestBody final TestSuiteDto dto) {
        return Optional.ofNullable(this.testSuiteService.updateTestSuite(dto))
            .orElseThrow(() -> new EntityNotFoundException(dto.getId()));
    }

    @RequestMapping(method = RequestMethod.POST, path = "{id}/testCase")
    public Long createTestCase(@PathVariable("id") final Long id, @RequestBody final TestCaseDto testCase) {
        return this.testCaseService.createTestCase(id, testCase);
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id")
    public EntityModel<TestSuiteDto> findTestSuiteById(@PathVariable("id") final Long id) {
        return Optional.ofNullable(this.testSuiteService.getSuite(id))
            .map(t -> new EntityModel<>(t, linkTo(methodOn(TestSuiteController.class)).withSelfRel()))
            .orElseThrow(() -> new EntityNotFoundException(id));
    }

}
