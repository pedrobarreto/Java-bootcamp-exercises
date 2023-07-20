package com.trybe.acc.java.caixaeletronico;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes para a classe Banco")
class BancoTest {

  Banco banco = new Banco();

  @Test
  @DisplayName("1 - Testa o gerador de número único para nova conta.")
  void gerarNumeroNovaContaTest() {
    String novaConta = banco.gerarNumeroNovaConta();
    assertNotNull(novaConta);
  }

  @Test
  @DisplayName("2 - Testa o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {
    banco.adicionarPessoaCliente("Pedro Barreto", "00526386002", "1234");

  }

  @Test
  @DisplayName("3 - Testa o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    banco.adicionarPessoaCliente("Pedro Barreto", "00526386002", "1234");
    PessoaCliente cliente = banco.pessoaClienteLogin("00526386002", "1234");
    assertEquals("00526386002", cliente.getCpf());

  }

  @Test
  @DisplayName("4 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    Banco banco = new Banco();
    PessoaCliente cliente = banco.adicionarPessoaCliente("Pedro Barreto", "00526386002", "1234");
    cliente.adicionarConta("Corrente", cliente);
    cliente.adicionarConta("Poupança", cliente);
    cliente.adicionarTransacaoContaEspecifica(0, 500, "depósito");
    banco.transferirFundos(cliente, 0, 1, 100);
    assertEquals(400, cliente.retornarSaldoContaEspecifica(0));
    assertEquals(100, cliente.retornarSaldoContaEspecifica(1));

  }

  @Test
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    Banco banco = new Banco();
    PessoaCliente cliente = banco.adicionarPessoaCliente("Pedro Barreto", "00526386002", "1234");
    cliente.adicionarConta("Corrente", cliente);
    cliente.adicionarTransacaoContaEspecifica(0, 500, "depósito");
    banco.sacar(cliente, 0, 300);
    assertEquals(200, cliente.retornarSaldoContaEspecifica(0));

  }

}
