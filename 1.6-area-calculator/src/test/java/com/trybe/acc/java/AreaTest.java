package com.trybe.acc.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AreaTest {
  @Test
  @DisplayName("1 - A aplicação pergunta, no terminal, a medida do lado do quadrado")
  public void testeMain() {

    String userInput = String.format("3.0", System.lineSeparator());

    ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
    System.setIn(bais);

    String esperado = "A area do quadrado de lado 3.0 é igual a 9.0";

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    Area.main(null);

    String[] linha = baos.toString().split(System.lineSeparator());
    String saida = linha[linha.length - 1];

    assertEquals(esperado, saida);


  }
}
