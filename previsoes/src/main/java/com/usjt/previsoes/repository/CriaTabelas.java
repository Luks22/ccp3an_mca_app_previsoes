package com.usjt.previsoes.repository;

import javax.persistence.Persistence;

public class CriaTabelas {

	public static void main(String[] args) {

		Persistence.createEntityManagerFactory("usjt");

	}

}
