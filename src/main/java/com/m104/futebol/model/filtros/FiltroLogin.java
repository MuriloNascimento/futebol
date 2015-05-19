package com.m104.futebol.model.filtros;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.m104.futebol.model.manegedbeans.UsuarioMB;

/**
 * Servlet Filter implementation class FiltroLogin
 */
@WebFilter(urlPatterns = {"/panel/*"})
public class FiltroLogin implements Filter {

	@Inject
	private UsuarioMB usuarioMB;
    /**
     * Default constructor. 
     */
    public FiltroLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		if (!this.usuarioMB.isLoged()) {
			String contextPath = ((HttpServletRequest) request).getContextPath();
			((HttpServletResponse) response).sendRedirect(contextPath + "/login.xhtml");
		} else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
