package com.trybe.acc.java.datacenter;

import com.trybe.acc.java.datacenter.entity.Aplicacao;
import com.trybe.acc.java.datacenter.entity.Datacenter;
import com.trybe.acc.java.datacenter.entity.Servidor;
import com.trybe.acc.java.datacenter.service.DatacenterService;

/**
 * Hello world.
 *
 */
public class App {
  /**
   * Metodo main.
   */
  public static void main(String[] args) {

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

    // Colocando App3 no servidor 2 do datacenter 2
    servidor2D2.addAplicacao(app3);

    service.update(datacenter2);

  }
}
