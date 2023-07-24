package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.dto.LoginDto;
import com.trybe.acc.java.programamilhas.exception.AutenticacaoInvalidaException;
import com.trybe.acc.java.programamilhas.result.TokenResult;
import com.trybe.acc.java.programamilhas.service.AutenticacaoService;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/autenticacao")
@ApplicationScoped
public class AutenticacaoResource {

  @Inject
  AutenticacaoService service;

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public TokenResult login(LoginDto dados)
      throws AutenticacaoInvalidaException, InvalidKeySpecException, NoSuchAlgorithmException {
    return TokenResult.construir(service.autenticar(dados.getLogin(), dados.getSenha()));
  }

}
