package br.com.fiap.valet.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.valet.beans.Valet;

public class Recibo implements Logica{
	
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		Valet v = new Valet();
		String passagem = null;
		
		v.setModelo(req.getParameter("modelo"));
		v.setPlaca(req.getParameter("placa"));
		
		
		
		if(v != null) {
			passagem = "/WEB-INF/paginas/recibo.jsp";
		}
		
		return passagem;
	}
}
