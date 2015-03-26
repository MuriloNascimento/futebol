package com.m104.futebol.model.repositorio;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.m104.futebol.model.entidades.Time;

@Stateless
public class TimeRepositorio {
	
	@PersistenceContext
	private EntityManager em;
	
	public void adicionar(Time time){
		this.em.merge(time);
	}
	
	public void remove(Time time){
		Time timeRm = this.em.find(Time.class, time.getId());
		this.em.remove(timeRm);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Time> buscarTodos(){
		TypedQuery<Time> query = this.em.createQuery("select t from Time t",Time.class);
		return query.getResultList();
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Time buscarPorId(long id){
		return this.em.find(Time.class, id);
	}

}
