package com.trybe.acc.java.programacadastro.service;

import com.trybe.acc.java.programacadastro.bean.DadosRetornoCadastro;

import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CadastroService {

  Map<Integer, DadosRetornoCadastro> dados = new HashMap<>();

  /**
   * Método responsável pelo cadastro. Insere os dados e retorna um
   * DadosRetornoCadastro.
   */
  public DadosRetornoCadastro cadastrar(String nome, String email, boolean protegido) {
    Integer id = (int) (Math.random() * 100);
    DadosRetornoCadastro retorno = new DadosRetornoCadastro();
    retorno.setIdCadastro(id);
    retorno.setNome(nome);
    retorno.setEmail(email);
    retorno.setProtegido(protegido);
    dados.put(id, retorno);
    return retorno;
  }

  public DadosRetornoCadastro obter(Integer id) {
    return dados.get(id);
  }

}
