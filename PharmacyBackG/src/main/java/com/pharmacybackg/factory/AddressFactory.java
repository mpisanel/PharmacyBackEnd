package com.pharmacybackg.factory;

import com.pharmacybackg.domain.Address_location;

/**
 * Created by SONY on 2016-08-02.
 */
public class AddressFactory
{
    public static Address_location createAddress(String postalAddress, String postalCode)
    {
        Address_location address = new Address_location
                .Builder()
                .withPostalAddr(postalAddress)
                .withPostalCode(postalCode)
                .build();
        return address;
    }
}
