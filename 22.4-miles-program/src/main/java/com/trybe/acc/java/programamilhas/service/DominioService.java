package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.DominioDao;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * The type Dominio service.
 */
@ApplicationScoped
public class DominioService {

  /**
   * The Dao.
   */
  @Inject
  DominioDao dao;

  /**
   * Buscar lancamentos list.
   *
   * @return the list
   */
  public List buscarLancamentos() {
    return dao.buscarLancamentos();
  }

  /**
   * Buscar parceiros list.
   *
   * @return the list
   */
  public List buscarParceiros() {
    return dao.buscarParceiros();
  }

  /**
   * Buscar produtos list.
   *
   * @return the list
   */
  public List buscarProdutos() {
    return dao.buscarProdutos();
  }

}
