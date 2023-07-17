package com.trybe.acc.java.testcontainers.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class ProdutoDao {


  private final ProdutoRepository produtoRepository;

  public ProdutoDao(ProdutoRepository produtoRepository) {
    this.produtoRepository = produtoRepository;
  }

  public Produto cadastrarproduto(Produto produto) {
    return produtoRepository.insert(produto);
  }

  public List<Produto> listarTodosprodutos() {
    return produtoRepository.findAll();
  }

  public Optional<Produto> buscarprodutoPeloId(String id) {
    return produtoRepository.findById(id);
  }

  /**
   * Atualiza um produto, dado seu id.
   * @param id o id do produto
   * @param produto o produto a ser atualizado.
   * @return o produto atualizado.
   */
  public Produto atualizarprodutoPeloId(String id, Produto produto) {
    Optional<Produto> buscarprodutoPeloId = produtoRepository.findById(id);
    Produto produtoAtualizado = buscarprodutoPeloId.get();
    produtoAtualizado.setPreco(produto.getPreco());
    produtoAtualizado.setNome(produto.getNome());
    return produtoRepository.save(produtoAtualizado);
  }

  public void excluirprodutoPeloId(String id) {
    produtoRepository.deleteById(id);
  }
}
