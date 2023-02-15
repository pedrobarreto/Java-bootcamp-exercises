package com.trybe.polimorfismo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FuncionarioTest {

  @Test
  @DisplayName("1 - Calcular sálario líquido da pessoa física")
  void testCalcularSalarioLiquidoPessoaFisica() {
    FuncionarioPessoaFisica objTeste = new FuncionarioPessoaFisica();
    objTeste.setSalarioBruto(5000);
    assertEquals(4000, objTeste.calcularSalarioLiquido());
  }

  @Test
  @DisplayName("2 - Calcular sálario líquido da pessoa jurídica")
  void testCalcularSalarioLiquidoPessoaJuridica() {
    FuncionarioPessoaJuridica objTeste = new FuncionarioPessoaJuridica();
    objTeste.setSalarioBruto(5000);
    assertEquals(4500, objTeste.calcularSalarioLiquido());
  }
}
