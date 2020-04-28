package com.test.reporting.reportingtool.services;

import com.test.reporting.reportingtool.converters.Converter;
import com.test.reporting.reportingtool.dtos.TestStepDto;
import com.test.reporting.reportingtool.jparepos.TestStep;
import com.test.reporting.reportingtool.repositories.TestCaseJpaRepository;
import com.test.reporting.reportingtool.repositories.TestStepJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestStepService {

    private TestStepJpaRepository repository;

    @Autowired
    private Converter converter;

    @Autowired
    private TestCaseJpaRepository testCaseRepository;

    public TestStepService(TestStepJpaRepository repository) {
        this.repository = repository;
    }

    public Long createTestStep(final Long testCaseId, final TestStepDto testStepDto) {
        TestStep entity = converter.convert(testStepDto);
        this.testCaseRepository.findById(testCaseId)
            .ifPresent(s -> {
                entity.setTestCase(s);
                this.repository.save(entity);
            });
        return entity.getId();
    }

    /*public Long updateTestCase(final TestCaseDto testCaseDto) {
        return this.repository.findById(testCaseDto.getId())
            .map(entity -> {
                converter.enrich(testCaseDto, entity);
                return entity;
            })
            .map(this.repository::save)
            .map(TestCase::getId)
            .orElse(null);
    }*/

    public TestStepDto getStep(final Long id) {
        TestStepDto dto = this.repository.findById(id)
            .map(this.converter::convert)
            .orElse(null);
        return dto;
    }

}
