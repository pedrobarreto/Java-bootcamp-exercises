package com.trybe.acc.java.minhasseries.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The type Serie.
 */
@Entity
@Table(name = "series")
public class Serie {

  @Id
  @Column(name = "id_serie")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column(name = "nome")
  private String nome;

  /**
   * Instantiates a new Serie.
   */
  public Serie() {
  }

  /**
   * Instantiates a new Serie.
   *
   * @param nome the nome
   */
  public Serie(String nome) {
    this.nome = nome;
  }

  @JsonManagedReference
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "serie")
  private List<Episodio> episodios = new ArrayList<>();


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
   * Adicionar episodio.
   *
   * @param episodio the episodio
   */
  public void adicionarEpisodio(Episodio episodio) {
    this.episodios.add(episodio);
  }

  /**
   * Gets episodios.
   *
   * @return the episodios
   */
  public List<Episodio> getEpisodios() {
    return episodios;
  }
}
