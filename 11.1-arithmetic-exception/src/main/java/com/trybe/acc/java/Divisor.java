package com.trybe.acc.java;

public class Divisor {

  /**
   * método de divisão.
   */
  public int dividir(int numero1, int numero2) throws ArithmeticException {

    try {
      int divisao = numero1 / numero2;
      return divisao;
    } catch (ArithmeticException e) {
      System.out.println(e);
    }
    return 0;
  }
}
