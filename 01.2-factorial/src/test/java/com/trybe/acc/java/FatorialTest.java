package com.trybe.acc.java;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FatorialTest {
	@Test
	@DisplayName("1 - A aplicação testa se o fatorial de 18 está correto")
	public void testeMain() {
		
	    
	     String esperado = "O fatorial de 18 é igual a 6402373705728000";
	     
	     ByteArrayOutputStream baos = new ByteArrayOutputStream();
	     PrintStream printStream = new PrintStream(baos);
	     System.setOut(printStream);

	     Fatorial.main(null);

	     String[] linha = baos.toString().split(System.lineSeparator());
	     String saida = linha[linha.length-1];
	     
	     assertEquals(esperado,saida);

	}
}
