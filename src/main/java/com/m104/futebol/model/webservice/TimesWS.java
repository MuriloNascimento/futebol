package com.m104.futebol.model.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import com.m104.futebol.model.entidades.Time;
import com.m104.futebol.model.repositorio.TimeRepositorio;

@WebService
@Stateless
public class TimesWS {

	@Inject
	private TimeRepositorio repo;
	
	public List<Time> buscarTodos(){
		return repo.buscarTodos();
	}
	
}
