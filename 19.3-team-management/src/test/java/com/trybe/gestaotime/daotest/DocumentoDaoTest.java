package com.trybe.gestaotime.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.trybe.gestaotime.dao.DocumentoDao;
import com.trybe.gestaotime.model.Documento;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DocumentoDaoTest {

  private DocumentoDao documentoDao;

  public DocumentoDaoTest() {
    this.documentoDao = new DocumentoDao();
  }

  @BeforeEach
  public void init() {
    this.limparDados();
  }

  @Test
  @DisplayName("1 - Deve Salvar um Documento.")
  public void deveSalvar() {
    // MONTAGEM DO CENÁRIO E CHAMADA DA AÇÃO
    this.documentoDao.salvar(this.criarObjeto("544", "544554454", "787"));

    // VERIFICAÇÃO DO RESULTADO ESPERADO
    List<Documento> resultado = this.documentoDao.listar();

    assertEquals(1, resultado.size());
    assertEquals("544", resultado.get(0).getNumeroCarteiraTrabalho());
    assertEquals("544554454", resultado.get(0).getCpf());
    assertEquals("787", resultado.get(0).getNumeroCbf());
  }

  @Test
  @DisplayName("2 - Deve Realizar Listagem de Documento.")
  public void deveListar() {

    // MONTAGEM DO CENÁRIO E CHAMADA DA AÇÃO
    for (int i = 0; i <= 5; i++) {
      this.documentoDao.salvar(this.criarObjeto("544", "544554454", "787"));
    }

    // VERIFICAÇÃO DO RESULTADO ESPERADO
    List<Documento> resultado = this.documentoDao.listar();

    assertEquals(6, resultado.size());

  }

  @Test
  @DisplayName("3 - Deve Editar um Documento.")
  public void deveEditar() {
    this.documentoDao.salvar(this.criarObjeto("544", "544554454", "787"));

    Documento resultado = this.documentoDao.listar().get(0);

    resultado.setCpf("11111");

    this.documentoDao.editar(resultado);

    // VERIFICAÇÃO DO RESULTADO ESPERADO
    List<Documento> listaResultados = this.documentoDao.listar();

    assertEquals(1, listaResultados.size());
    assertEquals("544", listaResultados.get(0).getNumeroCarteiraTrabalho());
    assertEquals("11111", listaResultados.get(0).getCpf());
    assertEquals("787", listaResultados.get(0).getNumeroCbf());

  }

  @Test
  @DisplayName("4 - Deve Deletar um Documento.")
  public void deveDeletar() {
    this.documentoDao.salvar(this.criarObjeto("544", "544554454", "787"));

    Documento resultado = this.documentoDao.listar().get(0);

    this.documentoDao.deletar(resultado.getId());

    // VERIFICAÇÃO DO RESULTADO ESPERADO
    List<Documento> listaResultados = this.documentoDao.listar();

    assertEquals(0, listaResultados.size());


  }

  private void limparDados() {
    List<Documento> objetos = this.documentoDao.listar();

    for (Documento documento : objetos) {
      this.documentoDao.deletar(documento.getId());
    }
  }

  private Documento criarObjeto(String numeroCarteiraTrabalho, String cpf, String numeroCbf) {
    Documento documento = new Documento();
    documento.setNumeroCarteiraTrabalho(numeroCarteiraTrabalho);
    documento.setCpf(cpf);
    documento.setNumeroCbf(numeroCbf);

    return documento;
  }

}
