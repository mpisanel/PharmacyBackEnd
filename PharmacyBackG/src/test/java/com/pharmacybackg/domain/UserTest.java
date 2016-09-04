package com.pharmacybackg.domain;

import junit.framework.TestCase;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pharmacybackg.factory.UserFactory;

/**
 * Created by SONY on 2016-08-17.
 */
public class UserTest /*extends TestCase*/{

    //Before
    public void setUp() throws Exception
    {
    }
    //@Test
    public void testCreateUser() throws Exception
    {
        User user = UserFactory.createUser("Luzolo", "Mpiyakhe");
        Assert.assertEquals("Luzolo", user.getUsername());
    }

}
