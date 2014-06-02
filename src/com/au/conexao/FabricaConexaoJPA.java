package com.au.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author BrunoRicardo
 */
public class FabricaConexaoJPA {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Sistema-Gerenciador-de-Pastelaria-Pastelao-Web");

    //Cria uma conexão através de uma entity manager
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    //Fecha a conexão através de uma entity manager
    public void close(EntityManager entityManager) {
        entityManager.close();
    }
}
