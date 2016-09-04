package com.pharmacybackg.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * Created by SONY on 2016-08-02.
 */
@Embeddable
public class Contact implements Serializable
{

    private String homeNumber;

    private String cellNumber;

    public Contact() { }

    public Contact(Builder builder)
    {
        cellNumber = builder.cellNumber;
        homeNumber = builder.homeNumber;
    }

    public String getCellNumber() { return cellNumber; }

    public String getHomeNumber() { return homeNumber; }

    public static class Builder
    {
        private String cellNumber;
        private String homeNumber;

        public Builder() {}

        public Builder withCellNumber(String cellNumber)
        {
            this.cellNumber = cellNumber;
            return this;
        }

        public Builder withHomeNumber(String homeNumber)
        {
            this.homeNumber = homeNumber;
            return this;
        }

        public Builder copy(Contact contact)
        {
            this.cellNumber = contact.cellNumber;
            this.homeNumber = contact.homeNumber;
            return this;
        }

        public Contact build()
        {
            return new Contact(this);
        }
    }

    @Override
    public String toString() {
        return "Contact{" +
                "homeNumber='" + homeNumber + '\'' +
                ", cellNumber='" + cellNumber + '\'' +
                '}';
    }
}
