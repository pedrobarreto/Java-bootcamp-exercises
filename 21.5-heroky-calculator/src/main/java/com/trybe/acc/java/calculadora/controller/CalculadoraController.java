package com.trybe.acc.java.calculadora.controller;

import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Calculadora controller.
 */
@RestController
public class CalculadoraController {

  /**
   * Gets calculadora.
   *
   * @param valor1   the valor 1
   * @param valor2   the valor 2
   * @param operacao the operacao
   * @return the calculadora
   */
  @GetMapping("/")
  public HashMap<String, Integer> getCalculadora(@RequestParam("primeiroValor") String valor1,
                                                 @RequestParam("segundoValor") String valor2,
                                                 @RequestParam("operacao") String operacao) {
    HashMap<String, Integer> response = new HashMap<>();
    try {
      Integer valor1Int = Integer.parseInt(valor1);
      Integer valor2Int = Integer.parseInt(valor2);
      switch (operacao) {
        case "ADICAO":
          response.put("valor", valor1Int + valor2Int);
          return response;
        case "SUBTRACAO":
          response.put("valor", valor1Int - valor2Int);
          return response;
        case "MULTIPLICACAO":
          response.put("valor", valor1Int * valor2Int);
          return response;
        default:
          response.put("valor", valor1Int / valor2Int);
          return response;
      }
    } catch (ArithmeticException e) {
      response.put("valor", 0);
      return response;
    }
  }
}
