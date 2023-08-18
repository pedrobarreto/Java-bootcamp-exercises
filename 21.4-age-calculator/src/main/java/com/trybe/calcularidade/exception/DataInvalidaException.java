package com.trybe.calcularidade.exception;

/**
 * Classe DataInvalidaException.
 */
@SuppressWarnings("serial")
public class DataInvalidaException extends RuntimeException {

  /**
   * Instantiates a new Data invalida exception.
   *
   * @param msg the msg
   */
  public DataInvalidaException(String msg) {
    super(msg);
  }
}
