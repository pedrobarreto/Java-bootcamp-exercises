package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.service.DominioService;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * The type Dominio resource.
 */
@Path("/dominio")
@ApplicationScoped
public class DominioResource {
  /**
   * The Service.
   */
  @Inject
  DominioService service;

  /**
   * Gets tipos lancamento.
   *
   * @return the tipos lancamento
   */
  @GET
  @Path("/tipolancamento")
  public List getTiposLancamento() {
    return service.buscarLancamentos();
  }

  /**
   * Gets parceiros.
   *
   * @return the parceiros
   */
  @GET
  @Path("/parceiro")
  public List getParceiros() {
    return service.buscarParceiros();
  }

  /**
   * Gets produtos.
   *
   * @return the produtos
   */
  @GET
  @Path("/produto")
  public List getProdutos() {
    return service.buscarProdutos();
  }

}
