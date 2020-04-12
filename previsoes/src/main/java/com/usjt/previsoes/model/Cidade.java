package com.usjt.previsoes.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
public class Cidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 30)
	private String nome;
	
	@Column(nullable = false)
	private Long latitude;
	
	@Column(nullable = false)
	private Long longitude;
	
	@OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL)
	private List<Previsao> previsao;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getLatitude() {
		return latitude;
	}
	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}
	public Long getLongitude() {
		return longitude;
	}
	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
	public List<Previsao> getPrevisao() {
		return previsao;
	}
	public void setPrevisao(List<Previsao> previsao) {
		this.previsao = previsao;
	}
	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", latitude=" + latitude + ", longitude=" + longitude
				+ "]";
	}
}

