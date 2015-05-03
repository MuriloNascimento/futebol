package com.m104.futebol.model.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.m104.futebol.model.entidades.Time;

@WebService
@Stateless
public class EnviaTime {
	@PersistenceContext
	private EntityManager em;
	
	public List<Time> enviar(){
		TypedQuery<Time> query = this.em.createQuery("select t from Time t",Time.class);
		return query.getResultList();
	}
}
