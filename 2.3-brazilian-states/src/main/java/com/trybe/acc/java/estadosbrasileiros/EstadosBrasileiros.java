package com.trybe.acc.java.estadosbrasileiros;

import java.util.Random;

public class EstadosBrasileiros {
  /**
   * Método principal para a execuçao do código.
   * 
   */
  public static void main(String[] args) {
    // Sorteia uma UF.
    String[] siglas = {"CE", "SC", "AM"};
    int pos = new Random().nextInt(siglas.length);

    // Mostra o nome do estado.
    mostraNomeEstado(siglas[pos]);
  }

  static void mostraNomeEstado(String uf) {

    if (uf == "CE") {
      imprime("CEARA");
    } else if (uf == "SC") {
      imprime("SANTA CATARINA");
    } else {
      imprime("AMAZONAS");
    }

  }

  // Chame a função escrevendo `imprime()`.
  static void imprime(String nomeEstado) {
    System.out.println(nomeEstado);
  }
}
