package com.pharmacybackg.factory;


import com.pharmacybackg.domain.Address_location;
import com.pharmacybackg.domain.Contact;
import com.pharmacybackg.domain.Name;
import com.pharmacybackg.domain.Patient;

import java.util.List;

/**
 * Created by SONY on 2016-08-05.
 */
public class PatientFactory
{
    public static Patient createPatient
            (Name name, Contact contact, Address_location address )
    {
        return new Patient.Builder(name).withContact(contact).withAddress(address).build();
    }
}
