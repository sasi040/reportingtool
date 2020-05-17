package com.test.reporting.reportingtool.repositories;


import com.test.reporting.reportingtool.entities.TestStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestStepRepository extends JpaRepository<TestStep, Long> {

}
