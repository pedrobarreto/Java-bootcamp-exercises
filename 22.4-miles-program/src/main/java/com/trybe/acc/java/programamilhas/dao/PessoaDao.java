package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.dto.LoginDto;
import com.trybe.acc.java.programamilhas.model.Pessoa;
import com.trybe.acc.java.programamilhas.util.HashUtil;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 * The type Pessoa dao.
 */
@ApplicationScoped
public class PessoaDao {

  /**
   * The Entity manager.
   */
  @Inject
  EntityManager entityManager;

  /**
   * Método responsável pela realização do login.
   *
   * <p>
   * Não delete este método!
   * </p>
   *
   * @param login the login
   * @param hash  the hash
   * @return the pessoa
   */
  public Pessoa autenticar(String login, String hash) {
    String hql = "from " + Pessoa.class.getSimpleName() + " where login = :login and hash = :hash";
    Query query = entityManager.createQuery(hql);
    query.setParameter("login", login);
    query.setParameter("hash", hash);
    return (Pessoa) query.getSingleResult();
  }

  /**
   * Salvar pessoa.
   *
   * @param login the login
   * @return the pessoa
   */
  @Transactional
  public Pessoa salvar(LoginDto login) throws InvalidKeySpecException, NoSuchAlgorithmException {
    HashUtil hashUtil = new HashUtil();
    String hash = hashUtil.hash(login.getSenha());
    Pessoa p = new Pessoa();
    p.setLogin(login.getLogin());
    p.setHash(hash);
    entityManager.persist(p);
    return p;
  }

  @Transactional
  public void deletar(Integer id) {
    Pessoa p = entityManager.find(Pessoa.class, id);
    entityManager.remove(p);
  }

}
