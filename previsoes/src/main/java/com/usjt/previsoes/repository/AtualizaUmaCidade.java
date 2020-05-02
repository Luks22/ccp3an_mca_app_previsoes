package com.usjt.previsoes.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.usjt.previsoes.model.Cidade;

public class AtualizaUmaCidade {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Cidade c = manager.find(Cidade.class, 1L);
		c.setNome("Rio de Janeiro");
		c.setLatitude(15985234D);
		c.setLongitude(23647859D);
		transaction.commit();
		manager.close();
		JPAUtil.close();

	}

}
