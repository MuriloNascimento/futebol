package com.m104.futebol.model.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.m104.futebol.model.adapter.JogadorAdapter;

@Entity
@XmlJavaTypeAdapter(JogadorAdapter.class)
public class Jogador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	private String nome;
	
	private String posicao;
	
	private int gols;
	
	private int idade;
	
	private int jogosRealizados;
	
	@JoinColumn
	@ManyToOne
	private Time time;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public int getGols() {
		return gols;
	}

	public void setGols(int gols) {
		this.gols = gols;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getJogosRealizados() {
		return jogosRealizados;
	}

	public void setJogosRealizados(int jogosRealizados) {
		this.jogosRealizados = jogosRealizados;
	}
	
}
