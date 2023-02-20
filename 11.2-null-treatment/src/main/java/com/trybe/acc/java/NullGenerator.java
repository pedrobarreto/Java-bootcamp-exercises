package com.trybe.acc.java;

public class NullGenerator {


  /**
   * Imprime erro caso o número não seja par.
   */
  public String getNome(int numero) throws ArithmeticException {
    try {
      if (numero % 2 == 0) {
        return "BOB";
      }
    } catch (ArithmeticException e) {
      System.out.println(e);
    }
    return "Nome nulo";
  }
}
