package com.trybe.calcularidade.exception;

import javax.xml.crypto.Data;

/**
 * Classe DataError.
 */
public class DataError extends RuntimeException {
  private String error;

  /**
   * Instantiates a new Data error.
   *
   * @param error the error
   */
  public DataError(String error) {
    this.error = error;
  }

  /**
   * Gets error.
   *
   * @return the error
   */
  public String getError() {
    return error;
  }

  /**
   * Sets error.
   *
   * @param error the error
   */
  public void setError(String error) {
    this.error = error;
  }
}
