package com.trybe.acc.java;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
  private List<String> contatos = new ArrayList<>();

  void incluirContato(String contato) {
    contatos.add(contato);
  }

  void excluirContato(String contato) {
    contatos.remove(contato);
  }

  boolean verificaContato(String contato) {
    return contatos.contains(contato);
  }

  int tamanhoAgenda() {
    return contatos.size();
  }


}
