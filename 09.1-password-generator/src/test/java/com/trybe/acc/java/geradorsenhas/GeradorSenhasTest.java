package com.trybe.acc.java.geradorsenhas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GeradorSenhasTest {
  public static final String[] SENHAS = {"A5$2B55S", "B55SCFFG", "CFFGD&54", "D&54EEDF", "EEDFFEGG",
      "FEGGG15E", "G15EH123", "H123I81F", "I81FJWEF", "JWEF####"};

  public static final Integer NUM_SENHAS = 10;

  private GeradorSenhas gerador = new GeradorSenhas();

  @Test
  @DisplayName("1 - Gerar senha")
  public void deveGerarSenhaCompleta() {
    for (int i = 0; i < NUM_SENHAS; i++) {
      assertEquals(SENHAS[i], gerador.gerarSenhaCompleta(i));
    }
  }

  @Test
  @DisplayName("2 - Escrever senha em arquivo")
  public void deveGerarOsArquivosEEscreverASenha() throws Exception {
    File tempDir = Files.createTempDirectory("gerador_senha").toFile();
    tempDir.deleteOnExit();

    for (int i = 0; i < NUM_SENHAS; i++) {
      String caminho = tempDir.getCanonicalPath() + File.separator + "arquivo_" + i + ".txt";
      File arquivo = new File(caminho);
      arquivo.deleteOnExit();

      String senhaFalsa = "senhafalsa#" + i;
      
      try {
        gerador.escreverSenhaNoArquivo(senhaFalsa, arquivo);
      } catch (IOException e) {
        e.printStackTrace();
      }

      if (arquivo.exists()) {
        FileReader leitorArquivo = new FileReader(arquivo);
        BufferedReader bufferedLeitor = new BufferedReader(leitorArquivo);

        String conteudoLinha = bufferedLeitor.readLine();
        assertEquals(conteudoLinha, senhaFalsa);

        leitorArquivo.close();
        bufferedLeitor.close();
      } else {
        fail();
      }
    }
  }
}
