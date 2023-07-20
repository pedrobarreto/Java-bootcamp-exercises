package com.trybe.acc.java.caixaeletronico;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste da classe Conta")
class ContaTest {

  @Test
  @DisplayName("6 - Testa o construtor da classe conta.")
  void construtorTest() {
    Banco banco = new Banco();
    PessoaCliente cliente = banco.adicionarPessoaCliente("Pedro Barreto", "00526386002", "1234");
    Conta conta = new Conta("Corrente", cliente);
    assertEquals("Corrente", conta.tipoConta);
  }

  @Test
  @DisplayName("7 - Testa o método adicionar transação e retornar saldo da conta.")
  void adicionarTransacaoTestRetornarSaldoTest() {
    Banco banco = new Banco();
    PessoaCliente cliente = banco.adicionarPessoaCliente("Pedro Barreto", "00526386002", "1234");
    Conta conta = new Conta("Corrente", cliente);
    conta.adicionarTransacao(500.0, "depósito");
    assertEquals(500.0, conta.retornarSaldo());


  }

  @Test
  @DisplayName("8 - Testa o método retornar resumo está retornando uma string com os valores corretamente.")
  void retornarResumoContaTest() {
    Banco banco = new Banco();
    PessoaCliente cliente = banco.adicionarPessoaCliente("Pedro Barreto", "00526386002", "1234");
    Conta conta = new Conta("Corrente", cliente);
    conta.adicionarTransacao(500.0, "depósito");
    assertTrue(conta.retornarResumoConta().contains("R$ 500.0 : Corrente"));

  }

  @Test
  @DisplayName("9 - Testa o método retornar extrato está imprimindo os valores corretamente.")
  void retornarExtratoTest() {
    Banco banco = new Banco();
    PessoaCliente cliente = banco.adicionarPessoaCliente("Pedro Barreto", "00526386002", "1234");
    Conta conta = new Conta("Corrente", cliente);

    assertThrows(NullPointerException.class, () -> {
      conta.retornarExtrato();
    });


  }

  @Test
  @DisplayName("10 - Testa o método Getter do atributo idConta está retornando.")
  void getIdContaTest() {
    Banco banco = new Banco();
    PessoaCliente cliente = banco.adicionarPessoaCliente("Pedro Barreto", "00526386002", "1234");
    Conta conta = new Conta("Corrente", cliente);
    assertNotNull(conta.getIdConta());

  }

  @Test
  @DisplayName("11 - Testa o método método Getter do atributo pessoaCliente está retornando.")
  void getPessoaClienteTest() {
    Banco banco = new Banco();
    PessoaCliente cliente = banco.adicionarPessoaCliente("Pedro Barreto", "00526386002", "1234");
    Conta conta = new Conta("Corrente", cliente);
    assertEquals(cliente, conta.getPessoaCliente());
  }

}
