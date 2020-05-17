package com.test.reporting.reportingtool.converters;

import com.test.reporting.reportingtool.dtos.ApplicationDto;
import com.test.reporting.reportingtool.dtos.ExecutionDto;
import com.test.reporting.reportingtool.dtos.TestCaseDto;
import com.test.reporting.reportingtool.dtos.TestStepDto;
import com.test.reporting.reportingtool.dtos.TestSuiteDto;
import com.test.reporting.reportingtool.entities.Application;
import com.test.reporting.reportingtool.entities.Execution;
import com.test.reporting.reportingtool.entities.TestCase;
import com.test.reporting.reportingtool.entities.TestStep;
import com.test.reporting.reportingtool.entities.TestSuite;

public interface Converter {
    ApplicationDto convert(Application entity);
    Application convert(ApplicationDto dto);
    ExecutionDto convert(Execution entity);
    Execution convert(ExecutionDto dto);
    TestSuiteDto convert(TestSuite entity);
    TestSuite convert(TestSuiteDto dto);
    TestCaseDto convert(TestCase entity);
    TestCase convert(TestCaseDto dto);
    TestStepDto convert(TestStep entity);
    TestStep convert(TestStepDto dto);

    // enrichers

    public void enrich(final ApplicationDto source, final Application destination);

    public void enrich(final ExecutionDto dto, final Execution entity) ;

    public void enrich(final TestSuiteDto dto, final TestSuite entity);

    public void enrich(final TestCaseDto dto ,final TestCase entity);

}
