package com.au.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaConexaoJPA {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Sistema-Gerenciador-de-Pastelaria-Pastelao-Web");
	
	public EntityManager getEntityManager(){
		return entityManagerFactory.createEntityManager();
	}
	
	public void close(EntityManager entityManager){
		entityManager.close();
	}
}
