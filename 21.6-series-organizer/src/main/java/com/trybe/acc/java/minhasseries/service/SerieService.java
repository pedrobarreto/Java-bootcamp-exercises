package com.trybe.acc.java.minhasseries.service;

import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.repository.EpisodioRepository;
import com.trybe.acc.java.minhasseries.repository.SerieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * The type Serie service.
 */
@Service
@Component
public class SerieService {

  @Autowired
  private SerieRepository serieRepository;

  @Autowired
  private EpisodioRepository episodioRepository;

  /**
   * Gets all series.
   *
   * @return the all series
   */
  public List<Serie> getAllSeries() {
    return serieRepository.findAll();
  }

  /**
   * Gets all episodios.
   *
   * @return the all episodios
   */
  public List<Episodio> getAllEpisodios() {
    return episodioRepository.findAll();
  }


  /**
   * Add serie serie.
   *
   * @param serie the serie
   * @return the serie
   */
  public Serie addSerie(Serie serie) {
    return serieRepository.save(serie);
  }

  /**
   * Add episodio serie.
   *
   * @param episodio the episodio
   * @param serieId  the serie id
   * @return the serie
   */
  public Serie addEpisodio(Episodio episodio, Integer serieId) {
    Serie serie = serieRepository.findById(serieId).get();
    Episodio novoEpisodio = new Episodio(episodio, serie);
    serie.adicionarEpisodio(novoEpisodio);
    return serieRepository.save(serie);

  }

  /**
   * Edit serie boolean.
   *
   * @param id    the id
   * @param serie the serie
   * @return the boolean
   */
  public Boolean editSerie(Integer id, Serie serie) {
    if (serieRepository.findById(id).isPresent()) {
      Serie serieToEdit = serieRepository.findById(id).get();
      serieToEdit.setNome(serie.getNome());
      return true;
    } else {
      return false;
    }
  }

  /**
   * Delete serie boolean.
   *
   * @param id the id
   * @return the boolean
   */
  public Boolean deleteSerie(Integer id) {
    if (serieRepository.findById(id).isPresent()) {
      serieRepository.deleteById(id);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Gets serie by id.
   *
   * @param id the id
   * @return the serie by id
   */
  public Serie getSerieById(Integer id) {
    return serieRepository.findById(id).get();
  }

  /**
   * Serie is valid boolean.
   *
   * @param id the id
   * @return the boolean
   */
  public boolean serieIsValid(Integer id) {
    return serieRepository.findById(id).isPresent();
  }

}
