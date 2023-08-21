package com.trybe.acc.java.iocdi.sistemapagamentos.repository;

import com.trybe.acc.java.iocdi.sistemapagamentos.model.Pagamento;
import org.springframework.stereotype.Repository;

/**
 * The type Pagamento repository.
 */
@Repository
public class PagamentoRepository {

  /**
   * Criar pagamento pagamento.
   *
   * @param pagamento the pagamento
   * @return the pagamento
   */
  public Pagamento criarPagamento(Pagamento pagamento) {
    return pagamento;
  }
}
