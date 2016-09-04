package com.pharmacybackg.domain;

import org.junit.Assert;
import org.junit.Test;
import com.pharmacybackg.factory.ProductFactory;

/**
 * Created by SONY on 2016-08-17.
 */
public class TestProduct
{
       //@Test
        public void TestProduct() throws Exception
        {
            Product prod = ProductFactory
                    .createProduct("Panado","End Headache","4",34.00);

            Assert.assertEquals("Panado", prod.getProductName());
        }

        public void TestUpdateProduct() throws Exception
        {
            Product prod = ProductFactory
                    .createProduct("Dispring","End Headache","4",34.00);

            Product newProd = ProductFactory
                    .createProduct("MadLemon","End Fever","4",30.00);

            Assert.assertEquals("Dispring",prod.getProductName());
            Assert.assertEquals("End Headache", prod.getProductDescription());
            Assert.assertNotEquals("End Fever", newProd.getProductDescription());
            Assert.assertEquals("MadLemon",newProd.getProductName());
        }
}
