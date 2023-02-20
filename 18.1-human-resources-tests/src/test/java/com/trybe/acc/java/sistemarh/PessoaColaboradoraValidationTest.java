package com.trybe.acc.java.sistemarh;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes de validação da classe PessoaColaboradora")
class PessoaColaboradoraValidationTest {

  @Test
  @DisplayName("1 - Ao setar `3000` como salário bruto, o método `calcularSlarioLiquido` deve retornar `2400`")
  public void testeCalcularSalarioLiquido3000() {
    PessoaColaboradora pessoaColaboradora = new PessoaColaboradora();
    pessoaColaboradora.setSalarioBruto(3000);
    assertEquals(2400, pessoaColaboradora.calcularSalarioLiquido());
  }

  @Test
  @DisplayName("2 - Ao setar `7430` como salário bruto, o método `calcularSlarioLiquido` deve retornar `5944`")
  public void testeCalcularSalarioLiquido7430() {
    PessoaColaboradora pessoaColaboradora = new PessoaColaboradora();
    pessoaColaboradora.setSalarioBruto(7430);
    assertEquals(5944, pessoaColaboradora.calcularSalarioLiquido());
  }

  @Test
  @DisplayName("3 - Com salário bruto de `3000`, o método `calcularValorBrutoRecebidoAnual` ao receber `5` como parâmetro, deve retornar `180000`")
  public void testeCalcularValorBrutoRecebidoAnual3000() {
    PessoaColaboradora pessoaColaboradora = new PessoaColaboradora();
    pessoaColaboradora.setSalarioBruto(3000);
    assertEquals(180000, pessoaColaboradora.calcularValorBrutoRecebidoAnual(5));

  }


  @Test
  @DisplayName("4 - Com salário bruto de `7430`, o método `calcularValorBrutoRecebidoAnual` ao receber `5` como parâmetro, deve retornar `445800`")
  public void testeCalcularValorBrutoRecebidoAnual7430() {
    PessoaColaboradora pessoaColaboradora = new PessoaColaboradora();
    pessoaColaboradora.setSalarioBruto(7430);
    assertEquals(445800, pessoaColaboradora.calcularValorBrutoRecebidoAnual(5));

  }

  @Test
  @DisplayName("5 - Com salário bruto de `3000`, o método `calcularValorLiquidoRecebidoAnual` ao receber `5` como parâmetro, deve retornar `144000`")
  public void testeCalcularValorLiquidoRecebidoAnual3000() {
    PessoaColaboradora pessoaColaboradora = new PessoaColaboradora();
    pessoaColaboradora.setSalarioBruto(3000);
    assertEquals(144000, pessoaColaboradora.calcularValorLiquidoRecebidoAnual(5));

  }

  @Test
  @DisplayName("6 - Com salário bruto de `7430`, o método `calcularValorLiquidoRecebidoAnual` ao receber `5` como parâmetro, deve retornar `356640`")
  public void testeCalcularValorLiquidoRecebidoAnual7430() {
    PessoaColaboradora pessoaColaboradora = new PessoaColaboradora();
    pessoaColaboradora.setSalarioBruto(7430);
    assertEquals(356640, pessoaColaboradora.calcularValorLiquidoRecebidoAnual(5));

  }

  @Test
  @DisplayName("7 - Com salário bruto de `3000`, o método `calcularValorImpostoAnual` ao receber `5` como parâmetro, deve retornar `36000`")
  public void testeCalcularValorImpostoAnual3000() {
    PessoaColaboradora pessoaColaboradora = new PessoaColaboradora();
    pessoaColaboradora.setSalarioBruto(3000);
    assertEquals(36000, pessoaColaboradora.calcularValorImpostoAnual(5));

  }

  @Test
  @DisplayName("8 - Com salário bruto de `7430`, o método `calcularValorImpostoAnual` ao receber `5` como parâmetro, deve retornar `89160`")
  public void testeCalcularValorImpostoAnual7430() {
    PessoaColaboradora pessoaColaboradora = new PessoaColaboradora();
    pessoaColaboradora.setSalarioBruto(7430);
    assertEquals(89160, pessoaColaboradora.calcularValorImpostoAnual(5));

  }
}
