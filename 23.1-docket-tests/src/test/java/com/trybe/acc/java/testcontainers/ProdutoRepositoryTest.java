package com.trybe.acc.java.testcontainers;

import com.trybe.acc.java.testcontainers.persistence.Produto;
import com.trybe.acc.java.testcontainers.persistence.ProdutoRepository;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * The type Produto repository test.
 */
@Testcontainers
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class ProdutoRepositoryTest {


  /**
   * The constant mongoDBContainer.
   */
  @Container
  static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo");

  @Autowired
  private ProdutoRepository produtoRepository;

  /**
   * Clean up.
   */
  @AfterEach
  void cleanUp() {
    this.produtoRepository.deleteAll();

  }


  /**
   * Modifica a URI do adapter MongoDB do spring data para utilizar a URL do container MongoDB.
   * <p>
   * Por padrão, a URI utilizada é o `localhost:27017`.
   *
   * @param registry the registry
   */
  @DynamicPropertySource
  static void mongoDbProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
  }

  /**
   * Deve cadastrar novoproduto.
   */
  @DisplayName("1 - Deve cadastrar um novo produto com sucesso.")
  @Test
  void DeveCadastrarNovoproduto() {

    Produto produto = produtoRepository.insert(new Produto("1", "produto1", 30L));

    Assertions.assertNotNull(produto);
  }


  /**
   * Deve listar todos osprodutos.
   */
  @DisplayName("2 - Deve listar todos os produtos com sucesso.")
  @Test
  void DeveListarTodosOsprodutos() {
    produtoRepository.insert(new Produto("1", "produto1", 30L));
    produtoRepository.insert(new Produto("2", "produto2", 40L));
    produtoRepository.insert(new Produto("3", "produto3", 50L));

    List<Produto> produtos = produtoRepository.findAll();

    Assertions.assertEquals(3, produtos.size());
  }


  /**
   * Deve buscarproduto pelo id.
   */
  @DisplayName("3 - Deve buscar um produto pelo id com sucesso.")
  @Test
  void DeveBuscarprodutoPeloId() {
    produtoRepository.insert(new Produto("1", "produto1", 30L));
    produtoRepository.insert(new Produto("2", "produto2", 40L));
    produtoRepository.insert(new Produto("3", "produto3", 50L));

    Produto produto = produtoRepository.findById("3").get();

    Assertions.assertEquals("produto3", produto.getNome());
  }


  /**
   * Deve atualizarproduto pelo id.
   */
  @DisplayName("4 - Deve atualizar um produto pelo id com sucesso.")
  @Test
  void DeveAtualizarprodutoPeloId() {
    produtoRepository.insert(new Produto("1", "produto1", 30L));
    produtoRepository.insert(new Produto("2", "produto2", 40L));
    produtoRepository.insert(new Produto("3", "produto3", 50L));

    Produto produto = produtoRepository.findById("3").get();

    produto.setNome("novo produto");
    produtoRepository.save(produto);

    Produto produtoAtualizado = produtoRepository.findById("3").get();

    Assertions.assertEquals("novo produto", produtoAtualizado.getNome());
  }


  /**
   * Deve excluirproduto pelo id.
   */
  @DisplayName("5 - Deve excluir um produto pelo id com sucesso.")
  @Test
  void DeveExcluirprodutoPeloId() {
    produtoRepository.insert(new Produto("1", "produto1", 30L));
    produtoRepository.insert(new Produto("2", "produto2", 40L));
    produtoRepository.deleteById("1");
    List<Produto> produtos = produtoRepository.findAll();
    Assertions.assertEquals(1, produtos.size());

  }

}
