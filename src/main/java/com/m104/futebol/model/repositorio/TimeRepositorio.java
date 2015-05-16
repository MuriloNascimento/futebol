package com.m104.futebol.model.repositorio;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Time> buscarTodos(){
		Query query = this.em.createNativeQuery("CALL buscar_todos_times",Time.class);
		return query.getResultList();
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Time buscarPorId(long id){
		return this.em.find(Time.class, id);
	}

}
