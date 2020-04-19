package com.test.reporting.reportingtool.repositories;


import com.test.reporting.reportingtool.jparepos.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseJpaRepository extends JpaRepository<TestCase, Long> {

}
