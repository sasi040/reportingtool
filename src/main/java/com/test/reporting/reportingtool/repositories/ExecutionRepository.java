package com.test.reporting.reportingtool.repositories;


import com.test.reporting.reportingtool.entities.Execution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExecutionRepository extends JpaRepository<Execution, java.lang.Long> {

}
