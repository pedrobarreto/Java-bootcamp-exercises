package com.trybe.calcularidade.exception;

/**
 * Classe DataFuturaException.
 */
@SuppressWarnings("serial")
public class DataFuturaException extends RuntimeException {
  /**
   * Instantiates a new Data futura exception.
   *
   * @param msg the msg
   */
  public DataFuturaException(String msg) {
    super(msg);
  }
}
