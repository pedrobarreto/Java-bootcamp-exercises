package com.trybe.restaurante.service;

import com.trybe.restaurante.dto.RestauranteDto;
import com.trybe.restaurante.entity.RestauranteEntity;
import com.trybe.restaurante.repository.RestauranteRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Classe RestauranteService.
 */
@ApplicationScoped
public class RestauranteService {

  @Inject
  private RestauranteRepository restauranteRepository;

  /**
   * Listar list.
   *
   * @return the list
   */
  public List<RestauranteEntity> listar() {
    return restauranteRepository.listAll();
  }

  /**
   * Buscar por id restaurante entity.
   *
   * @param id the id
   * @return the restaurante entity
   */
  public RestauranteEntity buscarPorId(Long id) {
    return restauranteRepository.findById(id);
  }

  /**
   * Salvar.
   *
   * @param restauranteDto the restaurante dto
   */
  @Transactional
  public void salvar(RestauranteDto restauranteDto) {
    RestauranteEntity restauranteEntity = new RestauranteEntity();
    restauranteEntity.setNome(restauranteDto.getNome());
    restauranteEntity.setDescricao(restauranteDto.getDescricao());

    restauranteRepository.persist(restauranteEntity);
  }

  /**
   * Atualizar.
   *
   * @param restauranteDto the restaurante dto
   * @param id             the id
   */
  @Transactional
  public void atualizar(RestauranteDto restauranteDto, Long id) {
    RestauranteEntity restauranteEntity = restauranteRepository.findById(id);
    restauranteEntity.setNome(restauranteDto.getNome());
    restauranteEntity.setDescricao(restauranteDto.getDescricao());

    restauranteRepository.persist(restauranteEntity);
  }

  /**
   * Deletar.
   *
   * @param id the id
   */
  @Transactional
  public void deletar(Long id) {
    restauranteRepository.deleteById(id);
  }


}
