package com.pharmacybackg.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by SONY on 2016-08-18.
 */
@RestController
@RequestMapping("/")
public class HomePage {
    @RequestMapping(method = RequestMethod.GET)
    public String getHomepage(){

        return "Welcome to the Pharmacy!";
    }

}
