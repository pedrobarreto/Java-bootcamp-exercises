package com.trybe.acc.java.iocdi.sistemapagamentos;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.trybe.acc.java.iocdi.sistemapagamentos.controller.PagamentoController;
import com.trybe.acc.java.iocdi.sistemapagamentos.repository.PagamentoRepository;
import com.trybe.acc.java.iocdi.sistemapagamentos.service.AuthConfigService;
import com.trybe.acc.java.iocdi.sistemapagamentos.service.PagamentoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ValidacaoInjecaoDeDependenciasTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    @DisplayName("1 - Deve validar se existe o bean AuthConfigService.")

    public void deveValidarSeoBeanAuthConfigFoiCriadoCorretamenteViaConfiguracao() {
        assertNotNull(applicationContext.getBean(AuthConfigService.class));

    }

    @Test
    @DisplayName("2 - Deve validar se existe o bean PagamentoService.")

    public void deveValidarSeoBeanPaymentServiceFoiCriadoCorretamenteViaAnnotation() {
        assertNotNull(applicationContext.getBean(PagamentoService.class));

    }

    @Test
    @DisplayName("3 - Deve validar se existe o bean PagamentoRepository.")

    public void deveValidarSeoBeanPaymentRepositoryFoiCriadoCorretamenteViaAnnotation() {
        assertNotNull(applicationContext.getBean(PagamentoRepository.class));

    }

    @Test
    @DisplayName("4 - Deve validar se existe o bean PagamentoController.")
    public void deveValidarSeoBeanPaymentControllerFoiCriadoCorretamenteViaAnnotation() {
        assertNotNull(applicationContext.getBean(PagamentoController.class));

    }


}
