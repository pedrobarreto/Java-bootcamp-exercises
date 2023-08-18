package com.trybe.calcularidade.exception;

/**
 * Classe ArgumentoIlegalException.
 */
@SuppressWarnings("serial")
public class ArgumentoIlegalException extends RuntimeException {
  /**
   * Instantiates a new Argumento ilegal exception.
   *
   * @param msg the msg
   */
  public ArgumentoIlegalException(String msg) {
    super(msg);
  }
}
