package com.trybe.acc.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class SomaValoresTest {
	@Test
	@DisplayName("1 - A aplicação testa se o resultado da soma dos elementos está correta")
	public void testeMain() {
		
    String userInput = String.format("2%s4%s5",
            System.lineSeparator(),
            System.lineSeparator(),
            System.lineSeparator()
    );
    
    ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
    System.setIn(bais);

    String esperado = "A soma é: 11";
    
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    SomaValores.main(null);

    String[] linha = baos.toString().split(System.lineSeparator());
    String saida = linha[linha.length-1];
    
    assertEquals(esperado,saida);
 
    
  }
}
