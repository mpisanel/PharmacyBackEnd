package com.pharmacybackg.service;
import com.pharmacybackg.App;
import com.pharmacybackg.domain.Address_location;
import com.pharmacybackg.domain.Contact;
import com.pharmacybackg.domain.Pharmacy;
import com.pharmacybackg.factory.AddressFactory;
import com.pharmacybackg.factory.ContactFactory;
import com.pharmacybackg.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by SONY on 2016-08-17.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class PharmacyServiceTest extends AbstractTestNGSpringContextTests {
    //@Autowired
    private PharmacyService service;

    private Long id;

    //@Autowired
    private PharmacyRepository repository;
    private List<Pharmacy> pharmacies;


    //@BeforeMethod
    public void setUp() throws Exception{
        pharmacies = new ArrayList<>();
    }

   //@Test
    public void create() throws Exception
    {
        Contact contact = ContactFactory
                .createContact("3dept@test.com", "7550");
        Address_location address_location = AddressFactory
                .createAddress("3 Hens rd", "7945");
        Pharmacy pharmacy = com.pharmacybackg.factory.PharmacyFactory
                .createPharmacy(address_location,contact, Collections.EMPTY_LIST);
        pharmacies.add(pharmacy);
        repository.save(pharmacies);
        id = pharmacy.getPharmacyID();
        Assert.assertNotNull(pharmacy.getPharmacyID());
    }
}
