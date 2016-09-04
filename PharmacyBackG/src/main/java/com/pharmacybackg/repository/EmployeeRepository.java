package com.pharmacybackg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pharmacybackg.domain.Employee;

/**
 * Created by SONY on 2016-08-05.
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>
{

}
