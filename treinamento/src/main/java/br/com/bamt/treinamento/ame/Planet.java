package br.com.bamt.treinamento.ame;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Planet {
	
	private String[] films;
	
	public String[] getFilms() {
		return films;
	}
	
	
	
	
}
