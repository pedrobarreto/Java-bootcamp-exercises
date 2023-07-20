package com.trybe.acc.java.caixaeletronico;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste dos métodos da classe PessoaCliente")
class PessoaClienteTest {

  @Test
  @DisplayName("12 - Testa o construtor da classe Pessoa Cliente.")
  void construtorTest() {
    PessoaCliente cliente = new PessoaCliente("Pedro Barreto", "00526386002", "1234");
    assertEquals("Pedro Barreto", cliente.nomeCompleto);

  }

  @Test
  @DisplayName("13 - Testa o método adicionar conta e o método retornar número de contas.")
  void adicionarContaTestRetornaNumeroDeContasTest() {
    PessoaCliente cliente = new PessoaCliente("Pedro Barreto", "00526386002", "1234");
    cliente.adicionarConta("Corrente", cliente);
    cliente.adicionarConta("Poupança", cliente);
    assertEquals(2, cliente.retornaNumeroDeContas());


  }

  @Test
  @DisplayName("14 - Testa o método retornar saldo de uma conta específica da pessoa cliente.")
  void retornarSaldoContaEspecificaTest() {
    PessoaCliente cliente = new PessoaCliente("Pedro Barreto", "00526386002", "1234");
    cliente.adicionarConta("Corrente", cliente);
    cliente.adicionarTransacaoContaEspecifica(0, 500.0, "deposito");
    assertEquals(500.0, cliente.retornarSaldoContaEspecifica(0));


  }


  @Test
  @DisplayName("15 - Testa o método retornar id de uma conta específica da pessoa cliente.")
  void retornarIdContaEspecificaTest() {
    PessoaCliente cliente = new PessoaCliente("Pedro Barreto", "00526386002", "1234");
    cliente.adicionarConta("Corrente", cliente);
    assertNotNull(cliente.retornarIdContaEspecifica(0));

  }

  @Test
  @DisplayName("16 - Testa o método retornar o extrato de uma conta específica da pessoa cliente.")
  void retornarExtratoContaEspecificaTest() {
    PessoaCliente cliente = new PessoaCliente("Pedro Barreto", "00526386002", "1234");
    cliente.adicionarConta("Corrente", cliente);


  }

  @Test
  @DisplayName("17 - Testa o método adiciona transacao de uma conta específica da pessoa cliente.")
  void adicionarTransacaoContaEspecificaTest() {
    PessoaCliente cliente = new PessoaCliente("Pedro Barreto", "00526386002", "1234");
    cliente.adicionarConta("Corrente", cliente);
    assertThrows(IndexOutOfBoundsException.class, () -> {
      cliente.adicionarTransacaoContaEspecifica(2, 500.0, "descricao");
    });

  }

  @Test
  @DisplayName("18 - Testa o método validar senha.")
  void validarSenhaTest() {
    PessoaCliente cliente = new PessoaCliente("Pedro Barreto", "00526386002", "1234");
    assertEquals(true, cliente.validarSenha("1234"));

  }

  @Test
  @DisplayName("19 - Testa o método retornar resumo contas.")
  void retornarResumoContasTest() {

    Banco banco = new Banco();
    PessoaCliente cliente = new PessoaCliente("Pedro Barreto", "00526386002", "1234");
    PessoaCliente clienteInvalido = banco.pessoaClienteLogin("00000000", "123");
    assertThrows(NullPointerException.class, () -> {
      clienteInvalido.retornarResumoContas();
    });

  }

  @Test
  @DisplayName("20 - Testa o método Getter do atributo cpf está retornando.")
  void getCpfTest() {
    PessoaCliente cliente = new PessoaCliente("Pedro Barreto", "00526386002", "1234");

    assertEquals("00526386002", cliente.getCpf());


  }

}
