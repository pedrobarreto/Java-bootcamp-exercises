package com.trybe.acc.java.gradlewar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MessageServiceTest {

  @DisplayName("1 - Verifica o build foi feito com sucesso.")
  @Test
  void testWARGerado() {
    File dir = new File("build/libs");
    File [] files = dir.listFiles(new FilenameFilter() {
      @Override
      public boolean accept(File dir, String name) {
        return name.endsWith(".war");
      }
    });
    assertNotEquals(0, files.length);
  }

  @DisplayName("2 - Valida se as dependências Apache Commons foi inserida.")
  @Test
  void testGradleBuildContemCommons() {
    File file = new File("build.gradle");

    try {
      Scanner scanner = new Scanner(file);
      boolean found = false;
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (!line.contains("//") && line.contains("apache.commons")) {
          found = true;
          break;
        }
      }
      scanner.close();
      assertEquals(true, found);
    } catch (FileNotFoundException e) {
      assertEquals("file build.gradle", "not found");
      e.printStackTrace();
    }
  }

  @DisplayName("3 - Valida se as dependências Google Guava foi inserida.")
  @Test
  void testGradleBuildContemGuava() {
    File file = new File("build.gradle");

    try {
      Scanner scanner = new Scanner(file);
      boolean found = false;
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (!line.contains("//") && line.contains("google.guava")) {
          found = true;
          break;
        }
      }
      scanner.close();
      assertEquals(true, found);
    } catch (FileNotFoundException e) {
      assertEquals("file build.gradle", "not found");
      e.printStackTrace();
    }
  }

}
