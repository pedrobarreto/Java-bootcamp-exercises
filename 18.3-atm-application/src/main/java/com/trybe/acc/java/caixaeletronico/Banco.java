package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

public class Banco {

  private ArrayList<PessoaCliente> pessoasClientes;
  private ArrayList<Conta> contas;

  public Banco() {
    this.pessoasClientes = new ArrayList<PessoaCliente>();
    this.contas = new ArrayList<Conta>();
  }

  /**
   * Método para gerar numero nova conta.
   */
  public String gerarNumeroNovaConta() {
    long theRandomNum = (long) (Math.random() * Math.pow(10, 10));
    String stringRandom = Long.toString(theRandomNum);
    return stringRandom;
  }

  /**
   * Método para adicionar Pessoa Cliente.
   */
  public PessoaCliente adicionarPessoaCliente(String nomeCompleto, String cpf, String senha) {
    PessoaCliente cliente = new PessoaCliente(nomeCompleto, cpf, senha);
    pessoasClientes.add(cliente);
    return cliente;
  }


  /**
   * Método para validar login de Pessoa Cliente.
   */
  public PessoaCliente pessoaClienteLogin(String cpf, String senha) {

    PessoaCliente cliente = pessoasClientes.stream()
        //
        .filter(e -> cpf.equals(e.getCpf()))
        //
        .filter(e -> senha.equals(e.getSenha()))
        //
        .findAny()
        //
        .orElse(null);

    return cliente;

  }


  /**
   * Método para adicionar conta.
   */
  public void adicionarConta(String tipoConta, PessoaCliente cliente) {
    Conta conta = new Conta(tipoConta, cliente);
    cliente.adicionarConta(tipoConta, cliente);
    this.contas.add(conta);
  }

  /**
   * Método para transferir fundos.
   */
  public void transferirFundos(PessoaCliente pessoaClienteAutenticada, int daConta, int paraConta,
      double quantia) {


    double saldo = pessoaClienteAutenticada.getConta(daConta).retornarSaldo();


    double saldoAtualizado = saldo - quantia;

    pessoaClienteAutenticada.getConta(daConta).adicionarTransacao(saldoAtualizado, "saque");

    pessoaClienteAutenticada.getConta(paraConta).adicionarTransacao(quantia, "depósito");


  }

  /**
   * Método para sacar.
   */
  public void sacar(PessoaCliente pessoaClienteAutenticada, int deConta, double quantia) {

    double saldo = pessoaClienteAutenticada.getConta(deConta).retornarSaldo();

    double saldoAtualizado = saldo - quantia;

    pessoaClienteAutenticada.getConta(deConta).adicionarTransacao(saldoAtualizado, "saque");


  }


  /**
   * Método para depositar.
   */
  public void depositar(PessoaCliente pessoaClienteAutenticada, int paraConta, double quantia) {
    // TODO Auto-generated method stub
    pessoaClienteAutenticada.getConta(paraConta).adicionarTransacao(quantia, "depósito");

  }

  public void mostrarExtrato(PessoaCliente pessoaClienteAutenticada, int conta) {
    pessoaClienteAutenticada.getConta(conta).retornarExtrato();

  }


}
