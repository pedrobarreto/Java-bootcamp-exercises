package com.trybe.acc.java.iocdi.sistemapagamentos.interceptor;

/**
 * The enum Verificacao.
 */
public enum Verificacao {

  /**
   * Pagamento verificacao.
   */
  PAGAMENTO("Pagamento");

  /**
   * The Valor.
   */
  String valor;

  Verificacao(String valor) {
    this.valor = valor;
  }

  /**
   * Gets valor.
   *
   * @return the valor
   */
  public String getValor() {
    return valor;
  }

}
