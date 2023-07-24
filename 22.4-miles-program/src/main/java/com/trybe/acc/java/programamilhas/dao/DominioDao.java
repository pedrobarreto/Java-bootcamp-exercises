package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.model.Parceiro;
import com.trybe.acc.java.programamilhas.model.Produto;
import com.trybe.acc.java.programamilhas.model.TipoLancamento;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * The type Pessoa dao.
 */
@ApplicationScoped
public class DominioDao {

  /**
   * The Entity manager.
   */
  @Inject
  EntityManager entityManager;


  /**
   * Buscar lancamentos list.
   *
   * @return the list
   */
  public List buscarLancamentos() {
    String hql = "from " + TipoLancamento.class.getSimpleName();
    Query query = entityManager.createQuery(hql);
    return query.getResultList();

  }

  /**
   * Buscar parceiros list.
   *
   * @return the list
   */
  public List buscarParceiros() {
    String hql = "from " + Parceiro.class.getSimpleName();
    Query query = entityManager.createQuery(hql);
    return query.getResultList();
  }

  /**
   * Buscar produtos list.
   *
   * @return the list
   */
  public List buscarProdutos() {
    String hql = "from " + Produto.class.getSimpleName();
    Query query = entityManager.createQuery(hql);
    return query.getResultList();
  }

}
