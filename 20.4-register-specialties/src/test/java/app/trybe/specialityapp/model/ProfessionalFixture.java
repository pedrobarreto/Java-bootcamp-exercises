package app.trybe.specialityapp.model;

import java.util.ArrayList;
import java.util.List;

public class ProfessionalFixture {

  public static Professional anyToEdit() {
    return new Professional(1, "Bruce Wayne", "Scientist");
  }

  public static Professional anyToInsert() {
    return new Professional(null, "William Birkin", "Scientist");
  }

}
