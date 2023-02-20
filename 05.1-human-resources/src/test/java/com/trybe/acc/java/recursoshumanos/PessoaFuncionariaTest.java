package com.trybe.acc.java.recursoshumanos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PessoaFuncionariaTest {

  @Test
  @DisplayName("1 - Crie um construtor para a PessoaFuncionaria que receba o nome, CPF, endereço e salário.")
  public void testeConstrutor() {
    PessoaFuncionaria objTeste =
        new PessoaFuncionaria("Maria da Silva", "158.699.457-31", "Rua da Aurora, 118", 15000);
    assertEquals("Maria da Silva", objTeste.getNomeCompleto());
    assertEquals("158.699.457-31", objTeste.getCpf());
    assertEquals("Rua da Aurora, 118", objTeste.getEndereco());
    assertEquals(15000.0, objTeste.getSalario());

  }

  @Test
  @DisplayName("2 - Crie um método getter para o atributo nomeCompleto de PessoaFuncionaria.")
  public void testeGetNomeCompleto() {
    PessoaFuncionaria objTeste =
        new PessoaFuncionaria("Maria da Silva", "158.699.457-31", "Rua da Aurora, 118", 15000);
    assertEquals("Maria da Silva", objTeste.getNomeCompleto());
  }

  @Test
  @DisplayName("3 - Crie um método setter para o atributo nomeCompleto de PessoaFuncionaria.")
  public void testeSetNomeCompleto() {
    PessoaFuncionaria objTeste =
        new PessoaFuncionaria("Maria da Silva", "158.699.457-31", "Rua da Aurora, 118", 15000);
    objTeste.setNomeCompleto("Maria da Silva Oliveira");
    assertEquals("Maria da Silva Oliveira", objTeste.getNomeCompleto());
  }

  @Test
  @DisplayName("4 - Crie um método getter para o atributo cpf de PessoaFuncionaria.")
  public void testeGetCpf() {
    PessoaFuncionaria objTeste =
        new PessoaFuncionaria("Maria da Silva", "158.699.457-31", "Rua da Aurora, 118", 15000);
    assertEquals("158.699.457-31", objTeste.getCpf());
  }

  @Test
  @DisplayName("5 - Crie um método getter para o atributo endereco de PessoaFuncionaria.")
  public void testeGetEndereco() {
    PessoaFuncionaria objTeste =
        new PessoaFuncionaria("Maria da Silva", "158.699.457-31", "Rua da Aurora, 118", 15000);
    assertEquals("Rua da Aurora, 118", objTeste.getEndereco());
  }

  @Test
  @DisplayName("6 - Crie um método setter para o atributo endereco de PessoaFuncionaria.")
  public void testeSetEndereco() {
    PessoaFuncionaria objTeste =
        new PessoaFuncionaria("Maria da Silva", "158.699.457-31", "Rua da Aurora, 118", 15000);
    objTeste.setEndereco("Rua da Moeda, 100");
    assertEquals("Rua da Moeda, 100", objTeste.getEndereco());
  }

  @Test
  @DisplayName("7 - Crie um método getter para o atributo salario de PessoaFuncionaria.")
  public void testeGetSalario() {
    PessoaFuncionaria objTeste =
        new PessoaFuncionaria("Maria da Silva", "158.699.457-31", "Rua da Aurora, 118", 15000);
    assertEquals(15000.0, objTeste.getSalario());
  }

  @Test
  @DisplayName("8 - Crie um método setter para o atributo salario de PessoaFuncionaria.")
  public void testeSetSalario() {
    PessoaFuncionaria objTeste =
        new PessoaFuncionaria("Maria da Silva", "158.699.457-31", "Rua da Aurora, 118", 15000);
    objTeste.setSalario(20000);
    assertEquals(20000.0, objTeste.getSalario());
  }


}
