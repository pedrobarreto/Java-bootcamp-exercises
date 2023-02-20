package com.trybe.acc.java.excecaomaioridade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

public class ShowTest {

  @Test
  @DisplayName("1 - Lançar exceção quando pessoa for menor de idade")
  public void deveLancarExcecaoQuandoPessoaMenorDeIdade() {
    // Using try/catch with string assertion to avoid compilation errors,
    // because at first the exception class will not exist
    boolean failedToThrowAnything = false;

    try {
      var show = new Show();
      show.permitirEntrada(17);

      // If we got here, the method is not throwing anything
      failedToThrowAnything = true;
    } catch (RuntimeException e) {
      throw new AssertionFailedError("Exceção deve ser do tipo 'checked'", null, null);
    } catch (Exception e) {
      Assertions.assertEquals("PessoaMenorDeIdadeException", e.getClass().getSimpleName());
    } catch (Throwable e) {
      throw new AssertionFailedError("Exceção deve herdar de Exception", null, null);
    }

    if (failedToThrowAnything) {
      throw new AssertionFailedError("Exceção deve ser lançada quando menor de idade", null, null);
    }
  }
}
