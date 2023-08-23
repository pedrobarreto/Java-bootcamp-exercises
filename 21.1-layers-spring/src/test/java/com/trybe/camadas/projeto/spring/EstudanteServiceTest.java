package com.trybe.camadas.projeto.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.trybe.camadas.projeto.spring.persistence.entity.Estudante;
import com.trybe.camadas.projeto.spring.persistence.repository.EstudanteRepository;
import com.trybe.camadas.projeto.spring.persistence.repository.EstudanteRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class EstudanteServiceTest {

  @Mock
  EstudanteRepository estudanteRepository;

  @InjectMocks
  EstudanteRepositoryImpl estudanteService;


  @Test
  @DisplayName("Deve criar um estudante")
  public void deveCriaEstudante() {
    Estudante estudante = new Estudante("1", "teste1", "java", "sao paulo");
    estudanteRepository.criarEstudante(estudante);
    estudanteService.criarEstudante(estudante);
    assertNotNull(estudante.getNomeEstudante());

  }

  @Test
  @DisplayName("Deve buscar um estudante pelo id")
  public void deveBuscarEstudantePeloId() {
    Estudante estudante = new Estudante("1", "teste1", "java", "sao paulo");
    estudanteRepository.buscaEstudantepeloId("1");
    estudanteService.buscaEstudantepeloId("1");
    assertNotNull(estudante.getId());
  }


  @Test
  @DisplayName("Deve atualizar um estudante pelo Id")
  public void deveAtualizarEstudantePeloid() {
    Estudante estudante = new Estudante("1", "nome atualizado", "java", "sao paulo");
    estudanteRepository.atualizaEstudantepeloId("1", estudante);
    estudanteService.atualizaEstudantepeloId("1", estudante);
    assertEquals("nome atualizado", estudante.getNomeEstudante());
  }

  @Test
  @DisplayName("Deve excluir um estudante pelo id")
  public void deveExcluirEstudantePeloid() {
    Estudante estudante = new Estudante("1", "estudante que sera excluido", "java", "sao paulo");
    estudanteRepository.excluiEstudantepeloId("1");
    estudanteService.excluiEstudantepeloId("1");
    assertEquals("1", estudante.getId());
  }


}
