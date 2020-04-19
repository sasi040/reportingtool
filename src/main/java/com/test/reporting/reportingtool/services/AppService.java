package com.test.reporting.reportingtool.services;

import com.test.reporting.reportingtool.converters.Converter;
import com.test.reporting.reportingtool.dtos.ApplicationDto;
import com.test.reporting.reportingtool.jparepos.Application;
import com.test.reporting.reportingtool.repositories.AppJpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    private AppJpaRepository repository;

    private Converter converter;

    public AppService(final AppJpaRepository repository, final Converter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public Long createApplication(final ApplicationDto applicationDto) {
        final Application result = this.repository.save(this.converter.convert(applicationDto));
        return result.getId();
    }

    public ApplicationDto getApplication(final Long id) {
        ApplicationDto dto = this.repository.findById(id)
            .map(this.converter::convert)
            .orElse(null);
        Optional.ofNullable(dto)
            .map(ApplicationDto::getExecutions)
            .ifPresent(execs -> {
                execs.forEach(e -> e.setApplicationId(id));
            });

        return dto;
    }


    public List<ApplicationDto> findAll() {
        return this.repository.findAll().stream()
            .map(this.converter::convert)
            .collect(Collectors.toList());
    }

}
