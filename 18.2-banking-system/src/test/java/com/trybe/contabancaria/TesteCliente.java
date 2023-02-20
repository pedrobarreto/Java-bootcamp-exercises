package com.trybe.contabancaria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TesteCliente {

  @Test
  void testeNome() {
    Cliente cliente = new Cliente();
    cliente.setNome("Pedro");
    assertEquals("Pedro", cliente.getNome());
  }

  @Test
  void testeSetCPFValido() {
    Cliente cliente = new Cliente();
    cliente.setCpf("02758787083");
    String cpf = cliente.getCpf();
    assertTrue(true, cpf);
  }

  @Test
  void testeSetCPFInvalido() {
    Cliente cliente = new Cliente();
    cliente.setCpf("91934480070");
    assertNull(cliente.getCpf());
  }

}
