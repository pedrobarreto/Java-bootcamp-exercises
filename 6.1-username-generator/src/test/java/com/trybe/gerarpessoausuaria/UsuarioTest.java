package com.trybe.gerarpessoausuaria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.trybe.gerarpessoausuaria.Usuario;


public class UsuarioTest {

  @Test
  @DisplayName("1 - Valida se usuário executa regra")
  public void validaSeUsuarioExecutaRegra() {
    var p = new Usuario("bruce", "wayne");

    assertEquals("bruce.wayne", p.getUsuario());
  }

  @Test
  @DisplayName("2 - Valida se usuário é sub-classe de pessoa")
  public void validaSeUsuarioEhSubclasseDePessoa() {
    var p = new Usuario("bruce", "wayne");

    assertEquals("Pessoa", p.getClass().getSuperclass().getSimpleName());
  }

  @Test
  @DisplayName("3 - Valida se usuário executa regra com nome nulo")
  public void validaSeUsuarioExecutaRegraComNomeNulo() {
    var p = new Usuario(null, "wayne");

    assertEquals("Usuário inválido", p.getUsuario());
  }

  @Test
  @DisplayName("4 - Valida se usuário executa regra com sobrenome nulo")
  public void validaSeUsuarioExecutaRegraComSobrenomeNulo() {
    var p = new Usuario("bruce", null);

    assertEquals("Usuário inválido", p.getUsuario());
  }

  @Test
  @DisplayName("5 - Valida se usuário executa regra com nome vazio")
  public void validaSeUsuarioExecutaRegraComNomeVazio() {
    var p = new Usuario("", "wayne");

    assertEquals("Usuário inválido", p.getUsuario());
  }

  @Test
  @DisplayName("6 - Valida se usuário executa regra com sobrenome vazio")
  public void validaSeUsuarioExecutaRegraComSobrenomeVazio() {
    var p = new Usuario("bruce", "");

    assertEquals("Usuário inválido", p.getUsuario());
  }

  @Test
  @DisplayName("7 - Valida se método implementa na sub-classe")
  public void validaSeMetodoImplementadoNaSubclasse() {
    var p = new Usuario("bruce", "wayne");
    assertEquals(Arrays.stream(p.getClass().getDeclaredMethods()).count(), 1);
    assertEquals(Arrays.stream(p.getClass().getSuperclass().getDeclaredMethods()).count(), 0);
  }

  @Test
  @DisplayName("8 - Valida se método implementado tem nome correto")
  public void validaSeMetodoImplementadoNaSubclasseTemNomeCorreto() {
    var p = new Usuario("bruce", "wayne");
    assertEquals(Arrays.stream(p.getClass().getDeclaredMethods()).count(), 1);
    assertEquals(Arrays.stream(p.getClass().getDeclaredMethods()).collect(Collectors.toList())
        .get(0).getName(), "getUsuario");
  }

  @Test
  @DisplayName("9 - Valida se atributos estao declarados")
  public void validaSeAtributosDeclaradosNaSuperclass() {
    var p = new Usuario("bruce", "wayne");
    assertEquals(Arrays.stream(p.getClass().getSuperclass().getDeclaredFields()).count(), 2);
  }

  @Test
  @DisplayName("10 - Valida se atributos declarados tem nomes corretos")
  public void validaSeAtributosDeclaradosNaSuperclassTemNomesCorretos() {
    var p = new Usuario("bruce", "wayne");
    assertEquals(Arrays.stream(p.getClass().getSuperclass().getDeclaredFields()).count(), 2);
    assertEquals(Arrays.stream(p.getClass().getSuperclass().getDeclaredFields())
        .collect(Collectors.toList()).get(0).getName(), "nome");
    assertEquals(Arrays.stream(p.getClass().getSuperclass().getDeclaredFields())
        .collect(Collectors.toList()).get(1).getName(), "sobrenome");
  }
}
