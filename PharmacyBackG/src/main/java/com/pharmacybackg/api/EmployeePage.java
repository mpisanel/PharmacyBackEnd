package com.pharmacybackg.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import com.pharmacybackg.domain.Employee;
import com.pharmacybackg.model.EmployeeResource;
import com.pharmacybackg.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 2016-08-20.
 */
@RestController
@RequestMapping(value="/emp/**")
public class EmployeePage {
    @Autowired
    private EmployeeService service;

    @RequestMapping(value = "/employees/", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> listAllEmployees() {
        List<Employee> employeeList = service.findAll();
        if(employeeList.isEmpty()){
            return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id) {
        System.out.println("Fetching Employee with id " + id);
        Employee employee = service.findById(id);
        if (employee == null) {
            System.out.println("Employee with id " + id + " not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createEmployee(@RequestBody Employee employee,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Employee " + employee.getId());
        service.save(employee);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/employee/{id}").buildAndExpand(employee.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @RequestMapping(value = "/employee/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        System.out.println("Updating employee " + id);

        Employee currentEmployee = service.findById(id);

        if (currentEmployee==null) {
            System.out.println("Employee with id " + id + " not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

        Employee updatedEmployee = new Employee
                .Builder(currentEmployee.getName())
                .copy(currentEmployee)
                .id(employee.getId())
                .withContact(employee.getContact())
                .withAddress(employee.getAddress())
                .build();
        service.update(updatedEmployee);
        return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/delete/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") long id, @RequestBody Employee emp) {
        System.out.println("Fetching & Deleting Employee with id " + id);

        Employee employee1 = service.findById(id);
        if (employee1 == null) {
            System.out.println("Unable to delete. Employee with id " + id + " not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

        service.delete(employee1);
        return new ResponseEntity<Employee>(HttpStatus.OK);
    }
}
