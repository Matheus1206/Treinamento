package br.com.bamt.treinamento.ame;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class PlanetService {

	private String urlBase = "https://swapi.dev/api/planets/";
	private String urlFilm= "https://swapi.dev/api/films/";
	private Planet planet;


	@Autowired
	private PlanetRepository planetRepository;
	

	public PlanetResponse save(PlanetRequest planetRequest) {
		Planet planet = planetRequest.toPlanet();
		planetRepository.save(planet);
		return planet.toPlanetResponse();
	}


	public List<PlanetResponse> getAllPlanets() {
		List<Planet> lista = planetRepository.findAll();
		List<PlanetResponse> listaResponse = new ArrayList<>();
		lista.forEach(p -> {
			listaResponse.add(new PlanetResponse(p.getName(), p.getClimate(), p.getTerrain()));
		});
		return listaResponse;
	}


	public PlanetResponse findByName(String name) {
		Planet planet = planetRepository.findByName(name).get();
		return new PlanetResponse(planet.getName(), planet.getClimate(), planet.getTerrain());
	}


	public PlanetResponse findById(Long id) {
		Planet planet = planetRepository.findById(id).get();
		return new PlanetResponse(planet.getName(), planet.getClimate(), planet.getTerrain());
	}


	public void deleteById(Long id) {
		Planet planet = planetRepository.findById(id).get();
		planetRepository.delete(planet);
	}

}
