package com.trybe.contabancaria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContaBancariaTest {

  @Test
  @DisplayName("4 - Faça um programa que retorne o nome de do cliente")
  public void testeNomeCliente() {
    ContaBancaria objTeste = new ContaBancaria();
    objTeste.setNomeCliente("Paulo Roberto");
    assertEquals("Paulo Roberto", objTeste.getNomeCliente());
  }

  @Test
  @DisplayName("5 - Escreva um método que retorne o CPF válido do cliente")
  public void testeCPFClienteValido() {
    ContaBancaria objTeste = new ContaBancaria();
    objTeste.setCpfCliente("02758787083");
    assertEquals("02758787083", objTeste.getCpfCliente());
  }

  @Test
  @DisplayName("6 - Faça um programa que retorne o CPF inválido do cliente")
  public void testeCPFClienteinValido() {
    ContaBancaria objTeste = new ContaBancaria();
    objTeste.setCpfCliente("02758787089");
    assertNull(objTeste.getCpfCliente());
  }

  @Test
  @DisplayName("7 - Escreva um método para efetuar um depósito")
  public void testeDepositar() {
    ContaBancaria objTeste = new ContaBancaria();
    assertEquals(5000, objTeste.depositar(5000));
  }

  @Test
  @DisplayName("8 - Escreva um método para sacar um valor")
  public void testeSacar() {
    ContaBancaria objTeste = new ContaBancaria();
    objTeste.depositar(5000);
    assertEquals(3000, objTeste.sacar(2000));
  }

  @Test
  @DisplayName("9 - Faça um programa para ver o saldo na conta")
  public void testeVerSaldo() {
    ContaBancaria objTeste = new ContaBancaria();
    objTeste.depositar(5000);
    assertEquals(5000, objTeste.verSaldo());
  }
}
