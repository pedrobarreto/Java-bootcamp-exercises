package com.trybe.acc.java.minhasseries;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.repository.SerieRepository;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MinhasSeriesApplicationTest {

  @Autowired
  private MockMvc mockMvc;

  @SpyBean
  private SerieRepository serieRepository;

  @Captor
  private ArgumentCaptor<Serie> serieCaptor;

  @BeforeEach
  public void setup() {
    serieRepository.deleteAll();
  }

  @Test
  @Order(1)
  @DisplayName("1 -  Deve adicionar uma serie na base de dados.")
  void deveAdicionarSerieNaBaseDeDados() throws Exception {
    final var serie = new Serie("Doctor Who");
    mockMvc
        .perform(post("/series").contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(serie)))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.nome").value(serie.getNome()));

    verify(serieRepository, atLeast(1)).save(serieCaptor.capture());

    assertThat(serieCaptor.getValue()).isNotNull();
    assertThat(serieCaptor.getValue().getId()).isNotNull();
    assertThat(serieCaptor.getValue().getNome()).isEqualTo(serie.getNome());
    assertThat(serieCaptor.getValue().getEpisodios()).isEmpty();
  }

  @Test
  @Order(2)
  @DisplayName("2 - Utilizar @ControllerAdvice em controller para informar que a série já existe na base de dados.")
  void deveEmitirConflitoQuandoNomeDaSerieExistirNaBaseDeDados() throws Exception {
    final var serie = new Serie("Doctor Who");

    serieRepository.save(serie);

    mockMvc
        .perform(post("/series").contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(serie)))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isConflict()).andExpect(jsonPath("$.error").value("Série Existente"));
  }

  @Test
  @Order(3)
  @DisplayName("3 - Deve retornar todas as séries existentes da base de dados.")
  void deveRetornarTodasSeriesExistentesNaBase() throws Exception {
    final var serie1 = new Serie("Doctor Who");
    final var serie2 = new Serie("Friends");
    serieRepository.save(serie1);
    serieRepository.save(serie2);

    mockMvc.perform(get("/series").contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$[0].nome").value(serie1.getNome()))
        .andExpect(jsonPath("$[1].nome").value(serie2.getNome()));
  }

  @Test
  @Order(4)
  @DisplayName("4 - Deve retornar lista vazia quando não existir séries na base de dados.")
  void deveRetornarListaVaziaQuandoNaoExistirSeriesNaBase() throws Exception {
    mockMvc.perform(get("/series").contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(content().string(containsString("[]")));
  }

  @Test
  @Order(5)
  @DisplayName("5 - Deve remover série, por um id existente informado.")
  void deveRemoverSerieQuandoExistirNaBase() throws Exception {
    final var serie = serieRepository.save(new Serie("Doctor Who"));;

    mockMvc.perform(delete("/series/" + serie.getId())).andExpect(status().isOk());
  }

  @Test
  @Order(6)
  @DisplayName("6 - Utilizar @ControllerAdvice em controller para emitir 'não encontrado' quando tenta remover uma série não existente na base de dados.")
  void deveEmitirNaoEncontradoQuandoSerieNaoExistirNaBase() throws Exception {
    mockMvc.perform(delete("/series/" + new Random().nextInt())).andExpect(status().isNotFound())
        .andExpect(jsonPath("$.error").value("Série não encontrada"));
  }

  @Test
  @Order(7)
  @DisplayName("7 - Deve adicionar episodio quando existir serie na base de dados.")
  void deveAdicionarEpisodioQuandoExistirSerieNaBaseDeDados() throws Exception {
    final var serie = serieRepository.save(new Serie("Doctor Who"));
    final var episodio = new Episodio(1, 60);

    mockMvc
        .perform(
            post("/series/" + serie.getId() + "/episodios").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(episodio)))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.nome").value(serie.getNome()));

    verify(serieRepository, atLeast(1)).save(serieCaptor.capture());

    assertThat(serieCaptor.getValue()).isNotNull();
    assertThat(serieCaptor.getValue().getId()).isNotNull();
    assertThat(serieCaptor.getValue().getNome()).isEqualTo(serie.getNome());
    assertThat(serieCaptor.getValue().getEpisodios()).hasSize(1);
  }

  @Test
  @Order(8)
  @DisplayName("8 - Utilizar @ControllerAdvice em controller para emitir 'não encontrado' quando tenta adicionar um episódio em uma série não existente na base de dados.")
  void deveEmitirNaoEncontradoQuandoNaoExistirSerieNaBaseDeDados() throws Exception {
    final var episodio = new Episodio(1, 60);

    mockMvc
        .perform(post("/series/" + new Random().nextInt() + "/episodios")
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(episodio)))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  @Test
  @Order(9)
  @DisplayName("9 - Deve retornar lista de episodios quando existir na base.")
  void deveRetornarListaDeEpisodiosQuandoExistirNaBase() throws Exception {
    var serie = new Serie("Doctor Who");
    serie = serieRepository.save(serie);
    final var episodio1 = new Episodio(null, 1, 60, serie);
    final var episodio2 = new Episodio(null, 2, 60, serie);

    serie.adicionarEpisodio(episodio1);
    serie.adicionarEpisodio(episodio2);

    serie = serieRepository.save(serie);

    mockMvc
        .perform(
            get("/series/" + serie.getId() + "/episodios").contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$[0].numero").value(episodio1.getNumero()))
        .andExpect(jsonPath("$[0].duracaoEmMinutos").value(episodio1.getDuracaoEmMinutos()))
        .andExpect(jsonPath("$[1].numero").value(episodio2.getNumero()))
        .andExpect(jsonPath("$[1].duracaoEmMinutos").value(episodio2.getDuracaoEmMinutos()));
  }

  @Test
  @Order(10)
  @DisplayName("10 - Deve retornar a soma da duração de todos episodios.")
  void deveRetornarTempoGastoDeTodosEpisodios() throws Exception {
    var serie = new Serie("Doctor Who");
    serie = serieRepository.save(serie);
    final var episodio1 = new Episodio(null, 1, 60, serie);
    final var episodio2 = new Episodio(null, 2, 100, serie);

    serie.adicionarEpisodio(episodio1);
    serie.adicionarEpisodio(episodio2);

    serieRepository.save(serie);

    mockMvc.perform(get("/series/tempo").contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.tempoEmMinutos")
            .value(episodio1.getDuracaoEmMinutos() + episodio2.getDuracaoEmMinutos()));
  }

  @Test
  @Order(11)
  @DisplayName("11 - Deve retornar tempo de todos episodios mesmo se não houver episodio na base de dados.")
  void deveRetornarTempoGastoDeTodosEpisodiosMesmoSeNaoHouverEpisodio() throws Exception {
    mockMvc.perform(get("/series/tempo").contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.tempoEmMinutos").value(0));
  }

  @Test
  @Order(12)
  @DisplayName("12 - Utilizar o conceito de Circuit Breaker ao tratamento de exceções.")
  void deveRetornarServicoIndisponivelCasoExtrapoleTaxaDeErros() throws Exception {
    final var episodio = new Episodio(1, 60);

    mockMvc.perform(post("/series/" + new Random().nextInt() + "/episodios")
        .contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(episodio)));

    mockMvc
        .perform(post("/series/" + new Random().nextInt() + "/episodios")
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(episodio)))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isServiceUnavailable());
  }
}
