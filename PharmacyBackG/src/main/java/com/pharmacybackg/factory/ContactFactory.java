package com.pharmacybackg.factory;

import com.pharmacybackg.domain.Contact;

/**
 * Created by SONY on 2016-08-05.
 */
public class ContactFactory
{
    public static Contact createContact(String cellNumber, String homeNumber)
    {
        Contact contact = new Contact
                .Builder()
                .withCellNumber(cellNumber)
                .withHomeNumber(homeNumber)
                .build();
        return contact;
    }
}
