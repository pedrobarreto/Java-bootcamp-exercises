package com.trybe.restaurante.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe RestauranteEntity.
 */
@Entity
public class RestauranteEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String nome;

  @Column
  private String descricao;

  /**
   * Instantiates a new Restaurante entity.
   */
  public RestauranteEntity() {
  }


  /**
   * Gets id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets nome.
   *
   * @return the nome
   */
  public String getNome() {
    return nome;
  }

  /**
   * Sets nome.
   *
   * @param nome the nome
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Gets descricao.
   *
   * @return the descricao
   */
  public String getDescricao() {
    return descricao;
  }

  /**
   * Sets descricao.
   *
   * @param descricao the descricao
   */
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
