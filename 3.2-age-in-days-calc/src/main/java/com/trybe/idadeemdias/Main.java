package com.trybe.idadeemdias;

import java.util.Scanner;

public class Main {

  /**
   * Calcula idade em dias.
   */

  public static void main(String[] args) {

    String nomeUsuario;
    short idadeEmAnos;
    short idadeEmMeses;
    short idadeEmDias;

    try (Scanner scan = new Scanner(System.in)) {
      System.out.println("Qual é o seu nome?");
      nomeUsuario = scan.next();

      System.out.println("Qual é sua idade em anos, meses e dias?");
      System.out.println("anos:");
      idadeEmAnos = scan.nextShort();

      System.out.println("meses:");
      idadeEmMeses = scan.nextShort();

      System.out.println("dias:");
      idadeEmDias = scan.nextShort();
    }

    Pessoa pessoa = new Pessoa();

    int calculoIdade = pessoa.calcularIdadeEmDias(idadeEmAnos, idadeEmMeses, idadeEmDias);

    System.out.println("Olá " + nomeUsuario + ", sua idade em dias é " + calculoIdade);

  }

}
