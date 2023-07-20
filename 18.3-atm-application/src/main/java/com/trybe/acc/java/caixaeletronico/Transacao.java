package com.trybe.acc.java.caixaeletronico;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {

  private String instante;
  protected Double quantia;
  protected String descricao;


  /**
   * Método construtor de Transação.
   */
  public Transacao(Double quantia, String descricao) {
    this.quantia = quantia;
    this.descricao = descricao;
    this.retornarInstante();
  }


  /**
   * Método para pegar quantia.
   */
  public Double getQuantia() {
    return this.quantia;
  }


  /**
   * Método para retornar instante.
   */
  public String retornarInstante() {
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    this.instante = LocalDateTime.now().format(formato);
    return this.instante;
  }

  public String retornarResumoTransacao() {
    return this.instante + "-------" + this.descricao + " R$ " + this.quantia;
  }

}

