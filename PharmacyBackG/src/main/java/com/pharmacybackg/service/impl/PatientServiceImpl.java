package com.pharmacybackg.service.impl;

import com.pharmacybackg.domain.Patient;
import com.pharmacybackg.repository.PatientRepository;
import com.pharmacybackg.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 2016-08-08.
 */
@Service
public class PatientServiceImpl implements PatientService
{
    @Autowired
    private PatientRepository repository;


    @Override
    public Patient findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Patient save(Patient entity) {
        return repository.save(entity);
    }

    @Override
    public Patient update(Patient entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Patient entity) {
        repository.delete(entity);
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> allPatients = new ArrayList<Patient>();

        Iterable<Patient> patients = repository.findAll();
        for (Patient employee : patients) {
            allPatients.add(employee);
        }
        return allPatients;
    }
}
