package com.test.reporting.reportingtool.repositories;


import com.test.reporting.reportingtool.entities.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {

}
