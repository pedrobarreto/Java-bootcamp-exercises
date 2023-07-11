package com.trybe.acc.java.gerenciadorestoque.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pedido")
public class Pedido {

  /**
   * Construtor para a entidade Pedido.
   */
  public Pedido(@JsonProperty("idDoPedido") String idDoPedido, @JsonProperty("nome") String produto,
      @JsonProperty("preco") Integer quantidade) {
    this.idDoPedido = idDoPedido;
    this.produto = produto;
    this.quantidade = quantidade;
  }

  @Id
  private String idDoPedido;
  private String produto;
  private Integer quantidade;

  public String getIdDoPedido() {
    return idDoPedido;
  }

  public void setIdDoPedido(String idDoPedido) {
    this.idDoPedido = idDoPedido;
  }

  public String getProduto() {
    return produto;
  }

  public void setProduto(String produto) {
    this.produto = produto;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }


}
