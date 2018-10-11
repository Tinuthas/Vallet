package br.com.fiap.valet.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.valet.beans.Usuario;
import br.com.fiap.valet.beans.Valet;
import br.com.fiap.valet.dao.ValetDAO;

public class Entrada implements Logica {
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		Valet v = new Valet();
		String passagem = null;
		
		HttpSession session = req.getSession();
		Usuario u = (Usuario) session.getAttribute("USUARIO");
		
		v.setModelo(req.getParameter("modelo"));
		v.setPlaca(req.getParameter("placa"));
		ValetDAO dao = new ValetDAO();
		String mensagem = dao.novaValet(v.getModelo(), v.getPlaca(), u);
		
		session.removeAttribute("LISTAVEICULO");
		ValetDAO valetDAO = new ValetDAO();
		Map<Long,Valet> listaValet = new HashMap<Long, Valet>();
		if (mensagem != null) {
			listaValet = valetDAO.buscarValets(u);
			List<Valet> lista = new ArrayList<Valet>(listaValet.values());
			session.setAttribute("LISTAVEICULO", lista);
			passagem = "index.jsp";
		}

		return passagem;
	}
}
