package com.trybe.acc.java.programamilhas.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Lancamento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idLancamento")
  private Integer id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idpessoa")
  private Pessoa usuario;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idtipolancamento")
  private TipoLancamento tipoLancamento;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idparceiro")
  private Parceiro parceiro;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idproduto")
  private Produto produto;

  private Integer valor;

  private String descricao;

  private LocalDate data;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Pessoa getUsuario() {
    return usuario;
  }

  public void setUsuario(Pessoa usuario) {
    this.usuario = usuario;
  }

  public TipoLancamento getTipoLancamento() {
    return tipoLancamento;
  }

  public void setTipoLancamento(TipoLancamento tipoLancamento) {
    this.tipoLancamento = tipoLancamento;
  }

  public Parceiro getParceiro() {
    return parceiro;
  }

  public void setParceiro(Parceiro parceiro) {
    this.parceiro = parceiro;
  }

  public Integer getValor() {
    return valor;
  }

  public void setValor(Integer valor) {
    this.valor = valor;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

}
