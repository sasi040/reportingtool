package com.test.reporting.reportingtool.services;

import com.test.reporting.reportingtool.converters.ConverterImpl;
import com.test.reporting.reportingtool.dtos.ExecutionDto;
import com.test.reporting.reportingtool.jparepos.Execution;
import com.test.reporting.reportingtool.repositories.AppJpaRepository;
import com.test.reporting.reportingtool.repositories.ExecutionJpaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExecutionService {

    private ExecutionJpaRepository repository;

    @Autowired
    private AppJpaRepository appRepository;

    @Autowired
    private ConverterImpl converter;

    public ExecutionService(ExecutionJpaRepository repository) {
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

    public Optional<Execution> findById(final java.lang.Long id) {
        return this.repository.findById(id);
    }

}
