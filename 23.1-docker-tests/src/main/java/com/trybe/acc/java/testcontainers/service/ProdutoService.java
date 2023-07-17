package com.trybe.acc.java.testcontainers.service;

import com.trybe.acc.java.testcontainers.persistence.Produto;
import com.trybe.acc.java.testcontainers.persistence.ProdutoDao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

  private final ProdutoDao produtoDao;


  public ProdutoService(ProdutoDao produtoDao) {
    this.produtoDao = produtoDao;
  }

  public Produto cadastrarproduto(Produto produto) {
    return produtoDao.cadastrarproduto(produto);
  }

  public List<Produto> listarTodosprodutos() {
    return produtoDao.listarTodosprodutos();
  }

  public Optional<Produto> buscarprodutoPeloId(String id) {
    return produtoDao.buscarprodutoPeloId(id);
  }

  public void atualizarprodutoPeloId(String id, Produto produto) {
    produtoDao.atualizarprodutoPeloId(id, produto);
  }

  public void excluirprodutoPeloId(String id) {
    produtoDao.excluirprodutoPeloId(id);
  }
}
