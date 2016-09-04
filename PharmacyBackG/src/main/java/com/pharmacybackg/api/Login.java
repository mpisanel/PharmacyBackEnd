package com.pharmacybackg.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pharmacybackg.domain.User;
import com.pharmacybackg.model.UserResource;
import com.pharmacybackg.service.UserService;

/**
 * Created by SONY on 2016-08-18.
 */
@RestController
@RequestMapping(value="/login/**")
public class Login {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/user/{username}/{password}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResource> loginUser(@PathVariable("username") String username, @PathVariable("password") String password)
    {
        User user = userService.findByUsernameAndPassword(username, password);

        if(user == null)
        {
            return new ResponseEntity<UserResource>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<UserResource>(HttpStatus.OK);
    }

    @RequestMapping(value="/user_test/{username}/{password}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User userTest(@PathVariable("username") String username, @PathVariable("password") String password)
    {
        User user = userService.findByUsernameAndPassword(username, password);

        if(user == null)
        {
            return user;
        }

        return user;
    }
}
