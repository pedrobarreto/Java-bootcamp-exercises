package com.trybe.calcularidade.controller;

import com.trybe.calcularidade.domain.Idade;
import com.trybe.calcularidade.exception.ArgumentoIlegalException;
import com.trybe.calcularidade.exception.DataFuturaException;
import com.trybe.calcularidade.exception.DataInvalidaException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe CalcularDataController.
 */
@RestController
public class CalcularDataController {

  /**
   * Gets ages.
   *
   * @param data the data
   * @return the ages
   */
  @GetMapping("/")
  public Object getAges(@RequestParam("data") String data) {

    if (data.equals("DD-mm-AAAA")) {
      throw new ArgumentoIlegalException("Data não é número");
    }

    try {
      LocalDate dataFormatada = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
      Idade idade = new Idade(dataFormatada);
      if (dataFormatada.isAfter(LocalDate.now())) {
        throw new DataFuturaException("Data Futura");
      }
      return ResponseEntity.ok(idade.getIdade());
    } catch (DateTimeParseException e) {
      throw new DataInvalidaException("Data Inválida");
    }

  }


}
