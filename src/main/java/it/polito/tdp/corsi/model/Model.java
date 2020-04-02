package it.polito.tdp.corsi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {

	private CorsoDAO dao;
	
	public Model() {
		dao = new CorsoDAO();
	}
	public List<Corso> getCorsiByPeriodo(Integer pd){
		return this.dao.getCorsiByPeriodo(pd);
	}
	
	public Map<Corso,Integer> getIscrittiByPeriodo(Integer pd){
		return this.dao.getIscrittiByPeriodo(pd);
	}
	
	public List<Studente> getStudentiByCorso(Corso c){
		return this.dao.getStudentiByCorso(c);
	}
	
	public boolean esisteCorso(String codins) {
		return dao.esisteCorso(codins);
	}
	
public Map<String,Integer> getDivisioneCds(Corso c){
		
	/*	List<Studente> studenti = this.dao.getStudentiByCorso(c);
		
		Map<String, Integer> statistiche = new HashMap<>();
		
		for(Studente a : studenti) {
			
			if(a.getCds() != null && !a.getCds().equals(""))
			if(statistiche.containsKey(a.getCds())) {
				statistiche.put(a.getCds(), statistiche.get(a.getCds())+1);
			}else
				statistiche.put(a.getCds(),1);
			
		}
		
		return statistiche;
		
		*/
	
		return dao.getDivisioneCds(c);
		
		
	}
	
}
