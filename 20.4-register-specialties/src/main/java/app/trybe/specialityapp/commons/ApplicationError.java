package app.trybe.specialityapp.commons;

import javax.ws.rs.core.Response;

/**
 * The type Application error.
 */
public class ApplicationError {

  private String message;
  private Response.Status status;

  /**
   * Instantiates a new Application error.
   *
   * @param message the message
   */
  public ApplicationError(String message, Response.Status status) {
    this.message = message;
    this.status = status;
  }

  public Response.Status getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }

}