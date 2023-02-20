package com.trybe.acc.java.anobissexto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnoBissextoTest {

  @Test
  @DisplayName("1 - Verifica se o método `identificarAnoBissexto` retorna `false` quando recebe `2021` como parâmetro")
  public void testeIdentificarAnoBissexto2021() {
    AnoBissexto anoBissexto = new AnoBissexto();
    assertEquals(false, anoBissexto.identificarAnoBissexto(2021));
  }

  @Test
  @DisplayName("2 - Verifica se o método `identificarAnoBissexto` retorna `true` quando recebe `2024` como parâmetro")
  public void testeIdentificarAnoBissexto2024() {
    AnoBissexto anoBissexto = new AnoBissexto();
    assertEquals(true, anoBissexto.identificarAnoBissexto(2024));
  }

  @Test
  @DisplayName("3 - Verifica se o método `identificarAnoBissexto` retorna `false` quando recebe `1901` como parâmetro")
  public void testeIdentificarAnoBissexto1901() {
    AnoBissexto anoBissexto = new AnoBissexto();
    assertEquals(false, anoBissexto.identificarAnoBissexto(1901));
  }

  @Test
  @DisplayName("4 - Verifica se o método `identificarAnoBissexto` retorna `true` quando recebe `1904` como parâmetro")
  public void testeIdentificarAnoBissexto1904() {
    AnoBissexto anoBissexto = new AnoBissexto();
    assertEquals(true, anoBissexto.identificarAnoBissexto(1904));
  }

  @Test
  @DisplayName("5 - Verifica se o método `identificarProximoAnoBissexto` retorna `2024` quando recebe `\"22/12/2021\"` como parâmetro")
  public void testeIdentificarProximoAnoBissexto2021() {
    AnoBissexto anoBissexto = new AnoBissexto();
    assertEquals(2024, anoBissexto.identificarProximoAnoBissexto("22/12/2021"));
  }

  @Test
  @DisplayName("6 - Verifica se o método `identificarProximoAnoBissexto` retorna `1904` quando recebe `\"13/02/1901\"` como parâmetro")
  public void testeIdentificarProximoAnoBissexto1901() {
    AnoBissexto anoBissexto = new AnoBissexto();
    assertEquals(1904, anoBissexto.identificarProximoAnoBissexto("13/02/1901"));
  }

}
