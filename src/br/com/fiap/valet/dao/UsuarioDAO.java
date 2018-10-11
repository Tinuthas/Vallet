package br.com.fiap.valet.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.fiap.valet.beans.Usuario;

public class UsuarioDAO {
	
	public static final Map<String, Usuario> USUARIOS = new HashMap<>();
	static {
		USUARIOS.put("usuario", new Usuario((long) 1,"usuario","usuario"));
		USUARIOS.put("contato", new Usuario((long) 2,"contato","contato"));
		USUARIOS.put("admin", new Usuario((long) 3,"admin","admin"));
		
	}
	
	public Usuario buscarUsuario(String login,String senha) {
		if(!USUARIOS.containsKey(login)) {
			return null;
		}
		Usuario u = USUARIOS.get(login);
		if(u.getSenha().equals(senha)) {
			return u;
		}

		return null;
	}
	
	public void adiciona(Usuario u) {
		u.setId((long) (USUARIOS.size() + 1));
		USUARIOS.put(u.getLogin(), u);
	}
	
}
