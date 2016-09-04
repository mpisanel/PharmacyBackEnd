package com.pharmacybackg.model;

import org.springframework.hateoas.ResourceSupport;
import com.pharmacybackg.domain.*;

/**
 * Created by SONY on 2016-08-18.
 */
public class PatientResource extends ResourceSupport {
    private Long resid;

    private Name name;
    private Contact contact;
    private Address_location address;
    public PatientResource(Builder build)
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

        public Builder copy(PatientResource patientResource) {
            this.resid = patientResource.resid;
            this.name = patientResource.name;
            this.contact = patientResource.contact;
            return this;
        }

        public PatientResource build() {
            return new PatientResource(this);
        }
    }
}
