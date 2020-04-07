package br.usjt.meteriologia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.usjt.meteriologia.interceptor.LoginInterceptor;
import br.usjt.meteriologia.model.Relogio;


@Configuration
public class AppConfig implements WebMvcConfigurer{

	@Bean
	public Relogio getRelogio() {
		return new Relogio();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").
		excludePathPatterns("/login", "/", "/fazerLogin", "/webjars/**", "/bootstrap/**");
	}
}
