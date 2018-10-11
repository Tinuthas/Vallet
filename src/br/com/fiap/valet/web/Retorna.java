package br.com.fiap.valet.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Retorna implements Logica {
	
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		req.getSession().removeAttribute("VEICULO");
		
		return "index.jsp";
	}

}
