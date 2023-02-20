package com.trybe.agenda;

import java.util.HashMap;

public class AgendaMapa {

  HashMap<String, String> contatos = new HashMap<String, String>();

  void incluirContato(String nome, String telefone) {

    contatos.put(nome, telefone);
  }


  void excluirContato(String nome) {

    contatos.remove(nome);
  }

  boolean verificaContato(String nome) {

    return contatos.containsKey(nome);

  }

  int tamanhoAgenda() {
    return contatos.size();

  }

  String atualizarTelefone(String nome, String telefone) {
    return contatos.put(nome, telefone);
  }

  String obterTelefone(String nome) {
    return contatos.get(nome);
  }

}
