package com.trybe.acc.java.programacadastro;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.trybe.acc.java.programacadastro.bean.DadosCadastro;
import com.trybe.acc.java.programacadastro.bean.DadosRetornoCadastro;
import io.restassured.http.ContentType;
import javax.validation.constraints.AssertTrue;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class CadastroResourceTest {

  @Test
  @DisplayName("1 - Cadastra um cliente com sucesso.")
  public void testCadastroSucesso() {
    DadosCadastro cadastro = new DadosCadastro();
    cadastro.setNome("Pedro");
    cadastro.setEmail("pedro@gmail.com");
    cadastro.setProtegido(false);

    given().body(cadastro).contentType(ContentType.JSON).post("/cadastro").then().statusCode(200)
        .body("nome", CoreMatchers.is("Pedro"), "email", CoreMatchers.is("pedro@gmail.com"),
            "protegido",
            CoreMatchers.is(false));
  }

  @Test
  @DisplayName("2 - Tenta cadastrar um cliente sem nome e recebe dados inválidos.")
  public void testCadastroSemNome() {
    DadosCadastro cadastro = new DadosCadastro();
    cadastro.setEmail("pedro@gmail.com");
    cadastro.setProtegido(false);

    given().body(cadastro).contentType(ContentType.JSON).post("/cadastro").then().statusCode(400);

  }

  @Test
  @DisplayName("3 - Tenta cadastrar um cliente com nome vazio e recebe internal server error.")
  public void testCadastroNomeVazio() {
    DadosCadastro cadastro = new DadosCadastro();
    cadastro.setEmail("pedro@gmail.com");
    cadastro.setNome("");
    cadastro.setProtegido(false);

    given().body(cadastro).contentType(ContentType.JSON).post("/cadastro").then().statusCode(500);

  }

  @Test
  @DisplayName("4 - Tenta obter um cadastro com id inválido e recebe bad request.")
  public void testObterSemId() {

    given().when().get("/cadastro/erro").then().statusCode(400);
  }

  @Test
  @DisplayName("5 - Tenta obter um cadastro com id que não está cadastrado e recebe bad request.")
  public void testObterIdInexistente() {
    given().when().get("/cadastro/10").then().statusCode(400);
  }

  @Test
  @DisplayName("6 - Tenta obter um cadastro protegido e recebe status 403.")
  public void testObterIdProtegido() {
    DadosCadastro cadastroProtegido = new DadosCadastro();
    cadastroProtegido.setNome("Ana");
    cadastroProtegido.setEmail("ana@gmail.com");
    cadastroProtegido.setProtegido(true);
    DadosRetornoCadastro retorno =
        given().body(cadastroProtegido).contentType(ContentType.JSON).post("/cadastro")
            .as(DadosRetornoCadastro.class);
    assertTrue(retorno.isProtegido());
    assertEquals("Ana", retorno.getNome());
    assertEquals("ana@gmail.com", retorno.getEmail());

    given().when().get("/cadastro/" + retorno.getIdCadastro()).then().statusCode(401);

  }

  @Test
  @DisplayName("7 - Obtém um cadastro com sucesso.")
  public void testObterSucesso() {
    DadosCadastro cadastroValido = new DadosCadastro();
    cadastroValido.setNome("Joao");
    cadastroValido.setEmail("joao@gmail.com");
    cadastroValido.setProtegido(false);
    DadosRetornoCadastro retorno =
        given().body(cadastroValido).contentType(ContentType.JSON).post("/cadastro")
            .as(DadosRetornoCadastro.class);

    given().when().get("/cadastro/" + retorno.getIdCadastro()).then().statusCode(200);

  }

}
