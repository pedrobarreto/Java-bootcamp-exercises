package com.trybe.acc.java.minhasseries.exceptions;

/**
 * The type Serie nao encontrada exception.
 */
public class SerieNaoEncontradaException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new Serie nao encontrada exception.
   *
   * @param message the message
   */
  public SerieNaoEncontradaException(String message) {
    super(message);
  }
}

