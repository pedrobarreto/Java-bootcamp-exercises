package com.trybe.acc.java;

import java.util.Scanner;

public class Main {


  /**
   * Calcula média de notas.
   */
  public static void main(String[] args) {

    String nomeUsuario;
    double nota1;
    double nota2;
    double nota3;
    double nota4;


    System.out.println("Qual é o seu nome?");

    try (Scanner scan = new Scanner(System.in)) {
      nomeUsuario = scan.next();

      System.out.println("Entre com as notas das provas:");
      System.out.println("Avaliação 1:");

      nota1 = scan.nextDouble();

      System.out.println("Avaliação 2:");

      nota2 = scan.nextDouble();

      System.out.println("Avaliação 3:");

      nota3 = scan.nextDouble();

      System.out.println("Avaliação 4:");

      nota4 = scan.nextDouble();
    }

    Nota nota = new Nota();

    double notaMedia = nota.calcularMedia(nota1, nota2, nota3, nota4);

    System.out.println("Olá, " + nomeUsuario + ", sua média é " + notaMedia);

  }

}
