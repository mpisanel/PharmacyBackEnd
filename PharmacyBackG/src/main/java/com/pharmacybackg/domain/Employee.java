package com.pharmacybackg.domain;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by SONY on 2016-08-05.
 */
@Entity
public class Employee implements Serializable
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

//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinColumn(name = "order_id")
//    private List<Orders> orders;

    public Employee() { }

    public Employee(Builder build)
    {
        id = build.id;
        name = build.name;
        contact = build.contact;
        address = build.address;
       // orders = build.orders;
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
       // private List<Orders> orders;

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
        public Builder copy(Employee employee)
        {
            this.id = employee.id;
            this.name = employee.name;
            this.contact = employee.contact;
            this.address = employee.address;

            return this;
        }

        public Employee build()
        {
            return new Employee(this);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (contact != null ? !contact.equals(employee.contact) : employee.contact != null) return false;
        return !(address != null ? !address.equals(employee.address) : employee.address != null);

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
