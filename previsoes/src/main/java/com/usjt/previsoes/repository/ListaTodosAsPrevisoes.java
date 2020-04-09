package com.usjt.previsoes.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.usjt.previsoes.model.Previsao;

public class ListaTodosAsPrevisoes {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		Query query = manager.createQuery("from Previsao");
		List<Previsao> previsoes = query.getResultList();
		for (Previsao p : previsoes) {
			System.out.println(" ");
			System.out.println(p);
			System.out.println(" ");
		}
		manager.close();
		JPAUtil.close();
	}
}