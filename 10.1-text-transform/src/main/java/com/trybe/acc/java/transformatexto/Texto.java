package com.trybe.acc.java.transformatexto;

public class Texto {

  /**
   * Classe de transformar texto.
   */
  public String transformaTexto(String frase) {


    String novaFrase = frase.replaceAll("\\+", " ");
    String[] palavras = novaFrase.split(" ");

    boolean ehPar = (novaFrase.indexOf('a') % 2) == 0;


    if (ehPar) {

      return frase.toUpperCase();

    } else {

      return palavras[0];

    }

  }


}
