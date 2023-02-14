package com.trybe.acc.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ImcTest {
	@Test
	@DisplayName("1 - A aplicação pergunta, no terminal, o peso e a altura")
	public void testeMain() {
		
	     String userInput = String.format("54.0%s1.70",
	             System.lineSeparator(),
	             System.lineSeparator()     
	     );
	     
	     ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
	     System.setIn(bais);

	     String esperado = "18.68512";
	     
	     ByteArrayOutputStream baos = new ByteArrayOutputStream();
	     PrintStream printStream = new PrintStream(baos);
	     System.setOut(printStream);

	     Imc.main(null);

	     String[] linha = baos.toString().split(System.lineSeparator());
	     String saida = linha[linha.length-1];
	     
	     assertEquals(esperado,saida);
    
	     
	}
}
