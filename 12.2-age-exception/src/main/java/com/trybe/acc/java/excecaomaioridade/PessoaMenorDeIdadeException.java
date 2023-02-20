package com.trybe.acc.java.excecaomaioridade;

public class PessoaMenorDeIdadeException extends Exception {

  private static final long serialVersionUID = 1L;

  public PessoaMenorDeIdadeException() {
    super("Menor de idade. Venda não permitida");
  }

}
