package com.trybe.acc.java.jogodasfazendas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class FarmTest {

  @Test
  @Order(1)
  @DisplayName("1 - Verifica se Farm é uma interface.")
  void farmIsInterface() {
    assertTrue(Farm.class.isInterface());
  }

  @Test
  @Order(2)
  @DisplayName("2 - Verifica se classe Polygon é abstrato.")
  void polugonIsAbstract() {
    assertTrue(Modifier.isAbstract(Polygon.class.getModifiers()));
  }

  @Test
  @Order(3)
  @DisplayName("3 - Verifica se atributos da classe Circle são estáticos.")
  void circleAtributeIsStatic() {
    assertTrue(piAttributeOfCircleIsStatic());
  }

  @Test
  @Order(4)
  @DisplayName("4 - Verifica se área do Square é calculada corretamente.")
  void squareAreaCalc() {
    assertEquals(9, new Square(3).area());
  }

  @Test
  @Order(5)
  @DisplayName("5 - Verifica se área do Square de lado zero é calculada corretamente.")
  void squareZeroAreaCalc() {
    assertEquals(0, new Square(0).area());
  }

  @Test
  @Order(6)
  @DisplayName("6 - Verifica se área do Triangle é calculada corretamente.")
  void triangleAreaCalc() {
    assertEquals(4.5, new Triangle(1.8, 5).area());
  }

  @Test
  @Order(7)
  @DisplayName("7 - Verifica se área do Triangle de um lado zero é calculada corretamente.")
  void triangleZeroAreaCalc() {
    assertEquals(0, new Triangle(0, 1).area());
  }

  @Test
  @Order(8)
  @DisplayName("8 - Verifica se área do Rectangle é calculada corretamente.")
  void rectangleAreaCalc() {
    assertEquals(9, new Rectangle(1.8, 5).area());
  }

  @Test
  @Order(9)
  @DisplayName("9 - Verifica se área do Rectangle de um lado zero é calculada corretamente.")
  void rectangleZeroAreaCalc() {
    assertEquals(0, new Rectangle(0, 1).area());
  }

  @Test
  @Order(10)
  @DisplayName("10 - Verifica se área do Circle é calculada corretamente.")
  void circleAreaCalc() {
    assertEquals(314, new Circle(10).area());
  }

  @Test
  @Order(11)
  @DisplayName("11 - Verifica se área do Circle de raio zero é calculada corretamente.")
  void circleZeroAreaCalc() {
    assertEquals(0, new Circle(0).area());
  }

  @Test
  @Order(12)
  @DisplayName("12 - Simula um jogo e verifica se o ganhador está correto.")
  void player() {
    Square sq = new Square(14);
    Triangle tr = new Triangle(5, 32);
    Rectangle rc = new Rectangle(3.5, 20);
    Circle c = new Circle(10);

    Farm[] farms = {sq, tr, rc, c};

    PlayerResult p1 = new PlayerResult("Farmer", farms);

    assertEquals(660, p1.score());
  }

  boolean piAttributeOfCircleIsStatic() {
    List<Field> declaredFields = Arrays.asList(Circle.class.getDeclaredFields());
    Field pi = declaredFields.stream().filter(f -> f.getName().equals("PI")).findAny().get();
    return Modifier.isStatic(pi.getModifiers());
  }

}
