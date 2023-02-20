package com.betrybe.acc.java.bankaccount;

import java.util.Scanner;

/**
 * A class.
 */
public class Application {

  /**
   * A simple get method.
   */
  public static void main(String[] args) {

    System.out.println("Informe o número da conta:");

    Scanner scanner = new Scanner(System.in);

    int input = scanner.nextInt();

    scanner.close();

    AccountNumberFormatter account = new AccountNumberFormatter();

    System.out.println("Numero da conta: " + account.formatAccountNumber(input));
  }

}
