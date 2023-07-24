package com.trybe.acc.java.programamilhas.rest;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.trybe.acc.java.programamilhas.dto.LoginDto;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class PessoaResourceTest {

  @Test
  @Order(1)
  @DisplayName("2 - Endpoint de criação de pessoa deve inserir uma Pessoa com sucesso.")
  public void testCreate() {
    LoginDto dadosPessoa = new LoginDto();
    dadosPessoa.setLogin("novapessoa");
    dadosPessoa.setSenha("novasenha");

    // Cadastro de novo usuario deve dar sucesso
    given().contentType("application/json").body(dadosPessoa).when().post("/pessoa").then()
        .statusCode(200);

    // Usuario com mesmo login deve dar erro
    Response resp = given().contentType("application/json").body(dadosPessoa).when().post("/pessoa")
        .then().extract().response();
    assertTrue(resp.getStatusCode() != 200);
  }

  @Test
  @Order(2)
  @DisplayName("3 - Endpoint de deletar pessoa funciona com sucesso.")
  public void testDelete() {


    UtilTest util = new UtilTest();
    int numSaldosAntes = util.saldos().size();

    String token = util.getToken("novapessoa", "novasenha");
    // Encerrar conta
    given().when().delete("/pessoa?token=" + token).then().statusCode(200);

    int numSaldosDepois = util.saldos().size();

    assertTrue(numSaldosDepois == numSaldosAntes - 1);
  }

}
