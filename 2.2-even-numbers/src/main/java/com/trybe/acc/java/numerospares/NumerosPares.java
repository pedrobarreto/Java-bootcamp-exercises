package com.trybe.acc.java.numerospares;

/**
 * Classe NumerosPares.
 * 
 */
public class NumerosPares {

  /**
   * Método para implementar o for que vai gerar os números de 4 a 20.
   * 
   */
  public static void main(String[] args) {


    for (int i = 4; i <= 20; i += 2) {
      imprime(i);
    }

  }

  /**
   * Método para imprimir no console os números de 4 a 20.
   * 
   */
  public static void imprime(int numero) {
    System.out.println(numero);
  }

}
