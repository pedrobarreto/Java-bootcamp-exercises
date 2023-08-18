package com.trybe.calcularidade.controller;

import com.trybe.calcularidade.exception.ArgumentoIlegalException;
import com.trybe.calcularidade.exception.DataFuturaException;
import com.trybe.calcularidade.exception.DataInvalidaException;
import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Classe GerenciadorAdvice.
 */
@ControllerAdvice
public class GerenciadorAdvice {
  /**
   * Handler bad request response entity.
   *
   * @param exception the exception
   * @return the response entity
   */
  @ExceptionHandler({DataFuturaException.class, DataInvalidaException.class})
  public ResponseEntity<HashMap<String, String>> handlerBadRequest(RuntimeException exception) {
    HashMap<String, String> response = new HashMap<>();
    response.put("error", exception.getMessage());
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(response);

  }

  /**
   * Handler internal server error.
   *
   * @param exception the exception
   * @return response entity
   */
  @ExceptionHandler(ArgumentoIlegalException.class)
  public ResponseEntity<HashMap<String, String>> handlerInternalServerError(
      RuntimeException exception) {
    HashMap<String, String> response = new HashMap<>();
    response.put("error", exception.getMessage());
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(response);
  }
}
