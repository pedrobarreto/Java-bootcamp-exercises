package com.trybe.calcularidade.domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;

/**
 * Classe Idade.
 */
public class Idade {
  private final LocalDate dataNascimento;

  /**
   * Instantiates a new Idade.
   *
   * @param dataNascimento the data nascimento
   */
  public Idade(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  /**
   * Gets idade.
   *
   * @return the idade
   */
  public HashMap<String, Integer> getIdade() {
    HashMap<String, Integer> response = new HashMap<>();
    response.put("idade", calcularIdade(dataNascimento));
    return response;
  }

  /**
   * Calcular idade integer.
   *
   * @param aniversario the aniversario
   * @return the integer
   */
  static Integer calcularIdade(final LocalDate aniversario) {
    final LocalDate dataAtual = LocalDate.now();
    final Period periodo = Period.between(aniversario, dataAtual);
    return periodo.getYears();
  }
}
