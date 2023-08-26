package com.trybe.acc.java.buzzwarn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
  private static final Logger LOGGING = LogManager.getLogger(App.class);


  /**
   * Método main.
   */
  public static void main(String[] args) {
    LOGGING.error("Este projeto é apenas para o teste!");
    Logst listener = new Logst(LOGGING);
    listener.countLogger();
  }
}
