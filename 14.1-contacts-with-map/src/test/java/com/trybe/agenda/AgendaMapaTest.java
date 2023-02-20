package com.trybe.agenda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AgendaMapaTest {

  AgendaMapa agenda = new AgendaMapa();

  @Test
  @DisplayName("Inicial")
  void testInit() {
    assertEquals(0, agenda.tamanhoAgenda());
    assertFalse(agenda.verificaContato("Maria"));
    agenda.excluirContato("Maria");
  }

  @Test
  @DisplayName("Inclusao")
  void testInclusao() {
    agenda.incluirContato("João", "88889999");
    assertFalse(agenda.verificaContato("Maria"));
    assertTrue(agenda.verificaContato("João"));
    agenda.excluirContato("Maria");
    assertTrue(agenda.verificaContato("João"));
    agenda.excluirContato("João");
    assertFalse(agenda.verificaContato("João"));
  }

  @Test
  @DisplayName("Repeticao")
  void testRepeticao() {
    agenda.incluirContato("João", "88889999");
    assertTrue(agenda.verificaContato("João"));
    agenda.atualizarTelefone("João", "77779999");
    assertTrue(agenda.verificaContato("João"));
    agenda.excluirContato("João");
    assertFalse(agenda.verificaContato("João"));
  }

  @Test
  @DisplayName("Isolamento")
  void testIsolamento() {
    agenda.incluirContato("João", "88889999");
    assertEquals(1, agenda.tamanhoAgenda());
    assertEquals(0, new AgendaMapa().tamanhoAgenda());
    assertTrue(agenda.verificaContato("João"));
    agenda.atualizarTelefone("João", "77779999");
    assertEquals(1, agenda.tamanhoAgenda());
    assertEquals(0, new AgendaMapa().tamanhoAgenda());
    assertEquals("77779999", agenda.obterTelefone("João"));
    agenda.excluirContato("João");
  }

  @Test
  @DisplayName("Atualizacao")
  void testAtualizacao() {
    agenda.incluirContato("João", "88889999");
    assertEquals("88889999", agenda.obterTelefone("João"));
    agenda.atualizarTelefone("João", "77779999");
    assertEquals("77779999", agenda.obterTelefone("João"));
    agenda.excluirContato("João");
    assertNull(agenda.obterTelefone("João"));
  }

}
