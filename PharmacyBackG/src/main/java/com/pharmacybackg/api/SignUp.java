package com.pharmacybackg.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.pharmacybackg.domain.User;
import com.pharmacybackg.service.UserService;

/**
 * Created by SONY on 2016-08-18.
 */
@RestController
@RequestMapping(value="/signup/**")
public class SignUp {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<Void> subscribeUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating user " + user.getUsername());

        if (userService.exists(user.getUsername())) {
            System.out.println("A User with username " + user.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        userService.save(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{username}").buildAndExpand(user.getUsername()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}
