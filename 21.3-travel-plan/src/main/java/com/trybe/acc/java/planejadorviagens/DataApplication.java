package com.trybe.acc.java.planejadorviagens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.trybe.acc.java.planejadorviagens.*" })
public class DataApplication {


  public static void main(String[] args) {
    SpringApplication.run(DataApplication.class, args);
  }

}
