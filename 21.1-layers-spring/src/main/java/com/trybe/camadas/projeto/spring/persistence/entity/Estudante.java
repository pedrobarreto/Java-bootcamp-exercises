package com.trybe.camadas.projeto.spring.persistence.entity;

/**
 * Classe Estudante.
 */
public class Estudante {

  /**
   * The Id.
   */
  String id;
  /**
   * The Nome.
   */
  String nome;
  /**
   * The Stack favorita.
   */
  String stackFavorita;
  /**
   * The Cidade.
   */
  String cidade;


  /**
   * Instantiates a new Estudante.
   *
   * @param id            the id
   * @param nome          the nome
   * @param stackFavorita the stack favorita
   * @param cidade        the cidade
   */
  public Estudante(String id, String nome, String stackFavorita, String cidade) {
    this.id = id;
    this.nome = nome;
    this.stackFavorita = stackFavorita;
    this.cidade = cidade;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Gets nome estudante.
   *
   * @return the nome estudante
   */
  public String getNomeEstudante() {
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
   * Gets stack favorita.
   *
   * @return the stack favorita
   */
  public String getStackFavorita() {
    return stackFavorita;
  }

  /**
   * Sets stack favorita.
   *
   * @param stackFavorita the stack favorita
   */
  public void setStackFavorita(String stackFavorita) {
    this.stackFavorita = stackFavorita;
  }

  /**
   * Gets cidade.
   *
   * @return the cidade
   */
  public String getCidade() {
    return cidade;
  }

  /**
   * Sets cidade.
   *
   * @param cidade the cidade
   */
  public void setCidade(String cidade) {
    this.cidade = cidade;
  }


}
