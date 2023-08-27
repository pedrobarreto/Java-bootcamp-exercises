package com.trybe.gestaotime.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.trybe.gestaotime.dao.JogadorDao;
import com.trybe.gestaotime.dao.TimeDao;
import com.trybe.gestaotime.dao.TorcedorDao;
import com.trybe.gestaotime.model.Jogador;
import com.trybe.gestaotime.model.Time;
import com.trybe.gestaotime.model.Torcedor;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class TimeDaoTest {

  private static final String PRE_FIXO_JOGADOR = "JOGADOR";
  private static final String PRE_FIXO_TORCEDOR = "TORCEDOR";

  private TimeDao timeDao;
  private JogadorDao jogadorDao;
  private TorcedorDao torcedorDao;

  public TimeDaoTest() {
    this.timeDao = new TimeDao();
    this.jogadorDao = new JogadorDao();
    this.torcedorDao = new TorcedorDao();
  }

  @Before
  public void init() {
    this.limparDados();
  }

  @Test
  @DisplayName("11 - Deve Salvar um Time.")
  public void deveSalvar() {
    this.timeDao.salvar(this.criarObjeto("Meu time", null, null));

    List<Time> resultado = this.timeDao.listar();

    assertEquals(1, resultado.size());
    assertEquals("Meu time", resultado.get(0).getNome());
  }

  @Test
  @DisplayName("12 - Deve Salvar um Time com Jogadores.")
  public void deveSalvarComJogadores() {
    int quantidadejogadores = 11;

    this.timeDao
        .salvar(this.criarObjeto("Meu time", this.criarJogadores(quantidadejogadores), null));

    List<Time> resultado = this.timeDao.listar();

    assertEquals(1, resultado.size());
    assertEquals("Meu time", resultado.get(0).getNome());
    assertEquals(quantidadejogadores, resultado.get(0).getJogadores().size());
  }

  @Test
  @DisplayName("13 - Deve Salvar um Time com Torcedores.")
  public void deveSalvarComTorcedores() {
    int quantidadeTorcedores = 5;

    this.timeDao
        .salvar(this.criarObjeto("Meu time", null, this.criarTorcedor(quantidadeTorcedores)));

    List<Time> resultado = this.timeDao.listar();

    assertEquals(1, resultado.size());
    assertEquals("Meu time", resultado.get(0).getNome());
    assertEquals(quantidadeTorcedores, resultado.get(0).getTorcedores().size());
  }

  @Test
  @DisplayName("14 - Deve Listar Times.")
  public void deveListar() {
    int quantidadeTimes = 10;

    for (int x = 0; x < quantidadeTimes; x++) {
      this.timeDao.salvar(this.criarObjeto("Meu time", null, null));
    }

    List<Time> resultado = this.timeDao.listar();

    assertEquals(quantidadeTimes, resultado.size());
  }

  @Test
  @DisplayName("15 - Deve Listar Time com Jogadores.")
  public void deveListarComJogadores() {
    int quantidadejogadores = 11;

    this.timeDao
        .salvar(this.criarObjeto("Meu time", this.criarJogadores(quantidadejogadores), null));

    List<Time> resultado = this.timeDao.listar();

    assertEquals(1, resultado.size());
    assertEquals("Meu time", resultado.get(0).getNome());
    assertEquals(quantidadejogadores, resultado.get(0).getJogadores().size());
  }

  @Test
  @DisplayName("16 - Deve Listar Time com Torcedores.")
  public void deveListarComTorcedores() {
    int quantidadeTorcedores = 5;

    this.timeDao
        .salvar(this.criarObjeto("Meu time", null, this.criarTorcedor(quantidadeTorcedores)));

    List<Time> resultado = this.timeDao.listar();

    assertEquals(1, resultado.size());
    assertEquals("Meu time", resultado.get(0).getNome());
    assertEquals(quantidadeTorcedores, resultado.get(0).getTorcedores().size());

  }

  @Test
  @DisplayName("17 - Deve Editar Time.")
  public void deveEditar() {
    this.timeDao.salvar(this.criarObjeto("Time A", null, null));

    Time time = this.timeDao.listar().get(0);

    time.setNome("Time B");

    this.timeDao.editar(time);

    // VERIFICAÇÃO DO RESULTADO ESPERADO
    List<Time> listaResultados = this.timeDao.listar();

    assertEquals(1, listaResultados.size());
    assertEquals("Time B", listaResultados.get(0).getNome());

  }

  @Test
  @DisplayName("18 - Deve Deletar Time")
  public void deveDeletar() {
    this.timeDao.salvar(this.criarObjeto("Time A", null, null));

    Time time = this.timeDao.listar().get(0);

    this.timeDao.deletar(time.getId());

    // VERIFICAÇÃO DO RESULTADO ESPERADO
    List<Time> listaResultados = this.timeDao.listar();

    assertEquals(0, listaResultados.size());
  }

  private void limparDados() {
    this.limparDadosTime();
    this.limparDadosJogadores();
    this.limparDadosTorcedores();
  }

  private void limparDadosTime() {
    List<Time> objetos = this.timeDao.listar();

    for (Time documento : objetos) {
      this.timeDao.deletar(documento.getId());
    }
  }

  private void limparDadosJogadores() {
    List<Jogador> jogadores = this.jogadorDao.listar();

    for (Jogador jogador : jogadores) {
      this.jogadorDao.deletar(jogador.getId());
    }
  }

  private void limparDadosTorcedores() {
    List<Torcedor> torcedores = this.torcedorDao.listar();

    for (Torcedor jogador : torcedores) {
      this.torcedorDao.deletar(jogador.getId());
    }
  }

  private Time criarObjeto(String nome, List<Jogador> jogadores, List<Torcedor> torcedores) {
    Time time = new Time();
    time.setNome(nome);
    time.setJogadores(jogadores);
    time.setTorcedores(torcedores);

    return time;
  }

  @SuppressWarnings("unused")
  private List<Jogador> criarJogadores(Integer qtd) {
    List<Jogador> jogadores = new ArrayList<>();

    for (int x = 0; x < qtd; x++) {
      Jogador jogador = new Jogador();
      jogador.setNome(PRE_FIXO_JOGADOR + x);
      this.jogadorDao.salvar(jogador);
    }

    return this.jogadorDao.listar();
  }

  @SuppressWarnings("unused")
  private List<Torcedor> criarTorcedor(Integer qtd) {
    List<Torcedor> torcedores = new ArrayList<>();

    for (int x = 0; x < qtd; x++) {
      Torcedor torcedor = new Torcedor();
      torcedor.setNome(PRE_FIXO_TORCEDOR + x);
      this.torcedorDao.salvar(torcedor);
    }

    return this.torcedorDao.listar();
  }
}
