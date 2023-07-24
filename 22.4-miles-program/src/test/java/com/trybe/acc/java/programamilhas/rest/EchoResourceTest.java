package com.trybe.acc.java.programamilhas.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class EchoResourceTest {

  @Test
  @DisplayName("1 - Endpoint echo retorna 'Olá' com status 200.")
  public void testEchoEndpoint() {
    given().when().get("/echo").then().statusCode(200).body(is("Olá!"));
  }

}
