package com.trybe.acc.java.sistemarh;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

@DisplayName("Teste de verificação de cobertura do projeto.")
public class CoverageValidationTest {

  @Test
  @DisplayName("9 - A cobertura de teste deve ser maior que 90%")
  public void testCoverage() throws ParserConfigurationException, SAXException, IOException,
      InterruptedException, XPathExpressionException {

    try {
      String[] commands =
          {"./mvnw clean", "./mvnw package -DskipCoverage=true -Dmaven.test.failure.ignore=true"};
      int status = 0;
      for (String command : commands) {
        Process p = Runtime.getRuntime().exec(command);
        status = p.waitFor();
      }

      if (status == 0) {
        File file = new File("target/site/jacoco/jacoco.xml");
        Map<String, Object> result = new XmlParser().parseToMap(file);
        @SuppressWarnings("unchecked")
        List<Map<String, String>> evaluations = (List<Map<String, String>>) result.get("counters");

        Map<String, String> sample = evaluations.stream()
            .filter(eval -> eval.get("type").equals("LINE")).collect(Collectors.toList()).get(0);

        Double percentage = Double.parseDouble(sample.get("percentage"));

        if (percentage <= 90) {
          fail("Expected: Test coverage > 90% but was " + percentage + "%");
        } else {
          assertTrue(percentage > 90);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();

      fail("Arquivo de cobertura não encontrado. Faça os testes passarem antes!");
    }
  }
}
