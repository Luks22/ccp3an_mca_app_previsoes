package br.usjt.meteriologia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.usjt.meteriologia.model.Relogio;



@Configuration
public class AppConfig {

	@Bean
	public Relogio getRelogio() {
		return new Relogio();
	}
}
