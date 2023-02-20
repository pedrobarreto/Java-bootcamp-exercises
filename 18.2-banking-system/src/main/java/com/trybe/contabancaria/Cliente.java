package com.trybe.contabancaria;

/**
 * Classe Cliente.
 **/

public class Cliente {

  private String nome = "";
  private String cpf = "";

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return this.cpf;
  }

  /**
   * Método set Cpf.
   **/
  public String setCpf(String cpf) {
    if (ValidaCpf.validarCpf(cpf)) {

      this.cpf = cpf;
      return cpf;
    }
    this.cpf = null;
    return null;
  }

}
