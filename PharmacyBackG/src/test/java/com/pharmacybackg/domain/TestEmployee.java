package com.pharmacybackg.domain;


import com.pharmacybackg.factory.EmployeeFactory;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by SONY on 2016-08-18.
 */
public class TestEmployee /*extends TestCase*/
{

   //@Test
    public void testCreate() {
        Employee employee = EmployeeFactory.createEmployee(new Name.Builder("Luxolo").build(), null, null);
        Assert.assertEquals(employee.getName().getLastName(), "Luxolo");
    }

   // @Test
    public void testUpdate() {
        Employee employee = EmployeeFactory.createEmployee(new Name.Builder("Mpisane").build(),  null, null);
        Employee employeecopy = new Employee.Builder(employee.getName()).copy(employee).build();
        Assert.assertEquals(employeecopy.getName().getLastName(), "Mpisane");
    }
}
