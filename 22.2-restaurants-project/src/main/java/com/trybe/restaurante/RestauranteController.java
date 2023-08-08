package com.trybe.restaurante;

import com.trybe.restaurante.dto.RestauranteDto;
import com.trybe.restaurante.entity.RestauranteEntity;
import com.trybe.restaurante.service.RestauranteService;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Classe RestauranteController.
 */
@Path("/restaurante")
public class RestauranteController {

  @Inject
  private RestauranteService restauranteService;

  /**
   * Listar list.
   *
   * @return the list
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<RestauranteEntity> listar() {
    return restauranteService.listar();
  }

  /**
   * Buscar por id restaurante entity.
   *
   * @param id the id
   * @return the restaurante entity
   */
  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public RestauranteEntity buscarPorId(@PathParam("id") Long id) {
    return restauranteService.buscarPorId(id);
  }

  /**
   * Atualizar response.
   *
   * @param restauranteDto the restaurante dto
   * @param id             the id
   * @return the response
   */
  @PATCH
  @Path("/{id}")
  public Response atualizar(RestauranteDto restauranteDto, @PathParam("id") Long id) {
    restauranteService.atualizar(restauranteDto, id);
    return Response.ok().build();
  }

  /**
   * Salvar response.
   *
   * @param restauranteDto the restaurante dto
   * @return the response
   */
  @Transactional
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response salvar(@Valid RestauranteDto restauranteDto) {
    restauranteService.salvar(restauranteDto);
    return Response.status(Response.Status.CREATED).build();
  }

  /**
   * Deletar.
   *
   * @param id the id
   */
  @DELETE
  @Path("/{id}")
  public void deletar(@PathParam("id") Long id) {
    restauranteService.deletar(id);
  }


}
