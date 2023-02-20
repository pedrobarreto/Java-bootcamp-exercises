package com.trybe.acc.java;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperacoesVeiculosTest {
	
  @Test
  @DisplayName("1 - Contar corretamente a quantidade de veículos diferentes em um Stream")
  void testNumVeiculosDiferentesVendidos() {
    Stream<String> s = Stream.of("Gol", "Gol", "Palio", "Siena", "Uno", "Uno", "Palio");
    Stream<Veiculo> s2 = Stream.of(new Veiculo("Gol"), new Veiculo("Gol"), new Veiculo("Palio"), new Veiculo("Uno"), new Veiculo("Uno"), new Veiculo("Palio"));
    OperacoesVeiculos op = new OperacoesVeiculos();
    assertEquals(4, op.numVeiculosDiferentesVendidos(s));
    assertEquals(3, op.numVeiculosDiferentesVendidos(s2));
  }
	
  @Test
  @DisplayName("2 - Retornar Stream de Strings a partir de um Stream de objetos Veículo")
  void testObterRepresentacaos() {
    OperacoesVeiculos op = new OperacoesVeiculos();
    Stream<Veiculo> s2 = Stream.of(new Veiculo("Gol"), new Veiculo("Gol"), new Veiculo("Palio"), new Veiculo("Uno"), new Veiculo("Uno"), new Veiculo("Palio"));
    Stream<Veiculo> s2Copy = Stream.of(new Veiculo("Gol"), new Veiculo("Gol"), new Veiculo("Palio"), new Veiculo("Uno"), new Veiculo("Uno"), new Veiculo("Palio"));
    Stream<String> representacao = op.obterRepresentacao(s2Copy);
    List<String> listaRepresentacao = representacao.collect(Collectors.toList());
    assertEquals(listaRepresentacao, op.obterRepresentacao(s2).collect(Collectors.toList()));
  }
	
  @Test
  @DisplayName("3 - Obetr uma lista de veículos a partir de um Stream de veículos")
  void testObterLista() {
    OperacoesVeiculos op = new OperacoesVeiculos();
    Stream<String> s = Stream.of("Gol", "Gol", "Palio", "Siena", "Uno", "Uno", "Palio");
    Stream<String> sCopy = Stream.of("Gol", "Gol", "Palio", "Siena", "Uno", "Uno", "Palio");
    Stream<Veiculo> s2 = Stream.of(new Veiculo("Gol"), new Veiculo("Gol"), new Veiculo("Palio"), new Veiculo("Uno"), new Veiculo("Uno"), new Veiculo("Palio"));
    Stream<Veiculo> s2Copy = Stream.of(new Veiculo("Gol"), new Veiculo("Gol"), new Veiculo("Palio"), new Veiculo("Uno"), new Veiculo("Uno"), new Veiculo("Palio"));
    List<String> lista = s.collect(Collectors.toList());
    assertEquals(lista, op.obterLista(sCopy));
		
    List<Veiculo> lista2 = s2.collect(Collectors.toList());
    assertEquals(lista2, op.obterLista(s2Copy));
  }
	
	
  public static class Veiculo {
    private String nome;

    public Veiculo(String nome) {
        this.nome = nome;
    }

    /**
     * @return
     * @see java.lang.Object#hashCode()
     * @Override
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    /**
     * @param obj
     * @return
     * @see java.lang.Object#equals(java.lang.Object)
     * @Override
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
          return true;
        if (obj == null)
          return false;
        if (getClass() != obj.getClass())
          return false;
        Veiculo other = (Veiculo) obj;
        if (nome == null) {
          if (other.nome != null)
            return false;
          } else if (!nome.equals(other.nome))
             return false;
          return true;
    }

    /**
     * @return
     * @see java.lang.Object#toString()
     * @Override
     */
    @Override
    public String toString() {
			return "Veiculo: " + nome;
    }
		
  }

}
