package com.pharmacybackg.model;

import org.springframework.hateoas.ResourceSupport;
import com.pharmacybackg.domain.*;

import java.util.List;

/**
 * Created by SONY on 2016-08-20.
 */
public class EmployeeResource extends ResourceSupport {
    private Long resid;

    private Name name;
    private Contact contact;
    private Address_location address;

    public EmployeeResource(Builder build)
    {
        resid = build.resid;
        name = build.name;
        contact = build.contact;
        address = build.address;
    }

    public long getResid() { return resid; }


    public Name getName() {
        return name;
    }

    public Contact getContact() { return contact; }

    public Address_location getAddress() { return address; }
    public static class Builder {
        private Long resid;
        private Name name;
        private Contact contact;
        private Address_location address;

        public Builder name(Name name) {
            this.name = name;
            return this;
        }

        public Builder resid(Long resid) {
            this.resid = resid;
            return this;
        }

        public Builder withContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder withAddress(Address_location address) {
            this.address = address;
            return this;
        }
        public Builder copy(EmployeeResource employee) {
            this.resid = employee.resid;
            this.name = employee.name;
            this.contact = employee.contact;
            this.address = employee.address;

            return this;
        }
        public EmployeeResource build() {
            return new EmployeeResource(this);
        }
    }
}
