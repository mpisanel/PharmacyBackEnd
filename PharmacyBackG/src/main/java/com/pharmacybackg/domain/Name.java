package com.pharmacybackg.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by SONY on 2016-08-02.
 */
@Embeddable
public class Name implements Serializable {
    private String firstName;
    private String lastName;
    private String typeTitle;

    private Name() {}

    public Name(Builder builder)
    {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.typeTitle = builder.jobtitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTypeTitle() {
        return typeTitle;
    }

    public static class Builder {

        private String firstName;
        private String lastName;
        private String jobtitle;


        public Builder(String lastName) {
            this.lastName = lastName;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder jobTitle(String jobtitle)
        {
            this.jobtitle = jobtitle;
            return this;
        }

        public Builder copy(Name name) {
            this.firstName = name.firstName;
            this.lastName = name.lastName;
            this.jobtitle = name.typeTitle;
            return this;
        }

        public Name build() {
            return new Name(this);
        }

    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
