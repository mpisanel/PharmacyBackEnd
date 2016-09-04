package com.pharmacybackg.repository;

import com.pharmacybackg.domain.Patient;
import com.pharmacybackg.factory.PatientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import com.pharmacybackg.App;
import com.pharmacybackg.factory.AddressFactory;
import com.pharmacybackg.factory.ContactFactory;
import com.pharmacybackg.factory.NameFactory;
import com.pharmacybackg.domain.Address_location;
import com.pharmacybackg.domain.Contact;
import org.testng.annotations.Test;

/**
 * Created by SONY on 2016-08-17.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudPatient extends AbstractTestNGSpringContextTests
{
    private Long id;

    //@Autowired
    PatientRepository repository;

    //@Test
    public void testCreate() throws Exception {
        repository.deleteAll();
        Patient patient = PatientFactory.createPatient(NameFactory.createName("Kusanele", "Mbawula", "Fever"),ContactFactory.createContact("0213937854", "0823451234"), AddressFactory.createAddress("21 Street", "7798"));
        repository.save(patient);
        id = patient.getId();
        Assert.assertNotNull(patient.getId());
    }

    //@Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Patient patient = repository.findOne(id);
        Assert.assertEquals(patient.getName().getFirstName(), "Kusanele");
    }
    //@Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Patient patient = repository.findOne(id);
        Patient newPatient = new Patient.Builder(patient.getName()).copy(patient).build();
        repository.save(newPatient);
        Patient updatedPatient = repository.findOne(id);
        Assert.assertEquals(updatedPatient.getName().getFirstName(), "Kusanele");
    }

    //@Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Patient patient = repository.findOne(id);
        repository.delete(patient);
        Patient newPatient = repository.findOne(id);
        Assert.assertNull(newPatient);
    }

}
