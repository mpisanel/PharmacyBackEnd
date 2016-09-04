package com.pharmacybackg.factory;

import com.pharmacybackg.domain.Product;

import java.util.List;

/**
 * Created by SONY on 2016-08-05.
 */
public class ProductFactory
{
    public static Product createProduct (String productName, String productDescription,String quantity, double productPrice)
    {
        Product prod = new Product
                .Builder(productName)
                .withProductDescription(productDescription)
                .withQuantity(quantity)
                .withProdPrice(productPrice)
                .build();

        return  prod;
    }
}
