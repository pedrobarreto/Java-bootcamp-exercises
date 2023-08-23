package com.trybe.camadas.projeto.spring.persistence.repository;

import com.trybe.camadas.projeto.spring.persistence.entity.Estudante;

/**
 * The type Estudante repository.
 */
public class EstudanteRepositoryImpl implements EstudanteRepository {
  @Override
  public Estudante criarEstudante(Estudante estudante) {
    return estudante;
  }

  @Override
  public Estudante atualizaEstudantepeloId(String id, Estudante estudante) {
    return estudante;
  }

  @Override
  public Estudante buscaEstudantepeloId(String id) {
    return null;
  }

  @Override
  public void excluiEstudantepeloId(String id) {

  }
}
