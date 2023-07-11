package com.trybe.acc.java.gerenciadorestoque.endpoint;

import com.trybe.acc.java.gerenciadorestoque.persistence.Pedido;
import com.trybe.acc.java.gerenciadorestoque.service.PedidoService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedido")
public class PedidoController {


  private final PedidoService pedidoService;

  public PedidoController(PedidoService pedidoService) {
    this.pedidoService = pedidoService;
  }

  @PostMapping
  public Pedido cadastrarpedido(@RequestBody Pedido pedido) {
    return pedidoService.cadastrarpedido(pedido);
  }

  @GetMapping
  public List<Pedido> listarTodospedidos() {
    return pedidoService.listarTodospedidos();
  }

  @GetMapping(path = "{id}")
  public Optional<Pedido> buscarpedidoPeloId(@PathVariable("id") String id) {
    return pedidoService.buscarpedidoPeloId(id);
  }

  @PutMapping(path = "/{id}")
  public void atualizarpedidoPeloId(@PathVariable String id, @RequestBody Pedido pedido) {
    pedidoService.atualizarpedidoPeloId(id, pedido);
  }

  @DeleteMapping(path = "/{id}")
  public void excluirpedidoPeloId(@PathVariable("id") String id) {
    pedidoService.excluirpedidoPeloId(id);
  }
}
