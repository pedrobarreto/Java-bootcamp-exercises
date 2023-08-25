package app.trybe.specialityapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The type Professional.
 */
@Entity
@Table(name = "tb_professional")
public class Professional {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "professional_name")
  private String name;
  @Column(name = "professional_speciality")
  private String speciality;

  /**
   * Construtor.
   */
  public Professional(Integer id, String name, String speciality) {
    this.id = id;
    this.name = name;
    this.speciality = speciality;
  }

  public Professional() {

  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public Integer getId() {
    return id;
  }


  /**
   * Gets speciality.
   *
   * @return the speciality
   */
  public String getSpeciality() {
    return speciality;
  }

  /**
   * Sets speciality.
   *
   * @param speciality the speciality
   */
  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

}
