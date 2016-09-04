package com.pharmacybackg.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pharmacybackg.App;
import com.pharmacybackg.factory.UserFactory;
import com.pharmacybackg.domain.User;

/**
 * Created by SONY on 2016-08-17.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class UserRepositoryTest extends AbstractTestNGSpringContextTests {

    private String id;

    //@Autowired
    private UserRepository repository;

    //@BeforeMethod
    public void setUp() throws Exception {
    }

    //@AfterMethod
    public void tearDown() throws Exception {
    }

    //@Test
    public void create() throws Exception {

        User user = UserFactory.createUser("Luxolo", "Mpisane");

        repository.save(user);

        id = user.getUsername();

        Assert.assertEquals(user.getUsername(), "Luxolo");
    }

}