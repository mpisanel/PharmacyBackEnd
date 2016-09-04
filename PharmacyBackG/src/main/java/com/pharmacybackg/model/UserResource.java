package com.pharmacybackg.model;

import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

/**
 * Created by SONY on 2016-08-18.
 */
public class UserResource extends ResourceSupport implements Serializable
{
    private String username;
    private String password;


    public UserResource() {
    }

    public UserResource(Builder build) {
        this.username = build.username;
        this.password = build.password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }



    public static class Builder
    {
        private String username;
        private String password;

        public Builder() {
        }


        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder copy(UserResource user) {
            this.username = user.username;
            this.password = user.password;
            return this;
        }

        public UserResource build(){ return new UserResource(this);}
    }

    @Override
    public String toString() {
        return "UserResource{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
