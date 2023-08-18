package com.trybe.acc.java.planejadorviagens;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.trybe.acc.java.planejadorviagens.challenge.PlanejandoDestino;
import com.trybe.acc.java.planejadorviagens.model.Country;
import com.trybe.acc.java.planejadorviagens.repository.CountryRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataApplicationTests {

  @Test
  void contextLoads() {}


  // void destinoPlanejado() {
  //   PlanejandoDestino.inserir();
  //   for (int x = 0; x < paises.length; x++) {
  //     String p = paises[x];
  //     assertTrue(repo.findByName(p).size() > 0);
  //     List<Country> lista = repo.findByName(p);
  //     if (lista.size() > 0) {
  //       Country country = lista.get(0);
  //       assertEquals(country.getCapital(), capitais[x]);
  //       assertEquals(country.getDdi(), null);
  //     }
  //   }

  //   PlanejandoDestino.corrigir();
  //   for (int x = 0; x < paises.length; x++) {
  //     String p = paises[x];
  //     assertTrue(repo.findByName(p).size() > 0);
  //     List<Country> lista = repo.findByName(p);
  //     if (lista.size() > 0) {
  //       Country country = lista.get(0);
  //       assertEquals(country.getCapital(), capitais[x]);
  //       assertEquals(country.getDdi(), ddis[x]);
  //     }
  //   }

  //   PlanejandoDestino.excluir();
  //   Iterable<Country> lista = repo.findAll();
  //   int i = 0;
  //   for (Country c : lista) {
  //     i++;
  //     assertNotEquals(c.getName(), paises[paises.length - 1]);
  //   }
  //   assertEquals(i, 3);
  // }

}
