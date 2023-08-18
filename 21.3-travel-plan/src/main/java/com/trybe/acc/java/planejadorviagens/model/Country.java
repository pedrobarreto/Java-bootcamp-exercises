package com.trybe.acc.java.planejadorviagens.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String id;
  private String name;
  private String capital;
  private String ddi;

  public Country() {}

  /**
   * Construtor para a entidade Country.
   * @param name o nome do país.
   * @param capital a capital.
   * @param ddi o DDI.
   */
  public Country(String name, String capital, String ddi) {
    this.name = name;
    this.capital = capital;
    this.ddi = ddi;
  }

  public String getCapital() {
    return capital;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }

  public String getDdi() {
    return ddi;
  }

  public void setDdi(String ddi) {
    this.ddi = ddi;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String toString() {
    return this.id.toString().concat(") ").concat(this.name).concat(":").concat(this.capital)
        .concat(" - DDI:").concat(this.ddi);
  }


}
