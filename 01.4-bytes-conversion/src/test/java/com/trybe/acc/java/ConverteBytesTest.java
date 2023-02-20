package com.trybe.acc.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ConverteBytesTest {
	
	@Test
	@DisplayName("1 - A aplicação pergunta, no terminal, um número")
	public void testeMain() {
		
	     String userInput = String.format("3",
	             System.lineSeparator()       
	     );
	     
	     ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
	     System.setIn(bais);

	     String esperado = "3 bytes correspodem a 24 bits";
	     
	     ByteArrayOutputStream baos = new ByteArrayOutputStream();
	     PrintStream printStream = new PrintStream(baos);
	     System.setOut(printStream);

	     ConverteBytes.main(null);

	     String[] linha = baos.toString().split(System.lineSeparator());
	     String saida = linha[linha.length-1];
	     
	     assertEquals(esperado,saida);
    
	     
	}
}
