package com.trybe.acc.java.anobissexto;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class AnoBissexto {

  /**
   * Método identifica ano bissexto.
   */

  public boolean identificarAnoBissexto(int ano) {
    if (Year.isLeap(ano)) {
      return true;
    }
    return false;
  }

  /**
   * Método identifica próximo ano bissexto.
   */
  public int identificarProximoAnoBissexto(String data) {
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate dataFormatada = LocalDate.parse(data, formato);
    LocalDate dataAcc;
    int acc = 0;

    do {
      acc += 1;
      dataAcc = dataFormatada.plusYears(acc);
    } while (!dataAcc.isLeapYear());
    return dataAcc.getYear();
  }
}
