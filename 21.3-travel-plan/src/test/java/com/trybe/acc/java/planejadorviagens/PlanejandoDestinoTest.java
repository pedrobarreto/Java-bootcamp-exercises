package com.trybe.acc.java.planejadorviagens;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.trybe.acc.java.planejadorviagens.challenge.PlanejandoDestino;
import com.trybe.acc.java.planejadorviagens.model.Country;
import com.trybe.acc.java.planejadorviagens.repository.CountryRepository;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
@ContextConfiguration(classes=DataApplication.class)
@RunWith(SpringRunner.class)
class PlanejandoDestinoTest {

  @Container
  static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo");


  /**
   * Modifica a URI do adapter MongoDB do spring data para utilizar a URL do container MongoDB.
   * 
   * Por padrão, a URI utilizada é o `localhost:27017`.
   *
   */
  @DynamicPropertySource
  static void mongoDbProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
  }


  @Autowired
  private CountryRepository countryRepository;

  @Autowired
  private PlanejandoDestino planejandoDestino;

  private String[] paises = new String[] {"BRASIL", "ARGENTINA", "URUGUAI", "PANAMA"};

  private String[] capitais =
      new String[] {"BRASILIA", "BUENOS AIRES", "MONTEVIDEO", "CIDADE DO PANAMA"};

  private String[] ddis = new String[] {"+55", "+54", "+598", "+507"};

  @Test
  @DisplayName("1 - Destino de Pedro é planejado com sucesso.")
  void destinoPlanejado() {
    planejandoDestino.inserir();
    for (int x = 0; x < paises.length; x++) {
      String p = paises[x];
      assertTrue(countryRepository.findByName(p).size() > 0);
      List<Country> lista = countryRepository.findByName(p);
      if (lista.size() > 0) {
        Country country = lista.get(0);
        assertEquals(country.getCapital(), capitais[x]);
        assertEquals(country.getDdi(), null);
      }
    }

    planejandoDestino.corrigir();
    for (int x = 0; x < paises.length; x++) {
      String p = paises[x];
      assertTrue(countryRepository.findByName(p).size() > 0);
      List<Country> lista = countryRepository.findByName(p);
      if (lista.size() > 0) {
        Country country = lista.get(0);
        assertEquals(country.getCapital(), capitais[x]);
        assertEquals(country.getDdi(), ddis[x]);
      }
    }

    planejandoDestino.excluir();
    Iterable<Country> lista = countryRepository.findAll();
    int i = 0;
    for (Country c : lista) {
      i++;
      assertNotEquals(c.getName(), paises[paises.length - 1]);
    }
    assertEquals(i, 3);
  }

}
