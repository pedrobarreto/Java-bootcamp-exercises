package com.trybe.acc.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperacoesVeiculos {



  <T> int numVeiculosDiferentesVendidos(Stream<T> veiculosVendidos) {

    return (int) veiculosVendidos.distinct().count();

  }

  <T> Stream<String> obterRepresentacao(Stream<T> veiculos) {
    return veiculos.map(veiculo -> veiculo.toString());
  }

  <T> List<T> obterLista(Stream<T> veiculos) {
    List<T> novaListaDeVeiculos = veiculos.collect(Collectors.toList());
    return novaListaDeVeiculos;
  }

}
