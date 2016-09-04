package com.pharmacybackg.domain;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by SONY on 2016-08-02.
 */
@Entity
public class Patient implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private Name name;

    @Embedded
    private Contact contact;

    @Embedded
    private Address_location address;
    public Patient() { }

    public Patient(Builder build)
    {
        id = build.id;
        name = build.name;
        contact = build.contact;
        address = build.address;
    }


    public Long getId() {return id;}

    public Name getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    public Address_location getAddress() {
        return address;
    }

    public static class Builder
    {
        private Long id;
        private Name name;
        private Contact contact;
        private Address_location address;

        public Builder(Name name) {this.name = name;}
        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }
        public Builder withContact(Contact contact)
        {
            this.contact = contact;
            return this;
        }

        public Builder withAddress(Address_location address)
        {
            this.address = address;
            return this;
        }
        public Builder copy(Patient patient)
        {
            this.id = patient.id;
            this.name = patient.name;
            this.contact = patient.contact;
            this.address = patient.address;

            return this;
        }

        public Patient build()
        {
            return new Patient(this);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (id != null ? !id.equals(patient.id) : patient.id != null) return false;
        if (name != null ? !name.equals(patient.name) : patient.name != null) return false;
        if (contact != null ? !contact.equals(patient.contact) : patient.contact != null) return false;
        return !(address != null ? !address.equals(patient.address) : patient.address != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
