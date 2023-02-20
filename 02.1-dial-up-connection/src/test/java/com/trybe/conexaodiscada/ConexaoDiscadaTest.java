package com.trybe.conexaodiscada;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConexaoDiscadaMock extends ConexaoDiscada {
  int numChamadas;
  int maxChamadas;

  ConexaoDiscadaMock(int maxChamadas) {
    this.numChamadas = 0;
    this.maxChamadas = maxChamadas;
  }

  @Override
  boolean verdadeiroOuFalso() {
    numChamadas += 1;

    return numChamadas >= maxChamadas;
  }
}


public class ConexaoDiscadaTest {

  @Test
  @DisplayName("1 - Testando a conexão discada à internet com três tentativas")
  public void mainTest() {
    ConexaoDiscadaMock mock;

    for (int maxChamadas = 1; maxChamadas <= 5; maxChamadas++) {
      mock = new ConexaoDiscadaMock(maxChamadas);
      ConexaoDiscada.conexaoDiscada = mock;
      ConexaoDiscada.main(null);

      assertEquals(Math.min(maxChamadas, 3), mock.numChamadas);
    }
  }
}
