package com.trybe.acc.java.programamilhas.rest;

import static io.restassured.RestAssured.given;
import com.trybe.acc.java.programamilhas.dto.LoginDto;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class AutenticacaoResourceTest {

  @Test
  @DisplayName("4 - Autenticação funciona com sucesso para usuário huguinho.")
  public void testAutenticacaoSucesso() {
    LoginDto dadosUsuario = new LoginDto();
    dadosUsuario.setLogin("huguinho");
    dadosUsuario.setSenha("root");
    given().contentType("application/json").body(dadosUsuario).when().post("/autenticacao").then()
        .statusCode(200);
  }

  @Test
  @DisplayName("5 - Autenticação funciona com sucesso para usuário zezinho.")
  public void testAutenticacaoSucesso2() {
    LoginDto dadosUsuario = new LoginDto();
    dadosUsuario.setLogin("zezinho");
    dadosUsuario.setSenha("senha");
    given().contentType("application/json").body(dadosUsuario).when().post("/autenticacao").then()
        .statusCode(200);
  }

  @Test
  @DisplayName("6 - Autenticação falha quando as credenciais não correspondem.")
  public void testAutenticacaoFalha() {
    LoginDto dadosUsuario = new LoginDto();
    dadosUsuario.setLogin("huguinho");
    dadosUsuario.setSenha("senha");
    given().contentType("application/json").body(dadosUsuario).when().post("/autenticacao").then()
        .statusCode(500);
  }

}
