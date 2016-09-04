package com.pharmacybackg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pharmacybackg.domain.Product;

/**
 * Created by SONY on 2016-08-07.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>
{


}
