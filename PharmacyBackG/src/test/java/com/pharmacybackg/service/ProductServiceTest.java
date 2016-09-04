package com.pharmacybackg.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import com.pharmacybackg.App;
import com.pharmacybackg.factory.ProductFactory;
import com.pharmacybackg.domain.Product;
import com.pharmacybackg.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 2016-08-17.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ProductServiceTest extends AbstractTestNGSpringContextTests{
    //@Autowired
    private ProductService service;
    private Long id;

    //@Autowired
    private ProductRepository repository;

    private List<Product> products;

   // @BeforeMethod
    public void setUp() throws Exception{
        products = new ArrayList<>();
    }
    //@Test
    public void create() throws Exception
    {

        Product product2 = ProductFactory.createProduct("Thetha", "ntozonke", "30", 24.60);

        products.add(product2);

        repository.save(product2);
        Assert.assertNotNull(product2);
    }
}
