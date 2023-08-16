package com.trybe.acc.java.minhasseries.exceptions;

/**
 * The type Serie existente exception.
 */
public class SerieExistenteException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new Serie existente exception.
   *
   * @param message the message
   */
  public SerieExistenteException(String message) {
    super(message);
  }
}

