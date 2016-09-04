package com.pharmacybackg.domain;


import com.pharmacybackg.factory.PatientFactory;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by SONY on 2016-08-17.
 */
public class TestPatient
{

    //@Test
    public void testCreate() {
        Patient patient = PatientFactory.createPatient(new Name.Builder("Putuza").build(), null, null);
        Assert.assertEquals(patient.getName().getLastName(), "Putuza");
    }

   // @Test
    public void testUpdate() {
        Patient patient = PatientFactory.createPatient(new Name.Builder("Huluza").build(),  null, null);
        Patient patientcopy = new Patient.Builder(patient.getName()).copy(patient).build();
        Assert.assertEquals(patientcopy.getName().getLastName(), "Huluza");
    }
}
