package com.trybe.contapoupanca;


public class ContaPoupanca {

  private String titularConta;
  private double saldo;

  /**
   * Métodos do titular da conta.
   */
  public ContaPoupanca(String titularConta, int depositoInicial) {
    this.titularConta = titularConta;
    this.saldo = depositoInicial;
  }


  public double depositar(int valorDepositado) {
    this.saldo = this.saldo + valorDepositado;
    return saldo;
  }

  public double sacar(int valorSaque) {
    this.saldo = this.saldo - valorSaque;
    return this.saldo;
  }

  public double mostrarSaldo() {
    return this.saldo;
  }

  public String mostrarTitularConta() {
    return this.titularConta;
  }

}
