package com.trybe.acc.java.planejadorviagens.challenge;

import com.trybe.acc.java.planejadorviagens.model.Country;
import com.trybe.acc.java.planejadorviagens.repository.CountryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlanejandoDestino {


  @Autowired
  private CountryRepository countryRepository;

  /**
   * Implemente a inserção.
   */
  public void inserir() {
    countryRepository.save(new Country("BRASIL", "BRASILIA", null));
    countryRepository.save(new Country("ARGENTINA", "BUENOS AIRES", null));
    countryRepository.save(new Country("URUGUAI", "MONTEVIDEO", null));
    countryRepository.save(new Country("PANAMA", "CIDADE DO PANAMA", null));

  }

  /**
   * Implemente a atualização.
   */
  public void corrigir() {

    List<Country> countries = countryRepository.findAll();
    countries.get(0).setDdi("+55");
    countries.get(1).setDdi("+54");
    countries.get(2).setDdi("+598");
    countries.get(3).setDdi("+507");
    countryRepository.saveAll(countries);
  }

  /**
   * Implemente a exclusão.
   */
  public void excluir() {
    List<Country> panama = countryRepository.findByName("PANAMA");
    countryRepository.delete(panama.get(0));

  }
}
