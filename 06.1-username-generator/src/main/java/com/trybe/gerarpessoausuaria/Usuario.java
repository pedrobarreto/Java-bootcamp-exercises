package com.trybe.gerarpessoausuaria;

public class Usuario extends Pessoa {

  String nomeCompleto;
  String[] usuariosInvalidos = {null, ""};

  /**
   * Classe Usuário.
   */

  public Usuario(String nome, String sobrenome) {
    super.nome = nome;
    super.sobrenome = sobrenome;

  }

  /**
   * Método para pegar o nome e sobrenome do usuário.
   *
   */
  public String getUsuario() {

    // forEach
    // https://www.javatpoint.com/java-for-loop
    for (String i : usuariosInvalidos) {

      if (nome == i || sobrenome == i) {
        return "Usuário inválido";
      }
    }

    nomeCompleto = nome + "." + sobrenome;
    return nomeCompleto;

  }
}
