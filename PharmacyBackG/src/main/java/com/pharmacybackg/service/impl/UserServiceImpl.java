package com.pharmacybackg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pharmacybackg.domain.User;
import com.pharmacybackg.repository.UserRepository;
import com.pharmacybackg.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 2016-08-08.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    public List<User> getUsers() {
        List<User> allusers = new ArrayList<User>();

        Iterable<User> users = repository.findAll();
        for (User user : users) {
            allusers.add(user);
        }
        return allusers;
    }

    public User findByUsernameAndPassword(String username, String password)
    {
        User user = repository.findOne(username);
        if(user != null)
        {
            if(user.getPassword().equals(password))
                return user;
        }

        return null;
    }

    public User save(User entity) {
        return repository.save(entity);
    }

    public User update(User entity) {
        return repository.save(entity);
    }

    public void delete(User entity) {
        repository.delete(entity);

    }

    public boolean exists(String username)
    {
        User user = repository.findOne(username);
        if(user==null)
            return false;

        return true;
    }

    public User getUser(String username)
    {
        User user =  repository.findOne(username);

        if(user != null)
        {
            return user;
        }

        return null;
    }
}
