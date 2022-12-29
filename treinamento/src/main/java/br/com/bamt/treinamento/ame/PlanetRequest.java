package br.com.bamt.treinamento.ame;

import javax.validation.constraints.NotBlank;

public class PlanetRequest {
	@NotBlank
	private String name;
	@NotBlank
	private String climate;
	@NotBlank
	private String terrain;
	
	public String getName() {
		return name;
	}
	
	public String getClimate() {
		return climate;
	}
	
	public String getTerrain() {
		return terrain;
	}

	public Planet toPlanet() {
		return new Planet(this.name, this.climate, this.terrain);
	}

}
