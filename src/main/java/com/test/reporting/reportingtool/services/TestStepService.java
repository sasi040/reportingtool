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

    public Long createTestCase(final Long testCaseId, final TestStepDto testStepDto) {
        TestStep entity = converter.convert(testStepDto);
        this.testCaseRepository.findById(testCaseId)
            .ifPresent(s -> {
                entity.setTestCase(s);
                this.repository.save(entity);
            });
        return entity.getId();
    }

}
