package com.trybe.acc.java.jogodasfazendas;

public class Circle implements Farm {

  static double PI = 3.14;
  int radius;

  public Circle(int radius) {
    this.radius = radius;
  }

  public double area() {
    return (int) Math.pow(radius, 2) * PI;
  }

}
