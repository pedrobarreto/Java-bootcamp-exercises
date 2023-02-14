package com.trybe.acc.java.estadosbrasileiros;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EstadosBrasileirosTest {

  @Test
  @DisplayName("1 - Testando a impressão dos nomes dos estados")
  public void mainTest() {
    PrintStream stdout = System.out;
    ByteArrayOutputStream capturedOut;

    capturedOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(capturedOut));
    EstadosBrasileiros.mostraNomeEstado("CE");
    assertEquals("CEARA" + System.lineSeparator(), capturedOut.toString());

    capturedOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(capturedOut));
    EstadosBrasileiros.mostraNomeEstado("SC");
    assertEquals("SANTA CATARINA" + System.lineSeparator(), capturedOut.toString());

    capturedOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(capturedOut));
    EstadosBrasileiros.mostraNomeEstado("AM");
    assertEquals("AMAZONAS" + System.lineSeparator(), capturedOut.toString());

    System.setOut(stdout);
  }

}
