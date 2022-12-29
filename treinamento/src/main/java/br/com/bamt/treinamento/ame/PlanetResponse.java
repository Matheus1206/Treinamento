package br.com.bamt.treinamento.ame;

public class PlanetResponse {
	
	private String name;
	private String climate;
	private String terrain;

	public PlanetResponse(String name, String climate, String terrain) {
		this.name = name;
		this.climate = climate;
		this.terrain = terrain;	
	}
	
	public String getClimate() {
		return climate;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTerrain() {
		return terrain;
	}

}
