package com.trybe.acc.java.sistemarh;

public class PessoaColaboradora {

  private double salarioBruto = 0.0;
  private double salarioLiquido = 0.0;
  private double imposto = 0.0;

  /**
   * Calcula salário Liquido.
   */
  public double calcularSalarioLiquido() {
    double imposto = this.salarioBruto * 0.2;
    double salarioLiquido = this.salarioBruto - imposto;
    this.setSalarioLiquido(salarioLiquido);
    this.setImposto(imposto);
    return this.salarioLiquido;
  }

  /**
   * Calcula valor bruto anual.
   */
  public double calcularValorBrutoRecebidoAnual(int ano) {
    int mesesTrabalhados = ano * 12;
    return (double) salarioBruto * mesesTrabalhados;
  }

  /**
   * Calcula valor liquido anual.
   */
  public double calcularValorLiquidoRecebidoAnual(int ano) {
    int mesesTrabalhados = ano * 12;
    this.calcularSalarioLiquido();

    return (double) this.salarioLiquido * mesesTrabalhados;
  }

  /**
   * Calcula imposto anual.
   */
  public double calcularValorImpostoAnual(int ano) {
    int mesesTrabalhados = ano * 12;
    this.calcularSalarioLiquido();
    return this.imposto * mesesTrabalhados;

  }

  public double getSalarioBruto() {
    return this.salarioBruto;
  }

  public void setSalarioBruto(double salarioBruto) {
    this.salarioBruto = salarioBruto;
  }

  public void setSalarioLiquido(double salarioLiquido) {
    this.salarioLiquido = salarioLiquido;
  }

  public void setImposto(double imposto) {
    this.imposto = imposto;
  }

}
