package com.usjt.previsoes.repository;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.usjt.previsoes.model.DiaDaSemana;
import com.usjt.previsoes.model.Previsao;

public class InsereUmaPrevisaoComDiaDaSemana {

	public static void main(String[] args) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		DiaDaSemana dia = new DiaDaSemana();
		dia.setNome("quarta-feira");
		manager.persist(dia);
		Previsao previsao = new Previsao();
		previsao.setData(new Date());
		previsao.setTempMax(29.0);
		previsao.setTempMin(19.0);
		previsao.setUmidade(80.0);
		previsao.setDescricao("Brisa suave com chance de chuva");
		previsao.setDiaSemana(dia);
		manager.persist(previsao);
		transaction.commit();
		
		manager.close();
		JPAUtil.close();
	}

}
