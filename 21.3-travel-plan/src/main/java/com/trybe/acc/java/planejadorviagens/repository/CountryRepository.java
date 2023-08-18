package com.trybe.acc.java.planejadorviagens.repository;

import com.trybe.acc.java.planejadorviagens.model.Country;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends MongoRepository<Country, String> {

  List<Country> findByName(String name);



}
