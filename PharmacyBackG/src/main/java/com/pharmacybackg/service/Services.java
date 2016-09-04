package com.pharmacybackg.service;

import java.util.List;

/**
 * Created by SONY on 2016-08-08.
 */
public interface Services <S,ID> {

    S findById(ID id);

    S save(S entity);

    S update(S entity);

    void delete(S entity);

    List<S> findAll();

}
