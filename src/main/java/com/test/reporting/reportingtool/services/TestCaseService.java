package com.test.reporting.reportingtool.services;

import com.test.reporting.reportingtool.converters.Converter;
import com.test.reporting.reportingtool.dtos.TestCaseDto;
import com.test.reporting.reportingtool.jparepos.TestCase;
import com.test.reporting.reportingtool.repositories.TestCaseJpaRepository;
import com.test.reporting.reportingtool.repositories.TestSuiteJpaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestCaseService {


    private TestCaseJpaRepository repository;

    @Autowired
    private TestSuiteJpaRepository testSuiteRepository;

    @Autowired
    private Converter converter;

    public TestCaseService(TestCaseJpaRepository repository) {
        this.repository = repository;
    }

    public Long createTestCase(final Long testSuiteId, final TestCaseDto testCaseDto) {
        TestCase entity = converter.convert(testCaseDto);
        this.testSuiteRepository.findById(testSuiteId)
            .ifPresent(s -> {
                entity.setTestSuite(s);
                this.repository.save(entity);
            });
        return entity.getId();
    }

    public Long updateTestCase(final TestCaseDto testCaseDto) {
        return this.repository.findById(testCaseDto.getId())
            .map(entity -> {
                converter.enrich(testCaseDto, entity);
                return entity;
            })
            .map(this.repository::save)
            .map(TestCase::getId)
            .orElse(null);
    }

    public Optional<TestCase> findById(final Long id) {
        return this.repository.findById(id);
    }

}
