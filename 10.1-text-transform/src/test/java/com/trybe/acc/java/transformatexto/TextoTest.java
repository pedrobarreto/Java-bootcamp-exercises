package com.trybe.acc.java.transformatexto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TextoTest {

  @Test
  @DisplayName("1 - Utiliza o método replace() para substituir caracter de uma String e o método split() para separar palavras por um caracter.")
  public void dadaUmaFraseRemovaOsEspacosDuplos() {
    String frase = "Lorem+ipsum+dolort+sit+ammet";

    Texto texto = new Texto();
    assertEquals("Lorem", texto.transformaTexto(frase));
  }

  @Test
  @DisplayName("2 - Utiliza o método indexOf() para retornar a posição de um caracter e utiliza o método toUpperCase() para deixar uma String com caixa alta.")
  public void transformaEmMaisculo() {
    String frase = "aaaaaaaaaaa";

    Texto texto = new Texto();

    assertEquals(frase.toUpperCase(), texto.transformaTexto(frase));
  }

  @Test
  @DisplayName("3 - Modifica o texto para caixa alta se a primeira ocorrência do caracter 'a' estiver em índice par.")
  public void transformaEmMaiusculoSePrimeiraLetraAEstiverEmPosicaoPar() {
    String frase = "Loarem ipsum dolort sit ammet";

    Texto texto = new Texto();

    assertEquals(frase.toUpperCase(), texto.transformaTexto(frase));
  }

  @Test
  @DisplayName("4 - Retorna a primeira palavra se a primeira letra 'a' estiver em posição ímpar.")
  public void retornaPrimeiraPalavraSePrimeiraLetraAEstiverEmPosicaoImpar() {
    String frase = "Lorem ipsum dolort sit ammet";

    Texto texto = new Texto();

    assertEquals("Lorem", texto.transformaTexto(frase));
  }

  @Test
  @DisplayName("5 - As regras de espaço, do caracter 'a' e do caracter '+' foram aplicadas em conjunto.")
  public void validaSeAlterouDeSomaParaEspaco() {
    String frase = "---+Lorem+ipsum dolort sit ammet";

    Texto texto = new Texto();

    assertEquals("---", texto.transformaTexto(frase));
  }

}
