package com.trybe.acc.java;

import java.time.LocalDate;

public class SimuladorRendimento {

  /**
   * Classe principal.
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    SimuladorRendimento obj = new SimuladorRendimento();
    double inicial = 500;
    double objetivo = 5000;
    System.out.println("Com " + inicial + " seu rendimento será " + objetivo + " no ano "
        + obj.simularRendimentoAnos(inicial, objetivo));

  }


  /**
   * Método Simulador de rendimentos.
   */
  int simularRendimentoAnos(double inicial, double objetivo) {

    double valorAcumulado = inicial;
    LocalDate hoje = LocalDate.now();
    LocalDate anoAcc;

    int anoObjetivo = 0;
    int acc = 0;

    do {
      acc += 1;
      valorAcumulado += (valorAcumulado * 0.1);
      anoAcc = hoje.plusYears(acc);
      anoObjetivo = anoAcc.getYear();
    } while (valorAcumulado <= objetivo);
    return anoObjetivo;
  }
}
