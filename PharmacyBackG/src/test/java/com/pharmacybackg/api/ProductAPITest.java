package com.pharmacybackg.api;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;
import com.pharmacybackg.App;
import com.pharmacybackg.domain.Product;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by SONY on 2016-08-20.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
//@IntegrationTest({"server.port=8080"})
public class ProductAPITest {
    final String BASE_URL = "http://localhost:8080/";
    private RestTemplate template;

   //@Before
    public void setUp() throws Exception {
        template = new TestRestTemplate();
    }

   // @Test
    public void testRead() throws Exception {
        ResponseEntity<String> response =template.getForEntity(BASE_URL+"api/product/readall", String.class);

        System.out.println("The response is "+response.getBody());
    }

    public static final String REST_SERVICE_URI = "http://localhost:8080/api";

    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllProducts(){
        System.out.println("Testing listAllProducts API-----------");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> ProductsMap = restTemplate.getForObject(REST_SERVICE_URI+"/products/", List.class);

        if(ProductsMap!=null){
            for(LinkedHashMap<String, Object> map : ProductsMap){
                System.out.println("Product : id="+map.get("id")+", Name="+map.get("name")+", Age="+map.get("age")+", Salary="+map.get("salary"));
            }
        }else{
            System.out.println("No Product exist----------");
        }
    }

    /* GET */
    private static void getProduct(){
        System.out.println("Testing getSubject API----------");
        RestTemplate restTemplate = new RestTemplate();
        Product Product = restTemplate.getForObject(REST_SERVICE_URI+"/product/1", Product.class);
        System.out.println(Product);
    }

    /* POST */
    private static void createProduct() {
        System.out.println("Testing create Product API----------");
        RestTemplate restTemplate = new RestTemplate();
        Product Product = new Product.Builder("Powder").withProductDescription("Panado").withQuantity("4").withProdPrice(23.00).build();
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/product/create/", Product, Product.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    /* PUT */
    private static void updateProduct() {
        System.out.println("Testing update Product API----------");
        RestTemplate restTemplate = new RestTemplate();
        Product Product = new Product.Builder("Powder").withProductDescription("Panado").withQuantity("4").withProdPrice(23.00).build();
        restTemplate.put(REST_SERVICE_URI+"/product/update/1", Product);
        System.out.println(Product);
    }

    /* DELETE */
    private static void deleteProduct() {
        System.out.println("Testing delete Product API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/product/delete/3");
    }


    /*DELETE */
    private static void deleteAllProducts() {
        System.out.println("Testing all delete Products API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "/product/");
    }
}
