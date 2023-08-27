package com.trybe.gestaotime.daotest;

import static org.junit.Assert.assertEquals;
import com.trybe.gestaotime.dao.TorcedorDao;
import com.trybe.gestaotime.model.Torcedor;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TorcedorDaoTest {

  private TorcedorDao torcedorDao;

  public TorcedorDaoTest() {
    this.torcedorDao = new TorcedorDao();
  }

  @BeforeEach
  public void init() {
    this.limparDadosTorcedores();
  }

  @Test
  @DisplayName("19 - Deve Salvar um Torcedor.")
  public void deveSalvar() {
    this.torcedorDao.salvar(this.criarTorcedor("Torcedor A"));
    this.torcedorDao.salvar(this.criarTorcedor("Torcedor A"));
    this.torcedorDao.salvar(this.criarTorcedor("Torcedor A"));
    this.torcedorDao.salvar(this.criarTorcedor("Torcedor A"));
    this.torcedorDao.salvar(this.criarTorcedor("Torcedor A"));

    List<Torcedor> resultado = this.torcedorDao.listar();

    assertEquals(5, resultado.size());
    assertEquals("Torcedor A", resultado.get(0).getNome());
  }

  @Test
  @DisplayName("20 - Deve Listar um Torcedor.")
  public void deveListar() {
    this.torcedorDao.salvar(this.criarTorcedor("Torcedor A"));
    this.torcedorDao.salvar(this.criarTorcedor("Torcedor A"));
    this.torcedorDao.salvar(this.criarTorcedor("Torcedor A"));
    this.torcedorDao.salvar(this.criarTorcedor("Torcedor A"));

    List<Torcedor> resultado = this.torcedorDao.listar();

    assertEquals(4, resultado.size());
  }

  @Test
  @DisplayName("21 - Deve Editar um Torcedor.")
  public void deveEditar() {
    this.torcedorDao.salvar(this.criarTorcedor("Torcedor A"));

    Torcedor torcedor = this.torcedorDao.listar().get(0);

    torcedor.setNome("Torcedor B");

    this.torcedorDao.editar(torcedor);

    // VERIFICAÇÃO DO RESULTADO ESPERADO
    List<Torcedor> listaResultados = this.torcedorDao.listar();

    assertEquals(1, listaResultados.size());
    assertEquals("Torcedor B", listaResultados.get(0).getNome());
  }

  @Test
  @DisplayName("22 - Deve Excluir um Torcedor.")
  public void deveExcluir() {
    this.torcedorDao.salvar(this.criarTorcedor("Torcedor A"));

    Torcedor torcedor = this.torcedorDao.listar().get(0);

    this.torcedorDao.deletar(torcedor.getId());

    // VERIFICAÇÃO DO RESULTADO ESPERADO
    List<Torcedor> listaResultados = this.torcedorDao.listar();

    assertEquals(0, listaResultados.size());
  }

  private void limparDadosTorcedores() {
    List<Torcedor> torcedores = this.torcedorDao.listar();

    for (Torcedor jogador : torcedores) {
      this.torcedorDao.deletar(jogador.getId());
    }
  }

  public Torcedor criarTorcedor(String nome) {
    Torcedor torcedor = new Torcedor();
    torcedor.setNome(nome);
    return torcedor;
  }

}
