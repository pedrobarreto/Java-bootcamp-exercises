package com.trybe.contabancaria;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidaCPFTest {

  @Test
  @DisplayName("2 - Escreva um método que valide um CPF")
  public void testeValidarCPFValido() {
    assertTrue(ValidaCpf.validarCpf("02758787083"));
  }

  @Test
  @DisplayName("3 - Faça um programa que retorne um CPF inválido")
  public void testeValidarCPFinValido() {
    assertFalse(ValidaCpf.validarCpf("02758787087"));
  }

}
