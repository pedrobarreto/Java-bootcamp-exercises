package com.trybe.idadeemdias;

import static org.junit.jupiter.api.Assertions.*;
import com.trybe.idadeemdias.Pessoa;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PessoaTest {

	@Test
	@DisplayName("1 - Escreva uma classe com o nome Pessoa")
	public void testPessoaClassname() {
		Pessoa p = new Pessoa();
		assertEquals("Pessoa", p.getClass().getSimpleName());
	}

	@Test
	@DisplayName("2 - Escreva um método que calcule a idade de Pessoa em dias")
	public void testCalcularIdadeEmDias1() {
		Pessoa p = new Pessoa();
		assertEquals(11769, p.calcularIdadeEmDias(32, 2, 29));
	}

	@Test
	@DisplayName("3 - Faça com que o cálculo da idade retorne um valor do tipo inteiro")
	public void testCalcularIdadeEmDias2() {
		Pessoa p = new Pessoa();
		assertEquals(11404, p.calcularIdadeEmDias(31, 2, 29));
	}

	@Test
	@DisplayName("4 - Faça com que o programa retorne a saída esperada")
	public void testCalcularIdadeEmDiasReturnType() {
		Pessoa p = new Pessoa();
		assertTrue(Integer.class.isInstance(p.calcularIdadeEmDias(32, 2, 29)));
	}

}
