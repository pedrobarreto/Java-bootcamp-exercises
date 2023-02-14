package com.trybe.idadeemdias;

public class Pessoa {

  /**
   * Imprime área do quadrado.
   */

  public int calcularIdadeEmDias(int anos, int meses, int dias) {

    int idadeEmDias = (anos * 365) + (meses * 30) + dias;

    return idadeEmDias;

  }

}
