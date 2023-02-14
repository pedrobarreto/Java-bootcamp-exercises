package com.trybe.idadeemdias;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import com.trybe.idadeemdias.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	@DisplayName("5 - A aplicação pergunta, no terminal, nome e idade e retorna a idade em dias")
	public void testeMain() {
		
	     String userInput = String.format("Paulo%s31%s2%s29",
	             System.lineSeparator(),
	             System.lineSeparator(),
	             System.lineSeparator()
	     );
	     
	     ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
	     System.setIn(bais);

	     String esperado = "Olá Paulo, sua idade em dias é 11404";
	     
	     ByteArrayOutputStream baos = new ByteArrayOutputStream();
	     PrintStream printStream = new PrintStream(baos);
	     System.setOut(printStream);

	     Main.main(null);

	     String[] linha = baos.toString().split(System.lineSeparator());
	     String saida = linha[linha.length-1];
	     
	     assertEquals(esperado,saida);
	     
	     
	     
	}

}
