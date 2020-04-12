package com.usjt.previsoes.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.usjt.previsoes.model.Cidade;
import com.usjt.previsoes.model.DiaDaSemana;
import com.usjt.previsoes.model.Previsao;


public class InsereUmaCidadeComDuasPrevisoes {

	public static void main(String[] args) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		
		Cidade cidade = new Cidade();
		cidade.setLatitude(546154646L);
		cidade.setLongitude(456484545L);
		cidade.setNome("São Paulo");
		
		List<Previsao> previsoes = new ArrayList<>();
		
		DiaDaSemana d1 = new DiaDaSemana();
		d1.setNome("quinta-feira");

		Previsao previsao1 = new Previsao();
		previsao1.setData(new Date());
		previsao1.setTempMax(30.0);
		previsao1.setTempMin(19.0);
		previsao1.setUmidade(80.0);
		previsao1.setDescricao("Brisa suave com céu nublado");
		previsao1.setDiaSemana(d1);
		previsao1.setCidade(cidade);
		
		previsoes.add(previsao1);
		
		DiaDaSemana d2 = new DiaDaSemana();
		d2.setNome("sexta-feira");
		
		Previsao previsao2 = new Previsao();
		previsao2.setData(new Date());
		previsao2.setTempMax(33.0);
		previsao2.setTempMin(18.0);
		previsao2.setUmidade(80.0);
		previsao2.setDescricao("Brisa suave com chance de chuva");
		previsao2.setDiaSemana(d2);
		previsao2.setCidade(cidade);
		
		previsoes.add(previsao2);
	
		cidade.setPrevisao(previsoes);
		
		manager.persist(cidade);
		
		transaction.commit();
		
		manager.close();
		JPAUtil.close();

	}

}
