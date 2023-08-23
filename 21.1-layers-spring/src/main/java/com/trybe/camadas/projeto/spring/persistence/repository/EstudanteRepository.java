package com.trybe.camadas.projeto.spring.persistence.repository;

import com.trybe.camadas.projeto.spring.persistence.entity.Estudante;
import org.springframework.stereotype.Repository;

/**
 * The interface Estudante repository.
 */
@Repository
public interface EstudanteRepository {
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
   * Busca estudantepelo id estudante.
   *
   * @param id the id
   * @return the estudante
   */
  public Estudante buscaEstudantepeloId(String id);

  /**
   * Exclui estudantepelo id.
   *
   * @param id the id
   */
  void excluiEstudantepeloId(String id);
}
