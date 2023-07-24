package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.PessoaDao;
import com.trybe.acc.java.programamilhas.dto.LoginDto;
import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.model.Pessoa;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import com.trybe.acc.java.programamilhas.util.TokenUtil;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * The type Pessoa service.
 */
@ApplicationScoped
public class PessoaService {

  /**
   * The Dao.
   */
  @Inject
  PessoaDao dao;

  /**
   * The Token util.
   */
  @Inject
  TokenUtil tokenUtil;

  /**
   * The Saldos.
   */
  List<SaldoResult> saldos = new ArrayList<>();

  /**
   * Salvar pessoa.
   *
   * @param pessoa the pessoa
   * @return the pessoa
   * @throws InvalidKeySpecException  the invalid key spec exception
   * @throws NoSuchAlgorithmException the no such algorithm exception
   */
  public Pessoa salvar(LoginDto pessoa) throws InvalidKeySpecException, NoSuchAlgorithmException {
    saldos.add(new SaldoResult(1000));
    return dao.salvar(pessoa);
  }

  /**
   * Deletar.
   *
   * @param token the token
   * @throws AcessoNaoAutorizadoException the acesso nao autorizado exception
   */
  public void deletar(String token) throws AcessoNaoAutorizadoException {
    Integer id = tokenUtil.obterIdUsuario(token);
    saldos.remove(0);
    dao.deletar(id);
  }

  /**
   * Saldos list.
   *
   * @return the list
   */
  public List<SaldoResult> saldos() {
    return saldos;
  }

}

