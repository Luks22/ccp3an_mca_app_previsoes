package com.usjt.previsoes.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.usjt.previsoes.model.Previsao;

public class RemoveUmaPrevisao {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Previsao p = manager.find(Previsao.class, 1L);
		manager.remove(p);
		transaction.commit();
		manager.close();
		JPAUtil.close();
	}
}