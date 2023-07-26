package com.trybe.acc.java.programacadastro.bean;

public class DadosRetornoCadastro {

  private Integer idCadastro;

  private String nome;

  private String email;

  private boolean protegido;

  public Integer getIdCadastro() {
    return idCadastro;
  }

  public void setIdCadastro(Integer idCadastro) {
    this.idCadastro = idCadastro;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public boolean isProtegido() {
    return protegido;
  }

  public void setProtegido(boolean protegido) {
    this.protegido = protegido;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
