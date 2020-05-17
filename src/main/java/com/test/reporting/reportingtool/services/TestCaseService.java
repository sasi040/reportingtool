package com.test.reporting.reportingtool.services;

import com.test.reporting.reportingtool.converters.Converter;
import com.test.reporting.reportingtool.dtos.TestCaseDto;
import com.test.reporting.reportingtool.entities.TestCase;
import com.test.reporting.reportingtool.repositories.TestCaseRepository;
import com.test.reporting.reportingtool.repositories.TestSuiteRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestCaseService {


    private TestCaseRepository repository;

    @Autowired
    private TestSuiteRepository testSuiteRepository;

    @Autowired
    private Converter converter;

    public TestCaseService(TestCaseRepository repository) {
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

    public TestCaseDto getTestCase(final Long id) {
        TestCaseDto dto = this.repository.findById(id)
            .map(this.converter::convert)
            .orElse(null);
        Optional.ofNullable(dto)
            .map(TestCaseDto::getSteps)
            .ifPresent(steps -> {
                steps.forEach(e -> e.setTestCaseId(id));
            });

        return dto;
    }

}
