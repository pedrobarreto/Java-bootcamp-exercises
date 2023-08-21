package com.trybe.acc.java.iocdi.sistemapagamentos;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.trybe.acc.java.iocdi.sistemapagamentos.controller.InterceptorController;
import com.trybe.acc.java.iocdi.sistemapagamentos.interceptor.Interceptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
@WebAppConfiguration

public class InterceptorTest {

    @Autowired
    WebApplicationContext wac;

    @Mock
    InterceptorController interceptorController;


    @Mock
    private Interceptor interceptor;

    private MockMvc mockMvc;

    @BeforeEach
    public void before() throws Exception {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(interceptorController)
                .addInterceptors(interceptor)
                .build();
        when(interceptor.preHandle(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(true);

    }

    @Test
    @DisplayName("5 - Deve validar se existe esse endpoint com interceptor.")
    public void deveValidarEndpointComInterceptor() throws Exception {
        mockMvc.perform(get("/middleware/com-interceptor"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @DisplayName("6 - Deve validar se existe esse endpoint sem interceptor.")
    public void deveValidarEndpointSemInterceptor() throws Exception {
        mockMvc.perform(get("/middleware/sem-interceptor"))
                .andExpect(status().is2xxSuccessful());
    }

}
