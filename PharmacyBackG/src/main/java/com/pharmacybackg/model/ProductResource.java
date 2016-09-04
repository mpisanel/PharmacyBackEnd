package com.pharmacybackg.model;

import org.springframework.hateoas.ResourceSupport;
import com.pharmacybackg.domain.Product;

import java.util.List;

/**
 * Created by SONY on 2016-08-18.
 */
public class ProductResource extends ResourceSupport {

    private Long resid;


    private String productName;
    private String productDescription;
    private int quantity;
    private double productPrice;



    public ProductResource (Builder build)
    {
        this.resid = build.id;
        productName = build.productName;
        productDescription = build.productDescription;
        quantity = build.quantity;
        productPrice = build.productPrice;
    }

    public Long getResid() {
        return resid;
    }

    public String getProductName() { return productName; }

    public String getProductDescription() { return productDescription; }

    public int getQuanity() { return quantity; }

    public double getProductPrice() { return productPrice; }


    public static class Builder
    {
        private Long id;
        private String productName;
        private String productDescription;
        private int quantity;
        private double productPrice;

        public Builder(String prodName) {this.productName = prodName;}


        public Builder withProductDescription(String productDescription)
        {
            this.productDescription = productDescription;
            return this;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder withQuantity(int quantity)
        {
            this.quantity = quantity;
            return this;
        }

        public Builder withProdPrice(double productPrice)
        {
            this.productPrice = productPrice;
            return this;
        }



        public Builder copy(ProductResource product)
        {
            this.id = product.getResid();
            this.productName = product.productName;
            this.productDescription = product.productDescription;
            this.quantity = product.quantity;
            this.productPrice = product.productPrice;
            return this;
        }

        public ProductResource build()
        {
            return new ProductResource(this);
        }
    }
}
