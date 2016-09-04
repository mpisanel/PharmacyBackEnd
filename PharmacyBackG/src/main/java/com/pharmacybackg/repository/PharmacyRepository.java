package com.pharmacybackg.repository;

import com.pharmacybackg.domain.Pharmacy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by SONY on 2016-08-07.
 */
@Repository
public interface PharmacyRepository extends CrudRepository<Pharmacy,Long>
{

}
