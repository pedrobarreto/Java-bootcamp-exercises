package com.trybe.contabancaria;

/**
 * Classe ValidaCpf.
 **/

public class ValidaCpf {

  // https://www.vivaolinux.com.br/script/Codigo-para-validar-CPF-e-CNPJ-otimizado
  private static final int[] pesoDV1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
  private static final int[] pesoDV2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

  private static int calcularDigito1(String str) {
    int soma = 0;
    int digito = 0;
    for (int i = 0; i < 9; i += 1) {
      digito = Integer.parseInt(str.substring(i, i + 1));
      soma += digito * pesoDV1[i];
    }
    soma = 11 - (soma % 11);
    return soma > 9 ? 0 : soma;
  }

  private static int calcularDigito2(String str) {
    int soma = 0;
    int digito = 0;
    for (int i = 0; i < 10; i += 1) {
      digito = Integer.parseInt(str.substring(i, i + 1));
      soma += digito * pesoDV2[i];
    }
    soma = 11 - (soma % 11);
    return soma > 9 ? 0 : soma;
  }

  /**
   * Método valida cpf.
   **/
  public static boolean validarCpf(String cpf) {

    Integer digito1 = calcularDigito1(cpf.substring(0, 9));
    Integer digito2 = calcularDigito2(cpf.substring(0, 10));
    String digitosVerificadores = digito1.toString() + digito2.toString();

    if (cpf.substring(9).contains(digitosVerificadores)) {
      return true;
    }
    return false;
  }


}
