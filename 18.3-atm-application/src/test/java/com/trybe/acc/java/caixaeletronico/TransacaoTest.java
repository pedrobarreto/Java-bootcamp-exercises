package com.trybe.acc.java.caixaeletronico;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes dos métodos da classe Transacao")
class TransacaoTest {


  @Test
  @DisplayName("21 - Testa o método construtor da classe Transacao.")
  void construtorTest() {
    Transacao transacao = new Transacao(500.0, "teste de transação");
    assertEquals("teste de transação", transacao.descricao);
    assertEquals(500.0, transacao.quantia);

  }


  @Test
  @DisplayName("22 - Testa o método Getter do atributo quantia.")
  void getQuantiaTest() {
    Transacao transacao = new Transacao(500.0, "teste de transação");
    assertEquals(500.0, transacao.getQuantia());

  }

  @Test
  @DisplayName("23 - Testa o método retornar resumo transacao.")
  void retornarResumoTransacaoTest() {
    Transacao transacao = new Transacao(700.0, "teste de transação");
    assertTrue(transacao.retornarResumoTransacao().contains("teste de transação R$ 700.0"));

  }

  @Test
  @DisplayName("24 - Testa o método instante está gerando o instante corretamente.")
  void retornarInstanteTest() {
    Transacao transacao = new Transacao(700.0, "teste de transação");
    assertNotNull(transacao.retornarInstante());

  }

}
