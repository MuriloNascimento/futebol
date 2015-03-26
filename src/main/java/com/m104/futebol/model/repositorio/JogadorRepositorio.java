package com.m104.futebol.model.repositorio;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.m104.futebol.model.entidades.Jogador;

@Stateless
public class JogadorRepositorio {

	@PersistenceContext
	private EntityManager em;
	
	public void adicionar(Jogador jogador){
		this.em.merge(jogador);
	}
	
	public void remove(Jogador jogador){
		Jogador jogadorRm = this.em.find(Jogador.class, jogador.getId());
		this.em.remove(jogadorRm);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Jogador> buscarTodos(){
		TypedQuery<Jogador> query = this.em.createQuery("select j from Jogador j",Jogador.class);
		return query.getResultList();
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Jogador buscarPorId(long id){
		return this.em.find(Jogador.class, id);
	}
	
}
