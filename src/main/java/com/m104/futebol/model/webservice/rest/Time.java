package com.m104.futebol.model.webservice.rest;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Time implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	private String nome;
	
	public Time(long id) {
		this.id = id;
	}

	public Time() {}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final long prime = 31;
		long result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return (int) result;
	}

	@XmlElement
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@XmlElement
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}