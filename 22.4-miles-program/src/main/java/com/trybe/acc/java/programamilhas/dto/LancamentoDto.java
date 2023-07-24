package com.trybe.acc.java.programamilhas.dto;

public class LancamentoDto {

  private String usuario;

  private Integer valor;

  private Integer idTipoLancamento;

  private Integer idParceiro;

  private String descricao;

  public Integer getValor() {
    return valor;
  }

  public void setValor(Integer valor) {
    this.valor = valor;
  }

  public Integer getIdTipoLancamento() {
    return idTipoLancamento;
  }

  public void setIdTipoLancamento(Integer idTipoLancamento) {
    this.idTipoLancamento = idTipoLancamento;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Integer getIdParceiro() {
    return idParceiro;
  }

  public void setIdParceiro(Integer idParceiro) {
    this.idParceiro = idParceiro;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

}
