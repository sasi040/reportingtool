package com.test.reporting.reportingtool.repositories;


import com.test.reporting.reportingtool.jparepos.TestSuite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestSuiteJpaRepository extends JpaRepository<TestSuite, Long> {

}
