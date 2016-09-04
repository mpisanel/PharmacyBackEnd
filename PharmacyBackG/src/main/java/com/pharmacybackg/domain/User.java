package com.pharmacybackg.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by SONY on 2016-08-02.
 */
@Entity
public class User implements Serializable {
    @Id
    private String username;
    private String password;

    public User() {}

    public User(Builder build) {
        this.username = build.username;
        this.password = build.password;
    }

    public String getUsername() {return username;}

    public String getPassword() {return password;}

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

        public Builder copy(User user) {
            this.username = user.username;
            this.password = user.password;
            return this;
        }

        public User build(){ return new User(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        return !(password != null ? !password.equals(user.password) : user.password != null);

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
