package com.trybe.conexaodiscada;

import java.util.Random;

/**
 * Classe ConexaoDiscada.
 *
 */
public class ConexaoDiscada {

  /**
   * Método principal.
   *
   */
  public static void main(String[] args) {

    int maxTentativas = 3;

    for (int i = 1; i <= maxTentativas; i += 1) {

      if (conectou()) {
        System.out.println("Conectado a internet");
        break;
      }

    }

  }

  // Chame esta função escrevendo `conectou()`
  static boolean conectou() {
    return conexaoDiscada.verdadeiroOuFalso();
  }

  static ConexaoDiscada conexaoDiscada = new ConexaoDiscada();

  // Retorna verdadeiro ou falso
  boolean verdadeiroOuFalso() {
    return new Random().nextInt(2) == 1;
  }

}
