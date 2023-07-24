package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.result.SaldoResult;
import com.trybe.acc.java.programamilhas.service.PessoaService;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;


@Path("/admin")
@ApplicationScoped
public class AdminResource {

  @Inject
  PessoaService service;

  @POST
  @Transactional
  @Path("/saldos")
  public List<SaldoResult> saldos(@QueryParam("token") String token) {

    return service.saldos();
  }


}
