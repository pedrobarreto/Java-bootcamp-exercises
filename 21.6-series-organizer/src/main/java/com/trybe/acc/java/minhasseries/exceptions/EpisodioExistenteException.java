package com.trybe.acc.java.minhasseries.exceptions;

/**
 * The type Episodio existente exception.
 */
public class EpisodioExistenteException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new Episodio existente exception.
   *
   * @param message the message
   */
  public EpisodioExistenteException(String message) {
    super(message);
  }
}

