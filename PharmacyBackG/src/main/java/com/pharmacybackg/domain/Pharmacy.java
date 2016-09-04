package com.pharmacybackg.domain;



import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by SONY on 2016-08-02.
 */
@Entity
public class Pharmacy implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pharmacyID;

    @Embedded
    private Address_location address;

    @Embedded
    private Contact contact;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private List<Employee> employees;
    public Pharmacy() { }

    public Pharmacy(Builder build)
    {
        address = build.address;
        contact = build.contact;
        employees = build.employees;
    }

    public Long getPharmacyID() { return pharmacyID; }

    public Address_location getAddress() { return address; }

    public Contact getContact() { return contact; }

    public List<Employee> getEmployees() { return employees; }

    public static class  Builder
    {
        private Address_location address;
        private Contact contact;
        private List<Employee> employees;

        public  Builder() {}

        public Builder withAddress (Address_location address)
        {
            this.address = address;
            return this;
        }

        public Builder withContact (Contact contact)
        {
            this.contact = contact;
            return this;
        }

        public Builder withEmployee(List<Employee> employees)
        {
            this.employees = employees;
            return this;
        }

        public Builder copy(Pharmacy pharmacy)
        {
            this.address = pharmacy.address;
            this.contact = pharmacy.contact;
            this.employees = pharmacy.employees;
            return  this;
        }

        public Pharmacy build()
        {
            return new Pharmacy(this);
        }
    }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pharmacy pharmacy = (Pharmacy) o;

            return pharmacyID == pharmacy.pharmacyID;

        }

        @Override
        public int hashCode() {
            return (int) (pharmacyID ^ (pharmacyID >>> 32));
        }

        @Override
        public String toString() {
            return "Pharmacy{" +
                    "pharmacyID=" + pharmacyID +
                    ", address=" + address +
                    ", contact=" + contact +
                    ", employees=" + employees +
                    '}';
        }
}
