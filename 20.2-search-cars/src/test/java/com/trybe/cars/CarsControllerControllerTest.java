package com.trybe.cars;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import com.trybe.cars.model.Car;
import com.trybe.cars.repository.CarsRepository;
import com.trybe.cars.service.CarsService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integration-tests.properties")
public class CarsControllerControllerTest {

  @MockBean
  private CarsService service;

  @MockBean
  private CarsRepository repository;

  @Autowired
  public MockMvc mockMvc;

  @SuppressWarnings("deprecation")
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  @DisplayName("1 - Veículo cadastrado com sucesso")
  public void getAllCars_OK() throws Exception {

    Car p = new Car();
    p.setNome("Gol");

    ArrayList<Car> cars = new ArrayList<>();
    cars.add(p);

    when(service.getAllCars()).thenReturn(cars);

    ResultActions response = mockMvc.perform(get("/cars").contentType(MediaType.APPLICATION_JSON));
    response.andExpect(status().isOk());
  }
}
