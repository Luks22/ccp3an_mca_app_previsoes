package com.usjt.previsoes.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "previsao")
public class Previsao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private Date data;
	
	@Column(nullable = false)
	private Double tempMax;
	
	@Column(nullable = false)
	private Double tempMin;
	
	@Column(nullable = false)
	private Double umidade;
	
	@Column(nullable = false, length = 200)
	private String descricao;
	
	@OneToOne(optional = false, cascade=CascadeType.ALL)
	@JoinColumn(name = "id_diaSemana")
	private DiaDaSemana diaSemana;
	
	@ManyToOne
	private Cidade cidade;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Double getTempMax() {
		return tempMax;
	}
	public void setTempMax(Double tempMax) {
		this.tempMax = tempMax;
	}
	public Double getTempMin() {
		return tempMin;
	}
	public void setTempMin(Double tempMin) {
		this.tempMin = tempMin;
	}
	public Double getUmidade() {
		return umidade;
	}
	public void setUmidade(Double umidade) {
		this.umidade = umidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public DiaDaSemana getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(DiaDaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	@Override
	public String toString() {
		return "Previsao [id=" + id + ", data=" + data + ", tempMax=" + tempMax + ", tempMin=" + tempMin + ", umidade="
				+ umidade + ", descricao=" + descricao + ", diaSemana=" + diaSemana + ", cidade=" + cidade + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Previsao other = (Previsao) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
