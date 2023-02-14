package com.trybe.acc.java.numerosaleatorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumerosAleatoriosMock extends NumerosAleatorios {
  int pos = 0;
  int[] resultados = {1, 3, 2, 5, 2, 5, 2, 2, 1, 1, 3, 1, 5, 4, 5};

  @Override
  int entreUmECinco() {
    int ret = resultados[pos];
    pos++;

    return ret;
  }
}


public class NumerosAleatoriosTest {
  @Test
  @DisplayName("1 - Testando a geração dos números aleatórios")
  public void mainTest() {

    PrintStream oldOut = System.out;
    ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(capturedOut));

    NumerosAleatoriosMock mock = new NumerosAleatoriosMock();
    NumerosAleatorios.numerosAleatorios = mock;

    String expected = "";

    for (int n : mock.resultados) {
      expected += String.valueOf(n) + System.lineSeparator();

      if (n == 4)
        break;
    }

    NumerosAleatorios.main(null);
    assertEquals(expected, capturedOut.toString());

    System.setOut(oldOut);
  }
}
