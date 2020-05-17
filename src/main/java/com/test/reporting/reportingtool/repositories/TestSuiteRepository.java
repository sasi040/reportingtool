package com.test.reporting.reportingtool.repositories;


import com.test.reporting.reportingtool.entities.TestSuite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestSuiteRepository extends JpaRepository<TestSuite, Long> {

}
