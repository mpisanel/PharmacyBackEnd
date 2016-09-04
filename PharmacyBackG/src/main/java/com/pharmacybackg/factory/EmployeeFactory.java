package com.pharmacybackg.factory;


import com.pharmacybackg.domain.*;

import java.util.List;

/**
 * Created by SONY on 2016-08-05.
 */
public class EmployeeFactory
{
    public static Employee createEmployee
            (Name name,  Contact contact, Address_location address )
    {
        return new Employee.Builder(name).withContact(contact).withAddress(address).build();
    }
}
