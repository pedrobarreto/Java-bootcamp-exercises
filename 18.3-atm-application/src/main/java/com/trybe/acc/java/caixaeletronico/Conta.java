package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

public class Conta {

  private Banco banco;
  protected String tipoConta;
  private String idConta;
  private PessoaCliente pessoaCliente;
  private ArrayList<Transacao> transacoes;


  /**
   * Método construtor de Conta.
   */
  public Conta(String tipoConta, PessoaCliente pessoaCliente) {
    this.banco = new Banco();
    this.tipoConta = tipoConta;
    this.pessoaCliente = pessoaCliente;
    this.idConta = banco.gerarNumeroNovaConta();

  }

  /**
   * Método para adicionar nova transação.
   */
  public void adicionarTransacao(Double quantia, String descricao) {
    Transacao transacao = new Transacao(quantia, descricao);
    this.transacoes = new ArrayList<Transacao>();
    transacoes.add(transacao);
  }


  double retornarSaldo() {
    double saldo = 0.0;
    if (this.transacoes != null) {
      for (Transacao transacao : this.transacoes) {
        saldo += transacao.getQuantia();
      }
    }
    return saldo;
  }

  public String retornarResumoConta() {
    return this.idConta + " : R$ " + this.retornarSaldo() + " : " + this.tipoConta;
  }


  /**
   * Método para retornar extrato.
   */
  public void retornarExtrato() {
    for (Transacao transacao : this.transacoes) {
      System.out.println(transacao.retornarResumoTransacao());
    }

  }

  public String getIdConta() {
    return idConta;
  }

  public PessoaCliente getPessoaCliente() {
    return this.pessoaCliente;
  }



}
