package com.m104.futebol.model.manegedbeans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.m104.futebol.model.entidades.Usuario;
import com.m104.futebol.model.repositorio.UsuarioRepositorio;

@Named
@SessionScoped
public class UsuarioMB implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioRepositorio usuarioRepositorio;
	
	private boolean loged;
	private Usuario usuario = new Usuario();
	
	public String logar(){
		if(!usuarioRepositorio.buscarPorLoginSenha(this.usuario).isEmpty()){
			this.loged = true;
			return "/panel/times.xhtml?faces-redirect=true";
		} else {
			this.usuario = new Usuario();
			this.loged = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login ou Senha incorreto, tente novamente",null));
			return null;
		}
	}
	
	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
	}

	public UsuarioRepositorio getUsuarioRepositorio() {
		return usuarioRepositorio;
	}

	public void setUsuarioRepositorio(UsuarioRepositorio usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isLoged() {
		return loged;
	}

	public void setLoged(boolean loged) {
		this.loged = loged;
	}
	
}
