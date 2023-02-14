package com.trybe.acc.java;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest {
	
  @Test
  @DisplayName("1 - Faça com que, no terminal, seja perguntado o nome e as notas da pessoa")
  public void testeMain() {
		
    String userInput = String.format("Carla%s9.85%s9.58%s9.90%s8.75",
	  System.lineSeparator(),
	  System.lineSeparator(),
	  System.lineSeparator(),
	  System.lineSeparator()
	);
	     
	ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
	System.setIn(bais);

	String esperado = "Olá, Carla, sua média é 9.52";
	     
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	PrintStream printStream = new PrintStream(baos);
	System.setOut(printStream);

	Main.main(null);

	String[] linha = baos.toString().split(System.lineSeparator());
	String saida = linha[linha.length-1];
	     
	assertEquals(esperado,saida);
	     	     
  }
}
