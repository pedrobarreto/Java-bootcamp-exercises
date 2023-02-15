package com.trybe.acc.java.jogodasfazendas;

public class Square implements Farm {

  int base;

  public Square(int base) {
    this.base = base;
  }


  public double area() {

    return (int) base * base;
  }


}

