package com.trybe.acc.java;

import java.util.List;
import java.util.stream.Stream;

public class CriadorStream {

  <T> Stream<T> criarDoItem(T item) {
    Stream<T> itens = Stream.of(item);
    return itens;
  }

  <T> Stream<T> criarDoArray(T[] array) {
    Stream<T> arrayItens = Stream.of(array);
    return arrayItens;
  }

  <T> Stream<T> criarDaLista(List<T> lista) {
    Stream<T> listaDeItens = lista.stream();
    return listaDeItens;
  }

}
