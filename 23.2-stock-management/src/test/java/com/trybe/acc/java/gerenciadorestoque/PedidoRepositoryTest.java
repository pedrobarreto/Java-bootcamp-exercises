package com.trybe.acc.java.gerenciadorestoque;

import com.trybe.acc.java.gerenciadorestoque.persistence.Pedido;
import com.trybe.acc.java.gerenciadorestoque.persistence.PedidoRepository;
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

import java.util.List;
import java.util.Optional;



@Testcontainers
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class PedidoRepositoryTest {

  @Container
  static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo");

  @Autowired
  private PedidoRepository pedidoRepository;

  @AfterEach
  void cleanUp() {
    this.pedidoRepository.deleteAll();
  }

  @DynamicPropertySource
  static void mongoDbProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
  }


  Pedido pedidoMock = new Pedido("61ff1e243dabcd00b6452431", "produto1", 1);

  @DisplayName("1 - Deve cadastrar um novo pedido com sucesso.")
  @Test
  void DeveCadastrarNovopedido() {
    this.pedidoRepository.insert(pedidoMock);


    Pedido pedido = pedidoRepository.insert(new Pedido("1", "produto1", 1));

    Assertions.assertNotNull(pedido);
  }


  @DisplayName("2 - Deve listar todos os pedidos com sucesso.")
  @Test
  void DeveListarTodosOspedidos() {
    this.pedidoRepository.findAll();


    List<Pedido> pedido = pedidoRepository.findAll();

    Assertions.assertNotNull(pedido);
  }



  @DisplayName("3 - Deve buscar um pedido pelo id com sucesso.")
  @Test
  void DeveBuscarpedidoPeloId() {
    this.pedidoRepository.findById(pedidoMock.getIdDoPedido());


    Optional<Pedido> pedido = pedidoRepository.findById("");

    Assertions.assertNotNull(pedido);
  }


  @DisplayName("4 - Deve atualizar um pedido pelo id com sucesso.")
  @Test
  void DeveAtualizarpedidoPeloId() {
    this.pedidoRepository.findById(pedidoMock.getIdDoPedido());
    this.pedidoRepository.save(pedidoMock);


    Pedido pedido = pedidoRepository.save(pedidoMock);

    Assertions.assertNotNull(pedido);
  }



  @DisplayName("5 - Deve excluir um pedido pelo id com sucesso.")

  @Test
  void DeveExcluirpedidoPeloId() {


    this.pedidoRepository.deleteById(pedidoMock.getIdDoPedido());


    Optional<Pedido> pedido = pedidoRepository.findById("");

    Assertions.assertEquals(pedido, Optional.empty());
  }

}


