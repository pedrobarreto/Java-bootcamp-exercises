package com.trybe.acc.java.jogodasfazendas;

public class PlayerResult {

  String name;
  double totalArea = 0;
  Farm[] farms;


  /**
   * Calc player total area .
   */

  public PlayerResult(String name, Farm[] farms) {

    this.name = name;
    this.farms = farms;

  }

  double score() {


    for (int i = 0; i < farms.length; i++) {
      totalArea += farms[i].area();
    }

    return totalArea;


  }

}
