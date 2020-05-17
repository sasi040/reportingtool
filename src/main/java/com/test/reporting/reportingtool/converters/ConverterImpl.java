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
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;

@Component
public class ConverterImpl implements Converter {

    private MapperFacade mapper;

    public ConverterImpl() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapper = mapperFactory.getMapperFacade();
    }

    @Override
    public ApplicationDto convert(final Application entity) {
        return this.mapper.map(entity, ApplicationDto.class);
    }

    @Override
    public Application convert(final ApplicationDto dto) {
        return this.mapper.map(dto, Application.class);
    }

    @Override
    public ExecutionDto convert(final Execution entity) {
        return this.mapper.map(entity, ExecutionDto.class);
    }

    @Override
    public Execution convert(final ExecutionDto dto) {
        return this.mapper.map(dto, Execution.class);
    }

    @Override
    public TestSuiteDto convert(final TestSuite entity) {
        return this.mapper.map(entity, TestSuiteDto.class);
    }

    @Override
    public TestSuite convert(final TestSuiteDto dto) {
        return this.mapper.map(dto, TestSuite.class);
    }

    @Override
    public TestCaseDto convert(final TestCase entity) {
        return this.mapper.map(entity, TestCaseDto.class);
    }

    @Override
    public TestCase convert(final TestCaseDto dto) {
        return this.mapper.map(dto, TestCase.class);
    }

    @Override
    public TestStepDto convert(final TestStep entity) {
        return this.mapper.map(entity, TestStepDto.class);
    }

    @Override
    public TestStep convert(final TestStepDto dto) {
        return this.mapper.map(dto, TestStep.class);
    }

    public void enrich(final ApplicationDto source, final Application destination) {
        this.mapper.map(source, destination);
    }

    public void enrich(final ExecutionDto dto, final Execution entity) {
        entity.setStatus(dto.getStatus());
        entity.setEndTime(dto.getEndTime());
    }

    public void enrich(final TestSuiteDto dto, final TestSuite entity) {
        entity.setStatus(dto.getStatus());
        entity.setEndTime(dto.getEndTime());
    }

    public void enrich(final TestCaseDto dto ,final TestCase entity) {
        entity.setStatus(dto.getStatus());
        entity.setEndTime(dto.getEndTime());
    }

}
