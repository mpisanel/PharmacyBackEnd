package com.pharmacybackg.domain;



import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by SONY on 2016-08-02.
 */
    @Embeddable
    public class Address_location implements Serializable
    {
        private String postalAddress;
        private String postalCode;

        public Address_location() { }

        public Address_location(Builder build)
        {
            postalAddress = build.postalAddress;
            postalCode = build.postalCode;
        }

        public String getPostalAddress() {
            return postalAddress;
        }

        public String getPostalCode() {
            return postalCode;
        }


        public static class Builder
        {
            private String postalAddress;
            private String postalCode;

            public Builder() { }

            public Builder withPostalAddr(String postalAddr)
            {
                this.postalAddress = postalAddr;
                return this;
            }

            public Builder withPostalCode(String postalCode)
            {
                this.postalCode = postalCode;
                return this;
            }

            public Builder copy(Address_location address)
            {
                this.postalAddress = address.postalAddress;
                this.postalCode = address.postalCode;
                return this;
            }

            public Address_location build()
            {
                return new Address_location(this);
            }
        }
    }


