package com.trybe.cars.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe Car.
 * 
 */
@Entity
@Table(name = "car", schema = "public")
public class Car {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "nome")
  private String nome;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }


}
