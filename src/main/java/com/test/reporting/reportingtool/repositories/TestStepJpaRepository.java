package com.test.reporting.reportingtool.repositories;


import com.test.reporting.reportingtool.jparepos.TestStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestStepJpaRepository extends JpaRepository<TestStep, Long> {

}
