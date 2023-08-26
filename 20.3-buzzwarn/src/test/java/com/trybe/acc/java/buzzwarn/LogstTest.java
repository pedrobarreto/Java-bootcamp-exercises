package com.trybe.acc.java.buzzwarn;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.CharArrayWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.StringLayout;
import org.apache.logging.log4j.core.appender.WriterAppender;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LogstTest {

  private static final String APPENDER_NAME = "log4jRuleAppender";

  /**
   * Logged messages contains level and message only. This allows us to test that level and message
   * are set.
   */
  private static final String PATTERN = "%msg%-5level ";

  private Logger logger = (Logger) org.apache.logging.log4j.LogManager.getLogger(App.class);

  private Appender appender;
  private final CharArrayWriter outContent = new CharArrayWriter();

  private boolean mul(int x, int y) {
    return x % y == 0;
  }

  @BeforeEach
  public void before() {
    StringLayout layout = PatternLayout.newBuilder().withPattern(PATTERN).build();
    appender = WriterAppender.newBuilder().setTarget(outContent).setLayout(layout)
        .setName(APPENDER_NAME).build();
    appender.start();
    logger.addAppender(appender);
  }

  @Test
  @DisplayName("1 - O método countLogger() deve gerar o log conforme o enunciado.")
  public void countLoggerDeveLogarCorretamente() {
    Logst listener = new Logst(logger);
    listener.countLogger();
    String strCheck = "";
    for (int x = 1; x <= 30; x++) {
      if (mul(x, 3) && mul(x, 5)) {
        strCheck = strCheck + x + "WARN";
      } else if (mul(x, 5)) {
        strCheck = strCheck + x + "DEBUG";
      } else if (mul(x, 3)) {
        strCheck = strCheck + x + "TRACE";
      } else {
        strCheck = strCheck + x + "INFO";
      }

      strCheck = strCheck + " ";

    }

    Collection<String> expected = new ArrayList<String>(Arrays.asList(strCheck.split(" "))).stream()
        .map(String::trim).collect(Collectors.toList());;
    Collection<String> response =
        new ArrayList<String>(Arrays.asList(outContent.toString().split(" "))).stream()
            .map(String::trim).collect(Collectors.toList());;

    expected.removeAll(response);
    assertTrue(expected.isEmpty());
  }

  @AfterEach
  void after() {
    logger.removeAppender(appender);
  }
}
