package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.PessoaDao;
import com.trybe.acc.java.programamilhas.exception.AutenticacaoInvalidaException;
import com.trybe.acc.java.programamilhas.model.Pessoa;
import com.trybe.acc.java.programamilhas.util.HashUtil;
import com.trybe.acc.java.programamilhas.util.TokenUtil;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AutenticacaoService {

  @Inject
  PessoaDao dao;

  @Inject
  TokenUtil tokenUtil;

  @Inject
  HashUtil hashUtil;

  /**
   * Autentica a pessoa usuária.
   * 
   */
  public String autenticar(String login, String pwd)
      throws AutenticacaoInvalidaException, InvalidKeySpecException, NoSuchAlgorithmException {
    Pessoa usuario = dao.autenticar(login, hashUtil.hash(pwd));
    if (usuario != null) {
      return tokenUtil.criarToken(usuario.getId());
    }
    throw new AutenticacaoInvalidaException();
  }

}
