package com.test.reporting.reportingtool.services;

import com.test.reporting.reportingtool.converters.Converter;
import com.test.reporting.reportingtool.dtos.TestSuiteDto;
import com.test.reporting.reportingtool.jparepos.TestSuite;
import com.test.reporting.reportingtool.repositories.ExecutionJpaRepository;
import com.test.reporting.reportingtool.repositories.TestSuiteJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestSuiteService {

    private TestSuiteJpaRepository repository;

    @Autowired
    private ExecutionJpaRepository executionRepository;

    @Autowired
    private Converter converter;

    public TestSuiteService(TestSuiteJpaRepository repository) {
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

}
