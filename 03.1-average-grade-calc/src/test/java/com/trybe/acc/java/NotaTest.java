package com.trybe.acc.java;

import com.trybe.acc.java.Nota;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NotaTest {

	@Test
	@DisplayName("2 - Escreva uma classe com o nome Nota")
	public void testNotaClassname() {
		Nota n = new Nota();
		assertEquals("Nota", n.getClass().getSimpleName());
	}
	@Test
	@DisplayName("3 - Escreva um método que calcule a média anual da pessoa")
	public void testCalcularMedia1() {
		Nota n = new Nota();
		assertEquals(9.52, n.calcularMedia(9.85, 9.58, 9.90, 8.75), 0.001);
	}
	
	@Test
	@DisplayName("5 - Faça com que o programa retorne a saída esperada")
	public void testCalcularMedia2() {
		Nota n = new Nota();
		assertEquals(8.2625, n.calcularMedia(7.80, 6.5, 10.00, 8.75), 0.001);
	}

	@Test
	@DisplayName("4 - Faça com que o cálculo da média retorne um valor do tipo Double")
	public void testCalcularMediaReturnType() {
		Nota n = new Nota();
		assertTrue(Double.class.isInstance(n.calcularMedia(7.80, 6.5, 10.00, 8.75)));
	}

	
}
