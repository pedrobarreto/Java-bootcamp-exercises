package com.trybe.contabancaria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TesteContaBancaria {

  @Test
  void testeNomeCliente() {
    Cliente cliente = new Cliente();
    cliente.setNome("Pedro");
    assertEquals("Pedro", cliente.getNome());
  }

  @Test
  void testeCPFClienteValido() {
    Cliente cliente = new Cliente();
    cliente.setCpf("91934480070");
    assertTrue(true, cliente.getCpf());
  }

  @Test
  void testeCPFClienteInvalido() {
    Cliente cliente = new Cliente();
    cliente.setCpf("91934480070");
    assertNull(cliente.getCpf());
  }

  @Test
  void testeDepositar() {
    ContaBancaria conta = new ContaBancaria();
    conta.depositar(500);
    int saldo = conta.verSaldo();
    assertEquals(500, saldo);
  }


  @Test
  void testeSacar() {
    ContaBancaria conta = new ContaBancaria();
    conta.depositar(500);
    conta.sacar(100);
    int saldo = conta.verSaldo();
    assertEquals(400, saldo);
  }

  @Test
  void testeVerSaldo() {
    ContaBancaria conta = new ContaBancaria();
    conta.depositar(500);
    conta.depositar(500);
    int saldo = conta.verSaldo();
    assertEquals(1000, saldo);
  }

}
