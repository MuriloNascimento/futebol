package com.m104.futebol.model.manegedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.m104.futebol.model.entidades.Time;
import com.m104.futebol.model.repositorio.TimeRepositorio;

@Named
@RequestScoped
public class TimeMB {
	
	@Inject
	private TimeRepositorio timeRepo;
	
	@ManagedProperty(value = "#{time}")
	private Time time = new Time();
		
	private List<Time> times;
	
	@PostConstruct
	public void init(){
		this.times = this.timeRepo.buscarTodos();
	}
	
	public void adicionar(){
		this.timeRepo.adicionar(this.time);
		this.time = new Time();
		this.init();
	}
	
	public void remove(){
		try{
				this.timeRepo.remove(this.time);
				this.init();
				this.time = new Time();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Excluido com sucesso",null));
		} catch (Exception e) {
			    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Excluido sem sucesso",null));
		}
	}

	public TimeRepositorio getTimeRepo() {
		return timeRepo;
	}

	public void setTimeRepo(TimeRepositorio timeRepo) {
		this.timeRepo = timeRepo;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

}
