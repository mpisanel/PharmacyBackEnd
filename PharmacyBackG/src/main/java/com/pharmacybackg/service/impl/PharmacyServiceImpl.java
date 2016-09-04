package com.pharmacybackg.service.impl;

import com.pharmacybackg.domain.Employee;
import com.pharmacybackg.domain.Pharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pharmacybackg.repository.PharmacyRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 2016-08-08..
 */
@Service
public class PharmacyServiceImpl implements com.pharmacybackg.service.PharmacyService
{
    @Autowired
    private PharmacyRepository repository;

    public List<Pharmacy> getPharmacies()
    {
        List<Pharmacy> allPharmacies = new ArrayList<Pharmacy>();
        Iterable<Pharmacy> laundries = repository.findAll();

        for(Pharmacy laundry: laundries)
        {
            allPharmacies.add(laundry);
        }
        return allPharmacies;
    }

    @Override
    public List<Employee> getEmployees(Long id) {
        return repository.findOne(id).getEmployees();
    }
}
