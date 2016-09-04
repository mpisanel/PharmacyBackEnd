package com.pharmacybackg.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pharmacybackg.domain.User;
import com.pharmacybackg.model.UserResource;
import com.pharmacybackg.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 2016-08-18.
 */
@RestController
@RequestMapping(value="/users/**")
public class UserPage {
    @Autowired
    private UserService service;

    @RequestMapping(value = "/all_users", method = RequestMethod.GET)
    public List<UserResource> getUsers() {
        List<UserResource> hateos = new ArrayList<UserResource>();
        List<User> users = service.getUsers();

        for (User user : users) {
            UserResource res = new UserResource
                    .Builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .build();
            hateos.add(res);
        }
        return hateos;
    }


    @RequestMapping(value="/user/{username}", method= RequestMethod.GET)
    public UserResource getUser(@PathVariable("username") String username) {
        User user = service.getUser(username);

        UserResource res = new UserResource
                .Builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
        System.out.println(res.toString());
        return res;
    }
}

