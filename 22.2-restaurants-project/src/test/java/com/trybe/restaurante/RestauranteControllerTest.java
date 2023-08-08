package com.trybe.restaurante;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import com.trybe.restaurante.dto.RestauranteDto;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;

@QuarkusTest
public class RestauranteControllerTest {

  @Test
  @DisplayName("1 - Salvar restaurantes")
  public void deveSalvarRestaurante() {
    RestauranteDto dto = new RestauranteDto();
    dto.setNome("McDonalds");
    dto.setDescricao("Fast Food");

    given().body(dto).contentType(ContentType.JSON).post("/restaurante").then().statusCode(201);
  }

  @Test
  @DisplayName("2 - Listar restaurantes")
  public void deveListarRestaurantesCriados() {
    RestauranteDto mc = new RestauranteDto();
    mc.setNome("McDonalds");
    mc.setDescricao("Fast Food");

    RestauranteDto bk = new RestauranteDto();
    bk.setNome("Burguer King");
    bk.setDescricao("Fast Food");

    given().body(mc).contentType(ContentType.JSON).post("/restaurante");

    given().body(bk).contentType(ContentType.JSON).post("/restaurante");

    given().when().get("/restaurante").then().statusCode(200).body("list.size()", is(3));
  }

  @Test
  @DisplayName("3 - Buscar restaurante por Id")
  public void deveRetornarBuscaPorId() {
    given().when().get("/restaurante/3").then().statusCode(200).body("nome", is("Burguer King"));
  }

  @Test
  @DisplayName("4 - Atualizar restaurante")
  public void deveAtualizarRegistro() {

    RestauranteDto popeye = new RestauranteDto();
    popeye.setNome("Popeye");
    popeye.setDescricao("Fast Food");

    given().body(popeye).contentType(ContentType.JSON).patch("/restaurante/2").then()
        .statusCode(200);
  }

  @Test
  @DisplayName("5 - Deletar restaurante")
  public void deveApagarRegistro() {

    given().delete("/restaurante/1");

    given().when().get("/restaurante").then().statusCode(200).body("list.size()", is(2));
  }

  @Test
  @DisplayName("6 - Deve validar header customizado")
  public void deveValidarHeader() {
    given().when().get("/restaurante/3").then().statusCode(200).header("X-Powered-By", "Trybe");
  }

}
