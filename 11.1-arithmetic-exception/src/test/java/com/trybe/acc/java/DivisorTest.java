package com.trybe.acc.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DivisorTest {

  @Test
  @DisplayName("1 - Retornar zero quando houver divisão por 0")
  public void deveRetornarZero() {
    assertEquals(0, new Divisor().dividir(2, 0));
  }
  
  @Test
  @DisplayName("2 - Retornar o valor correto para a divisão de 25 por 5")
  public void deveRealizarDivisaoComResultadoCorreto() {
    assertEquals(5, new Divisor().dividir(25, 5));
  }

}
