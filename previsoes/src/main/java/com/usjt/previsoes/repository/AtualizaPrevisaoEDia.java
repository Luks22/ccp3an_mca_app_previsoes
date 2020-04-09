package com.usjt.previsoes.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.usjt.previsoes.model.DiaDaSemana;
import com.usjt.previsoes.model.Previsao;

public class AtualizaPrevisaoEDia {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Previsao p = manager.find(Previsao.class, 1L);
		DiaDaSemana dia = p.getDiaSemana();
		dia.setNome("quinta-feira");
		p.setTempMax(32.0);
		p.setUmidade(75.0);
		transaction.commit();
		manager.close();
		JPAUtil.close();
	}
}