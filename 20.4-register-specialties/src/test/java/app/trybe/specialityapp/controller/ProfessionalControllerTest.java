package app.trybe.specialityapp.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import app.trybe.specialityapp.commons.ApplicationError;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.util.HttpStatus;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.*;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.trybe.specialityapp.SpecialityAppApplication;
import app.trybe.specialityapp.model.ProfessionalFixture;

/**
 * Essa classe de testes faz a checagem de todas operações do controller e seu fluxo completo para
 * isto é levantado um container em tempo de execução do teste e é feita todas as chamadas das APIs
 * em ordem de testagem. Por favor não trocar a ordem dos testes, pois poderá impactar nos
 * resultados
 */
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProfessionalControllerTest extends JerseyTest {

  @Override
  protected Application configure() {
    final ApplicationContext context =
        new AnnotationConfigApplicationContext(SpecialityAppApplication.class);

    return new ResourceConfig().register(ProfessionalController.class).property("contextConfig",
        context);
  }

  @BeforeAll
  @Override
  public void setUp() throws Exception {
    super.setUp();
  }

  @AfterAll
  @Override
  public void tearDown() throws Exception {
    super.tearDown();
  }

  /*
   * Testa os cenários de sucesso na ordem de execução.
   */

  @Test
  @DisplayName("11 - Inserindo novo registro.")
  public void test01() {
    WebTarget client = target("/professional/add");

    final Response response = client.request()
        .post(Entity.entity(ProfessionalFixture.anyToInsert(), MediaType.APPLICATION_JSON_TYPE));

    assertEquals(HttpStatus.CREATED_201.getStatusCode(), response.getStatus());
    assertEquals(MediaType.APPLICATION_JSON, response.getMediaType().toString());
    assertEquals("Inserido", response.readEntity(String.class));
  }

  @Test
  @DisplayName("12 - FindAll com registros.")
  public void test02() {

    WebTarget client = target("/professional/all");

    final Response response = client.request().get();

    System.out.println(response.readEntity(String.class));

    assertEquals(HttpStatus.OK_200.getStatusCode(), response.getStatus());
    assertEquals(MediaType.APPLICATION_JSON, response.getMediaType().toString());

  }

  @Test
  @DisplayName("13 - Editando um registro.")
  public void test03() {

    WebTarget client = target("/professional/edit/1");

    final Response response = client.request()
        .put(Entity.entity(ProfessionalFixture.anyToEdit(), MediaType.APPLICATION_JSON_TYPE));

    assertEquals(HttpStatus.OK_200.getStatusCode(), response.getStatus());
    assertEquals(MediaType.APPLICATION_JSON, response.getMediaType().toString());
    assertEquals("ID [1] atualizado", response.readEntity(String.class));

  }

  @Test
  @DisplayName("14 - Removendo um registro.")
  public void test04() {

    WebTarget client = target("/professional/delete/1");

    final Response response = client.request().delete();

    assertEquals(HttpStatus.OK_200.getStatusCode(), response.getStatus());
    assertEquals(MediaType.APPLICATION_JSON, response.getMediaType().toString());
    assertEquals("ID [1] removido", response.readEntity(String.class));

  }

  /*
   * Testa os cenário de falha na ordem de execução
   */

  @Test
  @DisplayName("15 - Inserir registro com ID explícito.")
  public void test05() {

    WebTarget client = target("/professional/add");

    final Response response = client.request()
        .post(Entity.entity(ProfessionalFixture.anyToEdit(), MediaType.APPLICATION_JSON_TYPE));

    var errorResponse = response.readEntity(ApplicationError.class);

    assertEquals(HttpStatus.BAD_REQUEST_400.getStatusCode(), response.getStatus());
    assertEquals(MediaType.APPLICATION_JSON, response.getMediaType().toString());
    assertEquals(Response.Status.BAD_REQUEST, errorResponse.getStatus());
    assertEquals("Não é permitido inserir novos registros com ID explícito",
        errorResponse.getMessage());
  }

  @Test
  @DisplayName("16 - FindAll sem registros retorna uma mensagem de erro.")
  public void test06() {

    WebTarget client = target("/professional/all");

    final Response response = client.request().get();

    var errorResponse = response.readEntity(ApplicationError.class);

    assertEquals(HttpStatus.NOT_FOUND_404.getStatusCode(), response.getStatus());
    assertEquals(MediaType.APPLICATION_JSON, response.getMediaType().toString());
    assertEquals(Response.Status.NOT_FOUND, errorResponse.getStatus());
    assertEquals("Nenhum registro foi encontrado!", errorResponse.getMessage());

  }

  @Test
  @DisplayName("17 - Editar registro inexistente retorna uma mensagem de erro.")
  public void test07() {

    WebTarget client = target("/professional/edit/2");

    final Response response = client.request()
        .put(Entity.entity(ProfessionalFixture.anyToEdit(), MediaType.APPLICATION_JSON_TYPE));

    var errorResponse = response.readEntity(ApplicationError.class);

    assertEquals(HttpStatus.NOT_FOUND_404.getStatusCode(), response.getStatus());
    assertEquals(MediaType.APPLICATION_JSON, response.getMediaType().toString());
    assertEquals(Response.Status.NOT_FOUND, errorResponse.getStatus());
    assertEquals("Não é possível editar, o ID informado não existe", errorResponse.getMessage());

  }

  @Test
  @DisplayName("18 - Remover registro inexistente retorna uma mensagem de erro.")
  public void test08() {

    WebTarget client = target("/professional/delete/2");

    final Response response = client.request().delete();

    var errorResponse = response.readEntity(ApplicationError.class);

    assertEquals(HttpStatus.NOT_FOUND_404.getStatusCode(), response.getStatus());
    assertEquals(MediaType.APPLICATION_JSON, response.getMediaType().toString());
    assertEquals(Response.Status.NOT_FOUND, errorResponse.getStatus());
    assertEquals("Não é possível deletar, o ID informado não existe", errorResponse.getMessage());

  }
}
