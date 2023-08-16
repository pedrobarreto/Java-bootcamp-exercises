package com.trybe.acc.java.minhasseries.exceptions;

import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type Global exception controller.
 */
@ControllerAdvice
public class GlobalExceptionController {

  /**
   * Handle recurso nao encontrado exception response entity.
   *
   * @param exception the exception
   * @return the response entity
   */
  @ExceptionHandler(SerieExistenteException.class)
  public ResponseEntity<String> handleRecursoNaoEncontradoException(
      SerieExistenteException exception) {
    return ResponseEntity
        .status(HttpStatus.CONFLICT)
        .body(exception.getMessage());
  }

  /**
   * Handle recurso nao encontrado exception response entity.
   *
   * @param exception the exception
   * @return the response entity
   */
  @ExceptionHandler(EpisodioExistenteException.class)
  public ResponseEntity<String> handleRecursoNaoEncontradoException(
      EpisodioExistenteException exception) {
    return ResponseEntity
        .status(HttpStatus.CONFLICT)
        .body(exception.getMessage());
  }

  /**
   * Handle recurso nao encontrado exception response entity.
   *
   * @param exception the exception
   * @return the response entity
   */
  @ExceptionHandler(SerieNaoEncontradaException.class)
  public ResponseEntity<Object> handleRecursoNaoEncontradoException(
      SerieNaoEncontradaException exception) {
    HashMap<String, String> response = new HashMap<>();
    response.put("error", exception.getMessage());
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(response);
  }

  /**
   * Handle recurso nao encontrado exception response entity.
   *
   * @param exception the exception
   * @return the response entity
   */
  @ExceptionHandler(ErroInesperadoException.class)
  public ResponseEntity<String> handleRecursoNaoEncontradoException(
      ErroInesperadoException exception) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(exception.getMessage());
  }


  /**
   * Handle runtime exception response entity.
   *
   * @param exception the exception
   * @return the response entity
   */
  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<String> handleRuntimeException(RuntimeException exception) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(exception.getMessage());
  }

  /**
   * Handle exception response entity.
   *
   * @param exception the exception
   * @return the response entity
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(Exception exception) {
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(exception.getMessage());
  }

  /**
   * Handle throwable response entity.
   *
   * @param exception the exception
   * @return the response entity
   */
  @ExceptionHandler(Throwable.class)
  public ResponseEntity<String> handleThrowable(Throwable exception) {
    return ResponseEntity
        .status(HttpStatus.BAD_GATEWAY)
        .body(exception.getMessage());
  }
}
