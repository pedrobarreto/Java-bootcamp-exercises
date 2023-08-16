package com.trybe.acc.java.minhasseries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Minhas series application.
 */
@SpringBootApplication
@SpringBootConfiguration
public class MinhasSeriesApplication extends ServletInitializer {
  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(MinhasSeriesApplication.class, args);
    System.out.println("iniciado");
  }

}