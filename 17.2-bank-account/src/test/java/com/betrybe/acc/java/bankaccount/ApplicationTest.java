package com.betrybe.acc.java.bankaccount;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest {

  @Test
  @DisplayName("6 - Executa o método main com sucesso.")
  public void successExecution() {
    String userInput = "448";
    ByteArrayInputStream consoleInput = new ByteArrayInputStream(userInput.getBytes());
    System.setIn(consoleInput);

    ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(consoleOutput);
    System.setOut(printStream);

    Application.main(null);

    String[] lines = consoleOutput.toString().split(System.lineSeparator());
    String finalOutput = lines[lines.length - 1];

    assertEquals("Numero da conta: 000448", finalOutput);
  }
}