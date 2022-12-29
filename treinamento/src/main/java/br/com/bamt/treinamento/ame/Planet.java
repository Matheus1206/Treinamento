package br.com.bamt.treinamento.ame;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "planet")
public class Planet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String climate;
	private String terrain;
	
	public Planet() {
		
	}
	
	public Planet(String name, String climate, String terrain) {
		this.name = name;
		this.climate = climate;
		this.terrain = terrain;
	}

	public String getName() {
		return name;
	}
	
	public String getClimate() {
		return climate;
	}
	
	public String getTerrain() {
		return terrain;
	}

	public PlanetResponse toPlanetResponse() {
		return new PlanetResponse(this.name, this.climate, this.terrain);
	}
}
