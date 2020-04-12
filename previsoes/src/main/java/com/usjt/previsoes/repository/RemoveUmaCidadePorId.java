package com.usjt.previsoes.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.usjt.previsoes.model.Cidade;

public class RemoveUmaCidadePorId {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Cidade c = manager.find(Cidade.class, 1L);
		manager.remove(c);
		transaction.commit();
		manager.close();
		JPAUtil.close();

	}

}
