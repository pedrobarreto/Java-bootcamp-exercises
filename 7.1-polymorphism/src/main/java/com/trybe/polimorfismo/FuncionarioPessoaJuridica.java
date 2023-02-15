package com.trybe.polimorfismo;

public class FuncionarioPessoaJuridica extends Funcionario {

  @Override
  public double calcularSalarioLiquido() {

    double salarioBruto = super.getSalarioBruto();

    // TODO Auto-generated method stub

    return salarioBruto - (salarioBruto * 0.1);
  }

}
