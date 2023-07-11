package com.trybe.acc.java.gerenciadorestoque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.junit.jupiter.Container;

class ContainerTest {

  @Container
  public static DockerComposeContainer container =
      new DockerComposeContainer(new File("docker-compose.yml"))
          .withServices("mongo_db", "application").withLocalCompose(false)
          .withExposedService("mongo_db_1", 27017).withExposedService("application_1", 8080);

  @Test
  @DisplayName("6 - O docker-compose.yml existe.")
  void dockerComposeExiste() {
    File f = new File("docker-compose.yml");
    assertTrue(f.exists());
  }

  @Test
  @DisplayName("7 - O Dockerfile existe.")
  void dockerFileExiste() {
    File f = new File("Dockerfile");
    assertTrue(f.exists());
  }

  @Test
  @DisplayName("8 - O Dockerfile é multi-stage.")
  void dockerFileMultiStage() {
    File f = new File("Dockerfile");

    try {
      Scanner scanner = new Scanner(f);
      int fromCount = 0;
      int copyCount = 0;
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (line.contains("FROM")) {
          fromCount++;
        } else if (line.contains("COPY")) {
          copyCount++;
        }
      }
      scanner.close();

      assertTrue(fromCount >= 2);
      assertTrue(copyCount >= 2);
    } catch (FileNotFoundException e) {
      fail("file Dockerfile not found");
      e.printStackTrace();
    }
  }

  @Test
  @DisplayName("9 - O arquivo de teste contém a configuração do MongoDBContainer.")
  void arquivoTesteContemConfiguracaoMongoDBContainer() {
    File f =
        new File("src/test/java/com/trybe/acc/java/gerenciadorestoque/PedidoRepositoryTest.java");

    try {
      Scanner scanner = new Scanner(f);
      boolean found = false;
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (line.contains("new MongoDBContainer(")) {
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
