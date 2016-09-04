package com.pharmacybackg.repository;

import com.pharmacybackg.App;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import com.pharmacybackg.factory.*;
import com.pharmacybackg.domain.*;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 2016-08-17.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudPharmacy extends AbstractTestNGSpringContextTests
{
    private Long id;

    //@Autowired
    PharmacyRepository repository;

    private List<Employee> employees;
    private List<Patient> patients;

    //@BeforeMethod
    public void setUp() throws Exception {
        employees = new ArrayList<Employee>();
        patients = new ArrayList<Patient>();
    }

    //@Test
    public void create() throws Exception
    {
        Address_location address_location = AddressFactory
                .createAddress("Steenb22erg", "45214");
        Contact contact = ContactFactory
                .createContact("23433234", "12323");
        Patient patient = PatientFactory
                .createPatient(new Name.Builder("Rawoot").build(), null, null);

        patients.add(patient);
        Employee employee = EmployeeFactory.createEmployee(new Name.Builder("Rawoot").build(), null, null);
        employees.add(employee);

        Pharmacy pharmacy = PharmacyFactory.createPharmacy(address_location, contact, employees);
        repository.save(pharmacy);

        id = pharmacy.getPharmacyID();
        Assert.assertNotNull(pharmacy.getPharmacyID());
    }

 // @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Pharmacy pharmacy =  repository.findOne(id);
        Assert.assertNotNull(pharmacy.getPharmacyID());
    }
   // @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Address_location address_location = AddressFactory
                .createAddress("Steenberg", "4521");
        Contact contact = ContactFactory
                .createContact("234234", "12323");

        Pharmacy pharmacy = repository.findOne(id);
        Pharmacy newPharmacy = new Pharmacy.Builder().withAddress(address_location).withContact(contact)
                .withEmployee(null).build();
        repository.save(newPharmacy);

        Pharmacy updatedPharmacy = repository.findOne(id);

        Assert.assertNotNull(updatedPharmacy.getPharmacyID());
    }
    //@Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Pharmacy pharmacy = repository.findOne(id);
        repository.delete(pharmacy);
        Pharmacy newPharmacy = repository.findOne(id);
        Assert.assertNull(newPharmacy);
    }
}
