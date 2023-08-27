package com.trybe.cars.service;

import com.trybe.cars.model.Car;
import com.trybe.cars.repository.CarsRepository;
import java.util.List;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Classe CarsService.
 * 
 */
@Service
public class CarsService {
  @Autowired
  private CarsRepository repository;

  public List<Car> getAllCars() {
    return repository.findAll();
  }
}
