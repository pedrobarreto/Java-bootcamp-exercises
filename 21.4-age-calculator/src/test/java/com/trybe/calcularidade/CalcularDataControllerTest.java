package com.trybe.calcularidade;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.trybe.calcularidade.controller.GerenciadorAdvice;
import com.trybe.calcularidade.exception.ArgumentoIlegalException;
import com.trybe.calcularidade.exception.DataFuturaException;
import com.trybe.calcularidade.exception.DataInvalidaException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class CalcularDataControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @SpyBean
  private GerenciadorAdvice gerenciadorAdvice;
  @Captor
  private ArgumentCaptor<RuntimeException> captor;

  @Test
  @DisplayName("1 - Utilizar o Spring para realizar testes nos endpoints de aplicações REST")
  void deveRetornarIdadeQuandoDataForValida() throws Exception {
    mockMvc.perform(get("/").param("data", "23-11-1981")).andExpect(status().isOk())
        .andExpect(jsonPath("$.idade").value(40));

    verify(gerenciadorAdvice, never()).handlerBadRequest(any());
    verify(gerenciadorAdvice, never()).handlerInternalServerError(any());
  }

  @Test
  @DisplayName(
      value = "2 - Utilizar @ExceptionHandler para criar fluxo de exceção em aplicação Spring")
  void deveRetornarErroQuandoDataForFutura() throws Exception {
    mockMvc.perform(get("/").param("data", "23-11-3000")).andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").value("Data Futura"));

    verify(gerenciadorAdvice).handlerBadRequest(captor.capture());
    verify(gerenciadorAdvice, never()).handlerInternalServerError(any());

    assertThat(captor.getValue()).isExactlyInstanceOf(DataFuturaException.class);
  }

  @Test
  @DisplayName(
      value = "3 - Utilizar @ControllerAdvice em controller para dar suporte ao tratamento de exceções")
  void deveRetornarErroQuandoDataEstiverIncompleta() throws Exception {
    mockMvc.perform(get("/").param("data", "11-1981")).andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").value("Data Inválida"));

    verify(gerenciadorAdvice).handlerBadRequest(captor.capture());
    verify(gerenciadorAdvice, never()).handlerInternalServerError(any());

    assertThat(captor.getValue()).isExactlyInstanceOf(DataInvalidaException.class);
  }

  @Test
  @DisplayName(
      value = "4 - Utilizar @ControllerAdvice em controller para dar suporte ao tratamento de exceções")
  void deveRetornarErroQuandoDataNaoForNumero() throws Exception {
    mockMvc.perform(get("/").param("data", "DD-mm-AAAA"))
        .andExpect(status().isInternalServerError())
        .andExpect(jsonPath("$.error").value("Data não é número"));

    verify(gerenciadorAdvice, never()).handlerBadRequest(any());
    verify(gerenciadorAdvice).handlerInternalServerError(captor.capture());

    assertThat(captor.getValue()).isExactlyInstanceOf(ArgumentoIlegalException.class);
  }

  @Test
  @DisplayName(
      value = "5 - Utilizar @ControllerAdvice em controller para dar suporte ao tratamento de exceções")
  void deveRetornarErroQuandoDataEstiverMalFormatada() throws Exception {
    mockMvc.perform(get("/").param("data", "2-3-11-1981")).andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").value("Data Inválida"));

    verify(gerenciadorAdvice).handlerBadRequest(captor.capture());
    verify(gerenciadorAdvice, never()).handlerInternalServerError(any());

    assertThat(captor.getValue()).isExactlyInstanceOf(DataInvalidaException.class);
  }

  @Test
  @DisplayName("6 - Utilizar o conceito de Circuit Breaker ao tratamento de exceções")
  void deveRetornarFallbackQuandoFlagEstiverHabilitada() throws Exception {
    mockMvc.perform(get("/").param("data", "2-3-11-1981").param("fallback", "true"))
        .andExpect(status().isOk()).andExpect(jsonPath("$.idade").value(0));

    verify(gerenciadorAdvice, never()).handlerBadRequest(any());
    verify(gerenciadorAdvice, never()).handlerInternalServerError(any());
  }

}
