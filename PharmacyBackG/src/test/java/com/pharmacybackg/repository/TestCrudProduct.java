package com.pharmacybackg.repository;

import com.pharmacybackg.App;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pharmacybackg.factory.ProductFactory;
import com.pharmacybackg.domain.Product;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by SONY on 2016-08-17.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudProduct extends AbstractTestNGSpringContextTests
{
    private Long id;

    //@Autowired
    ProductRepository repository;

    private List<Product> products;

   // @BeforeMethod
    public void setUp() throws Exception{
        products = new ArrayList<>();
    }

    //@Test
    public void create() throws Exception
    {

        Product product1 = ProductFactory.createProduct("Varaza", "strong Mathambo", "28", 25.60);

        products.add(product1);
        repository.save(products);

        Assert.assertNotNull(product1);
    }

   //@Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Product product =  repository.findOne(id);
        Assert.assertNotNull(product.getProductName());
    }

   //@Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Product product = repository.findOne(id);
        Product newProduct = new Product.Builder(product.getProductName()).withProductDescription("strong Mathambo")
                .withProdPrice(20.14).withQuantity("3").build();
        repository.save(newProduct);

        Product updatedProduct = repository.findOne(id);

        Assert.assertEquals("Varaza", updatedProduct.getProductName());
    }

    //@Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Product product = repository.findOne(id);
        repository.delete(product);
        Product newProduct = repository.findOne(id);
        Assert.assertNull(newProduct);
    }

}
