package com.trybe.contabancaria;

/**
 * Classe ContaBancaria.
 **/

public class ContaBancaria {

  int saldo = 0;
  Cliente cliente = new Cliente();

  public int getSaldo() {
    return saldo;
  }

  public void setSaldo(int saldo) {
    this.saldo = saldo;
  }

  public String getNomeCliente() {
    return cliente.getNome();
  }

  public void setNomeCliente(String nomeCliente) {
    this.cliente.setNome(nomeCliente);
  }

  public String getCpfCliente() {
    return cliente.getCpf();
  }

  public void setCpfCliente(String cpfCliente) {
    cliente.setCpf(cpfCliente);
  }

  public int depositar(int valor) {
    this.saldo = this.saldo + valor;
    return this.saldo;
  }

  public int sacar(int valor) {
    this.saldo = this.saldo - valor;
    return this.saldo;
  }

  public int verSaldo() {
    return this.saldo;
  }
}
