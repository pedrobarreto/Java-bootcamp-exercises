package app.trybe.specialityapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The type Speciality app application.
 */
@SpringBootApplication
@SpringBootConfiguration
public class SpecialityAppApplication extends ServletInitializer {
  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(SpecialityAppApplication.class, args);
    System.out.println("iniciado");
  }

}
