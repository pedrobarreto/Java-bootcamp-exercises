package com.trybe.acc.java;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LampadaTest {
	
	@Test
	@DisplayName("1 - A aplicação testa se o valor do estado da lâmpada é passado")
	public void testeMain() {
		
	     String esperado = "A lampada ligada: true!";
	     
	     ByteArrayOutputStream baos = new ByteArrayOutputStream();
	     PrintStream printStream = new PrintStream(baos);
	     System.setOut(printStream);

	     Lampada.main(null);

	     String[] linha = baos.toString().split(System.lineSeparator());
	     String saida = linha[linha.length-1];
	     
	     assertEquals(esperado,saida);
    
	     
	}
}
