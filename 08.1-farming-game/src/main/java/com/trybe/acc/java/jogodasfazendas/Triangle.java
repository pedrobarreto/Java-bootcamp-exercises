package com.trybe.acc.java.jogodasfazendas;


public class Triangle extends Polygon implements Farm {

  public Triangle(double base, double height) {
    super.base = base;
    super.height = height;
  }

  /**
   * Imprime área do Triangulo.
   */
  public double area() {

    return (super.base * super.height) / 2;

  }

}
