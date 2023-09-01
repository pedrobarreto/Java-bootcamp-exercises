package com.trybe.acc.java.hibernate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.trybe.acc.java.hibernate.entity.Veiculo;

class ApplicationTest {

  private Long save(Veiculo v) {
    try {
      EntityManagerFactory emf =
          Persistence.createEntityManagerFactory("com.trybe.acc.java.hibernate.veiculo-hibernate");
      EntityManager em = emf.createEntityManager();

      em.getTransaction().begin();
      em.persist(v);
      em.getTransaction().commit();

      em.close();
      return v.getId();
    } catch (Exception e) {
      return (long) 0;
    }

  }

  private Veiculo findById(Long id) {

    try {
      EntityManagerFactory emf =
          Persistence.createEntityManagerFactory("com.trybe.acc.java.hibernate.veiculo-hibernate");
      EntityManager em = emf.createEntityManager();

      Veiculo v = em.find(Veiculo.class, id);

      em.close();
      return v;

    } catch (Exception e) {
      return null;
    }

  }

  private boolean delete(Long id) {

    try {
      EntityManagerFactory emf =
          Persistence.createEntityManagerFactory("com.trybe.acc.java.hibernate.veiculo-hibernate");
      EntityManager em = emf.createEntityManager();

      Veiculo v = em.find(Veiculo.class, id);

      em.getTransaction().begin();
      em.remove(v);
      em.getTransaction().commit();

      em.close();
      return true;

    } catch (Exception e) {
      return false;
    }

  }

  @Test
  @DisplayName("1 - Verifica se veículo foi adicionado com sucesso.")
  void checkInsertVeiculo() {

    Veiculo v = new Veiculo();
    v.setAno(2022);
    v.setModelo("Uno");
    v.setQuilometragem("0");

    Long id = this.save(v);
    assertNotEquals(0, id);

    Veiculo insertedVeiculo = this.findById(id);
    assertEquals(2022, insertedVeiculo.getAno());
    assertEquals("Uno", insertedVeiculo.getModelo());
    assertEquals("0", insertedVeiculo.getQuilometragem());

    this.delete(insertedVeiculo.getId());

  }

}
