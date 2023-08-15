package com.trybe.listaprodutos;

import com.trybe.listaprodutos.model.Produto;
import com.trybe.listaprodutos.service.EstoqueService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * Classe EstoqueController.
 */
@Path("/")
public class EstoqueController {

  @Inject
  private EstoqueService estoqueService;


  /**
   * Listar produtos list.
   *
   * @return the list
   */
  @GET
  @Path("estoque")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Produto> listarProdutos() {
    return estoqueService.listar();
  }

  /**
   * Buscar por id produto.
   *
   * @param id the id
   * @return the produto
   */
  @GET
  @Path("estoque/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Produto buscarPorId(@PathParam("id") Integer id) {
    return estoqueService.buscarPorId(id);
  }

}
