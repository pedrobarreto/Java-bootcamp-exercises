package com.betrybe.acc.java.bankaccount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectTest {

  @Test
  @DisplayName("1 - Verifica se o projeto tem o Apache Commons como dependência.")
  public void testIfProjectContainsApacheCommonsDependency() {
    try {
      File pom = new File("build.gradle");
      BufferedReader reader = new BufferedReader(new FileReader(pom));

      boolean isValid = false;
      String line;
      while ((line = reader.readLine()) != null && !isValid) {
        System.out.println(line);
        isValid = line.contains("commons-lang3");
      }
      assertTrue(isValid);
    } catch (Exception error) {
      error.printStackTrace();
      assertFalse(true);
    }
  }

  @Test
  @DisplayName("2 - Verifica se existe o arquivo build.gradle.")
  public void testIfProjectContainsDependyManager() {
    try {
      File pom = new File("build.gradle");
      assertTrue(pom.exists());
    } catch (Exception error) {
      assertFalse(true);
    }
  }

}