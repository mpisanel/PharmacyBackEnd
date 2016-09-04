package com.pharmacybackg.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by SONY on 2016-08-02.
 */
@Entity
public class Product implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;
    private String productDescription;
    private String quantity;
    private double productPrice;

    public Product() { }

    public Product (Builder build)
    {
        id = build.id;
        productName = build.productName;
        productDescription = build.productDescription;
        quantity = build.quantity;
        productPrice = build.productPrice;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() { return productName; }

    public String getProductDescription() { return productDescription; }

    public String getQuantity() { return quantity; }

    public double getProductPrice() { return productPrice; }

    public static class Builder
    {
        private Long id;
        private String productName;
        private String productDescription;
        private String quantity;
        private double productPrice;

        public Builder(String prodName) {this.productName = prodName;}

        public Builder id(Long id){this.id= id; return this;};
        public Builder withProductDescription(String productDescription)
        {
            this.productDescription = productDescription;
            return this;
        }

        public Builder withQuantity(String quantity)
        {
            this.quantity = quantity;
            return this;
        }

        public Builder withProdPrice(double productPrice)
        {
            this.productPrice = productPrice;
            return this;
        }

        public Builder copy(Product product)
        {
            this.id = product.id;
            this.productName = product.productName;
            this.productDescription = product.productDescription;
            this.quantity = product.quantity;
            this.productPrice = product.productPrice;
            return this;
        }

        public Product build()
        {
            return new Product(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.productPrice, productPrice) != 0) return false;
        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;
        if (productDescription != null ? !productDescription.equals(product.productDescription) : product.productDescription != null)
            return false;
        return !(quantity != null ? !quantity.equals(product.quantity) : product.quantity != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productDescription != null ? productDescription.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        temp = Double.doubleToLongBits(productPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
