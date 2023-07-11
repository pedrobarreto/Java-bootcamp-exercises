package com.trybe.acc.java.gerenciadorestoque.service;

import com.trybe.acc.java.gerenciadorestoque.persistence.Pedido;
import com.trybe.acc.java.gerenciadorestoque.persistence.PedidoDao;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

  private final PedidoDao pedidoDao;


  public PedidoService(PedidoDao pedidoDao) {
    this.pedidoDao = pedidoDao;
  }

  public Pedido cadastrarpedido(Pedido pedido) {
    return pedidoDao.cadastrarpedido(pedido);
  }

  public List<Pedido> listarTodospedidos() {
    return pedidoDao.listarTodospedidos();
  }

  public Optional<Pedido> buscarpedidoPeloId(String id) {
    return pedidoDao.buscarpedidoPeloId(id);
  }

  public void atualizarpedidoPeloId(String id, Pedido pedido) {
    pedidoDao.atualizarpedidoPeloId(id, pedido);
  }

  public void excluirpedidoPeloId(String id) {
    pedidoDao.excluirpedidoPeloId(id);
  }
}
