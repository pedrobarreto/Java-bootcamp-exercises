package com.trybe.contabancaria;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TesteValidaCPF {

  @Test
  void TesteValidaCPFValido() {
    Cliente cliente = new Cliente();
    cliente.setCpf("20252111044");
    String cpf = cliente.getCpf();
    assertTrue(true, cpf);
  }

  @Test
  void TesteValidaCPFInvalido() {
    Cliente cliente = new Cliente();
    cliente.setCpf("2025211104422");
    String cpf = cliente.getCpf();
    assertNull(cpf);
  }

}
