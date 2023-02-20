package com.trybe.acc.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimuladorRendimentoTest {

	@Test
	@DisplayName("1 - Escreva um método que calcule o rendimento anual")
	public void testeSimularRendimento() {
		SimuladorRendimento objTeste = new SimuladorRendimento();
		assertEquals(LocalDateTime.now().plusYears(25).getYear(), objTeste.simularRendimentoAnos(500, 5000));
	}
	
	@Test
	@DisplayName("2 - Escreva um método que mostra uma mensagem no console")
	public void testeMain() {
		
	     String esperado = "Com 500.0 seu rendimento será 5000.0 no ano 2047";
	     
	     ByteArrayOutputStream baos = new ByteArrayOutputStream();
	     PrintStream printStream = new PrintStream(baos);
	     System.setOut(printStream);

	     SimuladorRendimento.main(null);

	     String[] linha = baos.toString().split(System.lineSeparator());
	     String saida = linha[linha.length-1];
	     
	     assertEquals(esperado,saida);
	     
	}
}
