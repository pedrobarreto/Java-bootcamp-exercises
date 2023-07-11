package com.trybe.acc.java.gerenciadorestoque.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class PedidoDao {


  private final PedidoRepository pedidoRepository;

  public PedidoDao(PedidoRepository pedidoRepository) {
    this.pedidoRepository = pedidoRepository;
  }

  public Pedido cadastrarpedido(Pedido pedido) {
    return pedidoRepository.insert(pedido);
  }

  public List<Pedido> listarTodospedidos() {
    return pedidoRepository.findAll();
  }

  public Optional<Pedido> buscarpedidoPeloId(String id) {
    return pedidoRepository.findById(id);
  }

  /**
   * Atualiza um Pedido, dado o seu Id.
   * 
   * @param id o Id do pedido.
   * @param pedido o Pedido a ser atualizado.
   * @return o pedido atualizado.
   */
  public Pedido atualizarpedidoPeloId(String id, Pedido pedido) {
    Optional<Pedido> buscarpedidoPeloId = this.buscarpedidoPeloId(id);
    Pedido pedidoAtualizado = buscarpedidoPeloId.get();
    pedidoAtualizado.setQuantidade(pedido.getQuantidade());
    pedidoAtualizado.setProduto(pedido.getProduto());
    return pedidoRepository.save(pedidoAtualizado);
  }

  public void excluirpedidoPeloId(String id) {
    pedidoRepository.deleteById(id);
  }
}
