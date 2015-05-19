package com.m104.futebol.model.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.m104.futebol.model.entidades.Time;
import com.m104.futebol.model.repositorio.TimeRepositorio;

@FacesConverter("timeConversor")
public class TimeConversor implements Converter {
	
	@Inject
	TimeRepositorio timeRepo;

	public Object getAsObject(FacesContext context, UIComponent component, String id) {
		return timeRepo.buscarPorId(Integer.parseInt(id));
	}

	public String getAsString(FacesContext context, UIComponent component, Object time) {
		if(time == null){
			return "";
		}
		Time t = (Time) time;
		return Long.toString(t.getId());
	}

}
