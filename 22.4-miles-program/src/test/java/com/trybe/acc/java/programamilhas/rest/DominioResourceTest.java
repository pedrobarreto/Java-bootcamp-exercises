package com.trybe.acc.java.programamilhas.rest;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.trybe.acc.java.programamilhas.model.Parceiro;
import com.trybe.acc.java.programamilhas.model.Produto;
import com.trybe.acc.java.programamilhas.model.TipoLancamento;
import io.quarkus.test.junit.QuarkusTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class DominioResourceTest {

  @Test
  @DisplayName("4 - Endpoint '/dominio/tipolancamento' funciona com sucesso.")
  public void testTipoLancamento() {
    List<TipoLancamento> list =
        Arrays.asList(given().when().get("/dominio/tipolancamento").as(TipoLancamento[].class));
    assertTrue(list.size() == 4);
  }

  @Test
  @DisplayName("5 - Endpoint '/dominio/parceiro' funciona com sucesso.")
  public void testParceiro() {
    List<Parceiro> list =
        Arrays.asList(given().when().get("/dominio/parceiro").as(Parceiro[].class));
    assertTrue(list.size() == 2);
  }

  @Test
  @DisplayName("6 - Endpoint '/dominio/produto' funciona com sucesso.")
  public void testProduto() {
    List<Produto> list = Arrays.asList(given().when().get("/dominio/produto").as(Produto[].class));
    assertTrue(list.size() == 4);
  }

}
