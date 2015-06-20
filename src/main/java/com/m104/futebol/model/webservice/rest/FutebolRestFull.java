package com.m104.futebol.model.webservice.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.m104.futebol.model.entidades.Time;
import com.m104.futebol.model.repositorio.TimeRepositorio;

@Path("/futrest")
@Stateless
public class FutebolRestFull {
	
	@Inject
	private TimeRepositorio timeRepositorio;
	
	
	@GET
	@Path("/times")
	@Produces("application/xml")
	public List<Time> gietTimes(){
		return timeRepositorio.buscarTodos();
	}

}