package com.trybe.acc.java.iocdi.sistemapagamentos.controller;

import com.trybe.acc.java.iocdi.sistemapagamentos.model.Pagamento;
import com.trybe.acc.java.iocdi.sistemapagamentos.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Pagamento controller.
 */
@RestController
public class PagamentoController {

  @Autowired
  private PagamentoService pagamentoService;

  /**
   * Criar pagamento pagamento.
   *
   * @param pagamento the pagamento
   * @return the pagamento
   */
  @PostMapping()
  public Pagamento criarPagamento(@RequestBody Pagamento pagamento) {
    return pagamentoService.criarPagamento(pagamento);
  }
}
