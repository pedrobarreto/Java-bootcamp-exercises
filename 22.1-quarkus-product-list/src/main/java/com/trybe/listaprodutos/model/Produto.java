package com.trybe.listaprodutos.model;

/**
 * Classe Produto.
 */
public class Produto {
  private Integer id;
  private String nome;


  /**
   * Instantiates a new Produto.
   */
  public Produto() {

  }

  /**
   * Instantiates a new Produto.
   *
   * @param id   the id
   * @param nome the nome
   */
  public Produto(Integer id, String nome) {
    this.id = id;
    this.nome = nome;
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
   * Gets nome.
   *
   * @return the nome
   */
  public String getNome() {
    return nome;
  }

}
