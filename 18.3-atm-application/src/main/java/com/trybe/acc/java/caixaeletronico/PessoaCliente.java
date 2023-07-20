package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

public class PessoaCliente {
  protected String nomeCompleto;
  private String cpf;
  private String senha;
  private Conta conta;
  private ArrayList<Conta> contas;

  /**
   * Método construtor da classe PessoaCliente.
   */
  public PessoaCliente(String nomeCompleto, String cpf, String senha) {
    this.nomeCompleto = nomeCompleto;
    this.cpf = cpf;
    this.senha = senha;
    this.contas = new ArrayList<Conta>();

    System.out.println("Nova pessoa cliente " + nomeCompleto + " com CPF: " + cpf + " criada!");
  }

  /**
   * Método que retorna numero de contas.
   */
  public int retornaNumeroDeContas() {
    return this.contas.size();
  }


  /**
   * Método que adiciona contas.
   */
  public void adicionarConta(String tipoConta, PessoaCliente cliente) {
    this.conta = new Conta(tipoConta, cliente);
    contas.add(conta);
  }

  public double retornarSaldoContaEspecifica(int indice) {
    return this.contas.get(indice).retornarSaldo();
  }

  public String retornarIdContaEspecifica(int indice) {
    return this.contas.get(indice).getIdConta();
  }

  public void retornarExtratoContaEspecifica(int indice) {
    this.contas.get(indice).retornarExtrato();
  }

  /**
   * Método de transação específica.
   */
  public void adicionarTransacaoContaEspecifica(int indice, double quantia, String descricao) {

    this.contas.get(indice).adicionarTransacao(quantia, descricao);

  }

  public String getCpf() {
    return this.cpf;
  }

  public String getSenha() {
    return this.senha;
  }

  /**
   * Método de validar senha.
   */
  public boolean validarSenha(String senha) {
    if (this.senha == senha) {
      return true;
    }
    return false;
  }


  /**
   * Método de buscar conta específica.
   */
  public Conta getConta(int indice) {
    return this.contas.get(indice);
  }


  /**
   * Método para retornar o resumo de contas.
   */
  public void retornarResumoContas() {

    for (Conta conta : this.contas) {
      System.out.println(conta.retornarResumoConta());
    }
  }



}
