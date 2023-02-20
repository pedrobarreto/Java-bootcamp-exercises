package com.trybe.acc.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NullGeneratorTest {

  @Test
  @DisplayName("1 - Em caso de sucesso, retornar o nome correto do método getNome()")
  public void deveRetornarBob() {
    NullGuard guard = new NullGuard();
		
    Assertions.assertEquals(guard.printName(2), "BOB");
  }
	
  @Test
  @DisplayName("2 - Em caso de insucesso, retornar a String 'Nome nulo'")
  public void deveRetornarNomeNulo() {
    NullGuard guard = new NullGuard();
		
    Assertions.assertEquals(guard.printName(3), "Nome nulo");
  }
}
