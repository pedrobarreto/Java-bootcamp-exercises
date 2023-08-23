package com.trybe.camadas.projeto.spring.service;

import com.trybe.camadas.projeto.spring.persistence.entity.Estudante;

/**
 * The type Estudante service.
 */
public class EstudanteServiceImpl implements EstudanteService {

  @Override
  public Estudante criarEstudante(Estudante estudante) {
    return estudante;
  }

  @Override
  public Estudante atualizaEstudantepeloId(String id, Estudante estudante) {
    return estudante;
  }

  @Override
  public void excluiEstudantepeloId(String id, Estudante estudante) {

  }

  @Override
  public Estudante buscaEstudantepeloId(String id) {
    return null;
  }
}
