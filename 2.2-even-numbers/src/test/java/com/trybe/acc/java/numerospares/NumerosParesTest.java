package com.trybe.acc.java.numerospares;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumerosParesTest {
  @Test
  @DisplayName("1 - Testar a impressão dos números de 4 a 20")
  public void mainTest() {
    PrintStream oldOut = System.out;
    ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(capturedOut));

    String expected = "";

    for (int n = 4; n <= 20; n += 2) {
      expected += String.valueOf(n) + System.lineSeparator();
    }

    NumerosPares.main(null);
    assertEquals(expected, capturedOut.toString());

    System.setOut(oldOut);
  }
}
