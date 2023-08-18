package com.trybe.calcularidade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Calcular idade application.
 */
@SpringBootApplication
public class CalcularIdadeApplication {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(CalcularIdadeApplication.class, args);
    System.out.println("iniciado!");
  }

}