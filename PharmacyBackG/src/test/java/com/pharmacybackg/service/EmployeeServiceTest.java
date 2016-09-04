package com.pharmacybackg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pharmacybackg.App;
import com.pharmacybackg.factory.*;
import com.pharmacybackg.domain.*;
import com.pharmacybackg.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by SONY on 2016-08-18.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class EmployeeServiceTest extends AbstractTestNGSpringContextTests {

    //@Autowired
    private EmployeeService service;

    private Long id;

    //@Autowired
    private EmployeeRepository repository;

    //@Test
    public void create() throws Exception {
        repository.deleteAll();

        Employee employee = EmployeeFactory.createEmployee(new Name.Builder("Rawoot").build(), null, null);
        repository.save(employee);
        id=employee.getId();
        Assert.assertNotNull(employee.getId());
    }

    //@Test(dependsOnMethods = "create")
    public void testGetEmployee() throws Exception {
        Employee employee = service.findById(id);
        Assert.assertEquals(employee.getName().getLastName(), "Rawoot");
    }

    //@Test(dependsOnMethods = "testGetEmployee")
    public void testGetEmployees() throws Exception {
        List<Employee> employeeList = service.findAll();
        Assert.assertEquals(employeeList.size(), 1);
    }

   //@Test(dependsOnMethods = "testGetEmployee")
    public void testEditEmployee() throws Exception {
        Employee employee = repository.findOne(id);
        Employee updatedEmployee = new Employee.Builder(employee.getName()).copy(employee).build();
        service.update(updatedEmployee);
        Employee newEmployee = repository.findOne(id);
        Assert.assertEquals(employee.getName().getLastName(), "Rawoot");
    }

    //@Test(dependsOnMethods = "testEditEmployee")
    public void testDeleteEmployee() throws Exception {
        Employee employee = repository.findOne(id);
        service.delete(employee);
        Employee newEmployee = repository.findOne(id);
        Assert.assertNull(newEmployee);
    }

}
