package br.com.fiap.valet.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/controller")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String passagem = req.getParameter("enviar");
		
		if(passagem != null) {
			throw new IllegalArgumentException("Não identificado parâmetro");
		}
		
		passagem = "br.com.fiap.valet.web." + passagem;

		try {
			
			Class<?> instancia = Class.forName(passagem);
			Logica objeto = (Logica) instancia.newInstance();
			String pagina = objeto.executa(req, resp);
			req.getRequestDispatcher(pagina).forward(req, resp);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
