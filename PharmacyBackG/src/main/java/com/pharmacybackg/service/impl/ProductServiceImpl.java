package com.pharmacybackg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pharmacybackg.domain.Product;
import com.pharmacybackg.repository.ProductRepository;
import com.pharmacybackg.service.ProductService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 2016-08-08.
 */
@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductRepository repository;

    @Override
    public Product findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Product save(Product entity) { return repository.save(entity); }

    @Override
    public Product update (Product entity) { return repository.save(entity); }

    @Override
    public void delete (Product product){ repository.delete(product); }

    @Override
    public List<Product> findAll() {
        List<Product> allProducts = new ArrayList<>();
        Iterable<Product> products = repository.findAll();

        for (Product product: products)
        {
            allProducts.add(product);
        }

        return allProducts;
    }





}
