package com.trybe.acc.java.jogodasfazendas;

public class Rectangle extends Polygon implements Farm {

  public Rectangle(double base, double height) {
    super.base = base;
    super.height = height;
  }

  /**
   * Imprime área do Retangulo.
   */
  public double area() {

    return super.base * super.height;

  }
}
