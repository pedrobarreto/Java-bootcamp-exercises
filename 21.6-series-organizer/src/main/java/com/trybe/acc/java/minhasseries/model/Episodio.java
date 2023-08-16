package com.trybe.acc.java.minhasseries.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The type Episodio.
 */
@Entity
@Table(name = "episodios")
public class Episodio {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column(name = "numero")
  private Integer numero;

  @Column(name = "duracao")
  private Integer duracaoEmMinutos;

  //https://stackoverflow.com/questions/47693110/could-not-write-json-infinite-recursion-stackoverflowerror-nested-exception
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_serie")
  private Serie serie;


  /**
   * Instantiates a new Episodio.
   */
  public Episodio() {

  }

  /**
   * Instantiates a new Episodio.
   *
   * @param numero  the numero
   * @param duracao the duracao
   */
  public Episodio(int numero, int duracao) {
    this.numero = numero;
    this.duracaoEmMinutos = duracao;
  }

  /**
   * Instantiates a new Episodio.
   *
   * @param id      the id
   * @param numero  the numero
   * @param duracao the duracao
   * @param serie   the serie
   */
  public Episodio(Object id, int numero, int duracao, Serie serie) {
    this.numero = numero;
    this.duracaoEmMinutos = duracao;
    this.serie = serie;
  }

  /**
   * Gets serie.
   *
   * @return the serie
   */
  public Serie getSerie() {
    return serie;
  }

  /**
   * Sets serie.
   *
   * @param serie the serie
   */
  public void setSerie(Serie serie) {
    this.serie = serie;
  }


  /**
   * Instantiates a new Episodio.
   *
   * @param episodio the episodio
   * @param serie    the serie
   */
  public Episodio(Episodio episodio, Serie serie) {
    this.numero = episodio.getNumero();
    this.duracaoEmMinutos = episodio.getDuracaoEmMinutos();
    this.serie = serie;
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
   * Sets id.
   *
   * @param id the id
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Gets numero.
   *
   * @return the numero
   */
  public Integer getNumero() {
    return numero;
  }

  /**
   * Sets numero.
   *
   * @param numero the numero
   */
  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  /**
   * Gets duracao em minutos.
   *
   * @return the duracao em minutos
   */
  public Integer getDuracaoEmMinutos() {
    return duracaoEmMinutos;
  }

  /**
   * Sets duracao em minutos.
   *
   * @param duracaoEmMinutos the duracao em minutos
   */
  public void setDuracaoEmMinutos(Integer duracaoEmMinutos) {
    this.duracaoEmMinutos = duracaoEmMinutos;
  }


}
