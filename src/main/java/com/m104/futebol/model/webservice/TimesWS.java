package com.m104.futebol.model.webservice;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.m104.futebol.model.entidades.Time;
import com.m104.futebol.model.repositorio.TimeRepositorio;

@WebService
@Stateless
public class TimesWS {

	@Inject
	private TimeRepositorio repo;
	
	//@Inject
	//private JogadorRepositorio joga;
	
	@Resource
	WebServiceContext wsctx;
	
	@SuppressWarnings("rawtypes")
	@WebMethod
	public List<Time> buscarTodos(){
	
		MessageContext messageContext = wsctx.getMessageContext();
		Map http_headers = (Map) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
		List userList = (List) http_headers.get("Username");
		List passList = (List) http_headers.get("Password");
		
		String user = "";
		String pass = "";
		
		if (userList!=null) {
			user = userList.get(0).toString();
		}
		if (passList!=null) {
			pass = passList.get(0).toString();
		}
		
		if (user.equals("futebol") && pass.equals("1234")) {
			return repo.buscarTodos();
		} else {
			return null;
		}
		
	}
	
	//@SuppressWarnings("rawtypes")
	//@WebMethod
	/*public List<Jogador> buscarTodosJogadores(){
	
		MessageContext messageContext = wsctx.getMessageContext();
		Map http_headers = (Map) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
		List userList = (List) http_headers.get("Username");
		List passList = (List) http_headers.get("Password");
		
		String user = "";
		String pass = "";
		
		if (userList!=null) {
			user = userList.get(0).toString();
		}
		if (passList!=null) {
			pass = passList.get(0).toString();
		}
		
		if (user.equals("futebol") && pass.equals("1234")) {
			return joga.buscarTodos();
		} else {
			return null;
		}
		
	}*/
	
}
