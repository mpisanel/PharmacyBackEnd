package com.pharmacybackg.factory;

import com.pharmacybackg.domain.User;

/**
 * Created by SONY on 2016-08-07.
 */
public class UserFactory {
    public static User createUser(String username, String password){
        User user = new User
                .Builder()
                .username(username)
                .password(password)
                .build();
        return user;
    }
}
