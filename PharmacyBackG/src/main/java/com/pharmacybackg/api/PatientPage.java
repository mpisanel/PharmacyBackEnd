package com.pharmacybackg.api;

import com.pharmacybackg.domain.Patient;
import com.pharmacybackg.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 2016-08-18.
 */
//request from android activity using pat
@RestController
@RequestMapping(value="/pat/**")
public class PatientPage {
    @Autowired
    private PatientService service;

    @RequestMapping(value = "/patients/", method = RequestMethod.GET)
    public ResponseEntity<List<Patient>> listAllPatients() {
        List<Patient> patientsList = service.findAll();
        if(patientsList.isEmpty()){
            return new ResponseEntity<List<Patient>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Patient>>(patientsList, HttpStatus.OK);
    }

    @RequestMapping(value = "/patient/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Patient> getPatient(@PathVariable("id") long id) {
        System.out.println("Fetching Patient with id " + id);
        Patient patient = service.findById(id);
        if (patient == null) {
            System.out.println("Patient with id " + id + " not found");
            return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Patient>(patient, HttpStatus.OK);
    }

    @RequestMapping(value = "/patient/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createPatient(@RequestBody Patient patient, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Patient " + patient.getId());

        service.save(patient);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/patient/{id}").buildAndExpand(patient.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/patient/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") long id, @RequestBody Patient patient) {
        System.out.println("Updating Patient " + id);

        Patient currentPatient = service.findById(id);

        if (currentPatient==null) {
            System.out.println("Patient with id " + id + " not found");
            return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
        }

        Patient updatedPatient = new Patient
                .Builder(currentPatient.getName())
                .copy(currentPatient)
                .id(patient.getId())
                .withContact(patient.getContact())
                .withAddress(patient.getAddress())
                .build();
        service.update(updatedPatient);
        return new ResponseEntity<Patient>(updatedPatient, HttpStatus.OK);
    }

    @RequestMapping(value = "/patient/delete/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Patient> deletePatient(@PathVariable("id") long id, @RequestBody Patient pat) {
        System.out.println("Fetching & Deleting Patient with id " + id);

        Patient patient = service.findById(id);
        if (patient == null) {
            System.out.println("Unable to delete. Patient with id " + id + " not found");
            return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
        }

        service.delete(patient);
        return new ResponseEntity<Patient>(HttpStatus.OK);
    }
}
