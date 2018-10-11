package br.com.fiap.valet.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import br.com.fiap.valet.beans.Usuario;
import br.com.fiap.valet.beans.Valet;

public class ValetDAO {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private static Date entrada = new Date();
	
	
	public static final Map<String,Map<Long,Valet>> VALETS = new HashMap<>();
	static {
		sdf.setLenient(false);
		
		Map<Long,Valet> listaValet = new HashMap<>();
		try {
			listaValet.put((long) 1, new Valet(1,"C3", "CLK-2341", entrada = sdf.parse("28/08/2018 17:30"), null, 0));
			listaValet.put((long) 2, new Valet(2, "BMW", "BMW-2018", entrada = sdf.parse("07/10/2018 23:43"), null, 0));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		VALETS.put("usuario", listaValet);
		VALETS.put("contato", listaValet);
		VALETS.put("admin", listaValet);
	}
	
	public Map<Long, Valet> buscarValets(Usuario u) {
		if(VALETS.containsKey(u.getLogin())) {
			return VALETS.get(u.getLogin());
		}else {
			return null;
		}
				
	}
	
	public String novaValet(String modelo, String placa, Usuario u) {
		// ADICIONANDO O ID
		long id = (VALETS.size() + 1);
		System.out.println(VALETS.size());
		//ADICIONANDO ENTRADA
		Date entrada = new Date();
		
		Map<Long,Valet> listaValet = VALETS.get(u.getLogin());
		listaValet.put((long) id,new Valet((long) id, modelo, placa,entrada, null, 0));
		
		VALETS.put(u.getLogin(), listaValet);
		return "OK";
	}
	
	public Valet saida(Usuario u, long id) {
		Date saida = new Date();
		Map<Long,Valet> listaValet = VALETS.get(u.getLogin());	
		Valet v = listaValet.get(id);
		listaValet.remove(u.getId());
		if(v != null) {
			v.setSaida(saida);
			long diferencia = v.getSaida().getTime() - v.getEntrada().getTime();
			int horas = (int) (diferencia/1000/60/60);
			int minutos = (int) (diferencia/1000/60) - (horas*60);
			if(horas * 4 == 0) {
				v.setPreco(4);
			}else {
				v.setPreco(horas*4);
			}
			if(minutos != 0) {
				v.setPreco(v.getPreco() + 4); 
			}
			return v;
		}else {
			return null;
		}
	}

}
