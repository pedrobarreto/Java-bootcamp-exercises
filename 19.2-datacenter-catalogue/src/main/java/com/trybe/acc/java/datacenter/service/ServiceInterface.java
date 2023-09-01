package com.trybe.acc.java.datacenter.service;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * NÃO ALTERAR ESSA INTERFACE.
 * 
 */
public interface ServiceInterface<T, I extends Serializable> {

  EntityManagerFactory emf =
      Persistence.createEntityManagerFactory("com.trybe.acc.java.hibernate.datacenter");

  void save(T s);

  void update(T s);

  void delete(I id);

  List<T> list();

  T findById(I id);
}
