package com.pharmacybackg.domain;


import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
/**
 * Created by SONY on 2016-08-17.
 */
public class TestPharmacy
{
   // @Test
    public void TestPharmacy() throws Exception
    {
        Address_location address = new Address_location();
        Contact contact = new Contact();

        Pharmacy pharmacy = com.pharmacybackg.factory.PharmacyFactory
                .createPharmacy(address,contact, Collections.EMPTY_LIST);

        Assert.assertEquals(Collections.EMPTY_LIST,pharmacy.getEmployees());
    }

    public void UpdateTest() throws Exception
    {
        Address_location address = new Address_location();
        Contact contact = new Contact();

        Pharmacy pharmacy = com.pharmacybackg.factory.PharmacyFactory
                .createPharmacy(address,contact, Collections.EMPTY_LIST);

        Pharmacy newPharmacy = com.pharmacybackg.factory.PharmacyFactory
                .createPharmacy(address,contact, Collections.EMPTY_LIST);

        Assert.assertNull(Collections.EMPTY_LIST);
        Assert.assertNull(pharmacy.getEmployees());
        Assert.assertNull(Collections.EMPTY_LIST);
        Assert.assertNotNull(newPharmacy.getAddress());
    }
}
