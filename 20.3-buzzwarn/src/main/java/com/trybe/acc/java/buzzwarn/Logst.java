package com.trybe.acc.java.buzzwarn;

import org.apache.logging.log4j.Logger;

public class Logst {

  private Logger logging;

  public Logst(Logger log) {
    this.logging = log;
  }

  private boolean mul(int x, int y) {
    return x % y == 0;
  }

  /**
   * CountLogger. Insira sua lógica aqui.
   */
  public void countLogger() {

    for (int x = 1; x <= 30; x += 1) {
      if (mul(x, 3) && mul(x, 5)) {
        logging.warn(x);
      } else if (mul(x, 5)) {
        logging.debug(x);
      } else if (mul(x, 3)) {
        logging.trace(x);
      } else {
        logging.info(x);
      }

    }

  }
}
