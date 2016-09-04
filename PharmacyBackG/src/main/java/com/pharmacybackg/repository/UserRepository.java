package com.pharmacybackg.repository;

import org.springframework.data.repository.CrudRepository;
import com.pharmacybackg.domain.User;

/**
 * Created by SONY on 2016-08-07.
 */
public interface UserRepository extends CrudRepository<User,String> {
}
