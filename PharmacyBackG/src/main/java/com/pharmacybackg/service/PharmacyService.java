package com.pharmacybackg.service;

import com.pharmacybackg.domain.Employee;
import com.pharmacybackg.domain.Pharmacy;

import java.util.List;

/**
 * Created by SONY on 2016-08-08.
 */
public interface PharmacyService
{
    List<Pharmacy> getPharmacies();
    List<Employee> getEmployees(Long id);
}
