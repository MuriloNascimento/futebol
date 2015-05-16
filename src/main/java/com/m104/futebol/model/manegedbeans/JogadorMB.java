package com.m104.futebol.model.manegedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.m104.futebol.model.entidades.Jogador;
import com.m104.futebol.model.repositorio.JogadorRepositorio;

@Named
@RequestScoped
public class JogadorMB {
	
	@Inject
	private JogadorRepositorio jogadorRepo;

	private Jogador jogador = new Jogador();
	
	private List<Jogador> jogadores;
	
	@PostConstruct
	public void init(){
		this.jogadores = this.jogadorRepo.buscarTodos();
	}
	
	public void adicionar(){
		try {
			this.jogadorRepo.adicionar(this.jogador);
			this.jogador = new Jogador();
			this.jogadores = null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Salvo com sucesso",null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Não Foi possivel salvar",null));
		}
	}
	
	public void remove(Jogador Jogador){
		try {
			this.jogadorRepo.remove(jogador);
			this.jogadores = null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Excluido o jogador "+Jogador.getNome(),null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Não foi possivel excluir o jogador"+Jogador.getNome(),null));
		}
	}

	public JogadorRepositorio getJogadorRepo() {
		return jogadorRepo;
	}

	public void setJogadorRepo(JogadorRepositorio jogadorRepo) {
		this.jogadorRepo = jogadorRepo;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	
}
