package com.trybe.contabancaria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClienteTest {
  @Test
  @DisplayName("1 - Faça um programa que retorne o nome de uma pessoa")
  public void testeNome() {
    Cliente objTeste = new Cliente();
    objTeste.setNome("Paulo Roberto");
    assertEquals("Paulo Roberto", objTeste.getNome());
  }

  @Test
  @DisplayName("2 - Escreva um método que valide um CPF")
  public void testeSetCPFValido() {
    Cliente objTeste = new Cliente();
    objTeste.setCpf("02758787083");
    assertEquals("02758787083", objTeste.getCpf());
  }

  @Test
  @DisplayName("3 - Faça um programa que retorne um CPF inválido")
  public void testeSetCPFInvalido() {
    Cliente objTeste = new Cliente();
    objTeste.setCpf("02758787089");
    assertNull(objTeste.getCpf());
  }

}
