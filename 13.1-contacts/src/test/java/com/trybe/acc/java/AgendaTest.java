package com.trybe.acc.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AgendaTest {
	Agenda agenda = new Agenda();

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
		agenda.incluirContato("João");
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
		agenda.incluirContato("João");
		assertTrue(agenda.verificaContato("João"));
		agenda.incluirContato("João");
		assertTrue(agenda.verificaContato("João"));
		agenda.excluirContato("João");
		assertTrue(agenda.verificaContato("João"));
	}
	
	@Test
	@DisplayName("Isolamento")
	void testIsolamento() {
		agenda.incluirContato("João");
		assertEquals(1, agenda.tamanhoAgenda());
		assertEquals(0, new Agenda().tamanhoAgenda());
		assertTrue(agenda.verificaContato("João"));
		agenda.incluirContato("João");
		assertEquals(2, agenda.tamanhoAgenda());
		agenda.excluirContato("João");
		assertEquals(1, agenda.tamanhoAgenda());
		assertEquals(0, new Agenda().tamanhoAgenda());
	}
}
