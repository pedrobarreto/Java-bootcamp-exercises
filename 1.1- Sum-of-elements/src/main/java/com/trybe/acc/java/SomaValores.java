package com.trybe.acc.java;

import java.util.Locale;
import java.util.Scanner;

public class SomaValores {

  /**
   * Soma do array.
   */

  public static void main(String[] args) {

    // Ler a entrada de um número pelo console
    Scanner scan = new Scanner(System.in).useLocale(Locale.US);

    int[] myArray = new int[3];
    int soma = 0;


    // Laço de repetição
    for (int index = 0; index < 3; index++) {
      System.out.println("Digite um número:");
      myArray[index] = scan.nextInt();
      soma = soma += myArray[index];
    }

    System.out.println("A soma é: " + soma);



  }

}
