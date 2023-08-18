package com.trybe.acc.java.calculadora;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class CalculadoraApplicationTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @DisplayName("1 - Verifica adição de dois números")
  public void deveRetornarResultadoComSomaQuandoOperacaoForAdicao() throws Exception {
    mockMvc.perform(
        get("/").param("primeiroValor", "2").param("segundoValor", "3").param("operacao", "ADICAO"))
        .andExpect(status().isOk()).andExpect(jsonPath("$.valor").value(5));
  }

  @Test
  @DisplayName("2 - Verifica subtração de dois números")
  public void deveRetornarResultadoComSubtracaoQuandoOperacaoForSubtracao() throws Exception {
    mockMvc.perform(get("/").param("primeiroValor", "5").param("segundoValor", "2")
        .param("operacao", "SUBTRACAO")).andExpect(status().isOk())
        .andExpect(jsonPath("$.valor").value(3));
  }

  @Test
  @DisplayName("3 - Verifica multiplicação de dois números")
  public void deveRetornarResultadoComMultiplicacaoQuandoOperacaoForMultiplicacao()
      throws Exception {
    mockMvc.perform(get("/").param("primeiroValor", "5").param("segundoValor", "3")
        .param("operacao", "MULTIPLICACAO")).andExpect(status().isOk())
        .andExpect(jsonPath("$.valor").value(15));
  }

  @Test
  @DisplayName("4 - Verifica divisão de dois números")
  public void deveRetornarResultadoComDivisaoQuandoOperacaoForDivisao() throws Exception {
    mockMvc.perform(get("/").param("primeiroValor", "6").param("segundoValor", "2")
        .param("operacao", "DIVISAO")).andExpect(status().isOk())
        .andExpect(jsonPath("$.valor").value(3));
  }

  @Test
  @DisplayName("5 - Verifica erro na divisão por zero")
  public void deveRetornarResultadoComZeroQuandoHouverErro() throws Exception {
    mockMvc.perform(get("/").param("primeiroValor", "2").param("segundoValor", "0")
        .param("operacao", "DIVISAO")).andExpect(status().isOk())
        .andExpect(jsonPath("$.valor").value(0));
  }
}
