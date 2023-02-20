package com.trybe.acc.java.sistemarh;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestePessoaColaboradora {


  @Test
  @DisplayName("Validando o método de calcular salário líquido")
  void testeCalcularSalarioLiquido() {
    PessoaColaboradora colaborador = new PessoaColaboradora();
    colaborador.setSalarioBruto(5000);
    double salarioLiquido = colaborador.calcularSalarioLiquido();
    assertEquals(4000.0, salarioLiquido);
  }

  @Test
  @DisplayName("Validando o método de calcular salário bruto anual")
  void testeCalcularValorBrutoRecebidoAnual() {
    PessoaColaboradora colaborador = new PessoaColaboradora();
    colaborador.setSalarioBruto(3000);
    double salarioBrutoAnual = colaborador.calcularValorBrutoRecebidoAnual(5);
    assertEquals(180000.0, salarioBrutoAnual);
  }

  @Test
  @DisplayName("Validando o método de calcular valor líquido recebido anual")
  void testeCalcularValorLiquidoRecebidoAnual() {
    PessoaColaboradora colaborador = new PessoaColaboradora();
    colaborador.setSalarioBruto(5000);
    colaborador.calcularSalarioLiquido();
    double salarioLiquidoAnual = colaborador.calcularValorLiquidoRecebidoAnual(1);
    assertEquals(48000.0, salarioLiquidoAnual);
  }

  @Test
  @DisplayName("Validando o método de calcular imposto anual")
  void testeCalcularValorImpostoAnual() {
    PessoaColaboradora colaborador = new PessoaColaboradora();
    colaborador.setSalarioBruto(7430);
    colaborador.calcularSalarioLiquido();
    double impostoAnual = colaborador.calcularValorImpostoAnual(5);
    assertEquals(89160.0, impostoAnual);
  }

}
