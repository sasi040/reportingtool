package com.test.reporting.reportingtool.services;

import com.test.reporting.reportingtool.converters.ConverterImpl;
import com.test.reporting.reportingtool.dtos.ExecutionDto;
import com.test.reporting.reportingtool.entities.Execution;
import com.test.reporting.reportingtool.repositories.ApplicationRepository;
import com.test.reporting.reportingtool.repositories.ExecutionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExecutionService {

    private ExecutionRepository repository;

    @Autowired
    private ApplicationRepository appRepository;

    @Autowired
    private ConverterImpl converter;

    public ExecutionService(ExecutionRepository repository) {
        this.repository = repository;
    }

    public Long createExecution(final Long applicationId, final ExecutionDto execution) {
        Execution entity = converter.convert(execution);
        this.appRepository.findById(applicationId)
            .ifPresent(s -> {
                entity.setApplication(s);
                this.repository.save(entity);
            });
        return entity.getId();
    }

    public Long updateExecution(final ExecutionDto execution) {
        return this.repository.findById(execution.getId())
            .map(entity -> {
                converter.enrich(execution, entity);
                return entity;
            })
            .map(this.repository::save)
            .map(Execution::getId)
            .orElse(null);
    }

    public ExecutionDto getExecution(final Long id) {
        ExecutionDto dto = this.repository.findById(id)
            .map(this.converter::convert)
            .orElse(null);
        Optional.ofNullable(dto)
            .map(ExecutionDto::getSuites)
            .ifPresent(suites -> {
                suites.forEach(e -> e.setExeuctionId(id));
            });

        return dto;
    }

}
