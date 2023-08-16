package com.trybe.acc.java.minhasseries.controller;

import com.trybe.acc.java.minhasseries.exceptions.SerieNaoEncontradaException;
import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.service.SerieService;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Serie controller.
 */
@RestController
public class SerieController {

  @Autowired
  private SerieService serieService;

  /**
   * Gets all series.
   *
   * @return the all series
   */
  @GetMapping("/series")
  public List<Serie> getAllSeries() {
    return serieService.getAllSeries();
  }

  /**
   * Gets all episodios.
   *
   * @return the all episodios
   */
  @GetMapping("/episodios")
  public List<Episodio> getAllEpisodios() {
    return serieService.getAllEpisodios();
  }

  /**
   * Add serie serie.
   *
   * @param serie the serie
   * @return the serie
   */
  @PostMapping("/series")
  public Serie addSerie(@RequestBody Serie serie) {
    return serieService.addSerie(serie);
  }

  /**
   * Add episodio serie.
   *
   * @param episodio the episodio
   * @param serieId  the serie id
   * @return the serie
   */
  @PostMapping("/series/{serie_id}/episodios")
  public Serie addEpisodio(@RequestBody Episodio episodio,
                           @PathVariable("serie_id") Integer serieId) {
    if (serieService.serieIsValid(serieId)) {
      return serieService.addEpisodio(episodio, serieId);
    }
    throw new SerieNaoEncontradaException("Serie não encontrada");
  }

  /**
   * Gets episodioby serie.
   *
   * @param serieId the serie id
   * @return the episodioby serie
   */
  @GetMapping("/series/{serie_id}/episodios")
  public List<Episodio> getEpisodiobySerie(@PathVariable("serie_id") Integer serieId) {
    if (serieService.serieIsValid(serieId)) {
      return serieService.getSerieById(serieId).getEpisodios();
    }
    return null;
  }

  /**
   * Gets episodios total.
   *
   * @return the episodios total
   */
  @GetMapping("/series/tempo")
  public Object getEpisodiosTotal() {
    List<Episodio> episodios = serieService.getAllEpisodios();
    HashMap<String, Integer> response = new HashMap<>();
    int sum = 0;
    for (Episodio episodio : episodios) {
      sum += episodio.getDuracaoEmMinutos();
    }
    response.put("tempoEmMinutos", sum);
    return response;
  }

  /**
   * Delete serie boolean.
   *
   * @param id the id
   * @return the boolean
   */
  @DeleteMapping("/series/{id}")
  public Boolean deleteSerie(@PathVariable("id") Integer id) {
    if (serieService.serieIsValid(id)) {
      return serieService.deleteSerie(id);
    }
    throw new SerieNaoEncontradaException("Série não encontrada");
  }
}
