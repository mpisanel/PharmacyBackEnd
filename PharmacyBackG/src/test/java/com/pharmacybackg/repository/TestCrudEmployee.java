package com.pharmacybackg.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pharmacybackg.App;
import com.pharmacybackg.factory.AddressFactory;
import com.pharmacybackg.factory.ContactFactory;
import com.pharmacybackg.factory.EmployeeFactory;
import com.pharmacybackg.factory.NameFactory;
import com.pharmacybackg.domain.Address_location;
import com.pharmacybackg.domain.Contact;
import com.pharmacybackg.domain.Employee;

/**
 * Created by SONY on 2016-08-18.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudEmployee extends AbstractTestNGSpringContextTests
{
    private Long id;

    //@Autowired
    EmployeeRepository repository;

   //@Test
    public void testCreate() throws Exception {
        repository.deleteAll();
        Employee employee = EmployeeFactory.createEmployee(NameFactory.createName("Luxolo", "Mpisane", "Tester"),ContactFactory.createContact("0213937854", "0823451234"), AddressFactory.createAddress("21 Street", "7798"));
        repository.save(employee);
        id = employee.getId();
        Assert.assertNotNull(employee.getId());
    }

    //@Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Employee employee = repository.findOne(id);
        Assert.assertEquals(employee.getName().getFirstName(), "Luxolo");
    }
    //@Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Employee employee = repository.findOne(id);
        Employee newEmployee = new Employee.Builder(employee.getName()).copy(employee).build();
        repository.save(newEmployee);
        Employee updatedEmployee = repository.findOne(id);
        Assert.assertEquals(updatedEmployee.getName().getFirstName(), "Luxolo");
    }

    //@Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Employee employee = repository.findOne(id);
        repository.delete(employee);
        Employee newEmployee = repository.findOne(id);
        Assert.assertNull(newEmployee);
    }

}
