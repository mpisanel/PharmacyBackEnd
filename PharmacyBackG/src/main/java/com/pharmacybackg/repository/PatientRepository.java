package com.pharmacybackg.repository;

import com.pharmacybackg.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 * Created by SONY on 2016-08-07.
 */
@Repository
public interface PatientRepository extends CrudRepository<Patient, Long>
{

}
