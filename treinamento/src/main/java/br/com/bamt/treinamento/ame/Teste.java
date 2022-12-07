package br.com.bamt.treinamento.ame;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Teste {
	
	private String urlBase = "https://swapi.dev/api/planets/";
	private String urlFilm= "https://swapi.dev/api/films/";
	private Planet planet;
	
	@GetMapping("{id}")
	public Planet getPlanet(@PathVariable Integer id) {
		String url;
		RestTemplate rest = new RestTemplate();
		url = urlBase.concat(Integer.toString(id));
		planet = rest.getForObject(url, Planet.class);
		getFilms();
		return planet;
	}
	
	private void getFilms() {
		RestTemplate rest = new RestTemplate();
		for(String s : planet.getFilms() ) {
			String number = s.replaceAll("[^0-9]", "");
			Filme filme = rest.getForObject(urlFilm.concat(number), Filme.class);
			System.out.println(filme.getTitle());
		}
	}
}
