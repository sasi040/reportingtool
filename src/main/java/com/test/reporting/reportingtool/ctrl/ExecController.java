package com.test.reporting.reportingtool.ctrl;

import com.test.reporting.reportingtool.exceptions.EntityNotFoundException;
import com.test.reporting.reportingtool.jparepos.Execution;
import com.test.reporting.reportingtool.jparepos.TestSuite;
import com.test.reporting.reportingtool.services.ExecutionService;
import com.test.reporting.reportingtool.services.TestSuiteService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/exec")
public class ExecController {


    @Autowired
    private ExecutionService executionService;

    @Autowired
    private TestSuiteService testSuiteService;


    @RequestMapping(method = RequestMethod.PUT)
    public java.lang.Long updateExecution(@RequestBody final Execution execution) {
        return Optional.ofNullable(this.executionService.updateExecution(execution))
            .map(Execution::getId)
            .orElseThrow(() -> new EntityNotFoundException(execution.getId()));
    }

   /* @RequestMapping(method = RequestMethod.POST,path = "{id}/suite")
    public java.lang.Long createTestSuite(@PathVariable("id") final java.lang.Long id, @RequestBody final TestSuite suite) {
        final Execution execution = this.executionService.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        suite.setExecution(execution);
        return this.testSuiteService.createSuite(suite);
    }*/

}
