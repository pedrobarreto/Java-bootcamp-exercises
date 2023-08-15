package com.trybe.listaprodutos;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class EstoqueControllerTest {

    @Test
    @DisplayName("Deve listar todos os produtos")
    public void deveListarProdutos() {
        given()
          .when().get("/estoque")
          .then()
             .statusCode(200)
                .contentType(ContentType.JSON)
                .body("list.size()", is(4));
    }

    @Test
    @DisplayName("Deve buscar produto por id")
    public void deveBuscarPorId() {
        given()
                .when().get("/estoque/1")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", is(1))
                .body("nome", is("Leite"));
    }

}