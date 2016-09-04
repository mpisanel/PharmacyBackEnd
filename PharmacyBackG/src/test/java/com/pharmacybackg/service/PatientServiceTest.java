package com.pharmacybackg.service;

import com.pharmacybackg.domain.Patient;
import com.pharmacybackg.factory.PatientFactory;
import com.pharmacybackg.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import com.pharmacybackg.App;
import com.pharmacybackg.domain.*;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by SONY on 2016-08-17.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class PatientServiceTest extends AbstractTestNGSpringContextTests {

   // @Autowired
    private PatientService service;

    private Long id;

  //  @Autowired
    private PatientRepository repository;

    //@Test
    public void create() throws Exception {
        repository.deleteAll();

        Patient patient = PatientFactory.createPatient(new Name.Builder("Mpizozo").build(), null, null);
        repository.save(patient);
        id=patient.getId();
        Assert.assertNotNull(patient.getId());
    }

   // @Test(dependsOnMethods = "create")
    public void testGetPatients() throws Exception {
        Patient patient = service.findById(id);
        Assert.assertEquals(patient.getName().getLastName(), "Mpizozo");
    }

    //@Test(dependsOnMethods = "testGetPatients")
    public void testGetPatient() throws Exception {
        List<Patient> patientsList = service.findAll();
        Assert.assertEquals(patientsList.size(), 1);
    }

   // @Test(dependsOnMethods = "testGetPatients")
    public void testEditPatients() throws Exception {
        Patient patient = repository.findOne(id);
        Patient updatedPatient = new Patient.Builder(patient.getName()).copy(patient).build();
        service.update(updatedPatient);
        Patient newPatient = repository.findOne(id);
        Assert.assertEquals(newPatient.getName().getLastName(), "Mpizozo");
    }

    //@Test(dependsOnMethods = "testEditPatients")
    public void testDeletePatient() throws Exception {
        Patient patient = repository.findOne(id);
        service.delete(patient);
        Patient newPatient = repository.findOne(id);
        Assert.assertNull(newPatient);
    }

}
