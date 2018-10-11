package br.com.fiap.valet.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.valet.beans.Usuario;
import br.com.fiap.valet.beans.Valet;

public class Login implements Logica{
	
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String passagem = null;
		Usuario u = new Usuario();
		HttpSession session = req.getSession();
		
		u.setLogin(req.getParameter("login"));
		u.setSenha(req.getParameter("senha"));
		
		// CHAMAR E FAZER VERIFICAÇÃO
		
		
		// VEICULOS ESTACIONADOS
		List<Valet> listaValet = new ArrayList<Valet>();
		
		
		
		
		if(u != null) {
			session.setAttribute("USUARIO", u);
			session.setAttribute("LISTAVEICULO", listaValet);
			passagem = "index.jsp";
		}
		
		
		return passagem;
	}

}
