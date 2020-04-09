package com.usjt.previsoes.repository;

import javax.persistence.EntityManager;

import com.usjt.previsoes.model.Previsao;

public class BuscaPrevisaoPorId {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		Previsao p = manager.find(Previsao.class, 1L);
		System.out.println(" ");
		System.out.println(p);
		System.out.println(" ");
		manager.close();
		JPAUtil.close();
	}
}