package com.usjt.previsoes.repository;

import javax.persistence.EntityManager;

import com.usjt.previsoes.model.Cidade;

public class BuscaUmaCidade {

	public static void main(String[] args) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		Cidade c = manager.find(Cidade.class, 1L);
		System.out.println(" ");
		System.out.println(c.getPrevisao());
		System.out.println(" ");
		manager.close();
		JPAUtil.close();

	}

}
