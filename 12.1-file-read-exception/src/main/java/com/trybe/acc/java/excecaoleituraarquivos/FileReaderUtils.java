package com.trybe.acc.java.excecaoleituraarquivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe do desafio.
 */
public class FileReaderUtils {

  /**
   * Retorna a primeira linha de um arquivo.
   */
  public String getFirstLine() throws FileNotFoundException {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("arquivo_nao_existente.txt"));
      try {
        return reader.lines().findFirst().get();
      } finally {
        try {
          reader.close();
        } catch (IOException e) {
          System.out.println(e);
        }
      }
    } catch (FileNotFoundException e) {
      return "Arquivo não existe";
    }
  }

}
