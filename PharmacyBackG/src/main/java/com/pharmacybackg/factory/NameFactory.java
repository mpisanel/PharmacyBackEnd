package com.pharmacybackg.factory;


import com.pharmacybackg.domain.Name;

/**
 * Created by SONY on 2016-08-05.
 */
public class NameFactory {

    public static Name createName(String firstName, String lastName, String jobTitle) {
        return new Name.Builder(lastName).firstName(firstName).jobTitle(jobTitle).build();
    }

}
