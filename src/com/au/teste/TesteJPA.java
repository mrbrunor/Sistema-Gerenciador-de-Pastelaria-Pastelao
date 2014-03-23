package com.au.teste;
/**
Author: BrunoRicardo
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.au.bean.Ingrediente;

public class TesteJPA {

	public static void main(String[] args) {
		
		Ingrediente ingrediente = new Ingrediente();
		ingrediente.setDescIng("Bacon");
		ingrediente.setValorIng(15);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SistemaPastelao");
		EntityManager manager = entityManagerFactory.createEntityManager();
		
		manager.getTransaction().begin();
		
		manager.persist(ingrediente);
		
		manager.getTransaction().commit();
		
		manager.close();
		
		

	}

}
