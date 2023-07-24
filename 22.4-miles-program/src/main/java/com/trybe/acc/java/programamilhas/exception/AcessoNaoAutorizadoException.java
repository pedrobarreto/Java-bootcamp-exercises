package com.trybe.acc.java.programamilhas.exception;

public class AcessoNaoAutorizadoException extends Exception {

  private static final long serialVersionUID = 1L;

  public AcessoNaoAutorizadoException() {
    super("Acesso não autorizado.");
  }

}
