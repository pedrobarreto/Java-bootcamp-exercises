package com.trybe.acc.java;

import java.util.Locale;
import java.util.Scanner;

public class Imc {

  /**
   * Calcula IMC.
   */

  public static void main(String[] args) {
    // Ler a entrada de um número pelo console
    Scanner scan = new Scanner(System.in).useLocale(Locale.US);

    System.out.println("Digite o peso:");
    float peso = scan.nextFloat();

    System.out.println("Digite a altura:");
    float altura = scan.nextFloat();

    float imc = peso / (altura * altura);

    System.out.println(imc);

  }

}
