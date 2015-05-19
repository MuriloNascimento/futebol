package com.m104.futebol.model.repositorio;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.m104.futebol.model.entidades.Usuario;

@Stateless
public class UsuarioRepositorio {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public Usuario buscarPorId(int id){
		return em.find(Usuario.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Usuario> buscarPorLoginSenha(Usuario usuario){

		Query consulta = em.createQuery("select u from Usuario u where u.senha = :senha and u.login = :login");
		consulta.setParameter("login", usuario.getLogin());
		consulta.setParameter("senha", usuario.getSenha());
		
		return consulta.getResultList();
		
	}

}
