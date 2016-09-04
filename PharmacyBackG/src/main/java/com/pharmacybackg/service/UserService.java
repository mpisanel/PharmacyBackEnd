package com.pharmacybackg.service;

import com.pharmacybackg.domain.User;

import java.util.List;

/**
 * Created by SONY on 2016-08-08.
 */
public interface UserService {
    List<User> getUsers();
    User findByUsernameAndPassword(String username, String password);
    User save(User entity);
    User update(User entity);
    User getUser(String username);
    void delete(User entity);
    boolean exists(String username);
}
