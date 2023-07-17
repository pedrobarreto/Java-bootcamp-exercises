package com.trybe.acc.java.testcontainers.endpoint;

import com.trybe.acc.java.testcontainers.persistence.Produto;
import com.trybe.acc.java.testcontainers.service.ProdutoService;

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
@RequestMapping("produto")
public class ProdutoController {


  private final ProdutoService produtoService;

  public ProdutoController(ProdutoService produtoService) {
    this.produtoService = produtoService;
  }

  @PostMapping
  public Produto cadastrarproduto(@RequestBody Produto produto) {
    return produtoService.cadastrarproduto(produto);
  }

  @GetMapping
  public List<Produto> listarTodosprodutos() {
    return produtoService.listarTodosprodutos();
  }

  @GetMapping(path = "{id}")
  public Optional<Produto> buscarprodutoPeloId(@PathVariable("id") String id) {
    return produtoService.buscarprodutoPeloId(id);
  }

  @PutMapping(path = "/{id}")
  public void atualizarprodutoPeloId(@PathVariable String id, @RequestBody Produto produto) {
    produtoService.atualizarprodutoPeloId(id, produto);
  }

  @DeleteMapping(path = "/{id}")
  public void excluirprodutoPeloId(@PathVariable("id") String id) {
    produtoService.excluirprodutoPeloId(id);
  }
}
