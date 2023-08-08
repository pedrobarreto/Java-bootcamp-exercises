package com.trybe.restaurante.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Classe RestauranteDto.
 */
public class RestauranteDto {

  @NotBlank
  private String nome;
  @NotBlank
  @Size(min = 3)
  private String descricao;


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
