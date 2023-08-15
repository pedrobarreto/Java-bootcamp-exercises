package com.trybe.listaprodutos.service;

import com.trybe.listaprodutos.model.Produto;
import com.trybe.listaprodutos.repository.EstoqueRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * The type Estoque service.
 */
@ApplicationScoped
public class EstoqueService {

  @Inject
  private EstoqueRepository estoqueRepository;

  /**
   * Listar list.
   *
   * @return the list
   */
  public List<Produto> listar() {
    return estoqueRepository.findAll();
  }

  /**
   * Buscar por id produto.
   *
   * @param id the id
   * @return the produto
   */
  public Produto buscarPorId(Integer id) {
    return estoqueRepository.findById(id);
  }
}

