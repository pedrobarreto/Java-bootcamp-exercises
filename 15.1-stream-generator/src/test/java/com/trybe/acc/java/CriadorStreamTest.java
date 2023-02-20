package com.trybe.acc.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CriadorStreamTest {
  CriadorStream criador = new CriadorStream();

  @Test
  @DisplayName("1 - Criação do item")
  void criarDoItemTest() {
    assertStreamEquals(Stream.of("João"), criador.criarDoItem("João"));
    assertStreamEquals(Stream.of(Integer.valueOf(5)), criador.criarDoItem(Integer.valueOf(5)));
  }

  @Test
  @DisplayName("2 - Criação do array")
  void criarDoArrayTest() {
    String[] strArray1 = new String[] { "João" };
    assertStreamEquals(Stream.of(strArray1), criador.criarDoArray(strArray1));
    String[] strArray2 = new String[] {};
    assertStreamEquals(Stream.of(strArray2), criador.criarDoArray(strArray2));
    Integer[] intArray1 = new Integer[] { Integer.valueOf(5) };
    assertStreamEquals(Stream.of(intArray1), criador.criarDoArray(intArray1));
    String[] strArray3 = new String[] { "João", "Maria", "José" };
    assertStreamEquals(Stream.of(strArray3), criador.criarDoArray(strArray3));
  }

  @Test
  @DisplayName("3 - Criação da lista")
  void criarDaListTest() {
    var strList1 = List.of("João");
    assertStreamEquals(strList1.stream(), criador.criarDaLista(strList1));
    var strList2 = Collections.emptyList();
    assertStreamEquals(strList2.stream(), criador.criarDaLista(strList2));
    var intList1 = List.of(Integer.valueOf(5));
    assertStreamEquals(intList1.stream(), criador.criarDaLista(intList1));
    var strList3 = List.of("João", "Maria", "José");
    assertStreamEquals(strList3.stream(), criador.criarDaLista(strList3));
  }

  static void assertStreamEquals(Stream<?> s1, Stream<?> s2) {
    Iterator<?> iter1 = s1.iterator(), iter2 = s2.iterator();
    while (iter1.hasNext() && iter2.hasNext()) {
        assertEquals(iter1.next(), iter2.next());
    }
    assert !iter1.hasNext() && !iter2.hasNext();
  }

}
