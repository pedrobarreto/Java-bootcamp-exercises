package com.trybe.gestaotime.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.trybe.gestaotime.dao.DocumentoDao;
import com.trybe.gestaotime.dao.JogadorDao;
import com.trybe.gestaotime.dao.TimeDao;
import com.trybe.gestaotime.model.Documento;
import com.trybe.gestaotime.model.Jogador;
import com.trybe.gestaotime.model.Time;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class JogadorDaoTest {

  private JogadorDao jogadorDao;
  private TimeDao timeDao;
  private DocumentoDao documentoDao;

  public JogadorDaoTest() {
    this.jogadorDao = new JogadorDao();
    this.timeDao = new TimeDao();
    this.documentoDao = new DocumentoDao();
  }

  @Before
  public void init() {
    this.limparDados();
  }

  @Test
  @DisplayName("5 - Deve Salvar um Jogador.")
  public void deveSalvar() {
    this.jogadorDao.salvar(this.criarJogador("Jogador", "Atacante", null, null));

    List<Jogador> resultado = this.jogadorDao.listar();

    assertEquals(1, resultado.size());
    assertEquals("Jogador", resultado.get(0).getNome());
    assertEquals("Atacante", resultado.get(0).getPosicao());
  }

  @Test
  @DisplayName("6 - Deve Salvar um Jogador com um Time.")
  public void deveSalvarComTime() {
    this.jogadorDao
        .salvar(this.criarJogador("Jogador", "Atacante", this.criarTime("Time A"), null));

    List<Jogador> resultado = this.jogadorDao.listar();

    assertEquals(1, resultado.size());
    assertEquals("Jogador", resultado.get(0).getNome());
    assertEquals("Atacante", resultado.get(0).getPosicao());
    assertEquals("Time A", resultado.get(0).getTime().getNome());

  }

  @Test
  @DisplayName("7 - Deve Salvar um Jogador com um Documento.")
  public void deveSalvarComDocumento() {
    this.jogadorDao.salvar(
        this.criarJogador("Jogador", "Atacante", null, this.criarDocumento("123", null, null)));

    List<Jogador> resultado = this.jogadorDao.listar();

    assertEquals(1, resultado.size());
    assertEquals("Jogador", resultado.get(0).getNome());
    assertEquals("Atacante", resultado.get(0).getPosicao());
    assertEquals("123", resultado.get(0).getDocumento().getNumeroCarteiraTrabalho());

  }

  @Test
  @DisplayName("8 - Deve Listar Jogadores.")
  public void deveListar() {
    for (int i = 0; i < 5; i++) {
      this.jogadorDao.salvar(this.criarJogador("Jogador", "Atacante", this.criarTime("Time A" + i),
          this.criarDocumento("123" + i, null, null)));
    }

    List<Jogador> resultado = this.jogadorDao.listar();

    assertEquals(5, resultado.size());

    for (int i = 0; i < 5; i++) {
      assertEquals("Jogador", resultado.get(i).getNome());
      assertEquals("Atacante", resultado.get(i).getPosicao());
      assertNotNull(resultado.get(i).getTime());
      assertNotNull(resultado.get(i).getDocumento());

    }
  }

  @Test
  @DisplayName("9 - Deve editar um Jogador.")
  public void deveEditar() {
    this.jogadorDao.salvar(this.criarJogador("Jogador A", null, null, null));

    Jogador jogador = this.jogadorDao.listar().get(0);

    jogador.setNome("Jogador B");

    this.jogadorDao.editar(jogador);

    // VERIFICAÇÃO DO RESULTADO ESPERADO
    List<Jogador> listaResultados = this.jogadorDao.listar();

    assertEquals(1, listaResultados.size());
    assertEquals("Jogador B", listaResultados.get(0).getNome());
  }

  @Test
  @DisplayName("10 - Deve Excluir um jogador.")
  public void deveExcluir() {
    this.jogadorDao.salvar(this.criarJogador("Jogador A", null, null, null));

    Jogador jogador = this.jogadorDao.listar().get(0);

    this.jogadorDao.deletar(jogador.getId());

    // VERIFICAÇÃO DO RESULTADO ESPERADO
    List<Jogador> listaResultados = this.jogadorDao.listar();

    assertEquals(0, listaResultados.size());
  }


  private void limparDados() {
    this.limparDadosJogador();
    this.limparDadosTime();
    this.limparDadosDocumento();
  }

  private void limparDadosJogador() {
    List<Jogador> objetos = this.jogadorDao.listar();

    for (Jogador objeto : objetos) {
      this.jogadorDao.deletar(objeto.getId());
    }
  }

  private void limparDadosTime() {
    List<Time> objetos = this.timeDao.listar();

    for (Time objeto : objetos) {
      this.timeDao.deletar(objeto.getId());
    }
  }

  private void limparDadosDocumento() {
    List<Documento> objetos = this.documentoDao.listar();

    for (Documento objeto : objetos) {
      this.documentoDao.deletar(objeto.getId());
    }
  }

  private Jogador criarJogador(String nome, String posicao, Time time, Documento documento) {
    Jogador jogador = new Jogador();
    jogador.setNome(nome);
    jogador.setPosicao(posicao);
    jogador.setTime(time);
    jogador.setDocumento(documento);

    return jogador;
  }

  private Time criarTime(String nome) {
    Time time = new Time();
    time.setNome(nome);
    this.timeDao.salvar(time);

    return this.timeDao.listar().get(0);
  }

  private Documento criarDocumento(String numeroCarteiraTrabalho, String cpf, String numeroCbf) {
    Documento documento = new Documento();
    System.out.println(numeroCarteiraTrabalho);
    documento.setNumeroCarteiraTrabalho(numeroCarteiraTrabalho);
    documento.setCpf(cpf);
    documento.setNumeroCbf(numeroCbf);
    this.documentoDao.salvar(documento);

    return this.documentoDao.listar().get(0);
  }

}
