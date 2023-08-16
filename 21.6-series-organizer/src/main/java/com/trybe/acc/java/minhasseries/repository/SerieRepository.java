package com.trybe.acc.java.minhasseries.repository;

import com.trybe.acc.java.minhasseries.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Serie repository.
 */
@Repository
public interface SerieRepository extends JpaRepository<Serie, Integer> {
}
