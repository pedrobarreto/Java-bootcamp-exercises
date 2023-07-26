package com.trybe.acc.java.programacadastro.rest;

import com.trybe.acc.java.programacadastro.bean.DadosCadastro;
import com.trybe.acc.java.programacadastro.bean.DadosRetornoCadastro;
import com.trybe.acc.java.programacadastro.service.CadastroService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("/cadastro")
@ApplicationScoped
public class CadastroResource {

  @Inject
  CadastroService service;

  /**
   * Endpoint de cadastro.
   */
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public Response cadastrar(DadosCadastro dados) {
    if (dados.getNome() == null) {
      return Response.status(Status.BAD_REQUEST).build();
    }
    if (dados.getNome().isEmpty()) {
      return Response.status(Status.INTERNAL_SERVER_ERROR).build();
    }
    DadosRetornoCadastro retorno =
        service.cadastrar(dados.getNome(), dados.getEmail(), dados.isProtegido());
    return Response.ok(retorno).build();
  }

  /**
   * Endpoint de busca de um cadastro, dado o ID.
   */
  @GET
  @Path("/{idCadastro}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response obterCadastro(@PathParam(value = "idCadastro") String idCadastro) {
    Integer id = converter(idCadastro);
    if (id == null) {
      return Response.status(Status.BAD_REQUEST).build();
    }
    DadosRetornoCadastro dados = service.obter(id);
    if (dados == null) {
      return Response.status(Status.BAD_REQUEST).build();
    }
    if (dados.isProtegido()) {
      return Response.status(Status.UNAUTHORIZED).build();
    }
    return Response.ok(dados).build();
  }

  private Integer converter(String idCadastro) {
    try {
      return Integer.valueOf(idCadastro);
    } catch (Exception e) {
      return null;
    }
  }
}
