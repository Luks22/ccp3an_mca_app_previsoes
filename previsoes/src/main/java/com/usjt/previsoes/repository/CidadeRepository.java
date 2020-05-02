package com.usjt.previsoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usjt.previsoes.model.Cidade;

public interface CidadeRepository extends JpaRepository <Cidade, Long>{

}
