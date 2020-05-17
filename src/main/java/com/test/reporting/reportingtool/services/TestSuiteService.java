package com.test.reporting.reportingtool.services;

import com.test.reporting.reportingtool.converters.Converter;
import com.test.reporting.reportingtool.dtos.TestSuiteDto;
import com.test.reporting.reportingtool.entities.TestSuite;
import com.test.reporting.reportingtool.repositories.ExecutionRepository;
import com.test.reporting.reportingtool.repositories.TestSuiteRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestSuiteService {

    private TestSuiteRepository repository;

    @Autowired
    private ExecutionRepository executionRepository;

    @Autowired
    private Converter converter;

    public TestSuiteService(TestSuiteRepository repository) {
        this.repository = repository;
    }

    public Long createTestSuite(final Long executionId, final TestSuiteDto testSuiteDto) {
        TestSuite entity = converter.convert(testSuiteDto);
        this.executionRepository.findById(executionId)
            .ifPresent(s -> {
                entity.setExecution(s);
                this.repository.save(entity);
            });
        return entity.getId();
    }

    public Long updateTestSuite(final TestSuiteDto testSuiteDto) {
        return this.repository.findById(testSuiteDto.getId())
            .map(entity -> {
                converter.enrich(testSuiteDto, entity);
                return entity;
            })
            .map(this.repository::save)
            .map(TestSuite::getId)
            .orElse(null);
    }

    public TestSuiteDto getSuite(final Long id) {
        TestSuiteDto dto = this.repository.findById(id)
            .map(this.converter::convert)
            .orElse(null);
        Optional.ofNullable(dto)
            .map(TestSuiteDto::getCases)
            .ifPresent(suites -> {
                suites.forEach(e -> e.setTestSuiteId(id));
            });

        return dto;
    }

}
