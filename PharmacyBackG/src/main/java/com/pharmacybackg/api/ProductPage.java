package com.pharmacybackg.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.util.UriComponentsBuilder;
import com.pharmacybackg.domain.Product;
import com.pharmacybackg.model.UserResource;
import com.pharmacybackg.service.ProductService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 2016-08-20.
 */
@RestController
@RequestMapping(value="/product/**")
public class ProductPage {
    @Autowired
    private ProductService service;


    //-----------------Retrieve all products-------------------------
    @RequestMapping(value = "/view_products/", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listAllProducts() {
        List<Product> products = service.findAll();
        if (products.isEmpty()) {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/createProduct", method = RequestMethod.POST)
    public ResponseEntity<Void> createProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating product " + product.getId());


        service.save(product);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/createProduct/{id}").buildAndExpand(product.getProductName()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/product/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        System.out.println("Updating Product " + id);

        Product currentProduct = service.findById(id);

        if (currentProduct == null) {
            System.out.println("Product with id " + id + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

        Product updatedProduct = new Product
                .Builder(currentProduct.getProductName())
                .copy(currentProduct)
                .id(product.getId())
                .withProductDescription(product.getProductDescription())
                .withQuantity(product.getQuantity())
                .withProdPrice(product.getProductPrice())
                .build();
        service.update(updatedProduct);
        return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/delete/[id]", method = RequestMethod.PUT)
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") long id, @RequestBody Product prod) {
        System.out.println("Fetching and Deleting Product with id " + id + "not found");
      Product product = service.findById(id);
       if(product == null){
           System.out.println("Unable to delete. Product with id " + id + " not found");
           return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
       }
        service.delete(product);
        return new ResponseEntity<Product>(HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {
        System.out.println("Fetching Product with id " + id);
        Product product = service.findById(id);
        if (product == null) {
            System.out.println("Product with id " + id + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

}
