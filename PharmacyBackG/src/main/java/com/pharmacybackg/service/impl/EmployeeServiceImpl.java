package com.pharmacybackg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pharmacybackg.domain.Employee;
import com.pharmacybackg.repository.EmployeeRepository;
import com.pharmacybackg.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 2016-08-05.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeRepository repository;


    @Override
    public Employee findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Employee save(Employee entity) {
        return repository.save(entity);
    }

    @Override
    public Employee update(Employee entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Employee entity) {
        repository.delete(entity);
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> allEmployees = new ArrayList<Employee>();

        Iterable<Employee> employees = repository.findAll();
        for (Employee employee : employees) {
            allEmployees.add(employee);
        }
        return allEmployees;
    }
}
