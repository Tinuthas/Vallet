package br.com.fiap.valet.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Logica{
	
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		session.removeAttribute("USUARIO");
		
		return "index.jsp";
		
	}
}
