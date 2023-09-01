package com.trybe.acc.java.datacenter;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import com.trybe.acc.java.datacenter.entity.Aplicacao;
import com.trybe.acc.java.datacenter.entity.Datacenter;
import com.trybe.acc.java.datacenter.entity.Servidor;
import com.trybe.acc.java.datacenter.service.AplicacaoService;
import com.trybe.acc.java.datacenter.service.DatacenterService;
import com.trybe.acc.java.datacenter.service.ServiceInterface;
import com.trybe.acc.java.datacenter.service.ServidorService;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

  @BeforeAll
  public static void populateDB() {
    Aplicacao app1 = new Aplicacao();
    app1.setNome("FutuereH");
    app1.setDescricao("Java");

    Aplicacao app2 = new Aplicacao();
    app2.setNome("Agro Techfields");
    app2.setDescricao("Python");

    Aplicacao app3 = new Aplicacao();
    app3.setNome("Trybe Course");
    app3.setDescricao("Javascript");



    Datacenter datacenter1 = new Datacenter();
    datacenter1.setNome("Cerrado");
    datacenter1.setLocalidade("Brasilia");


    Servidor servidor1D1 = new Servidor();
    servidor1D1.setNome("LoboGuara");
    servidor1D1.setDatacenter(datacenter1);
    datacenter1.addServidor(servidor1D1);


    // Colocando App1 no servidor 1 do datacenter 1
    servidor1D1.addAplicacao(app1);

    // Colocando App2 no servidor 1 do datacenter 1
    servidor1D1.addAplicacao(app2);

    // Colocando App3 no servidor 1 do datacenter 1
    servidor1D1.addAplicacao(app3);


    Servidor servidor2D1 = new Servidor();
    servidor2D1.setNome("Ariranha");
    servidor2D1.setDatacenter(datacenter1);
    datacenter1.addServidor(servidor2D1);


    // Colocando App2 no servidor 2 do datacenter 1
    servidor2D1.addAplicacao(app2);

    // Colocando App3 no servidor 3 do datacenter 1
    servidor2D1.addAplicacao(app3);

    DatacenterService service = new DatacenterService();
    service.save(datacenter1);


    Datacenter datacenter2 = new Datacenter();
    datacenter2.setNome("Mata Atlântica");
    datacenter2.setLocalidade("São Paulo");

    Servidor servidor1D2 = new Servidor();
    servidor1D2.setNome("Tamanduá Bandeira");
    servidor1D2.setDatacenter(datacenter2);
    datacenter2.addServidor(servidor1D2);



    Servidor servidor2D2 = new Servidor();
    servidor2D2.setNome("Jaguatirica");
    servidor2D2.setDatacenter(datacenter2);
    datacenter2.addServidor(servidor2D2);


    service.save(datacenter2);

    // Colocando App3 no servidor 1 do datacenter 2
    servidor1D2.addAplicacao(app3);

    // Colocando App1 no servidor 2 do datacenter 2
    servidor2D2.addAplicacao(app1);

    // Colocando App2 no servidor 2 do datacenter 2
    servidor2D2.addAplicacao(app2);

    service.update(datacenter2);
  }

  @Test
  @DisplayName("1 - Verifica se classes de service implementam ServiceInterface")
  public void testServiceImplementation() {
    AplicacaoService app = new AplicacaoService();
    assertEquals(1, app.getClass().getInterfaces().length);
    assertTrue(app.getClass().getInterfaces()[0].getName()
        .equals("com.trybe.acc.java.datacenter.service.ServiceInterface"));

    ServidorService server = new ServidorService();
    assertEquals(1, server.getClass().getInterfaces().length);
    assertTrue(server.getClass().getInterfaces()[0].getName()
        .equals("com.trybe.acc.java.datacenter.service.ServiceInterface"));

    DatacenterService datacenter = new DatacenterService();
    assertEquals(1, datacenter.getClass().getInterfaces().length);
    assertTrue(datacenter.getClass().getInterfaces()[0].getName()
        .equals("com.trybe.acc.java.datacenter.service.ServiceInterface"));

    Stream.of(ServiceInterface.class.getDeclaredMethods()).forEach(method -> {
      assertTrue(method.getName().equals("update") || method.getName().equals("list")
          || method.getName().equals("delete") || method.getName().equals("save")
          || method.getName().equals("findById"));
    });
  }

  @Test
  @DisplayName("2 - Verifica insere corretamente a entidade Datacenter")
  public void testInsertDatacenter() {
    DatacenterService service = new DatacenterService();
    List<Datacenter> data = service.list();
    assertEquals(2, data.size());
  }

  @Test
  @DisplayName("3 - Verifica insere corretamente a entidade Servidor")
  public void testInsertServidor() {
    ServidorService service = new ServidorService();
    List<Servidor> data = service.list();
    assertEquals(4, data.size());
  }

  @Test
  @DisplayName("4 - Verifica insere corretamente a entidade Aplicação")
  public void testInsertAplicacao() {
    AplicacaoService service = new AplicacaoService();
    List<Aplicacao> data = service.list();
    assertEquals(3, data.size());
  }

  @Test
  @DisplayName("5 - Testa relacionamento OneToMany (Datacenter <-> Servidor)")
  public void testRelacionamentoOneToMany() {
    ServidorService service = new ServidorService();
    List<Servidor> data = service.list();
    assertEquals(4, data.size());

    data.forEach(s -> {
      if (s.getNome().equals("Ariranha") || s.getNome().equals("LoboGuara")) {
        assertEquals("Cerrado", s.getDatacenter().getNome());
      } else if (s.getNome().equals("Tamanduá Bandeira") || s.getNome().equals("Jaguatirica")) {

      } else {
        fail("Relacionamentos errados");
      }
    });

  }

  @Test
  @DisplayName("6 - Testa relacionamento ManyToMany (Servidor <-> Aplicação)")
  public void testRelacionamentoManyToMany() {
    ServidorService service = new ServidorService();
    List<Servidor> data = service.list();
    assertEquals(4, data.size());

    data.forEach(s -> {
      if (s.getNome().equals("Ariranha")) {
        s.getAplicacoes().forEach(a -> {
          assertEquals(true,
              a.getNome().equals("Trybe Course") || a.getNome().equals("Agro Techfields"));
        });
      } else if (s.getNome().equals("LoboGuara")) {
        s.getAplicacoes().forEach(a -> {
          assertEquals(true, a.getNome().equals("Trybe Course")
              || a.getNome().equals("Agro Techfields") || a.getNome().equals("FutuereH"));
        });
      } else if (s.getNome().equals("Tamanduá Bandeira")) {
        s.getAplicacoes().forEach(a -> {
          assertEquals(true, a.getNome().equals("Trybe Course"));
        });
      } else if (s.getNome().equals("Jaguatirica")) {
        s.getAplicacoes().forEach(a -> {
          assertEquals(true,
              a.getNome().equals("FutuereH") || a.getNome().equals("Agro Techfields"));
        });
      } else {
        fail("Relacionamentos errados");
      }
    });

  }

  @Test
  @DisplayName("7 - Testa se remove entidade Datacenter")
  public void testRemoveDatacenter() {

    Datacenter datacenter = new Datacenter();
    datacenter.setNome("Test");

    DatacenterService service = new DatacenterService();
    service.save(datacenter);
    service.delete(datacenter.getId());

    assertNull(service.findById(datacenter.getId()));
  }

  @Test
  @DisplayName("8 - Testa se remove entidade Servidor")
  public void testRemoveServidor() {

    Servidor servidor = new Servidor();
    servidor.setNome("Test");

    ServidorService service = new ServidorService();
    service.save(servidor);
    service.delete(servidor.getId());

    assertNull(service.findById(servidor.getId()));
  }

  @Test
  @DisplayName("9 - Testa se remove entidade Aplicação")
  public void testRemoveAplicacao() {

    Aplicacao aplicacao = new Aplicacao();
    aplicacao.setNome("Test");

    AplicacaoService service = new AplicacaoService();
    service.save(aplicacao);
    service.delete(aplicacao.getId());

    assertNull(service.findById(aplicacao.getId()));
  }

  @AfterAll
  public static void clearDB() {
    DatacenterService service = new DatacenterService();
    service.delete((long) 1);
    service.delete((long) 2);

    AplicacaoService appService = new AplicacaoService();
    appService.delete((long) (1));
    appService.delete((long) (2));
    appService.delete((long) (3));
  }
}
