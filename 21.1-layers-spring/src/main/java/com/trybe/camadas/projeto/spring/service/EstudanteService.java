package com.trybe.camadas.projeto.spring.service;

import com.trybe.camadas.projeto.spring.persistence.entity.Estudante;
import org.springframework.stereotype.Service;

/**
 * The interface Estudante service.
 */
@Service
public interface EstudanteService {

  /**
   * Criar estudante estudante.
   *
   * @param estudante the estudante
   * @return the estudante
   */
  public Estudante criarEstudante(Estudante estudante);

  /**
   * Atualiza estudantepelo id estudante.
   *
   * @param id        the id
   * @param estudante the estudante
   * @return the estudante
   */
  public Estudante atualizaEstudantepeloId(String id, Estudante estudante);

  /**
   * Exclui estudantepelo id.
   *
   * @param id        the id
   * @param estudante the estudante
   */
  public void excluiEstudantepeloId(String id, Estudante estudante);

  /**
   * Busca estudantepelo id estudante.
   *
   * @param id the id
   * @return the estudante
   */
  public Estudante buscaEstudantepeloId(String id);

}
