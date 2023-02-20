package com.trybe.acc.java;

public class Fatorial {

  /**
   * Cálculo Fatorial.
   */
  public static void main(String[] args) {

    long fatorial = 1;
    int acc = 0;

    do {
      acc += 1;
      fatorial *= acc;
    } while (acc < 18);

    System.out.println("O fatorial de 18 é igual a " + fatorial);

  }

}
