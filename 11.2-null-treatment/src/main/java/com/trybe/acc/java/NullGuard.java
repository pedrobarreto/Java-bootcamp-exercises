package com.trybe.acc.java;

public class NullGuard {


  NullGenerator geradorErro = new NullGenerator();

  /**
   * Classe de imprimir erros.
   */
  public String printName(int divisor) {
    String erro = geradorErro.getNome(divisor);
    return erro;
  }

}
