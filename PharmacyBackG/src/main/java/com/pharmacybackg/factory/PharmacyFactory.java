package com.pharmacybackg.factory;

import com.pharmacybackg.domain.Address_location;
import com.pharmacybackg.domain.Contact;
import com.pharmacybackg.domain.Employee;
import com.pharmacybackg.domain.Pharmacy;

import java.util.List;

/**
 * Created by SONY on 2016-08-05.
 */
public class PharmacyFactory
{
    public static Pharmacy createPharmacy(Address_location address, Contact contact, List<Employee> employees)
    {
        Pharmacy pharmacy = new Pharmacy
                .Builder()
                .withAddress(address)
                .withContact(contact)
                .withEmployee(employees)
                .build();
        return pharmacy;
    }
}
