package br.com.bamt.treinamento.ame;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ame")
public class PlanetController {
	
	@Autowired
	private PlanetService planetService;
	
	@PostMapping
	public ResponseEntity<PlanetResponse> savePlanet(@RequestBody @Valid PlanetRequest planetRequest){
		System.out.println("REQUEST: " + planetRequest.getName());
		PlanetResponse planetResponse = planetService.save(planetRequest);
		return ResponseEntity.ok(planetResponse);
	}
	
	@GetMapping("list")
	public List<PlanetResponse> listPlanets(){
		return planetService.getAllPlanets();
	}

	@GetMapping("name")
	public PlanetResponse searchByName(@RequestParam String name){
		return planetService.findByName(name);
	}

	@GetMapping("id")
	public PlanetResponse searchById(@RequestParam Long id){
		return planetService.findById(id);
	}

	@DeleteMapping("delete")
	public void deleteById(@RequestParam Long id){
		planetService.deleteById(id);
	}
}
