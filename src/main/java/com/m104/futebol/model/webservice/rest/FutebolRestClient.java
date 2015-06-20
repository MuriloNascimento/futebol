package com.m104.futebol.model.webservice.rest;

import java.util.List;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.util.GenericType;

public class FutebolRestClient {

	public static void main(String[] args) throws Exception {
		
		ClientRequest clientRequest = new ClientRequest("http://localhost:8085/futebol/rest/futrest/times");
		clientRequest.accept("application/xml");
		
		List<Time> times = clientRequest.get(Time.class).getEntity(new GenericType<List<Time>>() {});

		for (Time time : times) {
			System.out.println(time.getNome());
		}

	}


}