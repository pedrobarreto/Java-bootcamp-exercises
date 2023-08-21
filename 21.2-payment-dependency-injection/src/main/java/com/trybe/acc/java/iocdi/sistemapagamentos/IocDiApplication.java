package com.trybe.acc.java.iocdi.sistemapagamentos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Ioc di application.
 */
@SpringBootApplication
@SpringBootConfiguration
public class IocDiApplication {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(IocDiApplication.class, args);
  }

}
