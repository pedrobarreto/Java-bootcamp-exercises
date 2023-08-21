package com.trybe.acc.java.iocdi.sistemapagamentos.service;

import com.trybe.acc.java.iocdi.sistemapagamentos.model.Auth;
import com.trybe.acc.java.iocdi.sistemapagamentos.model.Pagamento;
import com.trybe.acc.java.iocdi.sistemapagamentos.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * The type Pagamento service.
 */
@Service
@Component
public class PagamentoService {

  @Autowired
  private PagamentoRepository pagamentoRepository;
  private AuthConfigService authConfigService;

  /**
   * Validar login auth.
   *
   * @param auth the auth
   * @return the auth
   */
  public Auth validarLogin(Auth auth) {
    return authConfigService.fazerLogin(auth);
  }

  /**
   * Criar pagamento pagamento.
   *
   * @param pagamento the pagamento
   * @return the pagamento
   */
  public Pagamento criarPagamento(Pagamento pagamento) {
    return pagamentoRepository.criarPagamento(pagamento);
  }


}
